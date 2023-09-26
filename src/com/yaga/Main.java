package com.yaga;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляры класса Кошка
        Cat cat1 = new Cat("Мурка", 3);
        Cat cat2 = new Cat("Барсик", 2);

        // Попробуем записать экземпляры в файл
        try {
            FileOutputStream fileOut = new FileOutputStream("cats.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(cat1);
            out.writeObject(cat2);
            out.close();
            fileOut.close();
            System.out.println("Экземпляры класса Кошка записаны в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Попробуем прочитать экземпляры из файла
        try {
            FileInputStream fileIn = new FileInputStream("cats.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Cat restoredCat1 = (Cat) in.readObject();
            Cat restoredCat2 = (Cat) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Экземпляры класса Кошка прочитаны из файла:");
            System.out.println(restoredCat1);
            System.out.println(restoredCat2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
