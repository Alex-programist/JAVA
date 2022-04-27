package com.company;
import java.io.*;
import java.util.*;

import static com.company.Station.stations;

abstract class Tramvai_way implements Serializable
        {
            protected int nomer;
            protected float argintervalmove;
            public Tramvai_way(){}
        }
            class Station extends Tramvai_way implements Serializable {
                private String name;
                private int countpas;
                public static List<Station> stations = new ArrayList<>();
                public static List<Station> stations1 = new ArrayList<>();

                public Station() {
                }
                public Station(Station s) throws IOException {
                    this.nomer = s.nomer;
                    this.argintervalmove = s.argintervalmove;
                    this.name = s.name;
                    this.countpas = s.countpas;
                    stations.add(this);
                    FileOutputStream writeData = new FileOutputStream("peopledata.dat");
                    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
                    writeStream.writeObject(stations);
                    writeStream.flush();
                    writeStream.close();
                }

                public Station(int _nomer, int _argintervalmove, String _name, int _countpas) {
                    nomer=_nomer;
                    argintervalmove=_argintervalmove;
                    name=_name;
                    countpas=_countpas;
                }

                public static Station AddS() {
                    Scanner a = new Scanner(System.in);
                    Scanner с = new Scanner(System.in);
                    Station b = new Station();
                    try {
                        System.out.println("\tВведіть номер маршруту: ");
                        b.nomer = a.nextInt();
                        System.out.println("\tВведіть середній інтервал руху: ");
                        b.argintervalmove = a.nextFloat();
                        System.out.print("\tВведіть назву зупинки: ");
                        b.name = с.nextLine();
                        System.out.print("\tВведіть кількість пасажирів: ");
                        b.countpas = a.nextInt();
                    } catch (Exception ex) {
                        System.out.println("Введене некоректні значення!!!");
                        System.out.println("Повторіть спробу!!!");
                        return AddS();
                    }
                    return b;
                }
                public void OutputTramvai_way(){
                    System.out.println("\tНомер маршруту: " + nomer);
                    for (String s : Arrays.asList("\tСредній інтервал руху'я: " + argintervalmove, "\tНазва зупинки : " + name, "\tКількість пасажирів: " + countpas)) {
                        System.out.println(s);
                    }
                    System.out.println();
                }

                public static void OutputTramvai_way(List<Station> array) {
                    System.out.println("Кількість записів: " + array.size());
                    for (int i = 0; i < array.size(); i++) {
                        array.get(i).OutputTramvai_way();
                    }
                }
                public static int Sum(List<Station> stations4)
                {
                    int sum=0;
                    for(int i=0;i<stations4.size();i++)
                    {
                        sum+=stations4.get(i).countpas;
                    }
                    System.out.println("Загальна кількість пасажирів: " + sum);
                    return sum;
                }
                public static int Min(List<Station> stations3)
                {
                    int min = stations3.get(0).countpas;
                    for(int i = 0; i< stations3.size(); i++)
                    {
                        if(stations3.get(i).countpas<min)
                        {
                            min = stations3.get(i).countpas;
                        }
                    }
                    for(int k = 0; k< stations3.size(); k++)
                    {
                        if(stations3.get(k).countpas==min)
                        {
                           stations3.get(k).OutputTramvai_way();
                        }
                    }
                    System.out.println("Зупинки з найменшою кількістю пасажирів: " + min);
                    return min;
                }
                public static int Heig()
                {
                    int max=stations.get(0).name.toCharArray().length;
                    for(int i=0;i<stations.size();i++)
                    {
                        if(stations.get(i).name.toCharArray().length>max)
                        {
                            max = stations.get(i).name.toCharArray().length;
                        }
                    }
                    for(int k=0;k<stations.size();k++)
                    {
                        if(stations.get(k).name.toCharArray().length==max)
                        {
                            stations.get(k).OutputTramvai_way();
                        }
                    }
                    System.out.println("Запинка з найдовшою назвою: " + max);
                    return max;
                }
                public static void DeleteTramvai_way() throws IOException {
                    System.out.println("Введіть номер запису: ");
                    int n = new Scanner(System.in).nextInt();
                    if(n > stations.size()){
                        System.out.println("Номер за межами массиву!");
                        DeleteTramvai_way();
                        return;
                    }
                    stations.remove(n - 1);
                    FileOutputStream writeData = new FileOutputStream("peopledata.dat");
                    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
                    writeStream.writeObject(stations);
                    writeStream.flush();
                    writeStream.close();
                }
            }
                public class Main {

                    public static void main(String[] args) throws IOException {
                        String n;
                        Scanner in = new Scanner(System.in);
                        Station a1=new Station(2,3,"efw",4);
                        do {
                            System.out.println("1 - Ввести інформацію про трамвайний маршрут.");
                            System.out.println("2 - Вивести інформацію про трамвайний маршрут.");
                            System.out.println("3 - Вивести загальну кількість пасажирів.");
                            System.out.println("4 - Вивести зупунки з найменшою кількістю пасажирів.");
                            System.out.println("5 - Вивести зупинку з найдовшою назвою.");
                            System.out.println("6 - Видалити запис.");
                            System.out.println("7 - Завершити роботу.");
                            n = in.next();
                            switch (n) {
                                case "1":
                                    Station _Station = new Station(Station.AddS());
                                    break;
                                case "2":
                                    Station.OutputTramvai_way(stations);
                                    break;
                                case "3":

                                    Station.Sum(stations);
                                    break;
                                case "4":

                                    Station.Min(stations);
                                    break;
                                case "5":

                                    Station.Heig();
                                    break;
                                case "6":
                                    Station.DeleteTramvai_way();
                                    break;
                                case "7":
                                    File file = new File("C:\\Users\\38066\\IdeaProjects\\untitled21\\peopledata.dat");
                                    file.deleteOnExit();
                                    return;
                            }
                        } while (n != "7");
                    }
                }


