package com.web.MyPetForApp.member.repository;

import com.web.MyPetForApp.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {
    public Optional<Member> findByMemberName(String name);
    public Optional<Member> findByEmail(String email);
    @Query("select m.memberId from Member m where m.email = :memberEmail")
    public Long findMemberIdByEmail(@Param("memberEmail") String email);
}
