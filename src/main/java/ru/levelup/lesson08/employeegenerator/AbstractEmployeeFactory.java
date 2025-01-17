package ru.levelup.lesson08.employeegenerator;

import ru.levelup.lesson08.employees.Employee;

import java.util.Date;
import java.util.List;
import java.util.Random;

public abstract class AbstractEmployeeFactory {
    static private int regNumCounter = 1;
    private Random randomizer;
    private List<String> surNames;
    private List<String> names;
    private List<String> fatherNames;
    private Employee.Gender gender;

    private AbstractEmployeeFactory() {
    }

    protected AbstractEmployeeFactory(Random randomizer, List<String> surNames, List<String> names, List<String> fatherNames, Employee.Gender gender) {
        this.randomizer = randomizer;
        this.surNames = surNames;
        this.names = names;
        this.fatherNames = fatherNames;
        this.gender = gender;
    }

    public Employee generateEmployee() {
        return new Employee(surNames.get(randomizer.nextInt(surNames.size()))
                + " " + names.get(randomizer.nextInt(names.size()))
                + " " + fatherNames.get(randomizer.nextInt(fatherNames.size()))
                , regNumCounter++
                , randomizer.nextInt(20)
                , gender);


    }

}
