package pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource;

public class Account {
    private double saldo;
    private String accountNumber;

    @Override
    public String toString() {
        return "Account{" +
                "saldo=" + saldo +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }

    public Account(double saldo, String accountNumber) {
        this.saldo = saldo;
        this.accountNumber = accountNumber;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
