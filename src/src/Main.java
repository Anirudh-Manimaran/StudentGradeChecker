
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        Student student = new Student(studentName);
        boolean cycle = true;
        while (cycle) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Add class");
            System.out.println("2. Add assignment to class");
            System.out.println("3. Edit assignment grade");
            System.out.println("4. Remove assignment");
            System.out.println("5. Increment absences");
            System.out.println("6. Display student info");
            System.out.println("7. Display all classes and assignments");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }catch(Exception e){
                System.out.println("Enter a valid input (number)");
                continue;
            }

            if (choice == 1) {
                System.out.print("Class name: ");
                String className = scanner.nextLine();
                System.out.print("Class description: ");
                String description = scanner.nextLine();
                student.addClass(new Class(className, description));
                System.out.println("Class added.");
            } else if (choice == 2) {
                System.out.print("Class name: ");
                String className = scanner.nextLine();
                Class c = student.getClassByName(className);
                if (c == null) {
                    System.out.println("Class not found");
                    continue;
                }
                System.out.print("Assignment name: ");
                String assignment = scanner.nextLine();
                System.out.print("Grade: ");
                double grade = Double.parseDouble(scanner.nextLine());
                System.out.print("Weight: ");
                double weight = Double.parseDouble(scanner.nextLine());
                c.addAssignment(assignment, new Double[]{grade, weight});
                System.out.println("Assignment added.");
            } else if (choice == 3) {
                System.out.print("Class name: ");
                String className = scanner.nextLine();
                Class c = student.getClassByName(className);
                if (c == null) {
                    System.out.println("Class not found");
                    continue;
                }
                System.out.print("Assignment name: ");
                String assignment = scanner.nextLine();
                System.out.print("New grade: ");
                double grade = Double.parseDouble(scanner.nextLine());
                System.out.print("New weight: ");
                double weight = Double.parseDouble(scanner.nextLine());
                c.editAssignment(assignment, new Double[]{grade, weight});
                System.out.println("Assignment updated");
            } else if (choice == 4) {
                System.out.print("Class name: ");
                String className = scanner.nextLine();
                Class c = student.getClassByName(className);
                if (c == null) {
                    System.out.println("Class not found");
                    continue;
                }
                System.out.print("Assignment name: ");
                String assignment = scanner.nextLine();
                c.removeAssignment(assignment);
                System.out.println("Assignment removed");
            } else if (choice == 5) {
                student.incrementAbsence();
                System.out.println("Absence incremented");
            } else if (choice == 6) {
                System.out.println(student);
            } else if (choice == 7) {
                for (Class c : student.getClasses().values()) {
                    System.out.println(c);
                    System.out.println(c.viewAssignments());
                    System.out.println("Total Grade: " + c.totalGrade());
                }
            } else if (choice == 8) {
                System.out.println("Exiting");
                cycle = false;

            } else {
                System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
}