package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float y;
        System.out.println("Введіть значення х та z");
        int x = in.nextInt(),z = in.nextInt();
        if(x==5)
            System.out.println("Значення функції y="+ (y=3+x*z));
        if(x==-5)
            System.out.println("Значення функції y="+ (y=(x*z)/(7-z)));
        if(x==0)
            System.out.println("Значення функції y="+ (y=x));
        /*
           i  System.f(x==5)
          System.out.println("Значення функції y="+ (y=3+x*z));
           else if(x==-5)
            System.out.println("Значення функції y="+ (y=(x*z)/(7-z)));
           else if(x==0)
            System.out.println("Значення функції y="+ (y=x));
         */
    }
}
