package wallfacer5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import wallfacer5.entity.Node;

@Component
@Transactional
public interface NodeMapper {
    @Insert("INSERT INTO nodes (node_id, nodename, title, avatar, url, topics) VALUES "
    + "(#{node.node_id}, #{node.name}, #{node.title}, #{node.avatar}, #{node.url}, #{node.topics})")
    void insert(@Param("node") Node node);

    @Select("SELECT * FROM nodes WHERE node_id=#{id}")
    Node getNodeById(@Param("id")long id);

    @Select("SELECT * FROM nodes")
    List<Node> getAllNodes();

    @Select("SELECT DISTINCT node_id FROM nodes")
    List<Long> getAllNodeId();
}
