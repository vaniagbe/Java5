import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, BankAccount> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public BankAccount createAccount(String accountName, double initialDeposit) {
        int accountNumber = generateAccountNumber();
        BankAccount newAccount = new BankAccount(accountNumber, accountName, initialDeposit);
        accounts.put(accountNumber, newAccount);
        return newAccount;
    }

    private int generateAccountNumber() {
        // Logic to generate a unique account number
        return accounts.size() + 1;
    }

    public BankAccount findAccount(int accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found with account number: " + accountNumber);
        }
        return account;
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount) {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}
