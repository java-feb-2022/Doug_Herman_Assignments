public class BankAcctTest {
    public static void main(String[] args) {
        BankAccount acct1 = new BankAccount();
        BankAccount acct2 = new BankAccount();

        acct1.deposit(100.25, true);
        acct1.deposit(1500.75, false);
        acct2.deposit(75.25, true);
        acct2.deposit(500.45, false);
        acct2.withdraw(5000, true);

        acct1.displayTotalBalance();
        acct2.displayTotalBalance();

        acct1.displayBankTotals();
    }
}
