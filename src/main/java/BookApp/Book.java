// Copyright (c) 2018 Travelex Ltd

package BookApp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

    private String id;
    private int pages;
    private String title;
    private String authorId;
    private String contents;

    @JsonCreator
    public Book(@JsonProperty("pages") int pages,
                @JsonProperty("title") String title,
                @JsonProperty("contents") String contents) {
        this.pages = pages;
        this.title = title;
        this.contents = contents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
