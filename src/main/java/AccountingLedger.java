import java.io.*;
import java.time.LocalDate;
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
    static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        // Try with resources, so the reader is closed after being used.
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/transactions.csv"))) {

            bufferedReader.readLine(); // Reads the header so it isn't added to ArrayList

            while ((line = bufferedReader.readLine()) != null) { // Adds each readable line to an Array List, and converts into Transaction
                addTransaction(line); // Splits line into appropriate data types for the Transaction object, then adds object to ArrayList
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error! File not found: " + e);
        } catch (IOException e) {
            System.err.println("Error! An IO Error occurred: " + e);
        }
        displayHomeMenu();  // Launches into the first menu of the application
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

            System.out.println(); // Prints blank line for better readability

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

            System.out.println();

            switch (menuSelection) {
                case "A", "a" -> displayAll();
                case "D", "d" -> displayDeposits();
                case "P", "p" -> displayPayments();
                case "R", "r" -> reportsMenu();
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
            line = formattedDate + "|" + depositDescription + "|" + userName + "|" + depositAmount;
            addTransaction(line);

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
            line = formattedDate + "|" + paymentDescription + "|" + userName + "|-" + paymentAmount;
            addTransaction(line);

            System.out.println("Thank you! Your payment has been recorded.");

        } catch (java.io.IOException e) {
            System.err.println("An error occurred: " + e);
        }
    }

    public static void displayAll() {
        System.out.println();

        for (int i = transactions.size() - 1; i >= 0; i--) { // Goes through each line from bottom to top and prints them
            System.out.println(transactions.get(i));
        }

        System.out.print("\nInput any key to continue: ");
        myScanner.nextLine();

    }

    public static void displayDeposits() {

        for (int i = transactions.size() - 1; i >= 0; i--) {
            if (transactions.get(i).getAmount() > 0) {
                System.out.println(transactions.get(i));
            }
        }
        System.out.print("\nInput any key to continue: ");
        myScanner.nextLine();
    }

    public static void displayPayments() {
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                System.out.println(transaction);
            }
        }
        System.out.print("\nInput any key to continue: ");
        myScanner.nextLine();
    }

    public static void reportsMenu() {
        int reportMenuSelection;

        do {
            System.out.print("""
                    
                    ------------- Reports -------------
                    \t1) Month To Date
                    \t2) Previous Month
                    \t3) Year To Date
                    \t4) Previous Year
                    \t5) Search by Vendor
                    \t0) Back
                    
                    Please input the number that corresponds to your selection:\s""");

            reportMenuSelection = Integer.parseInt(myScanner.nextLine());

            System.out.println();

            switch (reportMenuSelection) {
                case 1 -> monthToDate();
//                case 2 -> previousMonth();
//                case 3 -> yearToDate();
//                case 4 -> previousYear();
//                case 5 -> searchByVendor();
                case 0 -> {
                }
                default -> System.err.println("Invalid input! Please input a valid number.");
            }
        } while (reportMenuSelection != 0);
    }

    public static void monthToDate() {
        LocalDate today = LocalDate.now();

        for (int i = transactions.size() - 1; i >= 0; i--) {
            }
        System.out.print("\nInput any key to continue: ");
        myScanner.nextLine();
    }

    public static void addTransaction(String line) {  // Creates Transaction objects
        String[] values = line.split("\\|");
        String dateTime = values[0] + "|" + values[1];
        String description = values[2];
        String vendor = values[3];
        double amount = Double.parseDouble(values[4]);
        Transaction transaction = new Transaction(dateTime, description, vendor, amount);
        transactions.add(transaction);
    }

    public static void displayTransactions(Integer i) {
        System.out.printf(transactions.get(i).getDateTime()
                + "|" + transactions.get(i).getDescription()
                + "|" + transactions.get(i).getVendor()
                + "|%,.2f\n", transactions.get(i).getAmount());
    }
}
