public class AccountManagement {
    private static int nextId = 1;

    private int id;
    private String firstName;
    private String lastName;
    private double cashBalance;

    public AccountManagement(String firstName, String lastName, double cashBalance) {
        this.id = nextId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cashBalance = cashBalance;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getCashBalance() {
        return cashBalance;
    }

    public void addCash(double amount) {
        if (amount >= 0) {
            this.cashBalance += amount;
            System.out.println("Cash added successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdrawCash(double amount) {
        if (amount >= 0 && amount <= cashBalance) {
            this.cashBalance -= amount;
            System.out.println("Cash withdrawn successfully.");
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }
}
           