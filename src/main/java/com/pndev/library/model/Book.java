package com.pndev.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table (name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    @NotBlank(message = "Title should not be blank")
    private String title;

    @Column(name = "author", nullable = false)
    @NotBlank(message = "Author should not be blank")
    private String author;

    @Column(name = "publication_year", nullable = false)
    @Min(value = 1500, message = "Publication year should be greater than 1500")
    @Max(value = 2100, message = "Publication year should be less than 2100")
    private Integer publicationYear;

    @Builder.Default
    @Column(nullable = false)
    private Boolean available = true;

}
