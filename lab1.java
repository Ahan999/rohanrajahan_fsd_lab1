import java.util.Random;
import java.util.Scanner;

class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

class CredentialService {
    private Employee employee;

    public CredentialService(Employee employee) {
        this.employee = employee;
    }

    public String generatePassword() {
        int passwordLength = 8;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < passwordLength; i++) {
            int index = random.nextInt(chars.length());
            password.append(chars.charAt(index));
        }

        return password.toString();
    }

    public String generateEmailAddress() {
        String department = getDepartment();
        String email = employee.getFirstName().toLowerCase() + employee.getLastName().toLowerCase() +
                "@" + department + ".company.com";
        return email;
    }

    public String getDepartment() {
        // Prompt the user to enter the department or implement logic to determine it automatically
        // For simplicity, we'll assume manual input in this example
        System.out.print("Enter the department of the new employee: ");
        Scanner scanner = new Scanner(System.in);
        String department = scanner.nextLine();
        return department;
    }

    public void showCredentials() {
        String password = generatePassword();
        String email = generateEmailAddress();

        System.out.println("Generated Credentials:");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first name of the new employee: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter the last name of the new employee: ");
        String lastName = scanner.nextLine();

        Employee employee = new Employee(firstName, lastName);
        CredentialService credentialService = new CredentialService(employee);
        credentialService.showCredentials();

        scanner.close();
    }
}
