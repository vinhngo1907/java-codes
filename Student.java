import java.util.Scanner;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private double mark;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, double mark) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mark = mark;
    }

    public void scanInfo() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter ID: ");
            this.id = scanner.nextInt();

            System.out.println("Enter first name: ");
            this.firstName = scanner.nextLine();

            System.out.println("Enter last name: ");
            this.lastName = scanner.nextLine();

            System.out.println("Enter mark: ");
            this.mark = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("An error occurred while reading input: " + e.getMessage());
        } finally {
            scanner.close(); // Close the scanner in the finally block to ensure it's always closed
        }
    }

    public void printInfo() {
        System.out.println("%3d|%10s%10s|%5f\n", getId(), getFirstName(), getLastName(), getMark());
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getMark() {
        return mark;
    }
}
