package model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Branch {

    //********************Fields**********************
    int id;
    String name;
    String address;


    @Override
    public String toString() {
        return "\nBranch Id: " + id +
                "\nName: " + name +
                "\nAddress: " + address +
                "\n- - - - - - - - - - - ";
    }

    //************************Counter Branch ID*************************************
    public static int currentId = 1;

    {
        currentId++;
    }

}
