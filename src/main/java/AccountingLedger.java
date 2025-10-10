import java.util.Objects;
import java.util.Scanner;

public class AccountingLedger {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        String menuSelection;

        do {

            System.out.print("""
                    
                    ------------- Home Screen -------------
                    \t\
                    D) Add Deposit
                    \tP) Make Payment (Debit)
                    \tL) Ledger
                    \tX) Exit\
                    
                    Please input the character that corresponds to your selection:\s
                    """);
            menuSelection = myScanner.nextLine();

            switch (menuSelection) {
                case "D" -> System.out.println("Adding deposit!");
//                case "P" -> makePayment;
//                case "L" -> displayLedger;
                case "X" -> System.out.println("Thanks for using my application!");

                default -> System.err.println("Invalid input! Please input a valid character.");
            }
        } while (!Objects.equals(menuSelection, "X"));
    }
}
