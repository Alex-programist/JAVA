package com.company;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Listle{
    void Remove() throws IOException;
    void PrintObject();
    static void AddObject(){}
    static void date(){}
    static void PrintAllObjects(){}
    static void date_this(){}
}
class Student implements Listle, Serializable{

    private int date;
    private int month;
    private int year;
    private String name;
    private String surname;
    public static List<Student> students = new ArrayList<>();

    public Student(int date, int month, int year, String name, String surname) {
        this.date = date;
        this.month = month;
        this.year = year;
        this.name = name;
        this.surname = surname;
        students.add(this);
    }
    public Student(){}

    public static void AddObject(){
        try {
            System.out.println("\tДата народження:");
            System.out.println("\tДень:");
            int date = new Scanner(System.in).nextInt();
            System.out.println("\tМісяць:");
            int month = new Scanner(System.in).nextInt();
            System.out.println("\tРік:");
            int year = new Scanner(System.in).nextInt();
            System.out.print("\tІм'я: ");
            String name = new Scanner(System.in).nextLine();
            System.out.print("\tПрізвище: ");
            String surname = new Scanner(System.in).nextLine();
            Student a = new Student(date, month, year, name, surname);
        }catch (Exception ex)
        {
            System.out.println("Введено не коретні дані!!!");
            System.out.println("Повторіть спробу!!!");
            AddObject();
        }
    }
    @Override
    public void PrintObject() {
        System.out.println("\tДата народження: " + this.date + " " +this.month+" "+this.year+" ");
        System.out.println("\tІм'я: " + this.name);
        System.out.println("\tПрізвище: " + this.surname);
    }
    public static void PrintAllObjects(){
        for(int i = 0; i < students.size(); i++){
            System.out.println("Студент №" + (i + 1));
            students.get(i).PrintObject();
        }
    }
    @Override
    public void Remove() throws IOException {
        students.remove(this);
    }
    public static void date() {
        int dat = LocalDateTime.now().getDayOfMonth();
        int mont = LocalDateTime.now().getMonthValue();
        int yea = LocalDateTime.now().getYear();
        System.out.println("Сьогоднішня дата: "+ dat + " " + " " + mont + " " + " " + yea);
        int q = dat + mont + yea;
        int min=Math.abs(q-students.get(0).date+students.get(0).month+students.get(0).year);
        for (int i = 0; i < students.size(); i++)
        {
            int qq=students.get(i).date+students.get(i).month+students.get(i).year;
            if(Math.abs(q-qq)<min)
            {
                min=Math.abs(q-qq);
            }
        }
      //  System.out.println(min);
        for(int k=0; k<students.size();k++)
        {
            int qq=students.get(k).date+students.get(k).month+students.get(k).year;
            int e=Math.abs(q-qq);
            if(e==min)
            {
                students.get(k).PrintObject();
                return;
            }
        }
    }
    public static void date_this() {
        int dat = LocalDateTime.now().getDayOfMonth();
        int mont = LocalDateTime.now().getMonthValue();
        int yea = LocalDateTime.now().getYear();
        System.out.println("Сьогоднішня дата: "+ dat + " " + " " + mont + " " + " " + yea);
        int q = dat + mont + yea;
        for (int i = 0; i < students.size(); i++)
        {
            System.out.println("Студент №" + (i + 1));
            int qq=students.get(i).date+students.get(i).month+students.get(i).year;
            if(q-qq>=0)
            {
                continue;
            }
            if(students.get(i).year!=yea)
            {
                continue;
            }
            students.get(i).PrintObject();
        }
    }
}
class File{
    public static String path;
    public static void SetPath(){
        System.out.print("Введіть шлях до файлу: ");
        path =new Scanner(System.in).nextLine();
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
        //Listte e = new Student();
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("1 - Ввести інформацію про студента.");
            System.out.println("2 - Вивести інформацію про студента.");
            System.out.println("3 - Записати інформацію в файл.");
            System.out.println("4 - Зчитати інформацію з файла.");
            System.out.println("5 - Вивести інформацію про студента з найближчим днем народження.");
            System.out.println("6 - Вивести дані про студентів, дні народження яких ще будуть у поточному році (відлік вести від поточної дати).");
            System.out.println("7 - Видалити запис.");
            System.out.println("8 - Завершити роботу.");
            n = in.next();
            switch (n) {
                case "1":
                    Student.AddObject();
                    break;
                case "2":
                    Student.PrintAllObjects();
                    break;
                case "3":
                    File.SetPath();
                    File.WriteList(Student.students, "student");
                    System.out.println("Інформація записана в файл.");
                    break;
                case "4":
                    File.SetPath();
                    System.out.println("Зчитування з файла - успішне!");
                    Student.students = File.<Student>ReadList("student");
                    break;
                case "5":
                    Student.date();
                    break;
                case "6":
                    Student.date_this();
                    break;
                case "7":
                    System.out.print("Введіть номер студента: ");
                    int nn = new Scanner(System.in).nextInt();
                    System.out.println("Запис видалено.");
                    if(nn < 1 || nn > Student.students.size()){
                        System.out.println("Студента з таким номером нема!");
                        break;
                    }
                    Student.students.remove(nn-1);
                    break;
                case "8":
                    return;
            }
        } while (n != "8");
    }
}

