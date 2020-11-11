package kukulam.module.advancedtesting.task5;

public class AccountBalance {
    private final double balance; // used double type only for learning purposes
    private final String currency;

    public AccountBalance(double balance, String currency) {
        this.balance = balance;
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }
}
