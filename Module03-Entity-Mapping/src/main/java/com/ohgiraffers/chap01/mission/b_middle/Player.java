package com.ohgiraffers.chap01.mission.b_middle;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "players")
public class Player {
    private int id;
    private String name;
}
