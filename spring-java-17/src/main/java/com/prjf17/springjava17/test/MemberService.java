package com.prjf17.springjava17.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public void test(){
        memberRepository.save(new Member(1L, "A")); // create
        Optional<Member> member = memberRepository.findById(1L); // 단건조회,  optional = NPE(null poing exception)을 방지해준다.
        List<Member> allMembers = memberRepository.findAll(); // 전체 조회

        memberRepository.delete(member.get()); // 삭제
    }
}
