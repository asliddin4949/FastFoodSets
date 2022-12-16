package service;

import data.Storage;
import interfaces.Admin;
import model.Branch;

import java.util.Scanner;

public class BranchService {

    public static Branch dynamicBranch;
    public static void addBranch(){
        System.out.println("Enter Branch Name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Branch branch = new Branch();
        if(branch.isExist(Storage.branches,name)){
            System.out.println("This Branch Name has been added!");
            Admin.adminMenu();
        }else {
            System.out.println("Enter Address:");
            scanner = new Scanner(System.in);
            String address = scanner.nextLine();
            branch.setId(Branch.currentId);
            branch.setName(name);
            branch.setAddress(address);
            Storage.branches.add(branch);
            System.out.println("Branch is successfully added!");
            Admin.adminMenu();
        }
    }
    public static void showBranches(){
        Storage.branches.forEach(System.out::println);
    }
}
