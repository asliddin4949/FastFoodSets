package interfaces.implement;

import data.Storage;
import interfaces.Delete;
import model.Branch;

import java.util.Scanner;

public class DeleteBranch implements Delete {

    private static DeleteBranch deleteBranch;

    public static DeleteBranch getInstance() {
        if (deleteBranch == null) {
            deleteBranch = new DeleteBranch();
        }
        return deleteBranch;
    }

    @Override
    public void delete() {
        Branch branch = new Branch();
        branch.showBranches();
        System.out.println("Enter Branch Id:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        branch = Storage.branches.stream().filter(branch1 -> branch1.getId() == id).findFirst().orElse(null);
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
}
