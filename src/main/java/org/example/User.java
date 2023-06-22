package org.example;

public class User {
    private String firstName;
    private String secondName;
    private int age;
    public void User(String firstName, String secondName, int age){
        setFirstName(firstName);
        setSecondName(secondName);
        setAge(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if ( age < 0 ){
            age = 0;
        }
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                '}';
    }
}
