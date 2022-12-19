package model;

import data.Storage;
import Console.AdminConsole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@EqualsAndHashCode
public class Branch implements CheckStorage<Branch> {

    //********************Fields**********************
    int id;
    String name;
    String address;


    //*******************Behaviors******************************
    @Override
    public boolean isExist(List<Branch> list, String name) {
        var branch1 = list.stream().filter(branch -> branch.getName().equals(name)).findFirst().orElse(null);
        return branch1 != null;
    }

    public void addBranch() {
        System.out.println("Enter Branch Name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Branch branch = new Branch();
        if (branch.isExist(Storage.branches, name)) {
            System.out.println("This Branch Name has been added!");
            AdminConsole.adminConsole();
        } else {
            System.out.println("Enter Address:");
            scanner = new Scanner(System.in);
            String address = scanner.nextLine();
            branch.setId(Branch.currentId);
            branch.setName(name);
            branch.setAddress(address);
            Storage.branches.add(branch);
            System.out.println("Branch is successfully added!");
            AdminConsole.adminConsole();
        }
    }

    public void showBranches() {
        Storage.branches.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "\nBranch Id: " + id +
                "\nName: " + name +
                "\nAddress: " + address +
                "\n- - - - - - - - - - - ";
    }

    //************************Counter Branch ID*************************************
    public static int currentId = 0;

    {
        currentId++;
    }

}
