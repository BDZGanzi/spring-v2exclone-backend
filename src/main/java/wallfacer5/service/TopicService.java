package wallfacer5.service;

import java.util.List;

import wallfacer5.entity.Topic;

public interface TopicService {
    void createTopic(Topic topic);

    Topic getTopicById(long id);

    List<Topic> getTopicsWithIndex(long index);
    
    
}
