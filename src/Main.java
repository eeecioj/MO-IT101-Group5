
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Employee {
    int id;
    String name;
    double hourlyRate;

    public Employee(int id, String name, double hourlyRate) {
        this.id = id;
        this.name = name;
        this.hourlyRate = hourlyRate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Display the title
        System.out.println("MotorPH Payroll System");
        
        // Add employee 1
        employees.add(new Employee(1, "Manuel Garcia III", 535.71));        
        // Add employee 2
        employees.add(new Employee(2, "Antonio Lim", 357.14));        
        // Add employee 3
        employees.add(new Employee(3, "Bianca Sofia Aquino", 357.14));        
        // Add employee 4
        employees.add(new Employee(4, "Isabella Reyes", 357.14));        
        // Add employee 5
        employees.add(new Employee(5, "Eduard Hernandez", 313.51));        
        // Add employee 6
        employees.add(new Employee(6, "Andrea Mae Villanueva", 313.51));        
        // Add employee 7
        employees.add(new Employee(7, "Brad San Jose", 255.80));        
        // Add employee 8
        employees.add(new Employee(8, "Alice Romualdez", 133.93));        
        // Add employee 9
        employees.add(new Employee(9, "Rosie Atienza", 133.93));
        // Add employee 10
        employees.add(new Employee(10, "Roderick Alvaro", 313.51));
        // Add employee 11
        employees.add(new Employee(11, "Anthony Salcedo", 302.53));
        // Add employee 12
        employees.add(new Employee(12, "Josie Lopez", 229.02));
        // Add employee 13
        employees.add(new Employee(13, "Martha Farala", 142.86));
        // Add employee 14
        employees.add(new Employee(14, "Leila Martinez", 142.86));
        // Add employee 15
        employees.add(new Employee(15, "Fredrick Romualdez", 318.45));
        // Add employee 16
        employees.add(new Employee(16, "Christian Mata", 255.80));
        // Add employee 17
        employees.add(new Employee(17, "Selena De Leon", 249.11));
        // Add employee 18
        employees.add(new Employee(18, "Allison San Jose", 133.93));
        // Add employee 19
        employees.add(new Employee(19, "Cydney Rosario", 133.93));
        // Add employee 20
        employees.add(new Employee(20, "Mark Bautista", 138.39));
        // Add employee 21
        employees.add(new Employee(21, "Darlene Lazaro", 138.39));
        // Add employee 22
        employees.add(new Employee(22, "Kolby Delos Santos", 142.86));
        // Add employee 23
        employees.add(new Employee(23, "Vella Santos", 133.93));
        // Add employee 24
        employees.add(new Employee(24, "Tomas Del Rosario", 133.93));
        // Add employee 25
        employees.add(new Employee(25, "Jacklyn Tolentino", 142.86));
        // Add employee 26
        employees.add(new Employee(26, "Percival Gutierrez", 147.32));
        // Add employee 27
        employees.add(new Employee(27, "Garfield Manalaysay", 147.32));
        // Add employee 28
        employees.add(new Employee(28, "Lizeth Villegas", 142.86));
        // Add employee 29
        employees.add(new Employee(29, "Carol Ramos", 133.93));
        // Add employee 30
        employees.add(new Employee(30, "Emelia Maceda", 133.93));
        // Add employee 31
        employees.add(new Employee(31, "Delia Aguilar", 133.93));
        // Add employee 32
        employees.add(new Employee(32, "John Rafael Castro", 313.51));
        // Add employee 33
        employees.add(new Employee(33, "Carlos Ian Martinez", 313.51));
        // Add employee 34
        employees.add(new Employee(34, "Beatriz Santos", 313.51));
     

        // Validate employee ID
        int employeeId;
        boolean validEmployeeId = false;
        do {
            System.out.println("Enter your employee ID:");
            employeeId = scanner.nextInt();
            for (Employee employee : employees) {
                if (employee.getId() == employeeId) {
                    validEmployeeId = true;
                    break;
                }
            }
            if (!validEmployeeId) {
                System.out.println("Invalid employee ID. Please try again.");
            }
        } while (!validEmployeeId);
        
        // Display employee information after validation
        System.out.println("\n--------------------------------------");
        System.out.println("EMPLOYEE INFORMATION:");
        System.out.println("--------------------------------------");
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                System.out.println("Employee ID: " + employee.getId());
                System.out.println("Name: " + employee.getName());
                System.out.println("Hourly Rate: Php" + employee.getHourlyRate());
                break;
            }
        }

        // Display Employee Timesheet
        System.out.println("\n--------------------------------------");
        System.out.println("EMPLOYEE TIMESHEET");
        System.out.println("--------------------------------------");
        
        // Time in and time out for employee for each day in a 5-day workweek
        double totalHoursWorked = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.println("\nEnter date for day " + i + " (mm/dd/yyyy):");
            String dateString = scanner.next();
            
            // Parse the date with the specified format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate date = LocalDate.parse(dateString, formatter);

            System.out.println("Enter time in for " + date + " (in 24-hour format, e.g., 9.30 for 9:30 AM):");
            double timeIn = scanner.nextDouble();
            System.out.println("Enter time out for " + date + " (in 24-hour format):");
            double timeOut = scanner.nextDouble();

            // Calculate hours worked for the day
            double hoursWorked = (timeOut - timeIn) - 1; // subtracting 1 hour for lunch break from 12PM to 1PM
            totalHoursWorked += hoursWorked;
        }

        // Calculate weekly and monthly salary
        Employee selectedEmployee = null;
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                selectedEmployee = employee;
                break;
            }
        }

        if (selectedEmployee != null) {
            double weeklySalary = selectedEmployee.getHourlyRate() * totalHoursWorked;
            double monthlySalary = weeklySalary * 4; // Assuming 4 weeks in a month

            // Calculate deductions and withholding tax
            double philHealthDeduction = monthlySalary * 0.03; // 3% of monthly salary
            double pagIbigDeduction = monthlySalary * 0.02; // 2% of monthly salary
            double sssDeduction = 0; // Adjust based on monthly salary range
            double withholdingTax = 0; // Adjust based on monthly salary range

            // Deduct SSS based on monthly salary range
            if (monthlySalary >= 22250 && monthlySalary < 22750) {
                sssDeduction = 1012.50;
            } else if (monthlySalary >= 22750 && monthlySalary < 23250) {
                sssDeduction = 1035;
            } else if (monthlySalary >= 23250 && monthlySalary < 23750) {
                sssDeduction = 1057.50;
            } else if (monthlySalary >= 23750 && monthlySalary < 24250) {
                sssDeduction = 1080;
            } else if (monthlySalary >= 24250 && monthlySalary < 24750) {
                sssDeduction = 1102.50;
            } else if (monthlySalary >= 24750) {
                sssDeduction = 1125;
            }
            
            
            // Calculate government deductions
            double govtDeductions = philHealthDeduction + pagIbigDeduction + sssDeduction;

            // Calculate taxable income
            double taxableIncome = monthlySalary - govtDeductions;
            
            // Calculate withholding tax based on monthly salary range
            if (taxableIncome >= 20833 && taxableIncome < 33333) {
                withholdingTax = (taxableIncome - 20833) * 0.20;
            } else if (taxableIncome >= 33333 && taxableIncome < 66667) {
                withholdingTax = (taxableIncome - 33333) * 0.25;
            } else if (taxableIncome >= 66667 && taxableIncome < 166667) {
                withholdingTax = (taxableIncome - 33333) * 0.30;
            }

            // Calculate total deductions
            double totalDeductions = govtDeductions + withholdingTax;
            
            // Calculate net salary
            double netSalary = taxableIncome - withholdingTax;

            // Display employee information and salary details
            System.out.println("\n--------------------------------------");
            System.out.println("EMPLOYEE PAYSLIP");
            System.out.println("--------------------------------------");
            
            System.out.println("\nTotal Hours Worked: " + totalHoursWorked);
            System.out.println("Weekly Salary: Php" + weeklySalary);
            System.out.println("--------------------------------------");
            System.out.println("GROSS INCOME: Php" + monthlySalary);
            System.out.println("--------------------------------------");
            System.out.println("\nPhilHealth: Php" + philHealthDeduction);
            System.out.println("Pag-IBIG: Php" + pagIbigDeduction);
            System.out.println("Social Security System: Php" + sssDeduction);
            System.out.println("Withholding Tax: Php" + withholdingTax);
            System.out.println("--------------------------------------");
            System.out.println("TOTAL DEDUCTIONS :Php " + totalDeductions);
            System.out.println("--------------------------------------");
            System.out.println("\n*****TAKE HOME PAY: Php" + netSalary + "*****");
        } else {
            System.out.println("Employee not found.");
        }
    }
}
