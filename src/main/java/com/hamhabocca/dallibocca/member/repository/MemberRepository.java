package com.hamhabocca.dallibocca.member.repository;

import com.hamhabocca.dallibocca.member.dto.MemberSimpleDTO;
import com.hamhabocca.dallibocca.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query(value = "SELECT A.MEMBER_ID, A.NICKNAME FROM MEMBER A WHERE A.MEMBER_ID = :paramId", nativeQuery = true)
    MemberSimpleDTO findByIdSimple(@Param("paramId") int memberId);
}
