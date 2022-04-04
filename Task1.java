package com.company;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {
    public static void Textwithout()throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть текстовий рядок:");
        String str = sc.next();
        var result = str.replace(",", " ");
        System.out.println("Вивід текстового рядку:= " + result);
    }
}
