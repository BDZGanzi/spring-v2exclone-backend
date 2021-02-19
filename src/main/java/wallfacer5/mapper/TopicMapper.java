package wallfacer5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import wallfacer5.entity.Topic;

@Component
@Transactional
public interface TopicMapper {
    @Insert("INSERT INTO topics (topic_id, title, content, member_id, node_id, created_at, last_modified, replies) "
    + "VALUES (#{topic.topic_id}, #{topic.title}, #{topic.content}, #{topic.member.member_id}, "
    + "#{topic.node.node_id}, #{topic.created_at}, #{topic.last_modified}, #{topic.replies})")
    void insert(@Param("topic") Topic topic);

    @Select("SELECT * FROM topics WHERE topic_id=#{id}")
    Topic getTopicById(long id);

    @Select("SELECT * FROM topics LIMIT #{limit}, #{offset}")
    List<Topic> getTopicsWithIndex(long offset, long limit);

    @Select("SELECT DISTINCT member_id FROM topics")
    List<Long> getAllMemberId();
    
    @Select("SELECT DISTINCT node_id FROM topics")
    List<Long> getAllNodeId();

    @Select("SELECT topic_id FROM topics")
    List<Long> getAllTopicId();
}
