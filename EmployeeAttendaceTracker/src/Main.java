import java.util.*;

class Employee{

    private int employeeId;
    private String employeeName;
    private String attendanceStatus;
    static ArrayList<String> AttendanceList = new ArrayList<>();

    public Employee(){

    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Employee(int employeeId, String employeeName, String attendanceStatus) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.attendanceStatus = attendanceStatus;
        AttendanceList.add(employeeId + "," +employeeName + "," + attendanceStatus);
    }

    static public void printEmployees(){

        if(AttendanceList.isEmpty()) {
            System.out.println("No Employees.... .");
            return ;
        }

        for (String it : AttendanceList){
            System.out.println(it);
        }
    }

    static public String generateAttendanceReport(ArrayList<String> attendanceList){

        int presentCount = 0;
        int absentCount = 0;
        for (String status : attendanceList) {
            if(status.equals("Present")){
                presentCount++;
            }else{
                absentCount++;
            }
        }

        StringBuilder report = new StringBuilder();

        report.append("Attendance Report :- \n");
        report.append("Total Employees: ").append(attendanceList.size()).append("\n");
        report.append("Employees Present: ").append(presentCount).append("\n");
        report.append("Employees Absent: ").append(absentCount);

        return report.toString();

    }

    public static String intToString(int id) {
        return String.valueOf(id);
    }

    public static int stringToInt(String id) {
        return Integer.parseInt(id);
    }

    static public void line(){
        System.out.println("-------------------------------------------------");
    }
}

class AttendanceTracker{
    public static void main(String[] args) {

        System.out.println("*********** Attendance Tracking System for UKG ***********");

        int val = 0;
        Scanner sc = new Scanner(System.in);

        try {
            do{
                Employee.line();
                System.out.println("1.Add Employees");
                System.out.println("2.Print the Employees");
                System.out.println("3.Generate Attendance Report");
                System.out.println("4.Exit");
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
                            System.out.print("Enter the Employee " + (i + 1)+ " status (Present / Absent) :- ");
                            String status = sc.nextLine();
                            new Employee(id,name,status);
                        }
                        break;
    
                    case 2:
                        System.out.println("Choice 2 :- ");
                        Employee.printEmployees();
                        break;
    
                    case 3:
                        System.out.println("Choice 3 :- ");
                        System.out.println(Employee.generateAttendanceReport(Employee.AttendanceList));
                        break;
    
                    case 4:
                        System.out.println("Exit...");
                        break;
    
                    default:
                        System.out.println("Enter a valid option listed from the list above...");
                        break;
    
                }
    
            }while (val != 4);
    
    
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Enter a valid option listed from the list above...");
        }

      
        sc.close();

    }
}  