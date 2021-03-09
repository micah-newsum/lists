package com.newsum.model;

public class SortedIntegerLinkedList {
  private IntegerNode head;

  public boolean add(Integer value){
    if (value == null){
      throw new IllegalArgumentException();
    }

    IntegerNode newNode = new IntegerNode(value);

    if (isEmpty()){
      head = newNode;
    } else {
      IntegerNode current = head;
      IntegerNode previous = null;

      // find first node where newNode is less than or equal to
      while (current != null && current.getValue() < newNode.getValue()){
        if (current.getValue() <= newNode.getValue()){
          previous = current;
        }
        current = current.getNext();
      }

      if (current == head){
        head = newNode;
      }
      newNode.setNext(current);

      if (previous != null){
        previous.setNext(newNode);
      }
    }
    return true;
  }

  public boolean isEmpty(){
    if (head == null){
      return true;
    }
    return false;
  }

  public void printList(){
    System.out.print("HEAD ->");
    IntegerNode current = head;
    while (current != null){
      System.out.print(current.getValue());
      System.out.print("->");
      current = current.getNext();
    }
    System.out.println("NULL");
  }
}
