package com.company;
import java.util.Scanner;

public class Task3 {
        static float Sum(int n,int x)
        {
            float sum = 0;
            for(int i = 1; i <= n; i++)
            {
                for(int j = 2; j <= n; j++)
                {
                    float a = x + i * j;
                    sum+=a;
                }
            }
            return sum;
        }
        public static void Start()
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Введіть x");
            int x=in.nextInt();
            System.out.println("Введіть n");
            int n=in.nextInt();
            System.out.println("Результат:"+Sum(n, x));
        }
}
