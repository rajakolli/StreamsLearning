/**
 * 
 */
package org.streams.learning;

/**
 * @author raja.kolli
 *
 */
public class Employee {
    private String name;
    private String department;

    public Employee(String n, String d) {
        name = n;
        department = d;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return getName() + " from " + getDepartment() + " dept";
    }
}
