import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int numberOfTestCases = Integer.parseInt(s);
		Map<Integer, String> noOfItems = new HashMap<Integer, String>();
		for (int i = 0; i < numberOfTestCases; i++) {
			s = in.nextLine();
			noOfItems.put(i, s);
		}
		for (Integer key : noOfItems.keySet()) {
			performAction(key, noOfItems.get(key));
		}
	}
	
	public static void performAction(int testCaseNo, String rs) {
		String[] coordinates = rs.split(" ");
		int r = Integer.valueOf(coordinates[0]);
		int s = Integer.valueOf(coordinates[1]);
	}
}
