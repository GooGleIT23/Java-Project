import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * The Rewards Member class queries the user to enter their Member ID in order to view the following information:
 * -Miles accumulated in the current year. 
 * -Total miles accumulated since joining the rewards program. 
 * -Join date of the rewards program. As members are automatically enrolled, the join date would be the date of the first flight taken by that member.
 * -Current reward tier, based on miles accumulated from the previous year.
 * -Given a prior year, the reward tier the passenger belonged to. For example, if 2020 is entered for the year, then the tier would be based on miles accumulated in 2019.
 * @author joshua
 */

public class RewardsMember {
/**
 * -The main method lists a bunch of queries that the user can type to view their account information.
 * -The main method reads the file as per the information entered by the user.
 * -For example if user enters Member ID 101, the FileReader object will read each line to show information about:
 * Miles accumulated
 * Total miles for the current year etc.....
 * -The method has if and else statements to allow the user to view the required information.
 * -The main method also calls the rewardMiles function to show the tier the passenger belonged to.
 * @param class1
 * @throws IOException
 */
	public static void main(Class<String[]> class1) throws IOException {
		Scanner scnr = new Scanner(System.in);
		System.out.println("\nWelcome to your Rewards Member Account.");
		System.out.println("\nPlease enter your Member ID: ");
		String user = scnr.next();
		int input1 = 0;
		System.out.println("\nWelcome member " + user);
		while (input1 != 6) {
			System.out.println("Enter (1) for Miles accumulated in this year");
			System.out.println("Enter (2) for Total Miles accumulated since joining the rewards program");
			System.out.println("Enter (3) for Join Date of the Rewards Program");
			System.out.println("Enter (4) for current Reward Tier, based on miles accumulated from the previous year.");
			System.out.println("Enter (5) to know the tier you belonged to in prior years");
			System.out.println("Enter (6) to exit the program");

			input1 = scnr.nextInt();
			FileReader fr3 = new FileReader("Input.txt");
			BufferedReader br3 = new BufferedReader(fr3);
			String s3;
			String lastLine = "";
			while ((s3 = br3.readLine()) != null) {
				String[] words = s3.split(" ");
				if (words[1].equals(user)) {
					lastLine = words[0];
				}
			}
			if (input1 == 1) {
				int totalCurrentMiles = 0;
				FileReader frr = new FileReader("Input.txt");
				BufferedReader brr = new BufferedReader(frr);
				String ss;
				String year = lastLine.substring(0, 4);
				while ((ss = brr.readLine()) != null) {
					String[] words = ss.split(" ");
					if (words[0].contains(year) && (words[1].equals(user))) {
						int currentMiles = Integer.parseInt(words[2]);
						totalCurrentMiles += currentMiles;
					}
				}
				System.out.println("Miles accumulated for the current year: " + totalCurrentMiles + " miles\n");
			} 
			else if (input1 == 2) {
				FileReader fr = new FileReader("Input.txt");
				BufferedReader br = new BufferedReader(fr);
				String s;
				int totalMiles = 0;
				while ((s = br.readLine()) != null) {
					String[] words = s.split(" ");
					if (words[1].equals(user)) {
						int miles = Integer.parseInt(words[2]);
						totalMiles += miles;
					}
				}
				System.out.println("Total miles accumulated since joining the Rewards Program: " + totalMiles + " miles\n");
				
			} 
			else if (input1 == 3) {
				FileReader fr1 = new FileReader("Input.txt");
				BufferedReader br1 = new BufferedReader(fr1);
				String s1;
				String joinDate = null;
				while ((s1 = br1.readLine()) != null) {
					String[] words1 = s1.split(" ");
					if (words1[1].equals(user)) {
						joinDate = words1[0];
						break;
					}
				}
				System.out.println("Join Date: " + joinDate + "\n");
			} 
			else if (input1 == 4) {
				String year;
				int totalTierMiles = 0;
				FileReader fr0 = new FileReader("Input.txt");
				BufferedReader br0 = new BufferedReader(fr0);
				String s0;
				year = lastLine.substring(0, 4);
				int Year = Integer.parseInt(year);
				Year = Year - 1;
				String Year1 = String.valueOf(Year);
				while ((s0 = br0.readLine()) != null) {
					String[] words = s0.split(" ");
					if (words[0].contains(Year1) && (words[1].equals(user))) {
						int currentTierMiles = Integer.parseInt(words[2]);
						totalTierMiles += currentTierMiles;
					}
				}
				System.out.println("For the current tier of " + totalTierMiles + " miles: ");
				rewardMiles(totalTierMiles);
			} 
			else if (input1 == 5) {
				System.out.println("\nPlease enter a year for which you would like to see your rewards tier: ");
				int answerYear = scnr.nextInt();
				int totalPriorMiles = 0;
				answerYear = answerYear - 1;
				String answerYear1 = String.valueOf(answerYear);
				FileReader fr2 = new FileReader("Input.txt");
				BufferedReader br2 = new BufferedReader(fr2);
				String s2;
				while ((s2 = br2.readLine()) != null) {
					String[] words2 = s2.split(" ");
					if (words2[0].contains(answerYear1) && words2[1].equals(user)) {
						int priorMiles = Integer.parseInt(words2[2]);
						totalPriorMiles += priorMiles;
					}
				}
				System.out.println("For the prior tier of " + totalPriorMiles + " miles: ");
				rewardMiles(totalPriorMiles);
			}
		}
		System.out.println("Thank you for choosing SKYTRAVEL AIRLINES. Goodbye :)");
	}
/**
 * The rewardMiles function will return which tier the user fits in based on their miles calculated for the current and previous years. 
 * @param miles
 */
	public static void rewardMiles(int miles) {
		if (miles >= 25000 && miles < 50000) {
			System.out.println("Your tier is Gold Status!\n");
		} else if (miles >= 50000 && miles < 75000) {
			System.out.println("Your tier is Platinum status!\n");
		} else if (miles >= 75000 && miles < 100000) {
			System.out.println("Your tier is Platinum Pro Status!\n");
		} else if (miles >= 100000 && miles < 150000) {
			System.out.println("Your tier is Executive Platinum Status!\n");
		} else if (miles >= 150000) {
			System.out.println("Your tier is Super Executive Platinum Status!\n");
		} else {
			System.out.println("Unfortunately, you didn't qualify to belong to any tier. Please accumulate more miles to belong to a tier next year. Thank you.\n");
		}
	}
}
