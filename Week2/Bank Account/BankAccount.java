import java.util.Random;

public class BankAccount {

    private static int numOfAccts = 0;
    private static double totalOfAllAccts = 0.0;

    private String acctNum;
    private double checkingBalance = 0;
    private double savingsBalance = 0;

    // Initialize account
    public BankAccount(){
        numOfAccts++;
        acctNum = generateAcctNumber();
    }

    // Get balances
    public double getCheckingBalance(){
        return checkingBalance;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    } 

    // Display Acct Balances
    public void displayTotalBalance(){
        System.out.printf("\nAccount Number: %s", acctNum);
        System.out.printf("\nChecking: $%s", checkingBalance);
        System.out.printf("\nSavings: $%s", savingsBalance);
        System.out.printf("\nTotal: $%s\n", (checkingBalance + savingsBalance));
    }

    // Display bank totals
    public void displayBankTotals(){
        System.out.printf("\nNumber of accounts: %s", numOfAccts);
        System.out.printf("\nTotal of all accounts: $%s\n", totalOfAllAccts);
    }

    // Deposit (true if checking acct, false if savings acct)
    public void deposit(double ammt, boolean acctChoice){
        if(acctChoice)
            checkingBalance += ammt;
        else
            savingsBalance += ammt;
        totalOfAllAccts += ammt;
    }
    // Withdraw (true if checking acct, false if savings acct)
    public void withdraw(double ammt, boolean acctChoice){
        
        if(acctChoice && ammt <= checkingBalance){
            checkingBalance -= ammt;
            totalOfAllAccts -= ammt;
        }
        else if (!acctChoice && ammt <= savingsBalance){
            savingsBalance -= ammt;
            totalOfAllAccts -= ammt;
        }
        else
            System.out.println("Account balance is insufficient for withdrawl.");
        
    }

    // Generate a random 10 digit account number
    private String generateAcctNumber(){
        Random rand = new Random();
        String acctNumString = "";
        for (int x = 0; x < 10; x++)
            acctNumString += rand.nextInt(10);
        return acctNumString;
    }
}
