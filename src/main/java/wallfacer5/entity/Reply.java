package wallfacer5.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Reply {
    @JsonProperty("id")
    @JsonAlias("id")   
    private long reply_id;
    private String content;
    // TODO
    private long member_id;
    private long topic_id;
    @JsonProperty("created")
    @JsonAlias("created")
    private long created_at;
    private long last_modified;
    private int thanks;

    public Reply(){}

    public long getReply_id() {
        return reply_id;
    }

    public void setReply_id(long reply_id) {
        this.reply_id = reply_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getMember_id() {
        return member_id;
    }

    public void setMember_id(long member_id) {
        this.member_id = member_id;
    }

    public long getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(long topic_id) {
        this.topic_id = topic_id;
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

    public int getThanks() {
        return thanks;
    }

    public void setThanks(int thanks) {
        this.thanks = thanks;
    }

    @Override
    public String toString() {
        return "Reply [content=" + content + ", created_at=" + created_at + ", last_modified=" + last_modified
                + ", member_id=" + member_id + ", reply_id=" + reply_id + ", thanks=" + thanks + ", topic_id="
                + topic_id + "]";
    }

    
}
