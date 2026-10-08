import java.util.ArrayList;
import java.util.Scanner;

class Account {

    int accountNo;
    String name;
    double balance;

    Account(int accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    void displayAccount() {
        System.out.println("Account No: " + accountNo);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
        System.out.println("----------------------");
    }

    void deposit(double amount) {

        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount.");
        }
        else if (amount > balance) {
            System.out.println("Insufficient balance.");
        }
        else {
            balance = balance - amount;
            System.out.println("Amount withdrawn successfully.");
        }
    }
}

class Bank {

    ArrayList<Account> accounts = new ArrayList<>();

    void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created successfully.");
    }

    void displayAccounts() {

        if (accounts.size() == 0) {
            System.out.println("No accounts available.");
            return;
        }

        for (Account account : accounts) {
            account.displayAccount();
        }
    }

    Account searchAccount(int accountNo) {

        for (Account account : accounts) {

            if (account.accountNo == accountNo) {
                return account;
            }
        }

        return null;
    }

    void depositMoney(int accountNo, double amount) {

        Account account = searchAccount(accountNo);

        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    void withdrawMoney(int accountNo, double amount) {

        Account account = searchAccount(accountNo);

        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    void checkBalance(int accountNo) {

        Account account = searchAccount(accountNo);

        if (account != null) {
            System.out.println("Current Balance: " + account.balance);
        } else {
            System.out.println("Account not found.");
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();

        while (true) {

            System.out.println("\n===== Banking Management System =====");

            System.out.println("1. Create Account");
            System.out.println("2. Display All Accounts");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter Account Number: ");
                int accountNo = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Initial Balance: ");
                double balance = sc.nextDouble();

                Account account =
                        new Account(accountNo, name, balance);

                bank.addAccount(account);

            }

            else if (choice == 2) {

                bank.displayAccounts();

            }

            else if (choice == 3) {

                System.out.print("Enter Account Number: ");
                int accountNo = sc.nextInt();

                System.out.print("Enter Amount: ");
                double amount = sc.nextDouble();

                bank.depositMoney(accountNo, amount);

            }

            else if (choice == 4) {

                System.out.print("Enter Account Number: ");
                int accountNo = sc.nextInt();

                System.out.print("Enter Amount: ");
                double amount = sc.nextDouble();

                bank.withdrawMoney(accountNo, amount);

            }

            else if (choice == 5) {

                System.out.print("Enter Account Number: ");
                int accountNo = sc.nextInt();

                bank.checkBalance(accountNo);

            }

            else if (choice == 6) {

                System.out.println("Thank you for using the banking system.");
                break;

            }

            else {

                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
