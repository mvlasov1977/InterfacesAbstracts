package org.example;
import org.example.Book;
import org.example.Printable;
import org.example.Magazine;
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

    }
}