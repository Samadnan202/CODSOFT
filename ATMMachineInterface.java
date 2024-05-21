package codeSoftIntershipTasks;
import java.util.Scanner;

class BankAccount
{
    private int balance;//30000
    
    public BankAccount(int initialAmount)//30000
    {
        this.balance = initialAmount;
    }
    public int balance()
    {
        return balance;
    }
    //Deposit Logic
    public void deposit(int amount)
    {
        if (amount > 0)
        {
            balance += amount;
            System.out.println("DEPOSIT OF " + amount + " Rs. IS SUCCESSFULL");
        } 
        else 
        {
            System.out.println("PLEASE CHOOSE A NUMBER ABOVE 0");
        }
    }
    //Withdraw Logic
    public void withdraw(int amount)
    {
        if (amount > 0 && amount <= balance)
        {
            System.out.println("WITHDRAW SUCCESSFULL OF "+amount+"Rs");
            balance = balance - amount;
        } 
        else 
        {
            System.out.println("INSUFFUCIENT BALANCE.");
        }
    }
}
class ATM
{
    private BankAccount account; 
    public ATM(BankAccount account)
    {
        this.account = account;
    }
    public void display()
    {
        System.out.println("SELECT OPTIONS");
        System.out.println("PRESS 1 TO DEPOSIT");
        System.out.println("PRESS 2 TO WITHDRAW");
        System.out.println("PRESS 3 TO CHECK BALANCE");
        System.out.println("PRESS 0 TO LEAVE");
    }
    public void run()
    {
        Scanner sc = new Scanner(System.in);
        int option;
        do
        {
            display();
            System.out.println("**********************");
            option = sc.nextInt();
            
            switch (option)
            {
                case 1:
                    System.out.println("ENTER AMOUNT TO DEPOSIT");
                    int depositAmount = sc.nextInt();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("ENTER AMOUNT TO WITHDRAW");
                    int withdrawAmount = sc.nextInt();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("CURRENT BALANCE " + account.balance());
                    break;
                case 0:
                    System.out.println("THANKS FOR WORKING WITH XYZ BANK");
                    break;
                default:
                    System.out.println("PLEASE ENTER ONLY THE GIVEN OPTIONS");   
            }
        }
        while (option != 0);
        sc.close();;
    }
}
public class ATMMachineInterface 
{
    public static void main(String[] args) 
    {
    	final int PIN2 = 2020;
        Scanner sc = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(50000);
        ATM atm = new ATM(userAccount);
       
        System.out.println("ENTER YOUR PIN");
        int pin1 = sc.nextInt();
        if (pin1 == PIN2) 
        {
            atm.run();
        } 
        else 
        {
            System.out.println("INVALID PIN");
        }
        sc.close();
    }
}