package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Task1();
    }

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
            System.out.print("Название:" + array_1[max].name);
            System.out.print("Кол-во:" + array_1[max].number);
            System.out.print("Цена:" + array_1[max].price);
            System.out.print("Год изготовления:" + array_1[max].year);
            System.out.print("Производитель:" + array_1[max].manufacturer);
        }
}

