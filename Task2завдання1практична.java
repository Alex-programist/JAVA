package com.company;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Task2 {
    public static int RRandom(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void ArrayRandom(int[] mat) {

        for (int i = 0; i < mat.length; i++) {

            mat[i] = RRandom(-100, 100);
        }
    }
    public static int sum(int[] mat, int N)
    {
        int dot1 = 0;
        int dot2 = 0;
        for(int i = 0; i < N; i++)
        {
            if(mat[i] > 0) {
                dot1 = i;
                break;
            }
        }
        for(int k = dot1+1; k < N; k++)
        {
            if(mat[k] >= 0) {
                dot2 = k;
                break;
            }
        }
        int sum=0;
        for(int m=dot1;m<=dot2;m++)
        {
            sum+=mat[m];
        }
      //out.println(sum);
        return sum;
    }
    static void suma() {
        int N;
        out.println("Ввеідть розмір масиву: ");
        Scanner sc = new Scanner(in);
        N = sc.nextInt();
        int[] mat = new int[N];
        ArrayRandom(mat);
        out.println("Вивід масиву: ");
        for (int i = 0; i < N; i++) out.printf("%5d", mat[i]);
        out.println();
        out.println("Сума елементів масиву між першим і другим додатніми елементами: "+" "+sum(mat,N));
    }
    }

