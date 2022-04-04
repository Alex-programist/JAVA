package com.company;
import java.io.IOException;
import java.io.*;

public class fw {
    public static void main() throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader("demo.txt"));
        BufferedWriter fw = new BufferedWriter(new FileWriter("demo1.txt"));
        String line;
        System.out.println("Вивід слів з парною кількістю символів:");
        while ((line = fr.readLine()) != null)
        {
            if(line.length()%2==0)
            {
                fw.write(line+ '\n');
                System.out.println(line);
            }
            else
            {
                 System.out.println("Немає слів з праною кількістю елементів!");
            }
        }
        fw.close();
        fr.close();
    }
    }



