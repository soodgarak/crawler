package io.fun_staurant.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String description;

    private String imageURL;

    private Recipe (String title, String contents, String description, String imageURL) {
        this.title = title;
        this.contents = contents;
        this.description = description;
        this.imageURL = imageURL;
    }

    public static Recipe of(String title, String contents, String description, String imageURL) {
        return new Recipe(title, contents, description, imageURL);
    }
}
