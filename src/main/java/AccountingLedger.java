import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class AccountingLedger {
    static Scanner myScanner = new Scanner(System.in);
    static String menuSelection = "";
    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");
    static String formattedDate = "";
    static String line;
    static ArrayList<String> transactions = new ArrayList<String>(); // Used later to store all transaction objects

    public static void main(String[] args) {
        displayHomeMenu();
    }

    public static void displayHomeMenu() {

        // Beginning of do-while loop, should always loop back to Home Screen unless user inputs X to exit
        do {
            System.out.print("""
                   \s
                    ------------- Home Screen -------------
                    \tD) Add Deposit
                    \tP) Make Payment (Debit)
                    \tL) Ledger
                    \tX) Exit
                   
                    Please input the character that corresponds to your selection:\s""");
            menuSelection = myScanner.nextLine();

            switch (menuSelection) { // Redirects user to requested menu or tool
                case "D", "d" -> addDeposit();
                case "P", "p" -> makePayment();
                case "L", "l" -> displayLedger();
                case "X", "x" -> System.out.println("Thanks for using my application!");
                default ->
                        System.err.println("Invalid input! Please input a valid character."); // Prints an error message if input is invalid
            }
        } while (!menuSelection.equalsIgnoreCase("x"));
    }

    public static void displayLedger() {

        do {
            System.out.print("""
                    
                    ------------- Ledger -------------
                    \tA) All
                    \tD) Deposits
                    \tP) Payments
                    \tR) Reports
                    \tH) Return Home
                    
                    Please input the character that corresponds to your selection:\s""");
            menuSelection = myScanner.nextLine();

            switch (menuSelection) {
                case "A", "a" -> displayAll();
                case "D", "d" -> displayDeposits();
//                case "P", "p" -> displayPayments();
//                case "R", "r" -> reportsMenu();
                case "H", "h" -> {
                }
                default -> System.err.println("Invalid input! Please input a valid character.");
            }
        } while (!menuSelection.equalsIgnoreCase("h"));
    }

    public static void addDeposit() {
        // Try with resources, so the FileWriter is closed after use. Append set to true.
        try (FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true)) {
            System.out.print("Please input your name or organization: ");
            String userName = myScanner.nextLine();
            System.out.print("Next, please input the amount you wish to deposit: ");
            String depositAmount = myScanner.nextLine();
            System.out.print("Finally, please input a small description of your deposit: ");
            String depositDescription = myScanner.nextLine();

            formattedDate = LocalDateTime.now().format(dateTimeFormatter);

            fileWriter.write("\n" + formattedDate + "|" + depositDescription + "|" + userName + "|" + depositAmount);

            System.out.println("Thank you! Your deposit has been recorded.");

        } catch (java.io.IOException e) {
            System.err.println("An error occurred: " + e);
        }
    }

    public static void makePayment() {
        try (FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true)) {
            System.out.print("Please input your name or organization: ");
            String userName = myScanner.nextLine();
            System.out.print("Next, please input the cost of your payment: ");
            String paymentAmount = myScanner.nextLine();
            System.out.print("Finally, please input what your payment is for: ");
            String paymentDescription = myScanner.nextLine();

            formattedDate = LocalDateTime.now().format(dateTimeFormatter);

            fileWriter.write("\n" + formattedDate + "|" + paymentDescription + "|" + userName + "|-" + paymentAmount);

            System.out.println("Thank you! Your payment has been recorded.");

        } catch (java.io.IOException e) {
            System.err.println("An error occurred: " + e);
        }
    }
//  IMPORTANT: Needs to display in order from newest to oldest, still incomplete
    public static void displayAll() {
        System.out.println();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/transactions.csv"))) {
            do {
                line = bufferedReader.readLine();
                if (line != null) {
                    System.out.println(line);
                }
            } while (line != null);

            System.out.println("\nInput any key to continue");
            myScanner.nextLine();

        } catch (FileNotFoundException e) {
            System.err.println("Error! File not found: " + e);
        } catch (IOException e) {
            System.err.println("Error! An IO Error occurred: " + e);
        }
    }

    public static void displayDeposits() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/transactions.csv"))) {

            bufferedReader.readLine(); // Reads the header so it isn't printed

            String input;
            while ((input = bufferedReader.readLine()) != null) {

            }
        } catch (FileNotFoundException e) {
            System.err.println("Error! File not found: " + e);
        } catch (IOException e) {
            System.err.println("Error! An IO Error occurred: " + e);
        }
    }
}
