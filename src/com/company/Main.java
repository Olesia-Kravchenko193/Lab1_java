package com.company;
import java.text.ParseException;
import java.util.Scanner;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.ZoneId;
import java.time.Period;

public class Main {

    public static void main(String[] args) throws ParseException{
        //Task1();
        Task2();
    }

    /* Вариант 14
    Определить товар, количество которого больше всего
    на складе, и напечатать все сведения о нем.*/
        public static void Task1() {

            Scanner scanner = new Scanner(System.in);
            int size;
            do {
                System.out.print("Введите кол-во продуктов: ");
                size = scanner.nextInt();
                scanner.nextLine();
            } while (size <= 0);
            Products[] array_1 = new Products[size];
            for (int i = 0; i < size; i++) {
                array_1[i] = new Products();
                System.out.print("Введите name: ");
                array_1[i].name = scanner.nextLine();
                System.out.print("Введите кол-во: ");
                array_1[i].number = scanner.nextInt();
                System.out.print("Введите цену: ");
                array_1[i].price = scanner.nextInt();
                System.out.print("Введите год изготовления: ");
                array_1[i].year = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Введите производителя: ");
                array_1[i].manufacturer = scanner.nextLine();
            }
            int max = 0;
            int max_number = 0;
            for (int i = 0; i < size - 1; i++) {
                if (array_1[i].number > array_1[i + 1].number) {
                    max_number = array_1[i].number;
                    max = i;
                } else {
                    max_number = array_1[i + 1].number;
                    max = i + 1;
                }
            }
            System.out.print("\nНазвание:" + array_1[max].name);
            System.out.print("\nКол-во:" + array_1[max].number);
            System.out.print("\nЦена:" + array_1[max].price);
            System.out.print("\nГод изготовления:" + array_1[max].year);
            System.out.print("\nПроизводитель:" + array_1[max].manufacturer);
        }

        /* Вариант 14
         Вывести все сведения о сотрудниках, стаж которых
         превышает 10 лет.*/
        public static void Task2() throws ParseException {

            Scanner scanner = new Scanner(System.in);
            int size;
            do {
                System.out.print("Введите кол-во сотрудников: ");
                size = scanner.nextInt();
                scanner.nextLine();
            } while (size <= 0);
            Employee[] array_2 = new Employee[size];
            int []arrayYear=new int[size];

            for (int i = 0; i < size; i++) {
                array_2[i] = new Employee();
                System.out.print("Фамилия: ");
                array_2[i].surname = scanner.nextLine();
                System.out.print("Имя: ");
                array_2[i].name = scanner.nextLine();
                System.out.print("Отчество: ");
                array_2[i].patronymic = scanner.nextLine();
                System.out.print("Должность: ");
                array_2[i].position = scanner.nextLine();
                System.out.print("Пол: ");
                array_2[i].gender = scanner.nextLine();

                LocalDate date_now = LocalDate.now(); // получаем текущую дату
                //System.out.println(date_now);
                System.out.print("Дата приема на работу (dd/MM/yyyy):");
                array_2[i].date=scanner.nextLine();
                Date DATE_1=new SimpleDateFormat("dd/MM/yyyy").parse(array_2[i].date);
                LocalDate date = DATE_1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                Period periodYear=Period.between(date,date_now); //считает расницу годов
                arrayYear[i]=periodYear.getYears(); //записывает в массив все разницы
            }
            for (int i = 0; i < size; i++) {
                if(arrayYear[i] > 10)
                {
                    System.out.print("\nФамилия:" + array_2[i].surname);
                    System.out.print("\nИмя:" +  array_2[i].name);
                    System.out.print("\nОтчество:" +  array_2[i].patronymic);
                    System.out.print("\nДолжность:" +  array_2[i].position);
                    System.out.print("\nПол:" +  array_2[i].gender);
                    System.out.print("\nДата приема на работу:" +  array_2[i].date);
                }
            }
        }
}

