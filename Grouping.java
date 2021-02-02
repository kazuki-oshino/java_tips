import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {

    private Employee() {
    }

    public Employee(String department, String name, int age) {
        this.department = department;
        this.name = name;
        this.age = age;
    }

    private String department;
    private String name;
    private int age;

    public String getDepartment() {
        return this.department;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("組織:%s 名前:%s 年齢:%d歳", this.department, this.name, this.age);
    }
}

public class Grouping {
    public static void main(String[] args) {

        // もととなるリストを生成する
        List<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new Employee("経理部", "山田晃子", 45);
        Employee employee2 = new Employee("経理部", "須藤珠緒", 69);
        Employee employee3 = new Employee("営業部", "県直人", 23);

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);

        // パターン①
        Map<String, List<Employee>> groupsOne = new HashMap<>();
        for (Employee employee : employeeList) {
            groupsOne.computeIfAbsent(employee.getDepartment(),
                (unused) -> new ArrayList<>()).add(employee);
        }
        System.out.println(groupsOne);

        // パターン②
        Map<String, List<Employee>> groupsTwo = employeeList
            .stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(groupsTwo);
    }
}

