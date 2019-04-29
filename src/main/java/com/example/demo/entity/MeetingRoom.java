package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class MeetingRoom {



    @Id
    private int id;

    private String name;

    private int capacity;

    public MeetingRoom() {
    }
}
