package ru.levelup.lesson08;

import ru.levelup.lesson08.employeegenerator.MaleEmployeeFactory;
import ru.levelup.lesson08.employeegenerator.FemaleEmployeeFactory;
import ru.levelup.lesson08.employees.Employee;
import ru.levelup.lesson08.employeeutils.EmployeeUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CollectionLauncher {
    public static void main(String[] args) {
        Random random = new Random();
        MaleEmployeeFactory maleFactory = new MaleEmployeeFactory(random);
        FemaleEmployeeFactory femaleFactory = new FemaleEmployeeFactory(random);

        List<Employee> employees = new LinkedList<>();

        for (int i = 0; i < 200; i++) {
            employees.add(
                    switch (random.nextInt(2)) {
                        case 0 -> femaleFactory.generateEmployee();
                        case 1 -> maleFactory.generateEmployee();
                        default -> null;
                    });
        }

        EmployeeUtils.printAllEmployees(employees);
        EmployeeUtils.printEmployeesWithExperence(employees, random.nextInt(20));
        EmployeeUtils.deleteEmployeeOnOddPositionReverse(employees);
        EmployeeUtils.printAllEmployees(employees);
        EmployeeUtils.deleteEmployeeOnEvenPositionWithIterator(employees);
        EmployeeUtils.printAllEmployees(employees);
    }
}
