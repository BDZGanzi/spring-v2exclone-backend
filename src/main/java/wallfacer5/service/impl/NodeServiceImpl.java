package wallfacer5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wallfacer5.entity.Node;
import wallfacer5.mapper.NodeMapper;
import wallfacer5.service.NodeService;

@Component
public class NodeServiceImpl implements NodeService {

    @Autowired
    NodeMapper nodeMapper;

    @Override
    public void createNode(Node node) {
        nodeMapper.insert(node);
    }

    @Override
    public Node getNodeById(long id) {
        return nodeMapper.getNodeById(id);
    }

    @Override
    public List<Node> getAllNodes() {
        return nodeMapper.getAllNodes();
    }
    
}
