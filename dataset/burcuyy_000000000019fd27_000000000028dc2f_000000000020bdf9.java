import java.io.*;
import java.util.Scanner;
class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int number_of_test_cases = scan.nextInt();
		for(int n = 1; n <= number_of_test_cases; n++) {
			int number_of_activities = scan.nextInt();
			int[] startings = new int[number_of_activities];
			int[] endings = new int[number_of_activities];
			String person = "";
			boolean possible = true;
			for (int i = 0; i < number_of_activities; i++) {
				startings[i] = scan.nextInt();
				endings[i] = scan.nextInt();
				boolean cameronIsEmpty = true;
				boolean jamieIsEmpty = true;
				if (possible) {
					for (int j = 0; j < i; j++) {
						if (person.charAt(j) == 'C') {
							if (cameronIsEmpty) {
								if ((startings[i] < startings[j] && endings[i] > startings[j]) 
										|| (startings[i] > startings[j] && endings[j] > startings[i])) {
									cameronIsEmpty = false;
								}
							}
						}
						else {
							if (jamieIsEmpty) {
								if ((startings[i] < startings[j] && endings[i] > startings[j]) 
										|| (startings[i] > startings[j] && endings[j] > startings[i])) {
									jamieIsEmpty = false;
								}
							}
						}
					}
					if (cameronIsEmpty) person = person + "C";
					else if (jamieIsEmpty) person = person + "J";
					else {
						person = "IMPOSSIBLE";
						possible = false;
					}
				}
			}
			System.out.println("Case #"+n+": "+person);
		}

	}
}