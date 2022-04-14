package com.company;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;
import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
            String n ;
            Task1Test a=new Task1Test();
            a.max();
            Scanner in = new Scanner(System.in);
            do {
                out.println("1 - Завдання 1 - Знайти максимальний елемент масиву.");
                out.println("2 - Завдання 2 - Знайти суму елементів масиву між першим й другим додатними елементами.");
                out.println("3 - Завдання 3 - Знайти середнє значення максимального та мінімального елементів масиву.");
                out.println("4 - Завершити роботу");
                n=in.next();
                switch (n) {
                    case "1":
                        Task1.maximum();
                        break;
                    case "2":
                        Task2.suma();
                        break;
                    case "3":
                        Task3.mediums();
                        break;
                    case "4":
                        return;
                    default:
                        throw new IllegalStateException("Ви ввели не правильне значення: " + n);
                }
            } while (n!="4");
        }

    }

