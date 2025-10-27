package com.ohgiraffers.chap01.mission.b_middle;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "team_id")
    private Team team;

    public Player() {

    }

    public Player(String name) {
        this.name = name;
    }


    public void setTeam(Team team) {
        this.team = team;
    }
}
