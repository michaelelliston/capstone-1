import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;
import java.time.LocalDateTime;

public class AccountingLedger {
    static Scanner myScanner = new Scanner(System.in);
    static String menuSelection = "";
    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");
    static String formattedDate = "";


    public static void main(String[] args) {
        displayHomeMenu();
    }

    public static void displayHomeMenu() {

        // Beginning of do-while loop, should always loop back to Home Screen unless user inputs X to exit
        do {
            System.out.print("""
                    
                    ------------- Home Screen -------------
                    \tD) Add Deposit
                    \tP) Make Payment (Debit)
                    \tL) Ledger
                    \tX) Exit\
                    
                    Please input the character that corresponds to your selection:
                    """);
            menuSelection = myScanner.nextLine();

            switch (menuSelection) { // Redirects user to requested menu or tool
                case "D" -> addDeposit();
                case "P" -> makePayment();
                case "L" -> displayLedger();
                case "X" -> System.out.println("Thanks for using my application!");
                default ->
                        System.err.println("Invalid input! Please input a valid character."); // Prints an error message if input is invalid
            }
        } while (!Objects.equals(menuSelection, "X"));
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
                    
                    Please input the character that corresponds to your selection:
                    """);
            menuSelection = myScanner.nextLine();

            switch (menuSelection) {
//            case "A" -> displayAll();
//            case "D" -> displayDeposits();
//            case "P" -> displayPayments();
//            case "R" -> reportsMenu();
                case "H" -> {
                }
                default -> System.err.println("Invalid input! Please input a valid character.");
            }
        } while (!Objects.equals(menuSelection, "H"));
    }

    public static void addDeposit() {
        try (FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true)) { // Try with resources; closes FileWriter when done.
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
        try (FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true)) { // Try with resources; closes FileWriter when done.
            System.out.print("Please input your name or organization: ");
            String userName = myScanner.nextLine();
            System.out.print("Next, please input the cost of your payment: ");
            String paymentAmount = myScanner.nextLine();
            System.out.print("Finally, please input what your payment is for: ");
            String paymentDescription = myScanner.nextLine();

            formattedDate = LocalDateTime.now().format(dateTimeFormatter);

            fileWriter.write("\n" + formattedDate + "|" + paymentDescription + "|" + userName + "|-" + paymentAmount);
        } catch (java.io.IOException e) {
            System.err.println("An error occurred: " + e);
        }
    }
}
