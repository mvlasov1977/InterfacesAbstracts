package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

public class UsersDataManipulationTests {
    static final boolean DEBUG=true; // activate timeout for monitor parallelism
    static final int TIMEOUTS=2500; // timeout value for monitor multithreading
    static UsersDataManipulation myUsersDataManipulation;
    static Double myReferenceAverageAge;

    @BeforeAll
    public static void beforeAll(){
        myUsersDataManipulation = new UsersDataManipulation("Test");
    }
    @BeforeEach
    public void beforeEach(){
        // isn't using now
    }
    private ArrayList<User> makeInitialUserData(){
        // make initial User data (contain A in second name) (no one have 18 year)
        ArrayList <User> myCollection = new ArrayList<>();
        myCollection.add(new User("C","A",5));
        myCollection.add(new User("D","B",4));
        myCollection.add(new User("C","C",3));
        myCollection.add(new User("B","D",2));
        myCollection.add(new User("A","E",1));
        UsersDataManipulationTests.myReferenceAverageAge = 3.0;
        return myCollection;
    }
    private ArrayList <User> makeSortedByAge(){
        // make reference User data , sorted by age !
        ArrayList <User> myCollection = new ArrayList<>();
        myCollection.add(new User("A","E",1));
        myCollection.add(new User("B","D",2));
        myCollection.add(new User("C","C",3));
        myCollection.add(new User("D","B",4));
        myCollection.add(new User("C","A",5));
        return myCollection;
    }
    private ArrayList<User> makeSortedByNameThenAge(){
        // make reference User data , sorted by name then age !
        ArrayList <User> myCollection = new ArrayList<>();
        myCollection.add(new User("A","E",1));
        myCollection.add(new User("B","D",2));
        myCollection.add(new User("C","C",3));
        myCollection.add(new User("C","A",5));
        myCollection.add(new User("D","B",4));
        return myCollection;
    }
    private ArrayList<User> makeContainS(){
        // make reference User data , contain S !
        ArrayList <User> myCollection = new ArrayList<>();
        myCollection.add(new User("A","E",1));
        myCollection.add(new User("B","D",2));
        myCollection.add(new User("C","C",3));
        myCollection.add(new User("C","S",5));
        myCollection.add(new User("D","B",4));
        return myCollection;
    }
    private ArrayList<User> makeNOTContainSorA(){
        // make reference User data , without S or A !
        ArrayList <User> myCollection = new ArrayList<>();
        myCollection.add(new User("A","E",1));
        myCollection.add(new User("B","D",2));
        myCollection.add(new User("C","C",3));
        myCollection.add(new User("C","N",5));
        myCollection.add(new User("D","B",4));
        return myCollection;
    }
    private ArrayList<User> makeOne18Year(){
        // make reference User data , without S or A !
        ArrayList <User> myCollection = new ArrayList<>();
        myCollection.add(new User("A","E",1));
        myCollection.add(new User("B","D",2));
        myCollection.add(new User("C","C",18));
        myCollection.add(new User("C","N",5));
        myCollection.add(new User("D","B",4));
        return myCollection;
    }
    private ArrayList<User> makeAllHave18Year(){
        // make reference User data , without S or A !
        ArrayList <User> myCollection = new ArrayList<>();
        myCollection.add(new User("A","E",35));
        myCollection.add(new User("B","D",19));
        myCollection.add(new User("C","C",25));
        myCollection.add(new User("C","N",19));
        myCollection.add(new User("D","B",20));
        return myCollection;
    }
    private ArrayList makeWrongCollection(){
        // make wrong collection
        ArrayList myCollection = new ArrayList<>();
        myCollection.add("wrong item 1");
        myCollection.add("wrong item 2");
        myCollection.add("wrong item 3");
        myCollection.add("wrong item 4");
        myCollection.add("wrong item 5");
        return myCollection;
    }
    @AfterEach
    public void afterEach(){
        // isn't using now
    }
    @Test
    @Tag("SortByAgePutIntoNewCollection")
    public void testSortByAgePutIntoNewCollection() throws InterruptedException {
        // Test right pattern of user data
        ArrayList<User> tmpUserArrayList = new ArrayList<>();
        myUsersDataManipulation.sortByAgePutIntoNewCollection(makeInitialUserData(), tmpUserArrayList);
        Assertions.assertEquals(tmpUserArrayList.toString(), makeSortedByAge().toString());
        if (DEBUG){Thread.sleep(TIMEOUTS);}
    }
    @Test
    @Tag("SortByAgePutIntoNewCollection")
    public void test2SortByAgePutIntoNewCollection() throws InterruptedException {
        // Test empty ArrayList
        ArrayList<User> referenceUserArrayList = new ArrayList<>();
        ArrayList<User> tmpUserArrayList = new ArrayList<>();
        myUsersDataManipulation.sortByAgePutIntoNewCollection(referenceUserArrayList, tmpUserArrayList);
        Assertions.assertEquals(referenceUserArrayList.toString(), tmpUserArrayList.toString());
        if (DEBUG){Thread.sleep(TIMEOUTS);}
    }
    @Test
    @Tag("SortByAgePutIntoNewCollection")
    public void test3SortByAgePutIntoNewCollection() throws InterruptedException {
        // Test wrong type of Collection
        try {
            myUsersDataManipulation.sortByAgePutIntoNewCollection(makeWrongCollection(), new ArrayList<>());
        }catch(Exception e) {
            Assertions.fail("Check input collection validate mechanism !");
        }
        if (DEBUG){Thread.sleep(TIMEOUTS);}
    }
    @Test
    @Tag("getUsersAverageAge")
    public void testGetUsersAverageAge() throws InterruptedException {
        // Test right pattern of user data
        Assertions.assertEquals(myUsersDataManipulation.getUsersAverageAge(makeInitialUserData()), myReferenceAverageAge);
        if (DEBUG){Thread.sleep(TIMEOUTS);}
    }
    @Test
    @Tag("getUsersAverageAge")
    public void test2GetUsersAverageAge() throws InterruptedException {
        // Test empty ArrayList
        Assertions.assertEquals(myUsersDataManipulation.getUsersAverageAge(new ArrayList<>()), 0.0);
        if (DEBUG){Thread.sleep(TIMEOUTS);}
    }
    @Test
    @Tag("getUsersAverageAge")
    public void test3GetUsersAverageAge() throws InterruptedException {
        // Test wrong type of Collection
        try {
            myUsersDataManipulation.getUsersAverageAge(makeWrongCollection());
        }catch(Exception e) {
            Assertions.fail("Check input collection validate mechanism !");
        }
        if (DEBUG){Thread.sleep(TIMEOUTS);}
    }
    @Test
    @Tag("sortByNameThenAge")
    public void testSortByNameThenAge() throws InterruptedException {
        // Test right pattern of user data
        ArrayList <User> UserArrayList = makeInitialUserData();
        myUsersDataManipulation.sortByNameThenAge(UserArrayList);
        Assertions.assertEquals(UserArrayList.toString(), makeSortedByNameThenAge().toString());
        if (DEBUG){Thread.sleep(TIMEOUTS);}
    }
    @Test
    @Tag("sortByNameThenAge")
    public void test2SortByNameThenAge() throws InterruptedException {
        // Test empty for empty ArrayList
        ArrayList<User> referenceUserArrayList = new ArrayList<>();
        myUsersDataManipulation.sortByNameThenAge(referenceUserArrayList);
        Assertions.assertTrue(referenceUserArrayList.isEmpty());
        if (DEBUG){Thread.sleep(TIMEOUTS);}
    }
    @Test
    @Tag("sortByNameThenAge")
    public void test3SortByNameThenAge() throws InterruptedException {
        // Test wrong type of Collection
        try {
            myUsersDataManipulation.sortByNameThenAge(makeWrongCollection());
        }catch(Exception e) {
            Assertions.fail("Check input collection validate mechanism !");
        }
        if (DEBUG){Thread.sleep(TIMEOUTS);}
    }
    @Test
    @Tag("isSecondNameContainSorA")
    public void testIsSecondNameContainSorA() throws InterruptedException {
        // Test right pattern of user data
        Assertions.assertTrue(myUsersDataManipulation.isSecondNameContainSorA(makeInitialUserData()));
        if (DEBUG){Thread.sleep(TIMEOUTS);}
    }
    @Test
    @Tag("isSecondNameContainSorA")
    public void test2IsSecondNameContainSorA() throws InterruptedException {
        // Test right pattern of user data
        Assertions.assertTrue(myUsersDataManipulation.isSecondNameContainSorA(makeContainS()));
        if (DEBUG){Thread.sleep(TIMEOUTS);}
    }
    @Test
    @Tag("isSecondNameContainSorA")
    public void test3IsSecondNameContainSorA() throws InterruptedException {
        // Test right pattern of user data
        Assertions.assertFalse(myUsersDataManipulation.isSecondNameContainSorA(makeNOTContainSorA()));
        if (DEBUG){Thread.sleep(TIMEOUTS);}
    }
    @Test
    @Tag("isSecondNameContainSorA")
    public void test4IsSecondNameContainSorA() throws InterruptedException {
        // Test empty  ArrayList
        Assertions.assertFalse(myUsersDataManipulation.isSecondNameContainSorA(new ArrayList<>()));
        if (DEBUG){Thread.sleep(TIMEOUTS);}
    }
    @Test
    @Tag("isSecondNameContainSorA")
    public void test5IsSecondNameContainSorA() throws InterruptedException {
        // Test wrong type of Collection
        try {
            myUsersDataManipulation.isSecondNameContainSorA(makeWrongCollection());
        }catch(Exception e) {
            Assertions.fail("Check input collection validate mechanism !");
        }
        if (DEBUG){Thread.sleep(TIMEOUTS);}
    }
    @Test
    @Tag("isAllUsersHaveOver18Years")
    public void testIsAllUsersHaveOver18Years() throws InterruptedException {
        // Test right pattern of user data (No one have 18 year)
        Assertions.assertFalse(myUsersDataManipulation.isAllUsersHaveOver18Years(makeInitialUserData()));
        if (DEBUG){Thread.sleep(TIMEOUTS);}
    }
    @Test
    @Tag("isAllUsersHaveOver18Years")
    public void test2IsAllUsersHaveOver18Years() throws InterruptedException {
        // Test right pattern of user data (one have 18 year)
        Assertions.assertFalse(myUsersDataManipulation.isAllUsersHaveOver18Years(makeOne18Year()));
        if (DEBUG){Thread.sleep(TIMEOUTS);}
    }
    @Test
    @Tag("isAllUsersHaveOver18Years")
    public void test3IsAllUsersHaveOver18Years() throws InterruptedException {
        // Test right pattern of user data (all have 18 year)
        Assertions.assertTrue(myUsersDataManipulation.isAllUsersHaveOver18Years(makeAllHave18Year()));
        if (DEBUG){Thread.sleep(TIMEOUTS);}
    }
    @ParameterizedTest
    @ValueSource(strings = {"cycle1", "cycle2", "cycle3"})
    @Tag("isAllUsersHaveOver18Years")
    public void test4IsAllUsersHaveOver18Years(String inputValue) throws InterruptedException {
        // Test empty ArrayList
        System.out.println(inputValue);
        Assertions.assertTrue(myUsersDataManipulation.isAllUsersHaveOver18Years(new ArrayList<>()));
        if (DEBUG){Thread.sleep(TIMEOUTS);}
    }
    @RepeatedTest(10)
    @Tag("isAllUsersHaveOver18Years")
    public void test5IsAllUsersHaveOver18Years() throws InterruptedException {
        // Test wrong type of Collection
        try {
            myUsersDataManipulation.isAllUsersHaveOver18Years(makeWrongCollection());
        }catch(Exception e) {
            Assertions.fail("Check input collection validate mechanism !");
        }
        if (DEBUG){Thread.sleep(TIMEOUTS);}
    }
    @AfterAll
    public static void finishTests(){
         System.out.println("Test UsersDataManipulationTests was finished !");
    }
}
