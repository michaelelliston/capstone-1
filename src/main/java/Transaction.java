public class Transaction {
    private String dateTime;
    private String description;
    private String vendor;
    private double amount;

    public Transaction(String dateTime, String description, String vendor, Double amount) {
        this.dateTime = dateTime;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public String getDateTime() {
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
        return this.dateTime + "|" + this.description + "|" + this.vendor + "|" + this.amount;
    }
}
