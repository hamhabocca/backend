package com.hamhabocca.dallibocca.member.service;

import com.hamhabocca.dallibocca.member.dto.MemberDTO;
import com.hamhabocca.dallibocca.member.dto.MemberSimpleDTO;
import com.hamhabocca.dallibocca.member.entity.Member;
import com.hamhabocca.dallibocca.member.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public MemberService(MemberRepository memberRepository, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public long registNewUser(MemberDTO newMember) {

        long lastId = memberRepository.findTopByOrderByMemberIdDesc();

        newMember.setNickname("새로운회원" + (lastId + 1));
        newMember.setLevel(1);
        newMember.setIsDeleted("N");

        return memberRepository.save(modelMapper.map(newMember, Member.class)).getMemberId();
    }

    public MemberDTO findMemberById(long memberId) {

        Member member = memberRepository.findById(memberId).get();

        return modelMapper.map(member, MemberDTO.class);
    }

    public MemberSimpleDTO findMemberByIdSimple(long memberId) {

        MemberSimpleDTO member = memberRepository.findMemberByIdSimple(memberId);

        member.setLinkToMyPage("/mypage/" + member.getMemberId());  //마이페이지 링크 기억안나서 아직 예시

        return member;
    }

    public /*List<MemberDTO>*/ Page<MemberDTO> findAllMembers(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("memberId"));

        return memberRepository.findAll(pageable).map(member -> modelMapper.map(member, MemberDTO.class));
    }

    @Transactional
    public void modifyMember(MemberDTO modifyInfo, long memberId, String type) {

        Member foundMember = memberRepository.findById(memberId).get();

        switch (type) {
            case "edit":
                if (modifyInfo.getNickname() != null) {
                    foundMember.setNickname(modifyInfo.getNickname());
                }
                if (modifyInfo.getPreferredLocation() != null) {
                    foundMember.setPreferredLocation(modifyInfo.getPreferredLocation());
                }
                if (modifyInfo.getPreferredType() != null) {
                    foundMember.setPreferredType(modifyInfo.getPreferredType());
                }
                break;

            case "deactivate":
                foundMember.setIsDeleted("Y");
                break;
        }
    }

    @Transactional
    public void deleteMember(long memberId) {

        Member foundMember = memberRepository.findById(memberId).get();

        memberRepository.delete(foundMember);
    }

    public boolean checkIfRepeated(String nickname) {

        List<Member> foundMember = memberRepository.findByNickname(nickname);

        if(foundMember.size() < 1) {
            return false;
        } else {
            return true;
        }
    }

    public MemberDTO findBySocialId(String socialLogin, long socialId) {

        Member foundMember = memberRepository.findBySocialId(socialLogin, socialId);

        return modelMapper.map(foundMember, MemberDTO.class);
    }
}
