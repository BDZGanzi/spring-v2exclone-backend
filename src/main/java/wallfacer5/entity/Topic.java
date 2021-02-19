package wallfacer5.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class Topic {
    @JsonProperty("id")
    // @JsonAlias("id")    
    private long topic_id;
    private String title;
    private String content;
    private long member_id;
    private long node_id;
    @JsonProperty("created")
    // @JsonAlias("created")
    private long created_at;
    private long last_modified;
    private int replies;
    @JsonProperty(access = Access.WRITE_ONLY)
    private Member member;
    @JsonProperty(access = Access.WRITE_ONLY)
    private Node node;

    public Topic(){}

    public long getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(long topic_id) {
        this.topic_id = topic_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public long getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(long last_modified) {
        this.last_modified = last_modified;
    }

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "Topic [content=" + content + ", created_at=" + created_at + ", last_modified=" + last_modified
                + ", member=" + member + ", node=" + node + ", replies=" + replies + ", title=" + title + ", topic_id="
                + topic_id + "]";
    }

    public long getMember_id() {
        return member_id;
    }

    public void setMember_id(long member_id) {
        this.member_id = member_id;
    }

    public long getNode_id() {
        return node_id;
    }

    public void setNode_id(long node_id) {
        this.node_id = node_id;
    }


}
