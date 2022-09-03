package com.testForJavaBackend1.testForJavaBackend1.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "galeries")
public class Galery {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String title = "Default title";
    private String link = "Default link";
    private String[] media = {"media"};
    private String date_taken = "Default date";

    @Column(columnDefinition="TEXT")
    private String description = "Default description";
    private String published = "Default published";
    private String author = "Default author";
    private String author_id = "Default authorId";
    private String[] tags = {"Default tags"};
}
