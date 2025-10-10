import java.util.Objects;
import java.util.Scanner;

public class AccountingLedger {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        String menuSelection;

        do {

            System.out.print("------------- Home Screen -------------\n\tD) Add Deposit\n\tP) Make Payment (Debit)\n\tL) Ledger\n\tX) Exit\nPlease input the character that corresponds to your selection: ");
            menuSelection = myScanner.nextLine();

        } while (!Objects.equals(menuSelection, "X"));
    }
}
