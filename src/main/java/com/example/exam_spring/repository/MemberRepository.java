package com.example.exam_spring.repository;

import com.example.exam_spring.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}

