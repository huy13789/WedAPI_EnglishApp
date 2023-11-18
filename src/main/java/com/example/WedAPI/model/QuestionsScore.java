package com.example.WedAPI.model;

import jakarta.persistence.*;
import lombok.*;
@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "questionscore")
public class QuestionsScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private Long scoreId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Questions question;

    @ManyToOne
    @JoinColumn(name = "user_answer_id", nullable = false)
    private Answers userAnswer;

    @Column(name = "is_correct", nullable = false)
    private boolean isCorrect;
}
