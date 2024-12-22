package lms.model;

import java.time.LocalDateTime;

public class PersonalDetails {
    private String name;
    private int age;
    private Gender gender;
    private String address;
    private String workDetails;
    private LocalDateTime joinDate;
    private LocalDateTime exitDate;
    private LocalDateTime subscriptionExpDate;

    public PersonalDetails(String name, int age, Gender gender, String address, String workDetails, LocalDateTime joinDate) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.workDetails = workDetails;
        this.joinDate = joinDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkDetails() {
        return workDetails;
    }

    public void setWorkDetails(String workDetails) {
        this.workDetails = workDetails;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public LocalDateTime getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDateTime exitDate) {
        this.exitDate = exitDate;
    }

    public LocalDateTime getSubscriptionExpDate() {
        return subscriptionExpDate;
    }

    public void setSubscriptionExpDate(LocalDateTime subscriptionExpDate) {
        this.subscriptionExpDate = subscriptionExpDate;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", workDetails='" + workDetails + '\'' +
                ", joinDate=" + joinDate +
                ", exitDate=" + exitDate +
                ", subscriptionExpDate=" + subscriptionExpDate;
    }
}
