package data;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static User currentUser;       //*****  Signed User
    public static Branch currentBranch;   //***** Ordering Branch
    public static List<Order> inProgress;  //***** InProgress Orders
    public static List<User> users = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    public static List<CurrentOrder> currentOrders = new ArrayList<>();
    public static  List<Product> products = new ArrayList<>();
    public static List<Branch> branches = new ArrayList<>();

}
