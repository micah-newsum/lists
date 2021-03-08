package com.newsum.model;

public class EmployeeLinkedList {
  private EmployeeNode head;
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
    head = node;
    size++;
  }

  public EmployeeNode removeFromFront(){
    if (isEmpty()){
      return null;
    }

    EmployeeNode removedNode = head;
    head = head.getNext();
    size--;
    removedNode.setNext(null);
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
      System.out.print(" -> ");
      current = current.getNext();
    }
    System.out.print("null");
  }
}
