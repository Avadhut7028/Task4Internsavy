import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRUDApplication {
    static List<String> data = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("CRUD Application");
            System.out.println("----------------");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createData(scanner);
                    break;
                case 2:
                    readData();
                    break;
                case 3:
                    updateData(scanner);
                    break;
                case 4:
                    deleteData(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
                    break;
            }

            System.out.println();
        } while (choice != 5);

        scanner.close();
    }

    private static void createData(Scanner scanner) {
        System.out.print("Enter the data to create: ");
        String newData = scanner.next();
        data.add(newData);
        System.out.println("Data created successfully!");
    }

    private static void readData() {
        if (data.isEmpty()) {
            System.out.println("No data available.");
        } else {
            System.out.println("Data:");
            for (String item : data) {
                System.out.println(item);
            }
        }
    }

    private static void updateData(Scanner scanner) {
        if (data.isEmpty()) {
            System.out.println("No data available to update.");
        } else {
            System.out.print("Enter the index of the data to update (0-" + (data.size() - 1) + "): ");
            int index = scanner.nextInt();
            if (index >= 0 && index < data.size()) {
                System.out.print("Enter the new data: ");
                String updatedData = scanner.next();
                data.set(index, updatedData);
                System.out.println("Data updated successfully!");
            } else {
                System.out.println("Invalid index!");
            }
        }
    }

    private static void deleteData(Scanner scanner) {
        if (data.isEmpty()) {
            System.out.println("No data available to delete.");
        } else {
            System.out.print("Enter the index of the data to delete (0-" + (data.size() - 1) + "): ");
            int index = scanner.nextInt();
            if (index >= 0 && index < data.size()) {
                data.remove(index);
                System.out.println("Data deleted successfully!");
            } else {
                System.out.println("Invalid index!");
            }
        }
    }
}
