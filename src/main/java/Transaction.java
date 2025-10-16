import java.time.LocalDateTime;

public class Transaction implements Comparable<Transaction> {
    private final LocalDateTime dateTime;
    private final String description;
    private final String vendor;
    private final double amount;

    public Transaction(LocalDateTime dateTime, String description, String vendor, Double amount) {
        this.dateTime = dateTime;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    /**
     * Splits a LocalDateTime value
     *
     * @return the LocalDateTime's month value as an integer
     */
    public int getMonth() {
        String dateTime = toString();
        String[] valueDate = dateTime.split("\\|");
        String[] valueMonth = valueDate[0].split("-");
        return Integer.parseInt(valueMonth[1]);
    }

    /**
     * Splits a LocalDateTime value
     *
     * @return the LocalDateTime's year value as an integer
     */
    public int getYear() {
        String dateTime = toString();
        String[] valueDate = dateTime.split("\\|");
        String[] valueYear = valueDate[0].split("-");
        return Integer.parseInt(valueYear[0]);
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

    /**
     * @param otherTransaction is compared with another transaction's LocalDateTime
     * @return the order to sort them by LocalDateTime
     */
    @Override
    public int compareTo(Transaction otherTransaction) {
        return this.dateTime.compareTo(otherTransaction.getDateTime());
    }
}
