package ru.levelup.lesson08;

import ru.levelup.lesson08.employeegenerator.MaleEmployeeFactory;
import ru.levelup.lesson08.employeegenerator.FemaleEmployeeFactory;
import ru.levelup.lesson08.employees.Employee;
import ru.levelup.lesson08.employeeutils.EmployeeUtils;

import java.util.*;

public class CollectionLauncher {
    public static void main(String[] args) {
        Random randomizer = new Random();

        Collection<Employee> employees = new LinkedList<>();

        EmployeeUtils.fillEmployeeCollection(employees, 100 ,randomizer);
        EmployeeUtils.printAllEmployees(employees);
        EmployeeUtils.printEmployeesWithExperence(employees, randomizer.nextInt(20));
        EmployeeUtils.deleteEmployeeOnOddPositionReverse(employees);
        EmployeeUtils.printAllEmployees(employees);
        EmployeeUtils.deleteEmployeeOnEvenPositionWithIterator(employees);
        EmployeeUtils.printAllEmployees(employees);
    }
}
