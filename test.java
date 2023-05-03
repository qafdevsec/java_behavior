public class TransferMoney {
    private Account fromAccount;
    private Account toAccount;
    private double amount;

    public TransferMoney(Account fromAccount, Account toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    public void transfer() {
        if (fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        } else {
            throw new IllegalArgumentException("Insufficient balance in the from account.");
        }
    }
}