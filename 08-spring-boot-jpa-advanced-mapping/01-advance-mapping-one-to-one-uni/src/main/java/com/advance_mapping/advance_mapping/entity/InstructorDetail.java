package com.advance_mapping.advance_mapping.entity;

import jakarta.persistence.*;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="youtube_channel")
    private String youtubeChannnel;

    @Column(name="hobby")
    private String hobby;

    // define default constructor
    public InstructorDetail() {}

    // define parameterized constructor
    public InstructorDetail(String youtubeChannnel, String hobby) {
        this.youtubeChannnel=youtubeChannnel;
        this.hobby=hobby;
    }

    // define getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannnel() {
        return youtubeChannnel;
    }

    public void setYoutubeChannnel(String youtubeChannnel) {
        this.youtubeChannnel = youtubeChannnel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    // define toString method

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannnel='" + youtubeChannnel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
