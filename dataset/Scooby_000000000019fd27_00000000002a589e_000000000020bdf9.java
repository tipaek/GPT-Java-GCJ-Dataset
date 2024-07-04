
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Brenton
 */
public class Solution {

	// Change the next two depending on the problem
	public static final String SAMPLE_INPUT = "src/example.in";
	public static final String SAMPLE_OUTPUT = "example.out";

	public static void main(String[] args) throws FileNotFoundException {

		// Set input to test file for testing
//		System.setIn(new FileInputStream(SAMPLE_INPUT));
//        System.setOut(new PrintStream(new FileOutputStream(SAMPLE_OUTPUT)));

		// Setup the input scanner
		Scanner readIn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		// Read in the number of cases
		int cases = readIn.nextInt();

		// Solve each case
		for (int caseNumber = 1; caseNumber <= cases; caseNumber++) {
			// Read and solve the next case from the input file
			String result = solveNextCase(readIn);

			// Print result to output file and to console
			System.out.println("Case #" + caseNumber + ": " + result);
		}
	}

	// Read in the next case from the file and solve it
	public static String solveNextCase(Scanner readIn) {

		// Read in the variables
		int numOfActivities = readIn.nextInt();
		List<Activity> activities = new ArrayList<>();

		for (int i = 0; i < numOfActivities; i++) {
			Activity a = new Activity();
			a.id = 0;
			a.start = readIn.nextInt();
			a.end = readIn.nextInt();
			activities.add(a);
		}
		// Sort by start
		Collections.sort(activities, new Comparator<Activity>() {
			@Override
			public int compare(Activity o1, Activity o2) {
				return Integer.compare(o1.start, o2.start);
			}
		});
		int current = 0;
		for (Activity a : activities) {
			if (a.assignee == 'U' && a.start >= current) {
				a.assignee = 'C';
				current = a.end;
			}
		}

		current = 0;
		for (Activity a : activities) {
			if (a.assignee == 'U' && a.start >= current) {
				a.assignee = 'J';
				current = a.end;
			}
		}

		for (Activity a : activities) {
			if (a.assignee == 'U') {
				return "IMPOSSIBLE";
			}
		}

		// Sort by start
		Collections.sort(activities, new Comparator<Activity>() {
			@Override
			public int compare(Activity o1, Activity o2) {
				return Integer.compare(o1.id, o2.id);
			}
		});

		String result = "";
		for (Activity a : activities) {
			result += a.assignee;
		}

		return result + "";

	}

}

class Activity {
	int id;
	int start;
	int end;
	char assignee = 'U';
}
