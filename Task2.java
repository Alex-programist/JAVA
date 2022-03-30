package com.company;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static int RRandom(int min, int max)
    {
        return (int) ((Math.random() * (max-min)) + min);
    }
    public static void ArrayRandom(int mat[][]) {

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = RRandom(1, 1);
            }
        }
    }
        static boolean isMagicSquare(int mat[][],int N) {
           int sumd1 = 0, sumd2 = 0;
            for (int i = 0; i < N; i++) {
                sumd1 += mat[i][i];
                sumd2 += mat[i][N - 1 - i];
            }
            if (sumd1 != sumd2)
                return false;
            for (int i = 0; i < N; i++) {

                int rowSum = 0, colSum = 0;
                for (int j = 0; j < N; j++) {
                    rowSum += mat[i][j];
                    colSum += mat[j][i];
                }
                if (rowSum != colSum || colSum != sumd1)
                    return false;
            }
            return true;
        }
        public static void squere() {
            int N;
            System.out.println("Ввеідть розмір квадратної матриці:");
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            int mat[][]=new int [N] [N];
            ArrayRandom(mat);
            //int[] [] nums = new int [] []{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};;
            System.out.println("Вивід елементів квадратної матриці");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.printf ( "%5d", mat[i][j]);
                }
                System.out.println();
                }
                if (isMagicSquare(mat,N))
                System.out.println("Матриця  є магічним квадратом");
            else
                System.out.println("Матриця  не є магічним квадратом");
        }
    }
