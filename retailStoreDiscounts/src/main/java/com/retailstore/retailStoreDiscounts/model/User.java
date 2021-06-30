package com.retailstore.retailStoreDiscounts.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(	name = "User",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "user_id"),

        })

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long userId;

    @Column(name="firstName")
    public String firstName;

    @Column(name="lastName")
    public String lastName;

    @Column(name="cell_No")
    public String cell_No;

    @Column(name="userType")
    public String userType;

    @Column(name="registrationDate")
    public Date registrationDate;


    public User() {
    }

    public User(long userId,String firstName, String lastName, String cell_No, String userType, Date registrationDate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cell_No = cell_No;
        this.userType = userType;
        this.registrationDate = registrationDate;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCell_No() {
        return cell_No;
    }

    public void setCell_No(String cell_No) {
        this.cell_No = cell_No;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public  void setRegistrationDate(Date registrationDate){
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cell_No='" + cell_No + '\'' +
                ", userType='" + userType + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
