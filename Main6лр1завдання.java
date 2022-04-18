package com.company;
import java.text.SimpleDateFormat;
import java.util.*;

class metereo {
    private Date date;
    private int temp;
    private float pressure;
    public static List<metereo> metereos = new ArrayList<>();

    public metereo() {}
   /*  public metereo(int _temp,float _pressure)
     {
        this.date=new Date(1,1,1);
        this.temp=_temp;
        this.pressure=_pressure;
     }*/
    public metereo(metereo m) {
        this.date = m.date;
        this.temp = m.temp;
        this.pressure = m.pressure;
        metereos.add(this);
    }

    public static metereo Addmetereo() {
        Scanner a = new Scanner(System.in);
        Scanner f = new Scanner(System.in);
        metereo e = new metereo();
        try {
            int d, m, y;
            System.out.print("\t\tДень: ");
            d = a.nextInt();
            System.out.print("\t\tМісяць: ");
            m = a.nextInt();
            System.out.print("\t\tРік: ");
            y = a.nextInt();
            e.date = new Date(y - 1900, m - 1, d);
            System.out.print("\tВведіть темпетуру: ");
            e.temp = f.nextInt();
            System.out.print("\tВведіть атмосферний тиск: ");
            e.pressure = f.nextFloat();
        } catch (Exception ex) {
            System.out.println("Введене некоректені значення!!!");
            System.out.println("Повторіть спробу!!!");
            return Addmetereo();
        }
        return e;
    }

    private void OutputInfometereo() {
        SimpleDateFormat dater = new SimpleDateFormat("d-MM-yyyy");
        System.out.println(dater.format(date) + "\t|\t" + temp + "\t|\t" + pressure);
    }

    public static void PrintAllmetereo(List<metereo> m) {
        System.out.println("Кількість записів: " + m.size());
        for (int i = 0; i < m.size(); i++) {
            m.get(i).OutputInfometereo();
        }
    }

    public static void PrintAllSortedmetereo() {
        List<metereo> a = new ArrayList<>(metereos);
        for (int i = 0; i < a.size() - 1; i++) {
            for (int k = 0; k < a.size() - 1; k++) {
                if (a.get(k).temp < a.get(k + 1).temp) {
                    metereo tmp = a.get(k);
                    a.set(k, a.get(k + 1));
                    a.set(k + 1, tmp);
                }
            }
        }
        PrintAllmetereo(a);
    }
}

    public class Main {

        public static void main(String[] args) {
            String n;
            Scanner in = new Scanner(System.in);
          /*  metereo a1=new metereo(2,3);
            metereo a2=new metereo(10,3);
            metereo a3=new metereo(5,3);
            metereo a4=new metereo(8,3);
            metereo.metereos.add(a1);
            metereo.metereos.add(a2);
            metereo.metereos.add(a3);
            metereo.metereos.add(a4);*/
            do {
                System.out.println("1 - Ввести інформацію про метеорологічні спостереження.");
                System.out.println("2 - Вивести інформацію про метеорологічні спостереження.");
                System.out.println("3 - Вивести метеорологічні спостереження відсортовані за температорою повітря у порядку спадання.");
                System.out.println("4 - Завершити роботу");
                n = in.next();
                switch (n) {
                    case "1":
                        metereo _metereo = new metereo(metereo.Addmetereo());
                        break;
                    case "2":
                        metereo.PrintAllmetereo(metereo.metereos);
                        break;
                    case "3":
                        metereo.PrintAllSortedmetereo();
                        break;
                    case "4":
                        return;
                }
            } while (n != "4");
        }
    }



