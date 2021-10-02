package com.company;
import java.text.ParseException; //сигнализирует об ошибке при анализе даты
import java.util.Scanner; //ввод и вывод данных
import java.time.LocalDate; //для взаемодействя с датой
import java.text.SimpleDateFormat; //для форматирования даты
import java.util.Date; //для работы с текущей датой
import java.time.ZoneId;//определяет временную зону
import java.time.Period; // описание календарной длительности (периода)

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
            Product[] products = new Product[size];
            for (int i = 0; i < size; i++) {
                products[i] = new Product();
                do {
                    System.out.print("Введите название товара:");
                    products[i].setName(scanner.nextLine());
                } while (!products[i].getName().matches("^[a-zA-Z]+$")); //регулярное выражение
                System.out.print("Введите кол-во: ");
                products[i].setNumber(scanner.nextInt());
                scanner.nextLine();
                do {
                    System.out.print("Введите цену:");
                    products[i].setPrice(scanner.nextLine());
                } while (!products[i].getPrice().matches("^[0-9]+$"));
                System.out.print("Введите год изготовления: ");
                products[i].setYear(scanner.nextLine());
                System.out.print("Введите производителя: ");
                products[i].setManufacturer(scanner.nextLine());
            }
            int max = Product.getMax(size, products);
            System.out.println(products[max]);
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
                array_2[i].setSurname(scanner.nextLine());
                System.out.print("Имя: ");
                array_2[i].setName(scanner.nextLine());
                System.out.print("Отчество: ");
                array_2[i].setPatronymic(scanner.nextLine());
                System.out.print("Должность: ");
                array_2[i].setPosition(scanner.nextLine());
                System.out.print("Пол: ");
                array_2[i].setGender(scanner.nextLine());

                LocalDate date_now = LocalDate.now(); // получаем текущую дату
                //System.out.println(date_now);
                    do {
                        System.out.print("Дата приема на работу (dd/MM/yyyy):");
                        array_2[i].setDate(scanner.nextLine());
                    } while (!array_2[i].getDate().matches("^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)$")); //регуляторное выражение
                Date DATE_1=new SimpleDateFormat("dd/MM/yyyy").parse(array_2[i].getDate());
                LocalDate date = DATE_1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                Period periodYear=Period.between(date,date_now); //считает разницу годов
                arrayYear[i]=periodYear.getYears(); //записывает в массив все разницы
            }
            for (int i = 0; i < size; i++) {
                if(arrayYear[i] > 10)
                {
                    System.out.println(array_2[i].toString());
                }
            }
        }
}

