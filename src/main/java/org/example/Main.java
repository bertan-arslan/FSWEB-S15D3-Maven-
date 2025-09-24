package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {

    private static Map<Integer, Employee> employeeMap;
    private static List<Employee> duplicatedEmployees;

    public static void main(String[] args) {
    List<Employee> employees = new ArrayList<>();

    employees.add(new Employee(1, "Bertan", "Arslan"));
    employees.add(new Employee(1, "Bertan", "Arslan"));
    employees.add(new Employee(1, "Bertan", "Arslan"));
    employees.add(new Employee(2, "Zeynep", "Türk"));
    employees.add(new Employee(2, "Zeynep", "Türk"));
    employees.add(new Employee(3, "Emin", "Yıldız"));
    employees.add(new Employee(4, "Tülin", "Çiçek"));
    employees.add(new Employee(5, "Emrah", "Yılmaz"));

    }
    public static List<Employee> findDuplicates(List<Employee> employees){
        employeeMap = new HashMap<>();
        duplicatedEmployees = new LinkedList<>();
        Iterator<Employee> iterator = employees.iterator();

        while(iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee == null){
                System.out.println("null record");
                continue;
            }

            if(employeeMap.containsKey(employee.getId())){
                duplicatedEmployees.add(employee);
            } else {
                employeeMap.put(employee.getId(),employee);
            }

        }
        return duplicatedEmployees;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            if (e == null) continue;
            map.putIfAbsent(e.getId(), e);
        }
        return map;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (Employee e : employees) {
            if (e == null) continue;
            freq.merge(e.getId(), 1, Integer::sum);
        }

        List<Employee> onlySingles = new LinkedList<>();
        for (Employee e : employees) {
            if (e == null) continue;
            if (freq.getOrDefault(e.getId(), 0) == 1) {
                onlySingles.add(e);
            }
        }
        return onlySingles;
    }

}