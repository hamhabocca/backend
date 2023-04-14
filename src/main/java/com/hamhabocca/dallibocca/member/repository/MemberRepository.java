package com.hamhabocca.dallibocca.member.repository;

import com.hamhabocca.dallibocca.member.dto.MemberSimpleDTO;
import com.hamhabocca.dallibocca.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT new com.hamhabocca.dallibocca.member.dto.MemberSimpleDTO(m.memberId, m.nickname) FROM Member m WHERE m.memberId = :memberId")
    MemberSimpleDTO findMemberByIdSimple(long memberId);

    List<Member> findByNickname(String nickname);

    @Query("SELECT m FROM Member AS m WHERE m.socialLogin LIKE :socialLogin AND m.socialId = :socialId")
    Member findBySocialId(String socialLogin, long socialId);

//    @Query(value = "SELECT SCHEMA.sequence_member_id.nextval FROM DUAL", nativeQuery = true)
//    long findCurrId();

    long findTopByOrderByMemberIdDesc();
}