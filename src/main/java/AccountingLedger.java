import java.util.Objects;
import java.util.Scanner;

public class AccountingLedger {
    static Scanner myScanner = new Scanner(System.in);
    static String menuSelection = "";

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
                    
                    Please input the character that corresponds to your selection:\s
                    """);
            menuSelection = myScanner.nextLine();

            switch (menuSelection) { // Redirects user to requested menu or tool
//                case "D" -> addDeposit();
//                case "P" -> makePayment();
                case "L" -> displayLedger();
                case "X" -> System.out.println("Thanks for using my application!");
                default -> System.err.println("Invalid input! Please input a valid character."); // Prints an error message if input is invalid
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
                    
                    Please input the character that corresponds to your selection:\s
                    """);
            menuSelection = myScanner.nextLine();

            switch (menuSelection) {
//            case "A" -> displayAll();
//            case "D" -> displayDeposits();
//            case "P" -> displayPayments();
//            case "R" -> reportsMenu();
                case "H" -> {}
                default -> System.err.println("Invalid input! Please input a valid character.");
            }
        } while(!Objects.equals(menuSelection, "H"));
    }
}
