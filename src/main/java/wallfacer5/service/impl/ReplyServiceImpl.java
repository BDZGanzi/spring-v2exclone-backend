package wallfacer5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wallfacer5.entity.Reply;
import wallfacer5.mapper.ReplyMapper;
import wallfacer5.service.ReplyService;

@Component
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyMapper replyMapper;

    @Override
    public void createReply(Reply reply) {
        replyMapper.insert(reply);
    }

    @Override
    public Reply getReplyById(long id) {
        return replyMapper.getReplyById(id);
    }

    @Override
    public List<Reply> getRepliesByTopicId(long topicId) {
        return replyMapper.getRepliesByTopicId(topicId);
    }
    
}
