// Copyright (c) 2018 Travelex Ltd

package com.BookApp;

import static io.crnk.core.resource.annotations.LookupIncludeBehavior.AUTOMATICALLY_ALWAYS;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiRelationId;
import io.crnk.jpa.annotations.JpaResource;
import lombok.Data;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@JpaResource(type = "books")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonApiId
    UUID id;

    @JsonApiField
    int pages;

    @JsonApiField
    String title;

    @JsonApiRelation
    @ManyToOne
    Author authorId;

    @JsonApiField
    String contents;

}
