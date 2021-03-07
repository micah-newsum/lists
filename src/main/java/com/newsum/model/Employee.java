package com.newsum.model;

public class Employee {
  private String firstName;
  private String lastName;
  private int id;

  public Employee(String firstName, String lastName, int id) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
  }

  @Override
  public String toString() {
    return String.format("{firstName='%s', lastName='%s', id=%d}",firstName,lastName,id);
  }
}
