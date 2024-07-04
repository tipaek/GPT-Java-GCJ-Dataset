import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		List<String> lines = new ArrayList<>();
		
		while(in.hasNext()) {
			lines.add(in.next());
		}

		int nbTestCases = Integer.parseInt(lines.get(0));
		int thisTestCaseNumber = 0;

		List<String> subCase = new ArrayList<>();
		int subCaseSize = 0;
		String outputString = "";

		for(int i = 1; i < lines.size(); i++) {
			if(subCaseSize == 0) {
				subCaseSize = Integer.parseInt(lines.get(i));
			}
			else {
				subCase.add(lines.get(i));
				subCaseSize--;
				if(subCaseSize == 0) {
					outputString = computeNumbers(subCase);
					thisTestCaseNumber++;
					System.out.println("Case #" + thisTestCaseNumber + ": " + outputString);
					nbTestCases--;
					if(nbTestCases == 0) {
						break;
					}
					else {
						subCase.clear();
					}
				}
			}
		}
		System.exit(0);
	}

	private static String computeNumbers(List<String> subCase) {

		int[][] myIntArray = convertStringArrayToIntArray(subCase);
		int arrayTrace = computeMatrixTrace(myIntArray);
		int rowDuplicates = computeMatrixRowDups(myIntArray);
		int columnDuplicates = computeMatrixColumnsDups(myIntArray);

		return "" + arrayTrace + " " + rowDuplicates + " " + columnDuplicates;
	}

	private static int computeMatrixColumnsDups(int[][] myIntArray) {
		int thisArrayColumnsDups = 0;
		int rowLength = myIntArray[0].length;
		Set<Integer> nums = new HashSet<>();

		for(int i = 0; i < rowLength; i++) {
			nums = new HashSet<>();
			for(int j = 0; j < rowLength; j++) {
				nums.add(myIntArray[j][i]);
			}
			if(nums.size() < rowLength) {
				thisArrayColumnsDups++;
			}
		}

		return thisArrayColumnsDups;
	}

	private static int computeMatrixRowDups(int[][] myIntArray) {
		int thisArrayRowDups = 0;
		int rowLength = myIntArray[0].length;
		Set<Integer> nums = new HashSet<>();

		for(int i = 0; i < rowLength; i++) {
			nums = new HashSet<>();
			for(int j = 0; j < rowLength; j++) {
				nums.add(myIntArray[i][j]);
			}
			if(nums.size() < rowLength) {
				thisArrayRowDups++;
			}
		}

		return thisArrayRowDups;
	}

	private static int computeMatrixTrace(int[][] myIntArray) {
		int thisArrayTrace = 0;
		for(int i = 0; i < myIntArray.length; i++) {
			thisArrayTrace += myIntArray[i][i];
		}
		return thisArrayTrace;
	}

	private static int[][] convertStringArrayToIntArray(List<String> subCase) {
		int arrayDimension = subCase.size();

		int[][] myIntArray = new int[arrayDimension][arrayDimension];
		for(int i = 0; i < arrayDimension; i++) {
			String[] thoseColumns = subCase.get(i).split(" ");
			for(int j = 0; j < arrayDimension; j++) {
				myIntArray[i][j] = Integer.parseInt(thoseColumns[j]);
			}
		}

		return myIntArray;
	}

}
