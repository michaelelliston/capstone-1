import java.time.LocalDateTime;

public class Transaction implements Comparable<Transaction> {
    private LocalDateTime dateTime;
    private String description;
    private String vendor;
    private double amount;

    public Transaction(LocalDateTime dateTime, String description, String vendor, Double amount) {
        this.dateTime = dateTime;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public int getMonth() {
        String dateTime = toString();
        String[] valueDate = dateTime.split("\\|");
        String[] valueMonth = valueDate[0].split("-");
        return Integer.parseInt(valueMonth[1]);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return getDateTime() + "|" + this.description + "|" + this.vendor + "|" + this.amount;
    }

    @Override
    public int compareTo(Transaction otherTransaction) {
        return this.dateTime.compareTo(otherTransaction.getDateTime());
    }
}
