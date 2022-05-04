package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Listle{
    static float Avg(List<work_day> work_days)
    {
        return 0;
    }
    static int Min(List<work_day> work_days)
    {
        return 0;
    }
    static int Count_way(List<work_day> work_days)
    {
        return 0;
    }
    void Remove();
    void PrintObject();
    static void AddObject(){}
    static void PrintAllObjects(){}

}
abstract class water_pull implements  Listle,Serializable
{
    protected String name;
    protected String adress;
    public water_pull(){}
}
class work_day extends water_pull implements Listle,Serializable {
    private String day;
    private int count_people;
    private int count_way;
    public static List<work_day> work_days = new ArrayList<>();

    public work_day() {

    }

    public work_day(String name, String adress, String day, int count_people, int count_way) {
        this.name = name;
        this.adress = adress;
        this.day = day;
        this.count_people = count_people;
        this.count_way = count_way;
        work_days.add(this);
    }

    @Override
    public void Remove() {
        work_days.remove(this);
    }

    @Override
    public void PrintObject() {
        System.out.println("\tНазва: " + this.name);
        System.out.println("\tАдреса: " + this.adress);
        System.out.println("\tДата: " + this.day);
        System.out.println("\tКількість відвідувачів: " + this.count_people);
        System.out.println("\tКількість доріжок: " + this.count_way);
    }

    public static void PrintAllObjets() {
        for (int i = 0; i < work_days.size(); i++) {
            System.out.println("Басейн №" + (i + 1));
            work_days.get(i).PrintObject();
        }
    }

    public static void AddObject() {
        try {
            System.out.println("\tВведіть назву басейну: ");
            String name = new Scanner(System.in).nextLine();
            System.out.println("\tВведіть aдресу: ");
            String adress = new Scanner(System.in).nextLine();
            System.out.println("\tВведіть дату: ");
            String day = new Scanner(System.in).nextLine();
            System.out.print("\tВведіть кількість людей: ");
            int count_people = new Scanner(System.in).nextInt();
            System.out.print("\tВведіть кількість доріжок: ");
            int count_way = new Scanner(System.in).nextInt();
            work_day a = new work_day(name, adress, day, count_people, count_way);
        } catch (Exception ex) {
            System.out.println("Введено некоректні значення!!!");
            System.out.println("Повторіть спробу!!!");
            AddObject();
        }
    }

    public static float Avg(List<work_day> work_days) {
        float cou = 0;
        for (int i = 0; i < work_days.size(); i++) {
            cou += work_days.get(i).count_people;
        }
        System.out.println("Середня кількість відвідувачів: " + cou / work_days.size());
        return cou / work_days.size();
    }

    public static int Min(List<work_day> work_days) {
        int min = work_days.get(0).count_way;
        for (int i = 0; i < work_days.size(); i++) {
            if (work_days.get(i).count_way < min) {
                min = work_days.get(i).count_way;
            }
        }
        for (int k = 0; k < work_days.size(); k++) {
            System.out.println("Басейн №" + (k + 1));
            if (work_days.get(k).count_way == min) {
                work_days.get(k).PrintObject();
            }
        }
        return min;
    }

    public static int Count_way(List<work_day> work_days) {
            int cou=0;
            int cou1=0;
            System.out.print("Введіть кількість доріжок: ");
            cou = new Scanner(System.in).nextInt();
            for(int i = 0; i < work_days.size(); i++){
                if(work_days.get(i).count_way>=cou)
                {
                    cou1++;
                }
            }
            System.out.println("Кількітсть доріжок більша за введене значення: " + cou1);
            return 0;
    }
}
class File{
    public static String path;
    public static void SetPath(){
        System.out.print("Введіть шлях до файлу: ");
        path = new Scanner(System.in).nextLine();
    }
    public static <T>void WriteList(List<T> Tlist, String fileName) throws IOException {
        FileOutputStream writeData = new FileOutputStream(path + "/" + fileName + ".dat");
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
        writeStream.writeObject(Tlist);
        writeStream.flush();
        writeStream.close();
    }
    public static <T>List<T> ReadList(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(path + "/" + fileName + ".dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<T> Tlist = (List<T>) ois.readObject();
        ois.close();
        return Tlist;
    }
}
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String n;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("1 - Ввести інформацію про басейн.");
            System.out.println("2 - Вивести інформацію про басейн.");
            System.out.println("3 - Записати інформацію в файл.");
            System.out.println("4 - Зчитати інформацію з файла.");
            System.out.println("5 - Вивести середню кількість відвідувачів.");
            System.out.println("6 - Вивести дні з мінімальною кількістю доступних доріжок.");
            System.out.println("7 - Кількість днів, коли було доступно не менше зазначеної кількості доріжок.");
            System.out.println("8 - Видалити запис.");
            System.out.println("9 - Завершити роботу.");
            n = in.next();
            switch (n) {
                case "1":
                    work_day.AddObject();
                    break;
                case "2":
                    work_day.PrintAllObjets();
                    break;
                case "3":
                    File.SetPath();
                    File.WriteList(work_day.work_days, "water");
                    System.out.println("Інформація записана в файл.");
                    break;
                case "4":
                    File.SetPath();
                    System.out.println("Зчитування з файла - успішне!");
                    work_day.work_days = File.<work_day>ReadList("water");
                    break;
                case "5":
                    work_day.Avg(work_day.work_days);
                    break;
                case "6":
                    work_day.Min(work_day.work_days);
                    break;
                case "7":
                    work_day.Count_way(work_day.work_days);
                    break;
                case "8":
                    System.out.print("Введіть номер басейна: ");
                    int nn = new Scanner(System.in).nextInt();
                    System.out.print("Басейн видално.");
                    if(nn < 1 || nn > work_day.work_days.size()){
                        System.out.println("Басейна з таким номером нема!");
                        break;
                    }
                    work_day.work_days.remove(nn-1);
                    break;
                case "9":
                    return;
            }
        } while (n != "9");
    }
}