import java.util.Calendar;

/**
 * Bank account that supports deposit, withdraw, balance inquiry,
 * and a text statement with timestamps. Invalid operations throw checked exceptions.
 * @author Mohammad,Albataineh
 * @author Sushant,Thakuri
 * @since 2025-11-04
 */
public class BankAccount {

    /** Optional account number. */
    private String accountNumber = "N/A";

    /** Current balance. */
    private double balance;

    /** Accumulates all transactions as text. */
    private final StringBuilder log = new StringBuilder();

/** Creates an account with zero balance. */
    public BankAccount()   {    
        
    this(0.0); 
    }


    /**
     * Creates an account with an initial balance (negative becomes 0).
     * @param initial initial balance
     */
    public BankAccount(double initial) {
        this.balance = Math.max(0.0, initial);
        appendLog("OPEN", initial, true);
    }

    /**
     * Deposits a positive amount.
     * @param amount amount to deposit
     * @throws Exception if amount <= 0
     */
    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            appendLog("DEPOSIT INVALID", amount, false);
            throw new Exception("Amount to deposit must be positive.");
        }
        balance += amount;
        appendLog("DEPOSIT", amount, true);
    }

    /**
     * Withdraws a positive amount not exceeding balance.
     * @param amount amount to withdraw
     * @throws Exception if amount <= 0 or amount > balance
     */
    public void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            appendLog("WITHDRAW INVALID", amount, false);
            throw new Exception("Amount to withdraw must be positive.");
        }
        if (amount > balance) {
            appendLog("WITHDRAW DECLINED (INSUFFICIENT FUNDS)", amount, false);
            throw new Exception("Insufficient funds.");
        }
        balance -= amount;
        appendLog("WITHDRAW", amount, true);
    }

    /**
     * Returns current balance.
     * @return current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns a statement of all transactions with timestamps.
     * @return statement text
     */
    public String getStatement() {
        return log.toString();
    }

    // Helper: append a timestamped line to the statement
    private void appendLog(String type, double amount, boolean applied) {
        Calendar c = Calendar.getInstance();
        String ts = String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", c);
        if (applied) {
            log.append(String.format("[%s] %s: %.2f | balance: %.2f%n",
                    ts, type, amount, balance));
        } else {
            log.append(String.format("[%s] %s: %.2f | balance unchanged: %.2f%n",
                    ts, type, amount, balance));
        }
    }
}
