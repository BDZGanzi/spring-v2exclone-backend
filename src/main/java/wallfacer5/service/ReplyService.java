package wallfacer5.service;

import java.util.List;

import wallfacer5.entity.Reply;

public interface ReplyService {
    void createReply(Reply reply);

    Reply getReplyById(long id);

    List<Reply> getRepliesByTopicId(long topicId);

    
}
