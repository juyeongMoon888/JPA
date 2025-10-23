package com.ohgiraffers.valueobject.chap01.section01;

import com.ohgiraffers.valueobject.chap01.section01.model.Reservation;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        Reservation reservation = new Reservation(
                "김철수",
                "101호",
                2,
                LocalDate.of(2025, 8, 1),
                LocalDate.of(2025, 8, 3),
                10000
        );
        System.out.println("예약 숙박일수: " + reservation.calculateNights());

        reservation.setTotalPrice(100);
        System.out.println("변경된 총 가격: " + reservation.getTotalPrice());

        Reservation reservation2 = new Reservation(
                "김철수",
                "101호",
                2,
                LocalDate.of(2025, 8, 3),
                LocalDate.of(2025, 8, 1),
                10000
        );
        System.out.println("예약 숙박일수: " + reservation2.calculateNights());

        reservation.setTotalPrice(100);
        System.out.println("변경된 총 가격: " + reservation2.getTotalPrice());
    }


}
