package com.startup.mvp.entity;

import lombok.*;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;

@Data
@Document(collectionName = "users")
public class User {
    @DocumentId
    private String id;
    private String name;
    private String email;
    // getters/setters
}
