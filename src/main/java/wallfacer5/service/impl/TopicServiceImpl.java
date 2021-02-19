package wallfacer5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wallfacer5.entity.Topic;
import wallfacer5.mapper.TopicMapper;
import wallfacer5.service.TopicService;

@Component
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicMapper topicMapper;

    @Override
    public void createTopic(Topic topic) {
        topicMapper.insert(topic);
    }

    @Override
    public Topic getTopicById(long id) {
        return topicMapper.getTopicById(id);
    }

    @Override
    public List<Topic> getTopicsWithIndex(long index) {
        long limit = 10;
        long offset = (index - 1)*limit;
        return topicMapper.getTopicsWithIndex(offset, limit);
    }
    
}
