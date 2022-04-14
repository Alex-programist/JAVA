package com.company;

import java.util.Scanner;

import static java.lang.System.*;

public class Task1 {
    public static int RRandom(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void ArrayRandom(int[] mat) {

        for (int i = 0; i < mat.length; i++) {

            mat[i] = RRandom(-100, 100);
        }
    }
    public static int max(int[] mat) {
        int maximum = mat[0];
        for (int i = 1; i < mat.length; i++) {
            if (mat[i] > maximum) maximum = mat[i];
        }
       // out.println(maximum);
        return maximum;
    }
    static void maximum() {
        int N;
        out.println("Ввеідть розмір масиву: ");
        Scanner sc = new Scanner(in);
        N = sc.nextInt();
        int[] mat = new int[N];
        ArrayRandom(mat);
        out.println("Вивід масиву: ");
        for (int i = 0; i < N; i++) out.printf("%5d", mat[i]);
        out.println();
        out.println("Максимальний елемент масиву: "+" "+max(mat));
    }
}