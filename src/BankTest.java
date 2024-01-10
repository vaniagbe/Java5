import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void testAccountCreation() {
        Bank bank = new Bank();
        BankAccount account = bank.createAccount("John Doe", 1000.0);

        assertNotNull(account);
        assertEquals("John Doe", account.getAccountName());
        assertEquals(1000.0, account.getBalance(), 0.001);
    }

    @Test
    void testNegativeDeposit() {
        Bank bank = new Bank();
        BankAccount account = bank.createAccount("Jane Doe", 500.0);

        assertThrows(NegativeAmountException.class, () -> account.deposit(-100.0));
    }

    @Test
    void testInsufficientFunds() {
        Bank bank = new Bank();
        BankAccount account = bank.createAccount("Bob", 200.0);

        assertThrows(InsufficientFundsException.class, () -> account.withdraw(300.0));
    }

    // Add more test cases to cover other scenarios
}
