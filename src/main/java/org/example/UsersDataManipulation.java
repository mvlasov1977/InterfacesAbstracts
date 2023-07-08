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
        try {
            Comparator <User> comparatorAgeOfUser = (u1, u2) -> {
                return u1.getAge() - u2.getAge();
            };
            inputCollection.stream().sorted(comparatorAgeOfUser).forEach(outputCollection::add);
        }catch (Exception e){
            // continue
            //throw new ClassCastException("Input ArrayList is not User type!");
        }
    }
    public Double getUsersAverageAge(ArrayList <User> inputCollection){
        try {
        if (!inputCollection.isEmpty()){
            return inputCollection.stream().map(User::getAge).mapToDouble(i -> i).average().getAsDouble();
        }else {
            return 0.0;
        }
        }catch (Exception e){
            return -1.0;
            // continue
            //throw new ClassCastException("Input ArrayList is not User type!");
        }
    }
    public void sortByNameThenAge(ArrayList <User> inputCollection){
        try {
        Comparator <User> comparatorNameAgeOfUser = (u1, u2) -> {
            if (u1.getFirstName().compareTo(u2.getFirstName()) == 0){
                return u1.getAge() - u2.getAge();
            }
            return u1.getFirstName().compareTo(u2.getFirstName());
        };
        inputCollection.sort(comparatorNameAgeOfUser);
        }catch (Exception e){
            // continue
            //throw new ClassCastException("Input ArrayList is not User type!");
        }
    }
    public Boolean isSecondNameContainSorA(ArrayList <User> inputCollection){
        try {
        return inputCollection.stream().map(i -> i)
                .filter(i -> ( (i.getSecondName().charAt(0) == 'S') || (i.getSecondName().charAt(0) == 'A') ))
                .toArray().length > 0;
        }catch (Exception e){
            return false;
            // continue
            //throw new ClassCastException("Input ArrayList is not User type!");
        }
    }
    public Boolean isAllUsersHaveOver18Years(ArrayList <User> inputCollection){
        try {
        return (inputCollection.stream()
                .map(User::getAge)
                .filter(i -> i<19)
                .toArray().length) == 0;
        }catch (Exception e){
            return true;
            // continue
            //throw new ClassCastException("Input ArrayList is not User type!");
        }
    }
}
