package com.example.WedAPI.model;

import jakarta.persistence.*;
import lombok.*;
@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "totalquestionsscore")
public class TotalQuestionsScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "total_score_id")
    private Long totalScoreId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private QuestionsScore quiz;

    @Column(name = "total_score", nullable = false)
    private int totalScore;
}
