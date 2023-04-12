package com.hamhabocca.dallibocca.member.repository;

import com.hamhabocca.dallibocca.member.dto.MemberSimpleDTO;
import com.hamhabocca.dallibocca.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query("SELECT new com.hamhabocca.dallibocca.member.dto.MemberSimpleDTO(m.memberId, m.nickname) FROM Member m WHERE m.memberId = :memberId")
    MemberSimpleDTO findMemberByIdSimple(int memberId);

    List<Member> findByNickname(String nickname);
}
