import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Vector;

public class FruitsOrderBy {

	private String welcomeMessage;

	public static void main(String[] args) {

		int userChoice=0;
		Scanner input = new Scanner(System.in);
		System.out
				.print("Welcome to fruit selector\nPlease select an option:\n");
		Controller ctller = new Controller();
while(userChoice != 5){
		System.out.println("Enter number 1 to order Alphabetical\n"
				+ "Enter number 2 to order by Lenght\n"
				+ "Enter 3 to order by index of i\nOption:");

		userChoice = input.nextInt();

		if (userChoice > 5 || userChoice < 1) {
			System.out.println("\nInvalid option-Please enter a valid number:");
			userChoice = input.nextInt();
		}

		if (userChoice == 1) {
			SortAlphabetical alpha = new SortAlphabetical();
			Iterator values = ctller.resort(alpha);
			while (values.hasNext()) { // condition to stop

				System.out.print(values.next() + "\n");
			}

		} else if (userChoice == 2) {

			SortByLength sLength = new SortByLength();

			Iterator values = ctller.resort(sLength);
			while (values.hasNext()) { // condition to stop

				System.out.print(values.next() + "\n");
			}

		} else if (userChoice == 3) {
			SortByIndexOfi sIndex = new SortByIndexOfi();

			Iterator values = ctller.resort(sIndex);

			while (values.hasNext()) { // condition to stop

				System.out.print(values.next() + "\n");
			}

		} else if (userChoice == 4) {

			Vector<String> list = ctller.getFruits();
			ListIterator<String> vInfo = list.listIterator();

			while (vInfo.hasNext()) {
				String value = vInfo.next();
				System.out.print(value + "\n");
			}

		} else if (userChoice == 5) {

			System.exit(0);
		}
}
	}

}
