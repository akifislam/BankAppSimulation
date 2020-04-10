// Name : Akif Islam
// Roll : 19107761-35


import java.util.Scanner;

public class BankApp {
    CurrentAccount c = new CurrentAccount();
    SavingAccount  s = new SavingAccount(); 


    void ShowWelcomeMenu() {
        System.out.println("Welcome to my BankApp ^_^ ");
        System.out.println("Please Create a Bank Account.");
        System.out.println("Press 1 to Open a Current Account");
        System.out.println("Press 2 to Open a Saving Account");
    } 


    int CheckPress() {
        Scanner input = new Scanner(System.in);
        int press = input.nextInt();
        return press;

   	}

    // Main Control Menu
    void ShowMainMenu () {
        System.out.println();
        System.out.println("-------------------------");
        System.out.println("1. Account Information");
        System.out.println("2. Current Balance");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Deposit Money");
        System.out.println("5. Clear Screen");
        System.out.println("6. Transaction History");
        System.out.println("7. Change Year / Select Year");
        System.out.println("8. Go to Tomorrow");
        System.out.println("0. Exit");
        System.out.println("-------------------------");
        System.out.println();

    } 

    
    // Organising and Running Everything

    void Action() {
        
        ShowWelcomeMenu();
        
        int p = CheckPress();
            
            if(p==1) {
                c.setAccountName();
                c.setAddress();
                c.setPhoneNumber();
                c.setInitalAmount(40000);
                c.ClearScreen();
                System.out.println("Your 'Current Account' has been created successfully !");
                c.AutoGeneratedAccountNo(); // Bank Account No.
              

                while (true) {

                    ShowMainMenu();
                    int q = CheckPress();

                    if (q == 1) {
                        c.showAccountInformation();
                    }

                    if (q == 2) {
                        c.showBalance();
                    }

                    if (q == 3) {
                        c.WithDraw(6); 
                    }

                    if (q == 4) {
                        c.Deposite(6); 
                    }

                    if (q == 5) {
                    	c.ClearScreen();
                   	}
     
                    if (q == 6) {
                        c.ShowTransactionHistory();
                    }
                    	

                    if (q == 7) {
                        c.calculateBalance();
                    }


                    if (q == 8) {
                        c.NextDay();
                        c.ClearScreen();
                    }


                    if (q == 0) //Exit 
                    	break;

                }

            }

        	if(p==2) {

	            s.setAccountName();
	            s.setAddress();
	            s.setPhoneNumber();
	            s.setInitalAmount(1000);
	            s.ClearScreen();
	            System.out.println("Your 'Saving Account' has been created successfully !");
	            s.AutoGeneratedAccountNo();


	            while (true) {
            
	                ShowMainMenu();

	                int q = CheckPress();


	                if (q == 1) {
	                    s.showAccountInformation();
	                }

	                if (q == 2) {
	                    s.showBalance();
	                }

	                if (q == 3) {
	                    s.WithDraw(3);
	                }

	                if (q == 4) {
	                    s.Deposite(3);
	                }

	                if (q == 5) {
	                    s.ClearScreen();
	                }

	                if (q == 6) {
	                    s.ShowTransactionHistory();
	                }


	                if (q == 7) {
	                    s.calculateBalance();
	                }

	                if (q == 8) {
	                    s.NextDay();
	                    s.ClearScreen();
	                }



	                if (q == 0) 
	                	break;


            }
        }

    }

}


