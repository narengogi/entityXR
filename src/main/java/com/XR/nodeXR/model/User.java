package com.XR.nodeXR.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node
@Getter
public class User {

    @Id
    @Setter
    private final String userName;

    @Setter
    @Property("firstName")
    private final String firstName;

    @Setter
    @Property("secondName")
    private final String secondName;

    public User(String userName, String firstName, String secondName) {
        this.userName = userName;
        this.firstName = firstName;
        this.secondName = secondName;
    }
}
