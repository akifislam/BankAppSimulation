// Name : Akif Islam
// Roll : 19107761-35

import java.util.Scanner;
public class CurrentAccount extends Account {
	
	double InitialBalance ;
	Scanner input = new Scanner(System.in);
	
	// Constructor
	CurrentAccount() {
		Balance = 0; // Before Creating Account
		TransactionCount = 0; 
	}

	

    // Implemented Abstract Methods

    float interestRate() {
        float rate = 0.045F;
        return rate;
    }


    void calculateBalance() {
        double yy = ChangeYear();
        Balance = Balance + (Balance * yy * interestRate());
        System.out.printf("Your Balance with 4.50%% interest after %.1f year will be %.2f TK\n",yy,Balance);
    }




}