package interfaces.implement;

import data.Storage;
import interfaces.Update;
import model.Branch;

import java.util.Scanner;

public class UpdateBranch implements Update {

    private static UpdateBranch updateBranch;

    public static UpdateBranch getInstance() {
        if (updateBranch == null) {
            updateBranch = new UpdateBranch();
        }
        return updateBranch;
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
        Branch branch = new Branch();
        branch.showBranches();
        System.out.println("Choose Branch Id:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        branch = Storage.branches.stream().filter(branch1 -> branch1.getId() == id).findFirst().orElse(null);
        return branch;

    }

}
