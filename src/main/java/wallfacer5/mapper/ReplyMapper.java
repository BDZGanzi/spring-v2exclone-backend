package wallfacer5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import wallfacer5.entity.Reply;

@Component
@Transactional
public interface ReplyMapper {
    @Insert("INSERT INTO replies "
    + "(reply_id, content, member_id, topic_id, created_at, last_modified, thanks) VALUES "
    + "(#{reply.reply_id}, #{reply.content}, #{reply.member_id}, #{reply.topic_id} , "
    + "#{reply.created_at}, #{reply.last_modified}, #{reply.thanks})")
    void insert(@Param("reply")Reply reply);

    @Select("SELECT * FROM replies WHERE reply_id=#{id}")
    Reply getReplyById(@Param("id")long id);

    @Select("SELECT * FROM replies WHERE topic_id=#{id}")
    List<Reply> getRepliesByTopicId(@Param("id")long topicId);

    @Select("SELECT DINSTINCT reply_id FROM replies")
    List<Long> getAllReplyId();

    @Select("SELECT DISTINCT member_id FROM replies")
    List<Long> getAllMemberId();
}
