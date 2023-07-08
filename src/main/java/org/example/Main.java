package org.example;

import java.util.*;

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

        System.out.println("\n");

        /*
        Створити клас User з полями: firstName, secondName, age. Виконати наступні операції:
        - Створити список з 10 обєктів типу User
        - відсортувати за віком та записати в нову колекцію
        - Підрахувати ссередній вік юзерів
        - Сортувати по декількам властивостям: firstName і age
        - Перевірити чи є юзери у юких прізвище починаєтся з літери "S' або "А"
        - Перевірити чи всі юзери старше 18 років
         */

        //- Створити список з 10 обєктів типу User
        ArrayList <User> userArrayList = new ArrayList<>();

        User user = new User("Maxim","Vlasov",19);
         userArrayList.add(user);
        User user2 = new User("Vasiliy","Petrov",50);
         userArrayList.add(user2);
        User user3 = new User("Mister","Ain",45);
         userArrayList.add(user3);
        User user4 = new User("Fanto","Mas",35);
         userArrayList.add(user4);
        User user5 = new User("Billy","Bons",55);
         userArrayList.add(user5);
        User user6 = new User("Bet","Men",30);
         userArrayList.add(user6);
        User user7 = new User("Dunkan","McClaut",400);
         userArrayList.add(user7);
        User user8 = new User("Dunkan","Sorever",100);
         userArrayList.add(user8);
        User user9 = new User("Windows","MustDie",99);
         userArrayList.add(user9);
        User user10 = new User("Ice","Cream",19);
         userArrayList.add(user10);
        System.out.println("\n");

        UsersDataManipulation UsersData = new UsersDataManipulation("My Users data");
        // - відсортувати за віком та записати в нову колекцію
        ArrayList <User> userArrayListNew = new ArrayList<>();
        UsersData.sortByAgePutIntoNewCollection(userArrayList, userArrayListNew);
        userArrayListNew.forEach(System.out::println);
        System.out.println("\n");

        // - Підрахувати ссередній вік юзерів
        System.out.println("Average age is: " + UsersData.getUsersAverageAge(userArrayList));
        System.out.println("\n");

        // - Сортувати по декількам властивостям: firstName і age
        UsersData.sortByNameThenAge(userArrayList);
        userArrayList.forEach(System.out::println);
        System.out.println("\n");

        // - Перевірити чи є юзери у юких прізвище починаєтся з літери "S' або "А"
        if ( UsersData.isSecondNameContainSorA(userArrayList) ){
            System.out.println("Some eser contains S and A in second name !");
        }else {
            System.out.println("Any user contains S and A in second name !");
        }
        System.out.println("\n");

        // Перевірити чи всі юзери старше 18 років
        System.out.println("Are all users over 18 ? " + (UsersData.isAllUsersHaveOver18Years(userArrayList)));
        System.out.println("\n");
    }
}