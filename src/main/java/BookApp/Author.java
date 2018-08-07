// Copyright (c) 2018 Travelex Ltd

package BookApp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Author {

    private String id;
    private String name;
    private String dob;
    private String penName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonCreator
    public Author(@JsonProperty("name") String name,
                  @JsonProperty("dob") String dob,
                  @JsonProperty("penName") String penName) {
        this.name = name;
        this.dob = dob;
        this.penName = penName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPenName() {
        return penName;
    }

    public void setPenName(String penName) {
        this.penName = penName;
    }

}
