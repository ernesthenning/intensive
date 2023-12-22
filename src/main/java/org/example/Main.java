package org.example;

import org.example.connection.ConnectionUtil;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public Main() throws SQLException, ClassNotFoundException {
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        sortTest();
        addTest();
        addAllTest();
        removeIndexTest();
        removeObjectTest();
        getTest();
        clearTest();
        UserRepository repository = new UserRepository();
        UserService service = new UserService(repository);
        User user = service.get(100001);
        System.out.println(user.getGirls().get(0).getName());
    }

    private static void sortTest() {
        System.out.println("============SortTest=============");
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        Integer[] ints = {45, 23, -11, 56, 65, 78, -31, 0, 21};
        customArrayList.addAll(List.of(ints));
        System.out.println("CustomArrayList before sorting: " + customArrayList);
        customArrayList.sort(Comparator.naturalOrder());
        System.out.println("CustomArrayList after sorting: " + customArrayList);
        System.out.println("=================================");
    }

    private static void addTest() {
        System.out.println("============AddTest=============");
        CustomArrayList<Character> customArrayList = new CustomArrayList<>();
        System.out.println("CustomArrayList before addition: " + customArrayList);
        customArrayList.add('A');
        customArrayList.add('B');
        customArrayList.add('C');
        System.out.println("CustomArrayList after addition: " + customArrayList);
        System.out.println("=================================");
        customArrayList.add(2, 'D');
        System.out.println("CustomArrayList after 2nd addition: " + customArrayList);
    }

    private static void addAllTest() {
        System.out.println("============AddAllTest=============");
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        System.out.println("CustomArrayList before addition: " + customArrayList);
        String[] names = {"John", "Johann", "Ivan"};
        List<String> list = new ArrayList<>(List.of(names));
        customArrayList.addAll(list);
        System.out.println("CustomArrayList after addition: " + customArrayList);
        System.out.println("=================================");
    }

    private static void removeIndexTest() {
        System.out.println("============RemoveIndexTest=============");
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        Integer[] ints = {45, 23, -11, 56, 65, 78, -31, 0, 21};
        customArrayList.addAll(List.of(ints));
        System.out.println("CustomArrayList before removal at -1: " + customArrayList);
        customArrayList.remove(-1);
        System.out.println("CustomArrayList after removal at -1: " + customArrayList);
        System.out.println("=================================");
        System.out.println("================Remove at 0=================");
        customArrayList.remove(0);
        System.out.println("CustomArrayList after removal at 0: " + customArrayList);
    }

    private static void removeObjectTest() {
        System.out.println("============RemoveObjectTest=============");
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        String[] cities = {"Moscow", "Paris", "London", "Berlin", "Warsaw"};
        customArrayList.addAll(List.of(cities));
        System.out.println("CustomArrayList before removal of Warsaw " + customArrayList);
        customArrayList.remove("Warsaw");
        System.out.println("CustomArrayList after removal of Warsaw " + customArrayList);
        System.out.println("=================================");
    }

    private static void getTest() {
        System.out.println("============GetTest=============");
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        String[] cities = {"Moscow", "Paris", "London", "Berlin", "Warsaw"};
        customArrayList.addAll(List.of(cities));
        System.out.println("Result of get(2) (London expected)  " + customArrayList.get(2));
        System.out.println("=================================");
    }

    private static void clearTest() {
        System.out.println("============ClearTest=============");
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        String[] cities = {"Moscow", "Paris", "London", "Berlin", "Warsaw"};
        customArrayList.addAll(List.of(cities));
        customArrayList.clear();
        System.out.println("Result of clear()  " + customArrayList);
        System.out.println("=================================");
    }




}