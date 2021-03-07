package com.newsum;

import com.newsum.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class Application {
  public static void main(String[] args) {
    List<Employee> employees = new ArrayList<>();

    employees.add(new Employee("Micah","Newsum",1));
    employees.add(new Employee("Aysha","Newsum",2));
    employees.add(new Employee("Audrey","Newsum",3));

    // accessing items from array list is O(1)
    System.out.println("Iterating over elements");
    employees.forEach(System.out::println);

    // replacing an item in the list is O(1)
    System.out.println("Replacing elements");
    employees.set(0,new Employee("John","Doe",4));
    employees.forEach(System.out::println);

    // inserting element at index is O(n) because may require shift of every element in backing array, as is the case below
    System.out.println("Inserting elements");
    employees.add(0,new Employee("Micah","Newsum",1));
    employees.forEach(System.out::println);
  }
}
