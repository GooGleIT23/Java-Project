import java.io.IOException;
import java.util.Scanner;

/**
 * -The RewardsMember class shows the user the Perks and Miles required for each tier
 * -Each tier represent the miles a passenger needs to belong to the tier, and the perks (as a descriptive string) of 
 * belonging to the tier.
 * @author joshua
 *
 */
public class RewardsProgram {
	
	/**
	 * -The main method in the Rewards Program calls the RewardsMember class to show the member specific account information
	 * -The user has different options in this main method through the call of the Rewards Member class.
	 * -Switch statements are used to display each case of query number.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		System.out.println(" WELCOME TO THE SKYTRAVEL ELITE REWARDS PROGRAM! ");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		Scanner scnr = new Scanner(System.in);
		int num = 0;
		int num1 = 0;

		System.out.println("Do you want to view the Rewards Program or your Rewards Member Account?");
		System.out.println("Enter 1 to view the Rewards Program");
		System.out.println("Enter 2 to view your Rewards Member Account");
		System.out.println("Enter 0 to exit");
		num = scnr.nextInt(); //user Input
		if (num == 2) {
			RewardsMember.main(String[].class);
			System.exit(0);

		} else if (num == 0) {
			System.out.println("You have exited the program. Thank you.");
			System.exit(0);
		}

		print();
		while (num1 != 6) {
			System.out.println("Please enter any tier from 1-5 to find out about our SKYTRAVEL ELITE Rewards Program and special perks for each tier.");
			System.out.print("Enter 6 to exit the program. ");
			num1 = scnr.nextInt();
			switch (num1) {
			case 1:
				System.out.println("To be eligible for Gold status, you need to earn 25,000 miles during the calender year.");
				System.out.println("Gold passengers get special perks such as a seat to sit in during the flight.\n");
				break;

			case 2:
				System.out.println("To be eligible for Platinum status, you need to earn 50,000 miles during the calender year.");
				System.out.println("Platinum passengers get special perks such as complementary upgrades to padded seats.\n");
				break;

			case 3:
				System.out.println("To be eligible for Platinum Pro status, you need to earn 75,000 miles during the calender year.");
				System.out.println("Platinum Pro is a special sub-tier of Platinum, in which the padded seats include arm rests.\n");
				break;

			case 4:
				System.out.println("To be eligible for Executive Platinum status, you need to earn 100,000 miles during the calender year.");
				System.out.println("Executive Platinum passengers enjoy perks such as complementary upgrades from the cargo hold to main cabin.\n");
				break;

			case 5:
				System.out.println("To be eligible for Super Executive Platinum status, you need to earn 150,000 miles during the calender year.");
				System.out.println("Super Executive Platinum is the highest public elite status tier, and for our most loyal passengers can have a copilot's seat and other special perks during the flight. \n");
				break;

			case 6:
				System.out.println("You have exited the program.\n");
				break;
			}
		}
		int num2 = 0;
		System.out.println("Enter 1 if you would like to view your Rewards Member Account");
		System.out.println("Enter 0 to exit the program");
		num2 = scnr.nextInt();
		if (num2 == 1) {
			RewardsMember.main(String[].class);
			System.exit(0);
		}
		if (num2 == 0) {
			System.out.println("You have exited the program. Thank you");
			System.exit(0);
		}
	}
/**
 * User will have a query to enter number from 1-5 to view each tier and their perks information. When user enter 6 the program exits.
 */
	public static void print() {
		System.out.print("\n");
		System.out.println("1: Gold Status - 25,000 miles");
		System.out.println("2: Platinum Status - 50,000 miles");
		System.out.println("3: Platinum Pro Status - 75,000 miles");
		System.out.println("4: Executive Status - 100,000 miles");
		System.out.println("5: Super Executive Status - 150,000 miles");
		System.out.println("NOTE: Miles are valid for a calender year beggining from January 1, and end on December 1.\n");
	}
}
