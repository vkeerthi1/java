package com;

import java.util.*;
import java.util.stream.Collectors;

public class MaximumUsingStreamMain {

    public static void main(String args[])
    {
        List<Employee> employeeList = createEmployeeList();
        List<String> employeeFilteredList = employeeList.stream()
                .filter(e->e.getAge()>20)
                .map(Employee::getName)
                .collect(Collectors.toList());

        employeeFilteredList.forEach((name)-> System.out.println(name));

        Long employeeFCountList = employeeList.stream()
                .filter(e->e.getAge()>25)
                .count();
        System.out.println(employeeFCountList);

        Optional<Employee> mary = employeeList.stream().filter(e -> e.getName().equalsIgnoreCase("mary")).findAny();
        if(mary.isPresent()){
            System.out.println(mary.get());
        }

        List<Employee> em = createEmployeeList();
        OptionalInt max = em.stream().
                mapToInt(Employee::getAge).max();

        if(max.isPresent())
            System.out.println("Maximum age of Employee: "+max.getAsInt());


        em.sort((e1,e2) -> e1.getAge() - e2.getAge());
        em.forEach(System.out::println);


        List<String> eist = em.stream().map(Employee::getName).collect(Collectors.toList());
       String employeeNamesStr = String.join(",",eist);
        System.out.println("Employees are: "+employeeNamesStr);


        Map<String, List<Employee>> collect = em.stream().collect(Collectors.groupingBy(Employee::getName));
        collect.forEach((name,employeeListTemp)->System.out.println("Name: "+name+" ==>"+employeeListTemp));


        Integer[] arr=new Integer[]{100,24,13,44,114,200,40,112};
        List<Integer> list = Arrays.asList(arr);
        OptionalDouble avg = list.stream().mapToInt(n -> n*n).filter(n -> n>1000).average();
        if(avg.isPresent())
            System.out.println(avg.getAsDouble());

    }

    public static List<Employee> createEmployeeList()
    {
        List<Employee> employeeList=new ArrayList<>();

        Employee e1=new Employee("John",21);
        Employee e2=new Employee("Martin",19);
        Employee e3=new Employee("Mary",31);
        Employee e4=new Employee("Stephan",18);
        Employee e5=new Employee("Gary",26);

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);

        return employeeList;
    }
}
