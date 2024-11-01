package com.telusko.QuizService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    int id;

    String title;
//    @ManyToMany
//    @JoinTable(joinColumns = @JoinColumn(name = "quiz_id"),inverseJoinColumns = @JoinColumn(name = "id"))
    @ElementCollection
    private List<Integer> questionIds;

}
