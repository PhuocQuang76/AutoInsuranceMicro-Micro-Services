package com.synergisticit.service;

import com.synergisticit.domain.Member;
import com.synergisticit.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }

    @Override
    public Member findById(Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if(member.isPresent()){
            return member.get();
        }
        return null;
    }
}
