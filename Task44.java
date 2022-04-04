package com.company;
import java.io.IOException;
import java.io.*;
public class Task44 {
    public static void few() throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader("demo2.txt"));
        BufferedWriter fw = new BufferedWriter(new FileWriter("demo3.txt", true));
        String line;
            if ((line = fr.readLine()) != null) {
                String operators[] = line.split("[0-9]+");
                String operands[] = line.split("[+-/*]");
                for (int i = 1; i < operands.length; i++) {
                    if (operators[i].equals("*")) {
                        operands[i - 1] = Integer.toString(Integer.parseInt(operands[i - 1]) * Integer.parseInt(operands[i]));
                        operands = Task2.RemoveFromArray(operands, i);
                        operators = Task2.RemoveFromArray(operators, i);
                        i--;
                    } else if (operators[i].equals("/")) {
                        operands[i - 1] = Integer.toString(Integer.parseInt(operands[i - 1]) / Integer.parseInt(operands[i]));
                        operands = Task2.RemoveFromArray(operands, i);
                        operators = Task2.RemoveFromArray(operators, i);
                        i--;
                    }

                }
                int agregate = Integer.parseInt(operands[0]);
                for (int i = 1; i < operands.length; i++) {
                    if (operators[i].equals("+"))
                        agregate += Integer.parseInt(operands[i]);
                    else if (operators[i].equals("-"))
                        agregate -= Integer.parseInt(operands[i]);
                }
                System.out.println("Вираз: " + line);
                System.out.println("Резульатат = " + agregate);
                fw.write("Вираз: " + line + " Результат = " + agregate + '\n');
            }
            else
            {
                System.out.println("Введенно не коретні дані!!!");
            }
                fw.close();
                fr.close();
            }
        }


