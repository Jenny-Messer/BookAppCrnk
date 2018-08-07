// Copyright (c) 2018 Travelex Ltd

package com.BookApp;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiRelationId;
import io.crnk.jpa.annotations.JpaResource;
import lombok.Data;

import java.util.Set;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@JpaResource(type = "authors")
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonApiId
    UUID authorId;

    @JsonApiField
    String name;

    @JsonApiField
    String dob;

    @JsonApiField
    String penName;

    @JsonApiRelation
    @OneToMany
    Set<Book> books;

}
