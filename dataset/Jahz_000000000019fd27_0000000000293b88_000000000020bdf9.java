import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;

/**
 * For classic solutions (NON-interactive ones) /!\ Don't forget to remove the
 * package declaration before submitting to google code jam servers /!\
 * 
 * Use isTest = true to test your code against the sample provided in the
 * problem (copy paste into Sample.in and SampleCorrection.out)
 * 
 * Use isTest = false to submit the code to google code jam servers
 * 
 */
public class Solution {

	public static final boolean isTest = false;
	public static final String directory = "/src/jam2020/qualif/problem3";

	public static void main(String[] args) throws IOException {

		Solution s = new Solution();

		if (isTest) {
			s.runFromFileForTesting(SAMPLE, directory);
		} else {
			s.runFromSystemInForSubmit();
		}

	}

	private void run(BufferedReader inputBR, PrintStream outputPS) throws IOException {

		// Starts to read the input
		String firstInputLine = inputBR.readLine();
		int t = getNbOfTestCase(firstInputLine);
		int nbInitLines = getNbInitLines(firstInputLine);

		if (nbInitLines > 0) {
			// We have to "init" the problem, it'll be used for all test cases
			String[] initInput = new String[nbInitLines];

			for (int i = 0; i < initInput.length; i++) {
				initInput[i] = inputBR.readLine();
			}
			initForAllTestCases(initInput);
		}

		// Start the test case loop
		for (int i = 1; i <= t; i++) {

			if (isTest) {
				err("Working on test case " + i + "/" + t);
			}

			// Gather the input
			String firstTestCaseLine = inputBR.readLine();
			int nbLinesToReadOnTop = getNbLinesToReadForCurrentTestCaseOnTopOfCurrentLine(firstTestCaseLine);
			String[] input = new String[1 + nbLinesToReadOnTop];
			input[0] = firstTestCaseLine;

			for (int j = 1; j < input.length; j++) {
				input[j] = inputBR.readLine();
			}

			// The real work now !
			String result = compute(input);

			// And write the output
			outputPS.println("Case #" + i + ": " + result);

		}

	}

	private void runFromSystemInForSubmit() throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		PrintStream output = System.out;

		run(input, output);

	}

	// Runs the solution against the provided input file, for testing purpose
	public void runFromFileForTesting(String filename, String directory) {

		long startTime = System.currentTimeMillis();

		err("Starting to run solution...");

		try {
			// Reads the input file
			File dir = new File(".");
			File inputFile = new File(dir.getCanonicalPath() + directory + File.separator + filename + ".in");
			BufferedReader inputBR = new BufferedReader(new FileReader(inputFile));

			// Construct the output file
			File oldOutputFile = new File(dir.getCanonicalPath() + directory + File.separator + filename + ".out");

			// Delete the old output file, if any
			if (oldOutputFile.delete()) {
				err(oldOutputFile.getName() + " is deleted !");
			} else {
				err("Nothing to delete.");
			}

			File newOutputFile = new File(dir.getCanonicalPath() + directory + File.separator + filename + ".out");
			PrintStream outputPS = new PrintStream(newOutputFile);

			run(inputBR, outputPS);

			outputPS.close();
			inputBR.close();

			if (filename.equals(SAMPLE)) {
				// Test it against the provided correction coming from the problem statement
				testSampleCorrection(directory);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		err("Run finished in " + (System.currentTimeMillis() - startTime) + " ms !");

	}

	private static final String SAMPLE = "Sample";
	private static final String SAMPLE_CORRECTION = "SampleCorrection";

	private void testSampleCorrection(String directory) throws IOException {

		err("Testing the sample output against the provided correction...");

		File dir = new File(".");

		File outputFile = new File(dir.getCanonicalPath() + directory + File.separator + SAMPLE + ".out");
		BufferedReader outputFileBR = new BufferedReader(new FileReader(outputFile));

		File correctionFile = new File(dir.getCanonicalPath() + directory + File.separator + SAMPLE_CORRECTION + ".out");
		BufferedReader correctionFileBR = new BufferedReader(new FileReader(correctionFile));

		String outputLine = outputFileBR.readLine();
		String correctionLine = correctionFileBR.readLine();
		int lineNumber = 1;
		boolean errorFound = false;

		while (outputLine != null) {

			if (!correctionLine.equals(outputLine.trim())) {
				if (isTest) {
					err("Error detected at line " + lineNumber + " !");
					err("Correction: " + correctionLine);
					err("But found:  " + outputLine);
				}
				errorFound = true;
			}

			lineNumber++;
			outputLine = outputFileBR.readLine();
			correctionLine = correctionFileBR.readLine();
		}

		if (correctionLine != null) {
			if (isTest) {
				err("More lines in the correction file !");
			}
			errorFound = true;
		}

		outputFileBR.close();
		correctionFileBR.close();

		if (errorFound) {
			err("Testing finished KO !");
		} else {
			err("Testing finished OK !");
		}

	}

	public static void err(String s) {
		if (isTest) {
			System.err.println(s);
		}
	}

	// Get the number of test cases, usually the only number of the first line
	public int getNbOfTestCase(String firstInputLine) {
		// return Integer.valueOf(firstInputLine.split(" ")[0]);
		return Integer.valueOf(firstInputLine);
	}

	// Get the number of lines we have to read to init all test cases
	public int getNbInitLines(String firstInputLine) {
		return 0;
	}

	// Init all the test cases, by setting some global values usually
	public void initForAllTestCases(String[] initInput) {

	}

	// Get the number of lines to read for a given test case on top of the first line, from the the first line of this test case
	public int getNbLinesToReadForCurrentTestCaseOnTopOfCurrentLine(String firstTestCaseLine) {
		return Integer.valueOf(firstTestCaseLine.split(" ")[0]);
	}

	// Finally do the real work !
	public String compute(String[] input) {

		String result = "";
		int[][] tasks = new int[Integer.valueOf(input[0])][2];
		for (int i = 0; i < tasks.length; i++) {
			tasks[i][0] = Integer.valueOf(input[i + 1].split(" ")[0]);
			tasks[i][1] = Integer.valueOf(input[i + 1].split(" ")[1]);
		}

		Arrays.sort(tasks, taskComparator);

		int C = -1;
		int J = -1;

		for (int i = 0; i < tasks.length; i++) {
			int[] task = tasks[i];

			boolean assigned = false;

			if (C <= task[0]) {
				C = task[1];
				result += "C";
				assigned = true;
			}
			if (J <= task[0]) {
				J = -1;
				if (!assigned) {
					J = task[1];
					result += "J";
					assigned = true;
				}
			}

			if (!assigned) {
				result = "IMPOSSIBLE";
				break;
			}

		}

		return result;
	}

	Comparator<int[]> taskComparator = new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0] < o2[0]) {
				return -1;
			} else if (o1[0] > o2[0]) {
				return 1;
			} else {
				if (o1[1] < o2[1]) {
					return -1;
				} else if (o1[1] > o2[1]) {
					return 1;
				}
			}
			return 0;
		}

	};

}