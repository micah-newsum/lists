package com.newsum.model;

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
