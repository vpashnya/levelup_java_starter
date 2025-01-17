package ru.levelup.lesson08.employeeutils;

import ru.levelup.lesson08.employees.Employee;

import java.util.*;

public class EmployeeUtils {
    public static void printAllEmployees(Collection<Employee> employees) {
        System.out.println(">>>> Cписок работников");
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void printEmployeesWithExperence(Collection<Employee> employees, int experenceInYear) {
        System.out.println(">>>> Cписок работников со стажем " + experenceInYear + " и более");
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getExperienceInYear() >= experenceInYear) {
                System.out.println(employee);
            }
        }
    }

    public static void deleteEmployeeOnOddPositionReverse(Collection<Employee> employees) {
        System.out.println(">>>> Удалим каждого второго - стоящего на нечетной позиции в КОЛЛЕКЦИИ, обход с конца коллекции");
        List<Employee> employeesList = new LinkedList<>(employees);

        for (int i = employeesList.size() - 1; i >= 0; i--) {
            if (i % 2 != 0) {
                employeesList.remove(i);
            }
        }

        employees.clear();
        employees.addAll(employeesList);
    }

    public static void deleteEmployeeOnEvenPositionWithIterator(Collection<Employee> employees) {
        System.out.println(">>>> Удалим каждого второго - стоящего на четной позиции в КОЛЛЕКЦИИ, с помощью итератора");
        Iterator iterator = employees.iterator();
        boolean needDelete = true;
        while (iterator.hasNext()) {
            iterator.next();
            if (needDelete) {
                iterator.remove();
            }
            needDelete = !needDelete;
        }
    }

}
