package wallfacer5.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Node {
    @JsonProperty("id")
    // @JsonAlias("id")
    private long node_id;
    @JsonProperty("nodename")
    // @JsonAlias("nodename")
    private String nodename;
    private String title;
    @JsonProperty("avatar_large")
    // @JsonAlias("avatar_large")
    private String avatar;
    private String url;
    private long topics;
    
    public Node(){}

    public long getNode_id() {
        return node_id;
    }

    public void setNode_id(long node_id) {
        this.node_id = node_id;
    }

    public String getName() {
        return nodename;
    }

    public void setName(String name) {
        this.nodename = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getTopics() {
        return topics;
    }

    public void setTopics(long topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "Node [avatar=" + avatar + ", node_id=" + node_id + ", name=" + nodename + ", title=" + title
                + ", topics=" + topics + ", url=" + url + "]";
    }

    
}
