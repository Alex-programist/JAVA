package com.company;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
public class Task3 {
    public static float RRandom(float min, float max) {
        return (float) ((Math.random() * (max - min)) + min);
    }

    public static void ArrayRandom(float[] mat) {

        for (int i = 0; i < mat.length; i++) {

            mat[i] = RRandom(-100, 100);

        }
    }
    public static float medium(float[] mat) {
        float maximum = mat[0];
        float minimum = mat[0];
        for (int i = 1; i < mat.length; i++) {
            if (mat[i] > maximum) maximum = mat[i];
        }
        for (int i = 1; i < mat.length; i++) {
            if (mat[i] < minimum) minimum = mat[i];
        }
       // out.println(maximum);
       // out.println(minimum);
        float b=0;
        b=(maximum+minimum)/2;
        //out.println(b);
        return b;
    }
    static void mediums() {
        int N;
        out.println("Ввеідть розмір масиву: ");
        Scanner sc = new Scanner(in);
        N = sc.nextInt();
        float[] mat = new float[N];
        ArrayRandom(mat);
        out.println("Вивід масиву: ");
        for (int i = 0; i < N; i++) {
            String str;
            str=String.format("%.1f  ",mat[i]);
            out.printf(str);
        }
        out.println();
        out.println("Середнє арифметичне максимального та мінімального елементів масиву: "+" "+ String.format("%.2f  ", medium(mat)));
    }
}
