public class CipherTest {
    
    private static final String ALGORITHM = "DES/CBC/PKCS5Padding";
    private static final String IV = "abcdefgh";
    
    public static void main(String[] args) throws Exception {
        byte[] key = "secretkey".getBytes();
        byte[] data = "somedata".getBytes();
        
        // generate predictable IV
        IvParameterSpec ivSpec = new IvParameterSpec(IV.getBytes());
        
        // initialize the cipher in encrypt mode with the predictable IV
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "DES"), ivSpec);
        
        // encrypt the data
        byte[] encryptedData = cipher.doFinal(data);
        
        // transfer money
        Account fromAccount = new Account(100);
        Account toAccount = new Account(0);
        double amount = 50;
        TransferMoney transfer = new TransferMoney(fromAccount, toAccount, amount);
        transfer.transfer();
        
        // decrypt the data using the predictable IV
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "DES"), ivSpec);
        byte[] decryptedData = cipher.doFinal(encryptedData);
        System.out.println(new String(decryptedData));
    }
}

class Account {
    private double balance;
    public Account(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void withdraw(double amount) {
        balance -= amount;
    }
    public void deposit(double amount) {
        balance += amount;
    }
}

class TransferMoney {
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
