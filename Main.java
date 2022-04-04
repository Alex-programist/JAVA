package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String n ;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("1 - Завдання 1");
            System.out.println("2 - Завдання 2");
            System.out.println("3 - Завершити роботу");
            n=in.next();
            switch (n) {
                case "1":
                    System.out.println("Завдання 1 - Поміняти перший і передостаній стовпці матриці.");
                    Task1.mat();
                    break;
                case "2":
                    System.out.println("Завдання 2 - Ввести квадратну матрицю цілих чисел. Визначити, чи ця матриця є магiчним квадратом, для якого суми елементiв кожного рядка i стовпчика є однаковими..");
                    Task2.squere();
                    break;
                case "3":
                    return;
            }
        } while (n!="3");
    }
}
