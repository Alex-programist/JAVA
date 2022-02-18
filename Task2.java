package com.company;
import java.util.Scanner;

public class Task2 {
    static int squareSum(int n) {
        int sum = 0;
        for (int i = 1; i <= 5; i++)
            sum += (2 * i - 1) * (2 * i - 1);
        return sum;
    }

    static int squareSum1(int n) {
        int sum=0;
        int i = 1;
        while(i<=5)
        {
            sum += (2 * i - 1) * (2 * i - 1);
            i++;
        }
        return  sum;
    }
    static int squareSum2(int n) {
        int sum=0;
        int i = 1;
        do
        {
            sum += (2 * i - 1) * (2 * i - 1);
            i++;
        }
        while(i<=5);
        return  sum;
    }
    public static void Start()
    {
        System.out.println("Квадрат суми всіх непарних чисел у діапазоні [1;10](цикл з параметром)= " + squareSum(5));
        System.out.println("Квадрат суми всіх непарних чисел у діапазоні [1;10](цикл з передумовою)= " + squareSum1(5));
        System.out.println("Квадрат суми всіх непарних чисел у діапазоні [1;10](цикл з післяумовою)= " + squareSum2(5));
    }
}

