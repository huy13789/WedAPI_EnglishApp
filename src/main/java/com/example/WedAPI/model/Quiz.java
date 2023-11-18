package com.example.WedAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Long quizId;

    @Column(name = "nameQuiz", length = 50, nullable = false, unique = true)
    @Size(max = 50, message = "nameCategory must be less than 250 characters")
    private String nameQuiz;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
