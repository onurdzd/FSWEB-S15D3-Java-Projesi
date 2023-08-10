import Models.Employee;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Employee employee1=new Employee(1,"onur","dzd");
        Employee employee2=new Employee(1,"onur2","dzd2");
        Employee employee3=new Employee(2,"onur3","dzd3");
        Employee employee4=new Employee(3,"onur4","dzd4");
        Employee employee5=new Employee(2,"onur5","dzd5");

        LinkedList<Employee> linkedList1=new LinkedList<>();
        linkedList1.add(employee1);
        linkedList1.add(employee2);
        linkedList1.add(employee3);
        linkedList1.add(employee4);
        linkedList1.add(employee5);

        LinkedList<Employee> duplicatedEmployeeList=new LinkedList<>();
        Map<Employee,Integer> uniqueEmployeeList=new HashMap<>();

        for (Employee linkedEmployee:linkedList1
             ) {
            int duplicatedCount= (int) linkedList1.stream().filter(item -> item.getId()==linkedEmployee.getId()).count();

            if(duplicatedEmployeeList.stream().noneMatch(elem -> elem.getId() == linkedEmployee.getId())) {
                if (duplicatedCount > 1 ) {
                    duplicatedEmployeeList.add(linkedEmployee);
                    uniqueEmployeeList.put(linkedEmployee, 1);
                } else {
                    uniqueEmployeeList.put(linkedEmployee, 1);
                }
            }
        }
        System.out.println(duplicatedEmployeeList.toString());
        System.out.println(uniqueEmployeeList);
        System.out.println(linkedList1.toString());
    }
}