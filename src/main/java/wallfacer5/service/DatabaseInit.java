package wallfacer5.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import wallfacer5.entity.Member;
import wallfacer5.entity.Node;
import wallfacer5.entity.Reply;
import wallfacer5.entity.Topic;
import wallfacer5.mapper.MemberMapper;
import wallfacer5.mapper.NodeMapper;
import wallfacer5.mapper.ReplyMapper;
import wallfacer5.mapper.TopicMapper;

@Component
public class DatabaseInit {
    @Value("hotTopics.json")
    Resource resource;

    @Autowired
    TopicMapper topicMapper;

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    NodeMapper nodeMapper;

    @Autowired
    ReplyMapper replyMapper;

    Logger logger = LoggerFactory.getLogger(getClass());

    HttpClient httpClient = HttpClient.newBuilder().build();

    public void init() throws InterruptedException, IOException, URISyntaxException {
        // String url = "https://www.v2ex.com/api/topics/hot.json";
        // String data = getSourceFromAPI(url);
        // InputStream data = resource.getInputStream();

        // if (data != null) {
        //     ObjectMapper mapper = new ObjectMapper();
        //     mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //     try {
        //         List<Topic> topics = Arrays.asList(mapper.readValue(data, Topic[].class));
        //         List<Long> existedMemberIds = memberMapper.getAllMemberIds();
        //         List<Long> existedNodeIds = nodeMapper.getAllNodeId();
        //         List<Long> existedtopicIds = topicMapper.getAllTopicId();

        //         for (Topic topic : topics) {
        //             if (!existedtopicIds.contains(topic.getTopic_id())) {
        //                 initTopic(topic);
        //             }
        //             initReplyByTopicId(topic.getTopic_id());
        //             Thread.sleep(30000);

        //             if(!existedNodeIds.contains(topic.getNode().getNode_id())){
        //                 initNodeById(topic.getNode().getNode_id());
        //             }

        //             if(!existedMemberIds.contains(topic.getMember().getMember_id())){
        //                 initMemberById(topic.getMember().getMember_id());
        //             }
        //         }

        //     } catch (JsonProcessingException e) {
        //         // TODO Auto-generated catch block
        //         e.printStackTrace();
        //     }

        // }
        List<Long> exsitedMemberIds = memberMapper.getAllMemberIds();

        List<Long> memberIds = replyMapper.getAllMemberId();
        int n = 0, m = 0;
        for(Long id : memberIds){
            if(!exsitedMemberIds.contains(id)){
                initMemberById(id.longValue());
                n++;
                if(n == 10){
                    n = 0;
                    m++;
                    if(m == 5)
                        return;
                    Thread.sleep(20000);
                }
                Thread.sleep(1000);
            }else{
                logger.info("member {} existed.", id.longValue());
            }
        }
    };

    public void initTopicById(long topicId) throws URISyntaxException, InterruptedException, IOException {
        String url = "https://www.v2ex.com/api/topics/show.json?id=" + topicId;
        String data = getSourceFromAPI(url);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Topic topic = mapper.readValue(data, Topic.class);
        try{
            topicMapper.insert(topic);
        }catch(DataAccessException e){
            logger.info("topic {} insert failed.", topic.getTopic_id());
            // 跳过不处理
        }
    };

    public void initTopic(Topic topic) {
        try {
            topicMapper.insert(topic);
        } catch (DataAccessException e) {
            logger.info("topic {} insert failed.", topic.getTopic_id());
        }
    };

    public void initMemberById(long memberId) throws URISyntaxException, InterruptedException, IOException {
        String url = "https://www.v2ex.com/api/members/show.json?id=" + memberId;
        String data = getSourceFromAPI(url);
        // logger.info(data);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Member member = mapper.readValue(data, Member.class);
        try {
            memberMapper.insert(member); 
        } catch (DataAccessException e) {
            logger.info("member {} insert failed.", memberId);
        }
    }

    void initNodeById(long nodeId) throws URISyntaxException, InterruptedException, IOException {
        String url = "https://www.v2ex.com/api/nodes/show.json?id=" + nodeId;
        String data = getSourceFromAPI(url);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Node node = mapper.readValue(data, Node.class);
        try {
            nodeMapper.insert(node);
        } catch (DataAccessException e) {
            logger.info("node {} insert failed.", nodeId);
        }
    }

    void initReplyByTopicId(long topicId) throws URISyntaxException, IOException, InterruptedException {
        String url = "https://www.v2ex.com/api/replies/show.json?topic_id=" + topicId;
        String data = getSourceFromAPI(url);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Reply> replies = Arrays.asList(mapper.readValue(data, Reply[].class));
        for (Reply reply : replies) {
            try {
                replyMapper.insert(reply);
            } catch (DataAccessException e) {
                logger.info("reply {} insert failed.", reply.getReply_id());
            }
        }
    }

    // void initReply(Reply reply) {
    //     replyMapper.insert(reply);
    // }

    String getSourceFromAPI(String url) throws URISyntaxException, InterruptedException, IOException {
        HttpRequest request;
        request = HttpRequest.newBuilder(new URI(url))
            .header("User-Agent", "Java HttpClient").header("Accept", "*/*")
            .timeout(Duration.ofSeconds(20))
            .version(Version.HTTP_2).build();
        HttpResponse<String> response;
        response = httpClient.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
        return response.body();
    }
}
