package com.km.tastefull.service;


import com.km.tastefull.domain.Member;
import com.km.tastefull.dto.MemberDto;
import com.km.tastefull.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //회원 가입
//    @Transactional //default 인 readOnly = false
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        System.out.println("memberservice :: "+member.getEmail());
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //Exception
        Member findMember = memberRepository.findByEmail(member.getEmail());
        Optional<Member> opMember = Optional.ofNullable(findMember);

        if (opMember.isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public Page<Member> findMembers(Pageable pageable){
        return memberRepository.findAll(pageable);
    }

}
