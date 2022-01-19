import java.util.HashSet;
import java.util.Set;

public class EmployeeHashEquals {
    String name;
    int age;

    public Employee(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String toString()
    {
        return "EmployeeHashEquals Name: "+name+" age: "+age;
    }

    public static void main(String args[])
    {
        EmployeeHashEquals e1=new EmployeeHashEquals("John",21);
        EmployeeHashEquals e2=new EmployeeHashEquals("John",21);

        System.out.println("Emp1"+e1.getName()+":"+e1.getAge());
        System.out.println("Emp1"+e2.getName()+":"+e2.getAge());

        System.out.println("Compare"+e1.equals(e2));
        System.out.println("HashCode e1:"+e1.hashCode());
        System.out.println("HashCode e2:"+e2.hashCode());
        //after only implementation of equals we need also hashcode ...why?

        //Set should override the duplicate values and should return me only one object
        // as both objects are same. but after overriding equals() you can see Set functionality is disturbed.
        Set<Employee> employees = new HashSet<>();
        employees.add(e1);
        employees.add(e2);
        System.out.println(employees);

       // If two objects are equal according to the equals(Object) method, then calling
        // the hashcode() method on each of the two objects must produce the same integer result.
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        EmployeeHashEquals emp = (EmployeeHashEquals) obj;
        return (emp.getName() == this.name && emp.getAge() == this.age);
    }

    @Override
    public int hashCode() {
        final int PRIME=31;
        int result =1;
        result = PRIME * result + this.age;
        return result;
    }
}
