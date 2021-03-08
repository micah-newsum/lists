package com.newsum;

import com.newsum.model.Employee;
import com.newsum.model.EmployeeLinkedList;

import java.util.ArrayList;
import java.util.List;

public class Application {
  public static void main(String[] args) {
    arrayListClient();
    employeeLinkedListClient();
  }

  private static void arrayListClient(){
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

    System.out.println("Check for element existence");
    System.out.println(employees.contains(new Employee("Micah", "Newsum", 1)));
    System.out.println(employees.indexOf(new Employee("Aysha", "Newsum",2)));

    // removing an element is O(n) because the operation may require every element in the backing array to be shifted down an index
    employees.remove(0);
    employees.forEach(System.out::println);
  }

  private static void employeeLinkedListClient(){
    Employee micah = new Employee("Micah","Newsum",1);
    Employee aysha = new Employee("Aysha","Newsum",2);
    Employee audrey = new Employee("Audrey","Newsum",3);

    EmployeeLinkedList list = new EmployeeLinkedList();

    System.out.println(list.isEmpty());

    list.addToFront(micah);
    list.addToFront(aysha);
    list.addToFront(audrey);

    list.printList();
    System.out.println();
    System.out.println(list.size());

    list.removeFromFront();
    list.printList();
  }
}
