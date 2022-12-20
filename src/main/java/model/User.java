package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class User  {
    //*****************Fields**********************
    private int userId;
    private String phoneNumber;
    private String name;
    private String password;
    private Role role;

    //*******************Behaviors******************************
    @Override
    public String toString() {
        return "\nUserId: " + userId +
                "\nPhoneNumber: +998 - " + phoneNumber +
                "\nName: " + name +
                "\n- - - - - - - - - -";
    }

    public User() {
    }

    public User(String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    //************************Counter User ID*************************************
    public static int currentId = 1;
    {
        currentId++;
    }


}
