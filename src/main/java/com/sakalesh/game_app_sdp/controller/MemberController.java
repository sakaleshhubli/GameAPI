package com.sakalesh.game_app_sdp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sakalesh.game_app_sdp.modal.Member;
import com.sakalesh.game_app_sdp.repository.MemberRepository;

@RestController
@RequestMapping(path = "/members")
public class MemberController {
    
    @Autowired
    private MemberRepository repo;
    
    // Add home endpoint for root path
    @GetMapping("/")
    public String home() {
        return "Member API is running! Use the following endpoints:\n" +
               "GET /members - Get all members\n" +
               "POST /members - Create a new member\n" +
               "GET /members/{id} - Get member by ID\n" +
               "PUT /members/{id} - Update member\n" +
               "DELETE /members/{id} - Delete member";
    }
    
    @PostMapping
    public Member create(@RequestBody Member member) {
        member.setId(null);
        Member savedMember = repo.save(member);
        return savedMember;
    }
    
    @GetMapping
    public List<Member> findAll() {
        List<Member> members = repo.findAll();
        return members;
    }
    
    @GetMapping(path = "/{id}")
    public Member findById(@PathVariable String id) {
        Member member = repo.findById(id).get();
        return member;
    }
    
    @PutMapping(path = "/{id}")
    public Member update(@PathVariable String id, @RequestBody Member member) {
        Member oldMember = repo.findById(id).get();
        oldMember.setName(member.getName());
        oldMember.setBalance(member.getBalance());
        oldMember.setPhone(member.getPhone());
        Member updatedMember = repo.save(oldMember);
        return updatedMember;
    }
    
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
