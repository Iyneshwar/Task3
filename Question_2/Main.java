
import java.util.Scanner;

interface Taxable {
    double SALES_TAX = 0.07;
    double INCOME_TAX = 0.105;

    double calcTax();
}


class Employee implements Taxable {
    private int empId;
    private String name;
    private double salary;


    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }


    @Override
    public double calcTax() {
        return salary * INCOME_TAX;
    }
}


class Product implements Taxable {
    private int pid;
    private double price;
    private int quantity;


    public Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }


    @Override
    public double calcTax() {
        return price * SALES_TAX;
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter Employee Information:");
        System.out.print("Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Employee Name: ");
        String empName = scanner.nextLine();
        System.out.print("Employee Salary: ");
        double empSalary = scanner.nextDouble();

        Employee employee = new Employee(empId, empName, empSalary);
        double incomeTax = employee.calcTax();
        System.out.println("Income Tax for Employee " + empName + " with ID " + empId + ": $" + incomeTax);


        System.out.println("\nEnter Product Information:");
        System.out.print("Product ID: ");
        int pid = scanner.nextInt();
        System.out.print("Product Price: ");
        double price = scanner.nextDouble();
        System.out.print("Product Quantity: ");
        int quantity = scanner.nextInt();


        Product product = new Product(pid, price, quantity);
        double salesTax = product.calcTax();
        System.out.println("Sales Tax for Product ID " + pid + ": $" + salesTax);


    }
}
