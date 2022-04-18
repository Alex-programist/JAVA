package com.company;
import java.io.*;
import java.util.*;

class bank implements Serializable {
    private String first_name;
    private String name;
    private String date;
    private float price;
    public static List<bank> people = new ArrayList<>();
    public static List<bank> sorted = new ArrayList<>();

    public bank(){}

    public bank(bank b) throws IOException {
        this.first_name = b.first_name;
        this.name = b.name;
        this.date = b.date;
        this.price = b.price;
        people.add(this);
        FileOutputStream writeData = new FileOutputStream("peopledata.dat");
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
        writeStream.writeObject(people);
        writeStream.flush();
        writeStream.close();
    }

    public static bank Addbank(){
        Scanner a = new Scanner(System.in);
        Scanner f = new Scanner(System.in);
        bank b = new bank();
        try {
            System.out.print("\tВведіть прізвище: ");
            b.first_name = a.nextLine();
            System.out.print("\tВведіть ім'я: ");
            b.name = a.nextLine();
            System.out.print("\tВведіть дату останньої операції: ");
            b.date = f.nextLine();
            System.out.print("\tВведіть суму вкладу: ");
            b.price = f.nextFloat();
        }
        catch(Exception ex){
            System.out.println("Введене некоректні значення!!!");
            System.out.println("Повторіть спробу!!!");
            return Addbank();
        }
        return b;
    }

    public static void Deletebank() throws IOException {
        System.out.println("Введіть номер запису: ");
        int n = new Scanner(System.in).nextInt();

        if(n > people.size()){
            System.out.println("Номер за межами массиву!");
            Deletebank();
            return;
        }
        people.remove(n - 1);
        FileOutputStream writeData = new FileOutputStream("peopledata.dat");
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
        writeStream.writeObject(people);
        writeStream.flush();
        writeStream.close();
    }
    public void Outputbank(){
        System.out.println("\tПрізвище: " + first_name);
        for (String s : Arrays.asList("\tІм'я: " + name, "\tДата останньої операції : " + date, "\tСума вкладу: " + price)) {
            System.out.println(s);
        }
        System.out.println();
    }

    public static void OutputAllbank(List<bank> array) {
        System.out.println("Кількість записів: " + array.size());
        for (int i = 0; i < array.size(); i++) {
            array.get(i).Outputbank();
        }
    }
    public static void Sortbank(){
        sorted.addAll(people);
            for(int i = 0; i < sorted.size()-1; i++){
                for(int j = 0; j < sorted.size()-1; j++){
                    if(sorted.get(i).price > sorted.get(i+1).price){
                        bank tmp = sorted.get(i);
                        sorted.set(i, sorted.get(i+1));
                        sorted.set(i+1, tmp);
                    }
                }
            }
        }
    public static void Searchbank(){
        String date_oper;
        System.out.print("Введіть дату операції: ");
        date_oper = new Scanner(System.in).nextLine();
        for(int i = 0; i < people.size(); i++){
            if(people.get(i).date.equals(date_oper)){
                people.get(i).Outputbank();
            }
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        String n;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("1 - Ввести інформацію про рахунки банку.");
            System.out.println("2 - Вивести інформацію про рахунки банку.");
            System.out.println("3 - Вивести рахунки банку відсортовані за сумою вкладу.");
            System.out.println("4 - Пошук за датою операції.");
            System.out.println("5 - Видалити запис.");
            System.out.println("6 - Завершити роботу.");
            n = in.next();
            switch (n) {
                case "1":
                    bank _bank = new bank(bank.Addbank());
                    break;
                case "2":
                    bank.OutputAllbank(bank.people);
                    break;
                case "3":
                    bank.Sortbank();
                    bank.OutputAllbank(bank.sorted);
                    break;
                case "4":
                    bank.Searchbank();
                    break;
                case "5":
                    bank.Deletebank();
                    break;
                case "6":
                    File file = new File("C:\\Users\\38066\\IdeaProjects\\untitled21\\peopledata.dat");
                    file.deleteOnExit();
                    return;
            }
        } while (n != "6");
    }
    }

