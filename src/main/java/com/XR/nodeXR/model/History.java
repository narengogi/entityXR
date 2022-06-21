package com.XR.nodeXR.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class History {
    @Id
    @JsonProperty
    private String id;

    @Property
    @JsonProperty
    private String title;

    @Property
    @JsonProperty
    private String url;

    @Property
    @JsonProperty
    private String lastVisitTimeLocal;

    @Property
    @JsonProperty
    private String lastVisitTimeUTC;

    @Property
    @JsonProperty
    private String typedCount;

    @Property
    @JsonProperty
    private String visitCount;

    @Relationship(type = "parent")
    @JsonIgnore
    private String test;
}
