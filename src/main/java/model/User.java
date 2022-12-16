package model;

import data.Storage;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class User implements CheckStorage<User> {

    private int userId;
    private String phoneNumber;
    private String name;
    private String password;
    private String role;

    @Override
    public String toString() {
        return  "\nUserId: " + userId +
                "\nPhoneNumber: +998 - " + phoneNumber +
                "\nName: " + name +
                "\nRole: " + role +
                "\n- - - - - - - - - -";
    }

    public static int currentId = 0;

    {
        currentId++;
    }

    @Override
    public boolean isExist(List<User> list, String phoneNumber) {
        var user1 = list.stream().filter(user -> user.getPhoneNumber().equals(phoneNumber)).findFirst().orElse(null);
        return user1!=null;
    }
}
