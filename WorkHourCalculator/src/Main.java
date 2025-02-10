import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Employee{

    private int employeeId;
    private String employeeName;
    private Double hourlyRate;
    private ArrayList<Double> workedHours= new ArrayList<>();
    private static HashMap<Integer,Employee> EmployeesList = new HashMap<>();


    public int getEmployeeId() {
        return employeeId;
    }

    public static HashMap<Integer, Employee> getEmployeesList() {
        return EmployeesList;
    }

    public ArrayList<Double> getWorkedHours() {
        return workedHours;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setWorkedHours(ArrayList<Double> workedHours) {
        this.workedHours = workedHours;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public static void setEmployeesList(HashMap<Integer, Employee> attendanceList) {
        EmployeesList = attendanceList;
    }

    public Employee(int id, String name, Double hourlyRate, ArrayList<Double> workedHours) {
        this.employeeId = id;
        this.employeeName = name;
        this.hourlyRate = hourlyRate;
        this.workedHours = workedHours;
        EmployeesList.put(id,this);
    }

    public Double calculateTotalHours(ArrayList<Double> workedHours) {
        double totalHours = 0;
        for (double hours : workedHours){
            totalHours += hours;
        }
        return totalHours;
    }

    public Double calculateWeeklyPay(Double totalHours, Double hourlyRate) {
        return totalHours * hourlyRate;
    }

    public String doubleToString(double value){
        return String.valueOf(value);
    }


    public String generatePayStub(Double totalHours, Double hourlyRate) {
        String name = this.employeeName;
        //Use string builder
        StringBuilder sb = new StringBuilder();
        return sb.append("Employee Name: ").append(name.substring(0,1).toUpperCase()).append(name.substring(1).toLowerCase()).append("\nTotal Hours: ").append(totalHours).append("\nHourly Rate: ").append(hourlyRate).append("\nWeekly Pay: ").append(totalHours * hourlyRate).toString();
    }



    static public void line(){
        System.out.println("-------------------------------------------------");
    }

}

public class Main {

    public static void main(String[] args) {
        System.out.println("*********** Work Hour Calculator Tracking System for UKG ***********");

        int val = 0;
        Scanner sc = new Scanner(System.in);

        do{
            Employee.line();
            System.out.println("1.Add Employees");
            System.out.println("2.Check your 'Total Hours' in the week");
            System.out.println("3.Check your 'Weekly Pay' in the week");
            System.out.println("4.Generate Attendance Report");
            System.out.println("5.Exit");
            System.out.print("Enter your choice :- ");
            val = sc.nextInt();
            Employee.line();

            switch (val){

                case 1:
                    System.out.println("Choice 1 :- ");
                    System.out.print("Enter the number of Employees you want to add :- ");
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter the Employee " + (i + 1)+ " id :- ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter the Employee " + (i + 1)+ " name :- ");
                        String name = sc.nextLine();
                        System.out.print("Enter the Employee " + (i + 1)+ " Hourly rate :- ");
                        Double hourlyRate = sc.nextDouble();
                        System.out.println("Enter the worked hours for the week : ");
                        ArrayList<Double> workedHours = new ArrayList<>();
                        for (int j = 0 ; j < 7 ; j++){
                            System.out.print("Enter the worked hours for day " + (j + 1) + " :- ");
                            double hours = sc.nextDouble();
                            workedHours.add(hours);
                        }

                        new Employee(id,name,hourlyRate,workedHours);
                    }
                    break;

                case 2:
                    System.out.println("Choice 2 :- ");
                    System.out.print("Enter your id to check the total hours :- ");
                    int id = sc.nextInt();
                    Employee emp = Employee.getEmployeesList().get(id);
                    if(emp == null){
                        System.out.println("Employee not found....");
                        break;
                    }
                    System.out.println("Total number of worked hours in the week are " + emp.calculateTotalHours(emp.getWorkedHours()));

                    break;

                case 3:
                    System.out.println("Choice 3 :- ");
                    System.out.print("Enter your id to check your weekly pay :- ");
                    int e_id = sc.nextInt();
                    Employee e = Employee.getEmployeesList().get(e_id);
                    if(e == null){
                        System.out.println("Employee not found....");
                        break;
                    }
                    double totalHours = e.calculateTotalHours(e.getWorkedHours());
                    System.out.println("Your weekly pay is " + e.calculateWeeklyPay(totalHours,e.getHourlyRate()));
                    break;

                case 4:
                    System.out.println("Choice 4 :- ");
                    System.out.print("Enter your id to generate the pay stub :- ");
                    int emp_id = sc.nextInt();
                    Employee employee = Employee.getEmployeesList().get(emp_id);
                    if(employee == null){
                        System.out.println("Employee not found....");
                        break;
                    }
                    double total_Hours = employee.calculateTotalHours(employee.getWorkedHours());
                    System.out.println(employee.generatePayStub(total_Hours,employee.getHourlyRate()));
                    break;
                case 5:
                    System.out.println("Exit...");
                    break;

                default:
                    System.out.println("Enter a valid option listed above...");
                    break;

            }

        }while (val != 5);
    }
}
