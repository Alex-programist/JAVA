package com.company;
import java.util.Scanner;
public class Task1 {
    public static void Start() {
        Scanner in = new Scanner(System.in);
        System.out.println("Обчислення значень функції f = ((x+y)/(x2+x*y-y2)+x/(1-y2)+y/)1+x2))");
        boolean error = true;
        do {
            try {
                System.out.print("Введіть x: ");
                int x = in.nextInt();
                System.out.print("Введіть y: ");
                int y = in.nextInt();
                float div = (float) (Math.pow(x,2)+x*y-Math.pow(y,2));
                float div1= (float) (1-Math.pow(y,2));
                float div2= (float) (1+Math.pow(x,2));
                if(div == 0 || div1==0 || div2==0) throw new ArithmeticException("Для заданих значень у обчислюваному виразі виконується ділення на 0");
                float f = (float) (x+y) / div + x/div1 + y/div2;
                System.out.printf("Результат: %f\n", f);
                error = false;
            }
            catch (ArithmeticException ex) {
                System.out.println(ex.getMessage());
            }
        } while (error);
    }
}
