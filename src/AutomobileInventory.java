import java.io.FileWriter;
import java.util.Scanner;
class Automobile {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    // Default constructor
    public Automobile() {
        this.make = "";
        this.model = "";
        this.color = "";
        this.year = 0;
        this.mileage = 0;
    }

    // Parameterized constructor
    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    // Add new vehicle
    public String newVehicle(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "Vehicle added successfully!";
        } catch (Exception e) {
            return "Failed to add vehicle.\nError: " + e.getMessage();
        }
    }

    // List vehicle info
    public String[] listVehicleInfo() {
        String[] info = new String[5];
        info[0] =  make;
        info[1] = model;
        info[2] = color;
        info[3] = "" + year;
        info[4] = "" + mileage;
        return info;
    }

    // Remove the vehicle
    public String removeVehicle() {
        try {
            this.make = "";
            this.model = "";
            this.color = "";
            this.year = 0;
            this.mileage = 0;
            return "Vehicle removed successfully!";
        } catch (Exception e) {
            return "Failed to remove vehicle.\nError: " + e.getMessage();
        }
    }

    // Update vehicle
    public String updateVehicle(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "Vehicle updated successfully!";
        } catch (Exception e) {
            return "Failed to update vehicle.\nError: " + e.getMessage();
        }
    }
}

// 1. Create an additional class to call your automobile class
public class AutomobileInventory {
    public static void main(String[] args) {
        // 1.1 Include a try..catch construct
        try {
            // 2 -> Call automobile class with parameterized constructor
            Automobile car1 = new Automobile("Toyota", "Corolla", "Red", 2009, 82903);

            // 2.1 -> Call the method to list the values.
            // 2.2 -> Loop through the array and print to the screen
            for (String car1Attribute : car1.listVehicleInfo()){
                System.out.println(car1Attribute);
            }

            // 3 -> Call the remove vehicle method to clear the variables
            // 3.1 -> Print the return value
            String remove_status = car1.removeVehicle();
            System.out.println(remove_status);

            // 4 -> Add a new vehicle
            Automobile car2 = new Automobile();
            String car2_status = car2.newVehicle("Chevrolet", "Silverado", "White", 2022, 8000);
            // 4.1 -> Print the return value
            System.out.println(car2_status);
            // 4.2 -> Call the list method and print the new vehicle information
            for (String car2Attribute : car2.listVehicleInfo()){
                System.out.println(car2Attribute);
            }
            // 5 -> Update the vehicle
            // 5.1 -> Print the return value
            String car2Update = car2.updateVehicle("Chevrolet", "Silverado", "Red", 2022, 18932);
            System.out.println(car2Update);
            // 5.2 -> Call the listing method and print the information to the screen
            for (String car2Attribute : car2.listVehicleInfo()){
                System.out.println(car2Attribute);
            }

            // 6 -> Display a message asking if the user wants to print the information to a file (Y/N)
            Scanner sc = new Scanner(System.in);
            System.out.print("Would you like to print the information to a file? (Y/N) >> ");

            // 6.1 -> Use a scanner to capture the response. If input (case insensitive) == "Y"...
            String userResponse = sc.nextLine();
            if (userResponse.equalsIgnoreCase("y")) {
                // 6.2 ... print the file to a predefined location
                try {
                    // This line will print the information to a file called cars.txt
                    // ... which is located at the top of the system project
                    // ...this location is OS-agnostic, unlike C:/User/X/Desktop
                    FileWriter writer = new FileWriter("./cars.txt");

                    for (String attrib : car2.listVehicleInfo()) {
                        System.out.println(attrib);
                        writer.write(attrib + "\n");
                    }
                    writer.close();
                    System.out.println("Successfully wrote information to `./cars.txt`");
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            else {
                System.out.println("File will not be printed.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}