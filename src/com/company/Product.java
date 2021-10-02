package com.company;

public class Product {
    private String name;
    private int number;
    private String price;
    private String year;
    private String manufacturer;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public static int getMax(int size, Product[] products) {
        int max = 0;
        int max_number = 0;
        for (int i = 0; i < size - 1; i++) {
            if (products[i].number > products[i + 1].number) {
                max_number = products[i].number;
                max = i;
            } else {
                max_number = products[i + 1].number;
                max = i + 1;
            }
        }
        return max;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", price='" + price + '\'' +
                ", year='" + year + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

}
