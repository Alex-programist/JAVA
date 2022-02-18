package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        String n ;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("1-Обчислення функції");
            System.out.println("2-Знаходження квадрату суми непарних чисел в діапазоні [1;10]");
            System.out.println("3-Знаходження суми за формулою");
            System.out.println("4-Вивести значення функції у табличному вигляді");
            System.out.println("5-Закінчити роботу");
            n=in.next();
            switch (n) {
                case "1":
                    System.out.println("Завдання 1");
                    Task1.Start();
                    break;
                case "2":
                    System.out.println("Завдання 2");
                    Task2.Start();
                    break;
                case "3":
                    System.out.println("Завдання 3");
                    Task3.Start();
                    break;
                case "4":
                    System.out.println("Завдання 4");
                    Task4.Start();
                    break;
                case "5":
                    return;
            }

        } while (n!="5");
    }
}
