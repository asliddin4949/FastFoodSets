package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@EqualsAndHashCode
public class Branch implements CheckStorage<Branch> {

    int id;
    String name;
    String address;

    public static int currentId = 0;
    {
        currentId++;
    }
    @Override
    public boolean isExist(List<Branch> list, String name) {
        var branch1 = list.stream().filter(branch -> branch.getName().equals(name)).findFirst().orElse(null);
        return branch1!=null;
    }

    @Override
    public String toString() {
        return "\nBranch Id: " + id +
                "\nName: " + name +
                "\nAddress: " + address +
                "\n- - - - - - - - - - - ";
    }


}
