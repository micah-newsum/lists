package com.newsum.model;

import java.util.NoSuchElementException;

public class EmployeeDoublyLinkedList {
  private EmployeeNode head;
  private EmployeeNode tail;
  private int size;

  /**
   * Adding to front of linked list achieves O(1) time complexity
   *
   * Note:
   * Adding a node to the middle of a linked list achieves O(n) time complexity because the
   * operation may require every subsequent nodes link to be redirected.
   *
   * @param employee
   */
  public void addToFront(Employee employee){
    EmployeeNode node = new EmployeeNode(employee);
    node.setNext(head);

    if (isEmpty()){
      tail = node;
    } else{
      head.setPrevious(node);
    }

    head = node;
    size++;
  }

  public void addToEnd(Employee employee){
    EmployeeNode node = new EmployeeNode(employee);
    if (tail == null){
      head = node;
    } else {
      tail.setNext(node);
      node.setPrevious(tail);
    }

    tail = node;
    size++;
  }

  public boolean addBefore(Employee employeeToAdd, Employee employee){
    // throw illegal argument exception if employee is null
    if (employeeToAdd == null){
      throw new IllegalArgumentException("Employee is null");
    }

    // create reference of node for employee. If none exists, throw no element found exception.
    EmployeeNode beforeNode = nodeOf(employee);

    if (beforeNode == null){
      return false;
    }

    // Create new node for employeeToAdd
    EmployeeNode newNode = new EmployeeNode(employeeToAdd);

    // check to see if employee is at head of list. if so, set employeeToAdd to head
    if (beforeNode == head){
      head = newNode;
    } else{
      EmployeeNode previousNode = beforeNode.getPrevious();
      previousNode.setNext(newNode);
      newNode.setPrevious(previousNode);
      beforeNode.setPrevious(newNode);
    }

    newNode.setNext(beforeNode);
    size++;
    return true;
  }

  private EmployeeNode nodeOf(Employee employeeToFind){
    EmployeeNode node = head;

    while (node != null){
      Employee employee = node.getEmployee();
      if (employee.equals(employeeToFind)){
        return node;
      } else {
        node = node.getNext();
      }
    }

    return node;
  }

  public EmployeeNode removeFromFront(){
    if (isEmpty()){
      return null;
    }

    EmployeeNode removedNode = head;

    // handle if node is tail
    if (head.getNext() == null){
      tail = null;
    } else{
      // next of head becomes head; therefore, previous is null
      head.getNext().setPrevious(null);
    }

    head = head.getNext();
    size--;
    removedNode.setNext(null);
    return removedNode;
  }

  public EmployeeNode removeFromEnd(){
    if (isEmpty()){
      return null;
    }

    EmployeeNode removedNode = tail;

    // if tail is the only item in the list
    if (tail.getPrevious() == null){
      head = null;
    } else{
      // tail's previous node now becomes tail
      tail.getPrevious().setNext(null);
    }

    tail = tail.getPrevious();
    size--;
    removedNode.setPrevious(null);
    return removedNode;
  }

  public int size(){
    return size;
  }

  public boolean isEmpty(){
    return head == null;
  }

  public void printList(){
    EmployeeNode current = head;
    System.out.print("HEAD -> ");
    while (current != null){
      System.out.print(current);
      System.out.print(" <=> ");
      current = current.getNext();
    }
    System.out.println("null");
  }
}
