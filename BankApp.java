public class BankApp{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		int choice;
		int loggedAcc=-1;
		do {
			System.out.println("BANK SYSTEM MENU");
			System.out.println("1. Create Account");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.println("Enter choice");
			choice=scan.nextInt();
			switch(choice) {
			case 1:
				scan.nextLine();
				System.out.println("Enter Name: ");
				String name=scan.nextLine();
				System.out.println("Set 4-Digit PIN: ");
				String pin=scan.next();
				System.out.print("Initial Deposit: ");
                double balance = scan.nextDouble();
                BankService.createAccount(name, pin, balance);
                break;
			case 2:
				System.out.println("Enter Account No: ");
				int accNo=scan.nextInt();
				scan.nextLine();
				System.out.println("Enter PIN: ");
				String inputPin=scan.nextLine();
				boolean success=BankService.login(accNo, inputPin);
				if(success) {
					loggedAcc=accNo;
					int subChoice;
					do {
						System.out.println("------Account Menu------");
						System.out.println("1. Deposit");
						System.out.println("2. Withdraw");
						System.out.println("3. Check Balance");
						System.out.println("4. Logout");
						System.out.println("Enter Choice: ");
						subChoice=scan.nextInt();
						switch(subChoice) {
						case 1:
							System.out.println("Enter amount to deposit: ");
							double dep=scan.nextDouble();
							BankService.deposit(loggedAcc, dep);
						    break;
						case 2:
							System.out.println("Enter amount to withdraw: ");
							double amt=scan.nextDouble();
							BankService.withdraw(loggedAcc, amt);
							break;
						case 3:
							BankService.checkBalance(loggedAcc);
							break;
						case 4:
							System.out.println("Logged out successfully.");
							break;
						default:
							System.out.println("Invalid choice");
							
					}
				}while(subChoice !=4);	
				}
				break;
			case 3:
				System.out.println("Thank you for using our bank!");
				break;
				default:
					System.out.println("Invalid option");
			}
			
			}while(choice !=3);
		scan.close();
	}

}
