package wallfacer5.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Member {
    @JsonProperty("id")
    @JsonAlias("id")
    private long member_id;
    private String username;
    @JsonProperty("avatar_large")
    @JsonAlias("avatar_large")
    private String avatar;
    private String url;

    @JsonProperty("created")
    @JsonAlias("created")
    private long created_at;

    public Member(){}
    
    public long getMember_id() {
        return member_id;
    }

    public void setMember_id(long member_id) {
        this.member_id = member_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public long getCreated() {
        return created_at;
    }

    public void setCreated(long created) {
        this.created_at = created;
    }

    @Override
    public String toString() {
        return "Member [avatar=" + avatar + ", created_at=" + created_at + ", member_id=" + member_id + ", url=" + url
                + ", username=" + username + "]";
    }

    
}
