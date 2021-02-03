import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class Saiki {

    public static void main(String[] args) {
        List<Department> departmentList = new ArrayList<>();
        departmentList.add(new Department("001", 1, "", "会社"));
        departmentList.add(new Department("003", 2, "001", "部1"));
        departmentList.add(new Department("002", 2, "001", "部2"));
        departmentList.add(new Department("004", 2, "001", "部3"));
        departmentList.add(new Department("006", 3, "003", "課1"));
        departmentList.add(new Department("005", 3, "003", "課2"));

        List<Department> firstHierarchyList = departmentList.stream()
            .filter(d -> d.getDepartmentLevel() == 1)
            .collect(Collectors.toCollection(LinkedList::new));

        List<Department> hierarchySortedList = new LinkedList<>();

        for (Department department : firstHierarchyList){
            sortHierarchy(hierarchySortedList, departmentList, department, 1);      
        }
         
        hierarchySortedList.forEach(System.out::println);
    }

    public static void sortHierarchy(
        List<Department> hierarchySortedList, List<Department> sortedList,
            Department department, int departmentLevel){
        hierarchySortedList.add(department);
        int nextDepartmentLevel = departmentLevel + 1;
        List<Department> nextHierarchyList = sortedList.stream()
            .filter(d -> d.getDepartmentLevel() == nextDepartmentLevel)
            .filter(d -> d.getHigherHierarchyDepartmentCd().equals(department.getDepartmentCd()))
            .sorted(Comparator.comparing(Department::getDepartmentCd))
            .collect(Collectors.toCollection(LinkedList::new));
        if (nextHierarchyList.size() != 0) {
            for (Department nextDepartment : nextHierarchyList){
                sortHierarchy(hierarchySortedList, sortedList, nextDepartment, nextDepartmentLevel);      
            }
        }
    }
}

class Department {

    Department(String dc, int dl, String hd, String dn) {
        this.departmentCd = dc;
        this.departmentLevel = dl;
        this.higherHierarchyDepartmentCd = hd;
        this.departmentName = dn;
    };

    private String departmentCd;    
    private int departmentLevel;
    private String higherHierarchyDepartmentCd;
    private String departmentName;

    public String getDepartmentCd() {
        return departmentCd;
    }

    public int getDepartmentLevel() {
        return departmentLevel;
    }

    public String getHigherHierarchyDepartmentCd() {
        return higherHierarchyDepartmentCd;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String toString() {
        return String.format("組織コード:%s 組織階層:%d 上位組織コード:%s 組織名:%s", this.departmentCd, this.departmentLevel, this.higherHierarchyDepartmentCd, this.departmentName);
    }

}