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
        return inputCollection.stream().map(i -> i.getAge()).mapToDouble(i -> i).average().getAsDouble();
    }
}
