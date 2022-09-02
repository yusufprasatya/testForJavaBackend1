package com.testForJavaBackend1.testForJavaBackend1.entity;

import lombok.NonNull;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "galeries")
public class Galery {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @NonNull
    private String title;

    @NonNull
    private String link;

    @NonNull
    private String[] media;

    @NonNull
    private String date_taken;

    @NonNull
    @Column(columnDefinition="TEXT")
    private String description;

    @NonNull
    private String published;

    @NonNull
    private String author;

    @NonNull
    private String author_id;

    @NonNull
    private String[] tags;
}
