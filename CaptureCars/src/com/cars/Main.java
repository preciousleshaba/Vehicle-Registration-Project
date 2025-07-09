package com.cars;

//importing classes
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

//Main class of the Vehicle registration App
public class Main {

    public static void main(String[] args) {

        //creating a Scanner object to read user input
        Scanner input = new Scanner(System.in);

        //creating a list(Collection) to store car objects
        Collection<Car> cars = new ArrayList<Car>();

        // Displaying a welcome message at the beginning

        System.out.println("WELCOME TO THE VEHICLE REGISTRATION SYSTEM");

        //Show the main menu
        System.out.println("Please select an option from the menu:");
        System.out.println("(1) Capture vehicle details");
        System.out.println("(2) View vehicle report");
        System.out.println("(3) Exit app");

        //Read user's menu selection
        int menuOption = input.nextInt();

        //To keep running as long as the user chooses 1 or 2
        while ((menuOption == 1) || (menuOption == 2)) {


            if (menuOption == 1) {   //User chooses to capture vehicle details

                //create a new car object
                Car carObj = new Car();

                //Declaring variables to store car details
                int year;
                int mileage;
                String make;
                String model;
                String plateNumber = "";
                String vinNum;

                //Ask user to enter car details
                System.out.println("Enter car make (e.g (Toyota):");
                make = input.next();

                System.out.println("Enter car model (e.g. corolla):");
                model = input.next();

                // Get VIN number - must be exactly 17 characters
                System.out.println("Enter VIN number (17 characters):");
                vinNum = input.next();
                while (vinNum.length() != 17) {
                    System.out.println(" Invalid VIN! Please enter exactly 17 characters:");
                    vinNum = input.next();
                }

                //Ask user for license plate format
                System.out.println("Select plate number format:");
                System.out.println("(1) Old format (e.g., AASSQP)");
                System.out.println("(2) New format (e.g., AA66QQGP)");
                int plateChoice = input.nextInt();

                if (plateChoice == 1) {
                    System.out.println("Enter plate number (old format):");
                    plateNumber = input.next();
                } else if (plateChoice == 2) {
                    System.out.println("Enter plate number (new format):");
                    plateNumber = input.next();
                }

                //Ask user to enter car mileage and year
                System.out.println("Enter car mileage (e.g.55000):");
                mileage = input.nextInt();

                System.out.println("Enter manufacturing year (e.g. 2015):");
                year = input.nextInt();

                //Set the values into the car object using setter methods
                carObj.setMake(make);
                carObj.setModel(model);
                carObj.setPlateNumber(plateNumber);
                carObj.setVin(vinNum);
                carObj.setYear(year);
                carObj.setMillage(mileage);

                //Add car object to the list
                cars.add(carObj);

                System.out.println("✅ Vehicle details captured successfully!\n");

                } else if (menuOption == 2) {
                //User chooses to view all captured vehicles

                if (cars.isEmpty()) {
                    System.out.println("There are no cars captured yet.");
                } else {
                    System.out.println("*************************");
                    System.out.println("VEHICLE REPORT");
                    System.out.println("******************************");

                    for (Car carObject : cars) {
                        System.out.println("MAKE: " + carObject.getMake());
                        System.out.println("MODEL: " + carObject.getModel());
                        System.out.println("VIN: " + carObject.getVin());
                        System.out.println("PLATE NUMBER: " + carObject.getPlateNumber());
                        System.out.println("YEAR: " + carObject.getYear());
                        System.out.println("MILEAGE: " + carObject.getMillage());
                        System.out.println("-------------------------------");
                    }
                }
            }
           //Show the menu again for the next action
            System.out.println("\nPlease select another option:");
            System.out.println("(1) Capture vehicle details");
            System.out.println("(2) View vehicle report");
            System.out.println("(3) Exit app");

            menuOption = input.nextInt();
        }

        //A thank you message when a user exits


        System.out.println("Thank you, for using VEHICLE REGISTRATION App!");
        System.out.println("Drive safely and have a great day!");

    }
}
