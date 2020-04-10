// Name : Akif Islam
// Roll : 19107761-35

import java.util.Scanner;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;


public abstract class Account {
    String AccountName;
    int AccountNumber;
    String Address;
    String PhoneNumber;
    double Balance;
    int TransactionCount=0;
    String TransactionHistory[] = new String[100];
    int i=0;
    
	Scanner input = new Scanner(System.in);


    abstract float interestRate();

    abstract void calculateBalance();

    
    void setAccountName() {
        System.out.println("Enter Your Account Name : ");
        AccountName = input.nextLine();
    }

    
    void setAddress() {
        System.out.println("Enter Your Address : ");
        Address = input.nextLine();

    }

    
    void setPhoneNumber() {
        System.out.println("Please Enter Your Phone No : ");
        PhoneNumber = input.nextLine();
    }

    
    void AutoGeneratedAccountNo() {
        Random rand = new Random();
        int number = 70002551 + rand.nextInt(25102899);
        AccountNumber = number;
        System.out.println("Your Account Number is : " + number );
     }

    
    void setInitalAmount(double limit)  {
        
        System.out.println("Initial Value : ");
        Balance = input.nextFloat();
        
        while(Balance<limit) {
            System.out.printf("To create a account, Minimum %.2f Tk is required as inital value\n",limit);
            System.out.println("Enter a valid input");
            Balance = input.nextFloat();
        }
    }

    
    void WithDraw(int TransactionLimit) {
        if(TransactionCount<TransactionLimit) {
            TransactionCount++;
            System.out.println("Enter Amount to WithDraw");
            double amount = input.nextDouble();

            while (amount < 0 || (Balance-amount)<0.00) {
                System.out.println("Invalid Input ! Input is negative or You may try to withdraw more than you have");
                System.out.println("Enter a valid ammount !");
                amount = input.nextDouble();
            }

            Balance = Balance - amount;

            Date thistime = new Date();
            SimpleDateFormat printformat = new SimpleDateFormat("HH : mm : ss");
            String str = "Withdrawed : " + amount + " TK | Balance : " + Balance + " TK | Time :  " + printformat.format(thistime);
            TransactionHistory[i] = str;
            i++;

        }
        
        else System.out.println("Your Daily Transaction Limit Reached ! Please Come Another Day :) ");

    }

    
    void Deposite(int TransactionLimit) {
        
        if(TransactionCount<TransactionLimit) {
            TransactionCount++;
            System.out.println("Enter Amount to Deposite");
            double amount = input.nextDouble();

            while (amount < 0) {
                System.out.println("Invalid Input ! Enter a valid amount.");
                amount = input.nextDouble();
            }


            Balance = Balance + amount;
            Date thistime = new Date();
            SimpleDateFormat printformat = new SimpleDateFormat("HH : mm : ss");
            String str = "Deposited : " + amount + " TK | Balance : " + Balance + " TK | Time :  " + printformat.format(thistime);
            

            TransactionHistory[i] = str;
            i++;

        }
        
        else System.out.println("Your Daily Transaction Limit Reached ! Please Come Another Day :) ");

    }


    void showBalance() {
        System.out.printf("*** Your Current Balance is %.2f TK *** ",Balance);
    }


    void ShowTransactionHistory() {
        
        if(i==0) System.out.println("You haven't made any transaction yet !");

	    else {
	        for(int p=0;p<i;p++) {
	            System.out.println(TransactionHistory[p]);
	        }
	    }

    }

	
	void showAccountInformation() {
        System.out.println();
        System.out.println("Account Name : " + AccountName);
        System.out.println("Account No : " + AccountNumber);
        System.out.println("Address : " + Address);
        System.out.println("Contact No : " + PhoneNumber);
        System.out.printf("Account Balance : %.2f BDT",Balance);
        System.out.println();
    }


    void ClearScreen() {

        try 
        {
        	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        } catch (Exception E) 
	        {
	        	System.out.println(E);
	        }
	        
	}

    double ChangeYear() {
        System.out.println("How Many Years Do You Want to Skip?");
        double y = input.nextDouble();
        TransactionCount = 0;

        String str = y + " years have been skipped (Interest Added) !";
        TransactionHistory[i] = str;
        i++;


        return y;
    }

    void NextDay() {
        TransactionCount = 0;
    }

}
