package com.company;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String n ;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("1 - Завдання 1 - З клавіатури вводиться текстовий рядок, видалити з тексту всі коми.");
            System.out.println("2 - Завдання 2 - З клавіатури вводиться текстовий рядок, видалити всі слова, передостання літера яких голосна.");
            System.out.println("3 - Завдання 3 - В  консольному  арифметичному  калькуляторі  замість  консольного  введення-виведення реалізувати  роботу  з  файлом.  Вхідний  файл  містить  обчислюваний  вираз.  Вихідний –обчислюваний вираз, текст \"Результат=\" і сам результат обчислення..");
            System.out.println("4 - Завдання 4 - З файлу імопртується текст і результат під час роботи записуєтсья в інший файл. (вивести всі слова, що мають парну кількість літер.)");
            System.out.println("5 - Завершити роботу");
            n=in.next();
            switch (n) {
                case "1":
                    Task1.Textwithout();
                    break;
                case "2":
                    Task2.main(args);
                    break;
                case "3":
                    Task44.few();

                    break;
                case "4":
                    fw.main();
                    break;
                case "5":
                    return;
            }
        } while (n!="5");
    }
        }


