
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
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
		String input = readIn.next();
		String result = input;

		boolean ingroup = false;

		for (int n = 9; n > 0; n--) {
			String newResult = "";
			for (int i = 0; i < result.length(); i++) {
				char c = result.charAt(i);
				if (c != '(' && c != ')') {

					int cNum = Integer.parseInt(c + "");
					if (!ingroup && cNum >= n) {
						ingroup = true;
						newResult += "(";

					} else if (ingroup && cNum < n) {
						ingroup = false;
						newResult += ")";
					}
					newResult += c;
				} else {
					newResult += c;
				}
				if (ingroup && i == result.length() - 1) {
					newResult += ")";
				}

			}
			result = newResult;
			ingroup = false;
		}

		return result;

	}
}
