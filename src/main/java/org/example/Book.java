package org.example;

public class Book implements Printable{
    private String myName;
    private String myAuthor;
    private int countOfSheets;
    public void Book(String myName, String myAuthor, int countOfSheets){
        this.myName = myName;
        this.myAuthor = myAuthor;
        this.countOfSheets = countOfSheets;
    }

    public String getMyName() {
        return myName;
    }

    public String getMyAuthor() {
        return myAuthor;
    }

    public int getCountOfSheets() {
        return countOfSheets;
    }

    @Override
    public void print() {
        System.out.println("Book '"+ myName + "' was printed ...");
    }
    static void printBooks(Printable[] printable){
        for (Printable myItem:printable) {
            if (myItem instanceof Book ){
                System.out.println(((Book) myItem).myName);
            }
        }
    }
}
