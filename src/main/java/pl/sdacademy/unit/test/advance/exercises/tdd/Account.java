package pl.sdacademy.unit.test.advance.exercises.tdd;

public class Account {
    private float balance;
    private String accountNumber;
    private Customer customer;

    public Account(float balance, String accountNumber, Customer customer) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.customer = customer;
    }

    public float getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void transferMoney(Account debit, float amount) {
        if(isValidate(debit, amount)) {
            this.setBalance(this.getBalance() - amount);
            debit.setBalance(debit.getBalance() + amount);
        }
    }

    private boolean isValidate(Account debit, float amount) {
        return validateAccountNumber(this.getAccountNumber())
                && validateAccountNumber(debit.getAccountNumber())
                && validateAmount(amount);
    }

    private boolean validateAccountNumber(String accountNumber) {
        if(accountNumber.length() == 26) {
            return true;
        }
        throw new IllegalArgumentException("Account number has wrong length: " + accountNumber);
    }

    private boolean validateAmount(float amount) {
        if(this.balance >= amount && amount >= 0) {
            return true;
        }
        throw new IllegalArgumentException("Amount is less than 0 or bigger than balance");
    }
}
