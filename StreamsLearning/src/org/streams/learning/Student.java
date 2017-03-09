package org.streams.learning;

public class Student {
	 public String name;
	 public int marks;

	 Student(String name, int marks) {
	  this.setName(name);
	  this.setMarks(marks);
	 }

	 public String getName() {
	  return name;
	 }

	 public void setName(String name) {
	  this.name = name;
	 }

	 public int getMarks() {
	  return marks;
	 }

	 public void setMarks(int marks) {
	  this.marks = marks;
	 }

	 @Override
	 public String toString() {
	  return getName();
	 }

}
