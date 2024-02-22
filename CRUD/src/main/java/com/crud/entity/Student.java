package com.crud.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name = "Student")
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "fullName", nullable = false, length = 100)
    private String fullName;
    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;
    @Column(name = "email", unique = true, length = 100)
    private String email;

    @Column(name = "phoneNumber", length = 10)
    private String phoneNumber;

}
