package com.synergisticit.controller;

import com.synergisticit.domain.Driver;
import com.synergisticit.domain.Member;
import com.synergisticit.service.DriverService;
import com.synergisticit.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class MemberController {
    @Autowired
    MemberService memberService;


    @PostMapping("/saveMember")
    public Member saveDriver(@RequestBody Member member){
        return memberService.save(member);

    }


    @GetMapping("/members")
    public List<Member> findAllMembers(){
        return memberService.findAllMember();
    }

    @GetMapping("/member/{memberId}")
    public Member findByIdMember(@PathVariable Long memberId) {
        return memberService.findById(memberId);
    }

//    @PutMapping("/updateMember")
//    public Driver updateDriver(@RequestBody Driver driver){
//        return memberService.updateDriver(driver);
//    }

//    @DeleteMapping("/deleteDriver/{driverId}")
//    public void deleteDriver(Long driverId){
//        driverService.deleteByIdDriver(driverId);
//    }

//    @GetMapping("/driverByUsername/{username}")
//    public Driver findByUsername(@PathVariable String username){
//        return driverService.findByUsername(username);
//    }
}
