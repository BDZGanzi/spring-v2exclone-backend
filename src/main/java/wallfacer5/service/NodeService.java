package wallfacer5.service;

import java.util.List;

import wallfacer5.entity.Node;

public interface NodeService {
    void createNode(Node node);

    Node getNodeById(long id);

    List<Node> getAllNodes();

    // Node searchNodeByName(String keyword);
}
