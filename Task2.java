package com.company;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
public class Task2 {
    public static String[] RemoveFromArray(String[] arr, int index) {
        String[] newArr = new String[arr.length - 1];

        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        for (int i = index; i < newArr.length; i++) {
            newArr[i] = arr[i + 1];
        }
        return newArr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.println("Ведіть слова:");
        str = sc.nextLine();
        String words[] = str.split(" ");
        for (int i = 0; i < words.length; i++) {
                str = words[i];
                char symbol = str.charAt(str.length() - 2);
                if (symbol == 'а' || symbol == 'у' || symbol == 'е' || symbol == 'і' || symbol == 'и' || symbol == 'О') {
                    words = RemoveFromArray(words, i);
                    i--;
                }
            }
          System.out.println("Вивід слів:");
            for (int i = 0; i < words.length; i++) {
                System.out.println(words[i]);
            }

        }
    }


