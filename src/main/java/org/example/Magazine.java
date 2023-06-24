package org.example;

public class Magazine implements Printable{
    private String myName;
    private int countOfArticles;
    private int countOfSheets;
    public void Magazine(String myName, int countOfArticles, int countOfSheets){
        this.myName = myName;
        this.countOfArticles = countOfArticles;
        this.countOfSheets = countOfSheets;
    }

    public String getMyName() {
        return myName;
    }

    public int getCountOfArticles() {
        return countOfArticles;
    }

    public int getCountOfSheets() {
        return countOfSheets;
    }

    @Override
    public void print() {
        System.out.println("Magazine '" + myName +"' was printed ...");
    }
    static void printMagazines(Printable[] printable){
        for (Printable myItem:printable) {
            if (myItem instanceof Magazine ){
                System.out.println(((Magazine) myItem).myName);
            }
        }
    }
    public static void printInterface(Printable p){
        p.print();
    }
}
