package com.company;
import java.util.Scanner;

public class Task4 {
    public static float q(float a, float b, float dx)
    {
        float x;
        for(x=a;x<0;x+=dx){}
        return x;
    }
public static void Start(){
        Scanner in = new Scanner(System.in);
        System.out.println("Функція:2+x3/x^13");
        float a=-3;
        float b=3;
        float dx=0.5f;
        System.out.println("x\t\t|\ty");
        System.out.println("----------------------------");
        for (float x=a;x<=b;x+=dx)
        {
            System.out.println("%.2f\t|\t"+x);
        try {

            if (x==q(a,b,dx)) throw new ArithmeticException ("Помилка, ділення на 0 не можливе!");
            float y=(float)((2+Math.pow(x,2))/(x+Math.sqrt(13)));
            System.out.println("$.5f\n"+y);
        }
        catch (ArithmeticException ex)
        {
         System.out.println(ex.getMessage());
        }
        }
}
}