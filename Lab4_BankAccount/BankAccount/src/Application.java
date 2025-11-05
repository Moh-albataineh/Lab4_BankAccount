/**
 * Bank Account Application Tester (modified to use try/catch).
 * Runs a fixed sequence of operations and prints results.
 */
public class Application {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);

        System.out.println("New Account Balance: " + account.getBalance());

        System.out.println("Withdrawing 200");
        try {
            account.withdraw(200);
            System.out.println("New Balance: " + account.getBalance());
        } catch (Exception e) {
            System.out.println("Withdraw failed: " + e.getMessage());
        }

        System.out.println("Withdrawing -100");
        try {
            account.withdraw(-100);
            System.out.println("New Balance: " + account.getBalance());
        } catch (Exception e) {
            System.out.println("Withdraw failed: " + e.getMessage());
        }

        System.out.println("Depositing -100");
        try {
            account.deposit(-100);
            System.out.println("New Balance: " + account.getBalance());
        } catch (Exception e) {
            System.out.println("Deposit failed: " + e.getMessage());
        }

        System.out.println("Depositing 1000");
        try {
            account.deposit(1000);
            System.out.println("New Balance: " + account.getBalance());
        } catch (Exception e) {
            System.out.println("Deposit failed: " + e.getMessage());
        }

        System.out.println("Withdrawing 200");
        try {
            account.withdraw(200);
            System.out.println("New Balance: " + account.getBalance());
        } catch (Exception e) {
            System.out.println("Withdraw failed: " + e.getMessage());
        }

        System.out.println("*************************************");
        System.out.println(account.getStatement());
    }
}
