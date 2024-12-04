package com.synergisticit.service;

import com.synergisticit.domain.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {
    public Member save(Member member);


    public List<Member> findAllMember();

    public Member findById(Long memberId);
}
