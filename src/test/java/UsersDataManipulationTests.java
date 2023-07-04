import org.example.*;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class UsersDataManipulationTests {
    static UsersDataManipulation myUsersDataManipulation;
    public ArrayList<User> userArrayList;
    public ArrayList<User> referenceUserArrayList;
    @BeforeAll
    static void beforeAll(){
        System.out.println("TBefore all , started !");
        myUsersDataManipulation = new UsersDataManipulation("Test");
        ArrayList<User> userArrayList = new ArrayList<>();
        ArrayList<User> referenceUserArrayList = new ArrayList<>();
        System.out.println("Test UsersDataManipulationTests was started !");
    }
    @AfterAll
    public static void finishTests(){
        System.out.println("Test UsersDataManipulationTests was finished !");
    }
    @BeforeEach
    public void makeInitialUserData(){
        // make initial User data
        userArrayList.add(new User("E","A",5));
        userArrayList.add(new User("D","B",4));
        userArrayList.add(new User("C","C",3));
        userArrayList.add(new User("B","D",2));
        userArrayList.add(new User("A","E",1));
    }
    private void makeSortedByAge(){
        // make reference User data , sorted y age !
        referenceUserArrayList.clear();
        referenceUserArrayList.add(new User("A","E",1));
        referenceUserArrayList.add(new User("B","D",2));
        referenceUserArrayList.add(new User("C","C",3));
        referenceUserArrayList.add(new User("D","B",4));
        referenceUserArrayList.add(new User("E","A",5));
    }
    @AfterEach
    public void afterEach(){
        userArrayList.clear();
        referenceUserArrayList.clear();
    }
    @Test
    @DisplayName("sortByAgePutIntoNewCollection")
    public void testSortByAgePutIntoNewCollection(){
        ArrayList<User> tmpUserArrayList = new ArrayList<>();
        System.out.println(myUsersDataManipulation);
        myUsersDataManipulation.sortByAgePutIntoNewCollection(userArrayList, tmpUserArrayList);
        System.out.println("step 1");
        makeSortedByAge();
        System.out.println(tmpUserArrayList);
        System.out.println();
        System.out.println(referenceUserArrayList);
        Assertions.assertNotEquals(tmpUserArrayList.equals(referenceUserArrayList), true);
    }
}
