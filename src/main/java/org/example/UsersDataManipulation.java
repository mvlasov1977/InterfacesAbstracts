package org.example;
import java.util.*;
public class UsersDataManipulation {
    private String projectName;
    public UsersDataManipulation(String projectName){
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }
    public void sortByAgePutIntoNewCollection(ArrayList <User> inputCollection, ArrayList <User> outputCollection){
        Comparator <User> comparatorAgeOfUser = (u1, u2) -> {
            return u1.getAge() - u2.getAge();
        };
        inputCollection.stream().sorted(comparatorAgeOfUser).forEach(outputCollection::add);
    }
    public Double getUsersAverageAge(ArrayList <User> inputCollection){
        return inputCollection.stream().map(User::getAge).mapToDouble(i -> i).average().getAsDouble();
    }
    public void sortByNameThenAge(ArrayList <User> inputCollection){
        Comparator <User> comparatorNameAgeOfUser = (u1, u2) -> {
            if (u1.getFirstName().compareTo(u2.getFirstName()) == 0){
                return u1.getAge() - u2.getAge();
            }
            return u1.getFirstName().compareTo(u2.getFirstName());
        };
        inputCollection.sort(comparatorNameAgeOfUser);
    }
    public Boolean isSecondNameContainSorA(ArrayList <User> inputCollection){
        return inputCollection.stream().map(i -> i)
                .filter(i -> ( (i.getSecondName().charAt(0) == 'S') || (i.getSecondName().charAt(0) == 'A') ))
                .toArray().length > 0;
    }
    public Boolean isAllUsersHaveOver18Years(ArrayList <User> inputCollection){
        return (inputCollection.stream()
                .map(User::getAge)
                .filter(i -> i<19)
                .toArray().length) == 0;
    }
}
