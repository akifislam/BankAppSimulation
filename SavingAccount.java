// Name : Akif Islam
// Roll : 19107761-35


import java.util.Scanner;
import java.text.SimpleDateFormat; 
import java.util.Date;

public class SavingAccount extends Account {

	
	// Constructor
	
	SavingAccount() {
		Balance = 0; // Before Creating Account
		TransactionCount = 0; 
	}

	
    
    double InitialBalance;
    double RemainingWithDrawLimit = 120000;
    Scanner input = new Scanner(System.in);

	
    // Implemented Abstruct Methods

    float interestRate() {
        float rate = 0.0275F;
        return rate;
    }

    void calculateBalance() {
        double yy = ChangeYear();
        Balance = Balance + (Balance * yy * interestRate());
        System.out.printf("Your Balance with 2.75%% interest after %.1f year will be %.2f TK\n",yy,Balance);
    }

    // Method Override to set different conditions

    void WithDraw(int TransactionLimit) {

        if (TransactionCount < TransactionLimit && RemainingWithDrawLimit > 0) {

            System.out.println("Enter Amount to WithDraw");
            double amount = input.nextDouble();

     		TransactionCount++;

            while (amount>RemainingWithDrawLimit) {
                System.out.println("You cannot withdraw more than 120000 in a day || Remaining Limit for today : " + RemainingWithDrawLimit);
                System.out.println("Enter a valid ammount !");
                amount = input.nextDouble();
            }

            while (amount < 0) {
                System.out.println("Invalid Input ! Please give a positive Value");
                System.out.println("Enter a valid ammount !");
                amount = input.nextDouble();
            }

            while (amount > 50000) {
                System.out.println(" Invalid Input ! You cannot withdraw more than 50000 per transaction");
                System.out.println("Enter a valid ammount !");
                amount = input.nextDouble();
            }
            
            while ((Balance - amount) < 500) {
                System.out.println("Inavlid Input ! You must have to keep at least 500TK in your account");
                System.out.println("Enter a valid ammount !");
                amount = input.nextDouble();
            }


            RemainingWithDrawLimit = RemainingWithDrawLimit - amount;
            Balance = Balance - amount;

            // Saving in Transaction History with Time
            Date thistime = new Date();
            SimpleDateFormat printformat = new SimpleDateFormat("HH : mm : ss");
            String str = "Withdrawed : " + amount + " TK | Balance : " + Balance + " TK | Time :  " + printformat.format(thistime);
            TransactionHistory[i] = str;
            i++;

        }
        else System.out.println("Your Daily Transaction Limit Reached ! Try another day :) ");
    }

    // Method Overide 
    double ChangeYear() {
        System.out.println("How Many Years Do You Want to Skip?");
        double y = input.nextDouble();
        TransactionCount = 0;
        RemainingWithDrawLimit = 120000;

        String str = y + " years have been skipped (Interest Added) !";
        TransactionHistory[i] = str;
        i++;
        return y;
    }

    // Method Overide
    void NextDay() {
        TransactionCount = 0;
        RemainingWithDrawLimit = 120000;
    }

}





