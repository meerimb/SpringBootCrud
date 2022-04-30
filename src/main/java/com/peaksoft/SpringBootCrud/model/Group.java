package com.peaksoft.SpringBootCrud.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupName;
    private LocalDate dateOfStart;
    private LocalDate dateOfFinish;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "course_group"
            , joinColumns = @JoinColumn(name = "group_id")
            , inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    @Override
    public String toString() {
        return groupName;
    }
}

