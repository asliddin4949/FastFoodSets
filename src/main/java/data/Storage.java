package data;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class Storage {
         //*****  Signed User
    public static User currentUser;
    public static User admin = new User("admin","admin1");
    public static Branch currentBranch;   //***** Ordering Branch
    public static List<Order> inProgress;  //***** InProgress Orders
    public static List<User> users = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    public static List<CurrentOrder> currentOrders = new ArrayList<>();
    public static  List<Product> products = new ArrayList<>();
    public static List<Branch> branches = new ArrayList<>();

}
