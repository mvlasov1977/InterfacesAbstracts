package org.example;
import org.example.Book;
import org.example.Printable;
import org.example.Magazine;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Printable[] arrayOfEdition;
        arrayOfEdition = new Printable[4];

        Book myFirstBook = new Book();
        myFirstBook.Book("Infinity", "Vasia Pupkin", 200);

        Book mySecondBook = new Book();
        mySecondBook.Book("Hell", "Jorge Mc'Nilon", 100);

        Magazine myFirstMagazine = new Magazine();
        myFirstMagazine.Magazine("How its made", 50, 10);

        Magazine mySecondMagazine = new Magazine();
        mySecondMagazine.Magazine("Discovery", 30, 20);

        arrayOfEdition[0] = myFirstBook;
        arrayOfEdition[1] = mySecondBook;
        arrayOfEdition[2] = myFirstMagazine;
        arrayOfEdition[3] = mySecondMagazine;

        for (Printable myItem:arrayOfEdition) {
            myItem.print();

        }
        System.out.println("\n");

        System.out.println("Books :");
        Book.printBooks(arrayOfEdition);
        System.out.println("\n");

        System.out.println("Magazines :");
        Magazine.printMagazines(arrayOfEdition);
        System.out.println("\n");

        /*
        1. Створити лямбда вираз для інтерфейсу Printable з дз 8
        2. Перробити виклик метода print через посилання на метод
         */

        // Створюю лямбда вираз для інтерфейсу Printable
        Printable p = () -> System.out.println("hello LAMBDA");
        p.print(); //  hello LAMBDA
        System.out.println("\n");

        //Перероблюю виклик метода print через посилання на метод

        myFirstBook.printInterface(()->System.out.println("Book '"+ myFirstBook.getMyName() + "' was printed ..."));
        mySecondMagazine.printInterface(()->System.out.println("Magazine '"+ mySecondMagazine.getMyName() + "' was printed ..."));

        /*
        Створити клас User з полями: firstName, secondName, age. Виконати наступні операції:
        - Створити список з 10 обєктів типу User
        - відсортувати за віком та записати в нову колекцію
        - Підрахувати ссередній вік юзерів
        - Сортувати по декількам властивостям: firstName і age
        - Перевірити чи є юзери у юких прізвище починаєтся з літери "S' або "А"
        - Перевірити чи всі юзери старше 18 років
         */

    }
}