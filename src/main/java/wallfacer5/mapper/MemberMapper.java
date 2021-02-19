package wallfacer5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import wallfacer5.entity.Member;

@Component
@Transactional
public interface MemberMapper {
    @Insert("INSERT INTO members (member_id, username, avatar, url, created_at) VALUES "
    + "(#{member.member_id}, #{member.username}, #{member.avatar}, #{member.url}, #{member.created_at})")
    void insert(@Param("member") Member member);

    @Select("SELECT * FROM members WHERE member_id=#{id}")
    Member getMemberById(@Param("id")long id);

    @Select("SELECT DISTINCT member_id FROM members")
    List<Long> getAllMemberIds();
}
