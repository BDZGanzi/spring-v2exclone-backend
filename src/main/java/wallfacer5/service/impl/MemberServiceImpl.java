package wallfacer5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wallfacer5.entity.Member;
import wallfacer5.mapper.MemberMapper;
import wallfacer5.service.MemberService;

@Component
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberMapper memberMapper;

    @Override
    public void createMember(Member member) {
        memberMapper.insert(member);
    }

    @Override
    public Member getMemberById(long id) {
        return memberMapper.getMemberById(id);
    }
    
}
