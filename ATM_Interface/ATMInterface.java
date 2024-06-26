import java.util.*;
class Bank{
    int balance = 0;

    public int CheckBalance(){
        return balance;
    }

    public void deposit(int amount){
        balance += amount;
    }

    public void withDraw(int amount){
        balance -= amount;
    }
}

public class ATMInterface{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Object of Bank Class to access its methods
        Bank b = new Bank();

        int next = 4;

        while(next == 4){
            //Main Menu
            System.out.println("Choose an Option: ");
            System.out.println("1) Deposit");
            System.out.println("2) WithDraw");
            System.out.println("3) Check current balance");
    
            int option = sc.nextInt();
            
            //Deposit Process
            if(option == 1){
                System.out.println("Enter the deposit amount:");
                int amount = sc.nextInt();
    
                if(amount < 0){
                    System.out.println("Amount can't be Negative. Transaction Failed.");
                    sc.close();
                    return;
                }
    
                b.deposit(amount);
                System.out.println("Amount Deposited Successfully!");
            }

            //Withdrawl Process
            else if(option == 2){
                System.out.println("Enter the amount to Withdraw:");
                int amount = sc.nextInt();
    
                int bal = b.CheckBalance();
    
                if(bal < amount){
                    System.out.println("Transaction Failed due to insufficient balance for withdrawls.");
                    System.out.println();
                    System.out.println("Your balance " + bal + " is less than the withdrawl amount of " + amount);
                    System.out.println();
                    sc.close();
                    return;
                }
    
                b.withDraw(amount);
                System.out.println("Amount Withdrawed Successfully!");
            }

            //Balance checking Process
            else if(option == 3){
                System.out.println("Your current balance is " + b.CheckBalance());
            }

            //Invalid option Processing
            else{
                System.out.println("Transaction Failed due to Invalid option");
                sc.close();
                return;
            }
            
            //Determining to continue transaction
            System.out.println();
            System.out.println("i.  Enter 4 to go to the Main Menu of transaction");
            System.out.println("ii. Enter 5 to close transaction");
            next = sc.nextInt();
            
            //Transaction Continues.....
            if(next == 4){
                System.out.println();
                System.out.println("---------------------------------------------------------");
                continue;
            } 

            //End of Transaction
            else if(next == 5) break;
        }
        sc.close();
    }
}