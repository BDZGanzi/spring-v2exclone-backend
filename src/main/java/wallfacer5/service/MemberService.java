package wallfacer5.service;

import java.util.List;

import wallfacer5.entity.Member;

public interface MemberService {
    void createMember(Member member);

    Member getMemberById(long id);

}
