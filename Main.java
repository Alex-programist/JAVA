package com.company;
import java.util.Scanner;

public class Main {

    static boolean function(int circle_x, int circle_y,int rad, int x, int y)
    {
        if ((x - circle_x) * (x - circle_x) +
                (y - circle_y) * (y - circle_y) <= rad * rad)
            return true;
        else
            return false;
    }
        public static void main(String arg[])
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Введіть кординати точки A");
            int x = in.nextInt(), y = in.nextInt();;
            System.out.println("Введіть кординати центра кола та радіус");
            int circle_x = in.nextInt(), circle_y = in.nextInt(), rad = in.nextInt();
            if (function(circle_x, circle_y, rad, x, y))
                System.out.print("Точка находиться всередині кола");
            else
                System.out.print("Точка находиться зовні кола");
        }
    }




