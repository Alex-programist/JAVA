package com.company;
import java.util.Scanner;

public class Task1 {
    public static void ArrayInput(int mat[][], int n,int m) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
    }
    static void Swap_First_Last (int mat[][],int n,int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
            int temp = mat[i][0];
            mat[i][0] = mat[i][n - 1];
            mat[i][n - 1] = temp;
        }
    }
    }
        public static void mat () {
            int n;
            int m;
            System.out.println("Ввеідть розмір матриці:");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            m = sc.nextInt();
            int mat[][] = new int[n][m];
            System.out.println("Введіть елементи двохвимірного масиву:");
            ArrayInput(mat, n, m);
            System.out.println("Вивід елементів матриці");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.printf("%5d", mat[i][j]);
                }
                System.out.println();
            }
            System.out.println("Вивід елементів матриці після переміщення");
            Swap_First_Last(mat,n,m);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.printf("%5d", mat[i][j]);
                }
                System.out.println();
            }
        }
    }
