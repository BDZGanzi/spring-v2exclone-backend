package wallfacer5.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wallfacer5.entity.Member;
import wallfacer5.entity.Node;
import wallfacer5.entity.Reply;
import wallfacer5.entity.Result;
import wallfacer5.entity.Topic;
import wallfacer5.service.MemberService;
import wallfacer5.service.NodeService;
import wallfacer5.service.ReplyService;
import wallfacer5.service.TopicService;

@RestController
@RequestMapping("/api")
public class APIController {
    @Autowired
    MemberService memberService;

    @Autowired
    TopicService topicService;

    @Autowired
    NodeService nodeService;

    @Autowired
    ReplyService replyService;

    @GetMapping("/member/{id}")
    public Member member(@PathVariable("id") long id){
        return memberService.getMemberById(id);
    }

    @GetMapping("/topic/{id}")
    public Result<Topic> topic(@PathVariable("id") long id){
        var topic = topicService.getTopicById(id);
        return topic!=null ? new Result<Topic>(topic, "success", 200) : new Result<Topic>(null, "failed", 404);
    }

    @GetMapping("/node/{id}")
    public Node node(@PathVariable("id") long id){
        return nodeService.getNodeById(id);
    }

    @GetMapping("/reply/{id}")
    public Reply reply(@PathVariable("id") long id){
        return replyService.getReplyById(id);
    }

    @GetMapping("/replies/{topicid}")
    public List<Reply> replies(@PathVariable("topicid") long topicId){
        return replyService.getRepliesByTopicId(topicId);
    }
}
