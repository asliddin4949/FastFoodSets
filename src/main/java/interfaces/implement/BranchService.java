package interfaces.implement;

import data.Storage;
import interfaces.CreateReadUpdateDelete;
import model.Branch;

import java.util.List;
import java.util.Scanner;

public class BranchService implements CreateReadUpdateDelete {

    private static BranchService branchService;

    public static BranchService getInstance() {
        if (branchService != null) {
            branchService = new BranchService();
        }
        return branchService;
    }


    @Override
    public void add() {
        System.out.println("Enter Branch Name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        if (isExist(Storage.branches, name)) {
            System.out.println("This Branch Name has been added!");

        } else {
            System.out.println("Enter Address:");
            scanner = new Scanner(System.in);
            String address = scanner.nextLine();
            Branch branch = new Branch();
            branch.setId(Branch.currentId);
            branch.setName(name);
            branch.setAddress(address);
            Storage.branches.add(branch);
            System.out.println("Branch is successfully added!");

        }
    }

    @Override
    public void show() {
        Storage.branches.forEach(System.out::println);
    }

    @Override
    public void update() {
        Branch branch = chooseBranch();
        if (branch != null) {
            while (true) {
                int command = chooseUpdateField(branch);
                if (command == 1) {
                    changeName(branch);
                } else if (command == 2) {
                    changeAddress(branch);
                } else if (command == 0) {
                    break;
                } else {
                    System.out.println("Wrong Command");
                }
            }
        } else {
            System.out.println("Entered Wrong Id!");
        }
    }

    @Override
    public void delete() {
        show();
        System.out.println("Enter Branch Id:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Branch branch = Storage.branches.stream().filter(branch1 -> branch1.getId() == id).findFirst().orElse(null);
        if (branch != null) {
            for (Branch stBranch : Storage.branches) {
                if (stBranch.equals(branch)) {
                    Storage.branches.remove(branch);
                }
            }
            System.out.println("Branch Deleted");
        } else {
            System.out.println("Wrong Branch Id");
        }
    }

    public boolean isExist(List<Branch> list, String name) {
        var branch1 = list.stream().filter(branch -> branch.getName().equals(name)).findFirst().orElse(null);
        return branch1 != null;
    }

    private void changeAddress(Branch branch) {
        System.out.println("Enter New Branch Address:");
        Scanner scanner = new Scanner(System.in);
        String address = scanner.nextLine();
        for (Branch updatingBranch : Storage.branches) {
            if (updatingBranch.equals(branch)) {
                updatingBranch.setAddress(address);
            }
        }
        System.out.println("Branch Address Changed!");
    }

    private void changeName(Branch branch) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter New Branch Name:");
        String name = scanner.nextLine();
        for (Branch updatingBranch : Storage.branches) {
            if (updatingBranch.equals(branch)) {
                updatingBranch.setName(name);
            }
        }
        System.out.println("Branch Name Changed!");
    }

    private int chooseUpdateField(Branch branch) {
        System.out.println(branch);
        System.out.println("'1' - \"Change Name\"  '2' - \"Change Address\"  '0' - \"go back\"");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();

    }

    private Branch chooseBranch() {
        show();
        System.out.println("Choose Branch Id:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        return Storage.branches.stream().filter(branch1 -> branch1.getId() == id).findFirst().orElse(null);
    }
}
