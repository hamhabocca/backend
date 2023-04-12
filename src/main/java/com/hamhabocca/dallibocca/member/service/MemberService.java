package com.hamhabocca.dallibocca.member.service;

import com.hamhabocca.dallibocca.member.dto.MemberDTO;
import com.hamhabocca.dallibocca.member.dto.MemberSimpleDTO;
import com.hamhabocca.dallibocca.member.entity.Member;
import com.hamhabocca.dallibocca.member.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public void registNewMemberTest(MemberDTO newMember) {

        Member m = memberRepository.save(modelMapper.map(newMember, Member.class));
    }

    public MemberDTO findMemberById(int memberId) {

        Member member = memberRepository.findById(memberId).get();

        return modelMapper.map(member, MemberDTO.class);
    }

//    public MemberSimpleDTO findMemberByIdSimple(int memberId) {
//
////        MemberSimpleDTO member = memberRepository.findByIdSimple(memberId);
//
//        member.setLinkToMyPage("/mypage/" + member.getMemberId());  //마이페이지 링크 기억안나서 아직 예시
//
//        return member;
//    }

    public List<MemberDTO> findAllMembers() {

        List<Member> memberList = memberRepository.findAll();

        return memberList.stream().map(member -> modelMapper.map(member, MemberDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public void modifyMember(MemberDTO modifyInfo, int memberId) {

        Member foundMember = memberRepository.findById(memberId).get();

        if(modifyInfo.getNickname() != null) {
            foundMember.setNickname(modifyInfo.getNickname());
        }
        if(modifyInfo.getPreferredLocation() != null) {
            foundMember.setPreferredLocation(modifyInfo.getPreferredLocation());
        }
        if(modifyInfo.getPreferredType() != null) {
            foundMember.setPreferredType(modifyInfo.getPreferredType());
        }
    }
}
