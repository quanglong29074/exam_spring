package com.example.exam_spring.service;

import com.example.exam_spring.entity.Member;
import com.example.exam_spring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Optional<Member> findById(String userId) {
        return memberRepository.findById(userId);
    }
}
