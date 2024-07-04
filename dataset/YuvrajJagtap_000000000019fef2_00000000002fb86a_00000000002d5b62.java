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
	
	public static void performAction(int testCaseNo, String xy) {
		String[] coordinates = xy.split(" ");
		int x = Integer.valueOf(coordinates[0]);
		int y = Integer.valueOf(coordinates[1]);
		int total = Math.abs(x) + Math.abs(y);
		if (total % 2 == 0) {
			System.out.println("Case #" + (testCaseNo + 1) + ": " + "IMPOSSIBLE");
			return;
		}
		int power = findPower(total);
		String s = "";
		while (power >= 0) {
			if (Math.abs(x) > Math.abs(y)) {
				if (x > 0) {
					x = x - (int)(Math.pow(2, power));
					s = "E" + s;
				} else {
					x = x + (int)(Math.pow(2, power));
					s = "W" + s;
				}
			} else {
				if (y > 0) {
					y = y - (int)(Math.pow(2, power));
					s =  "N" + s;
				} else {
					y = y + (int)(Math.pow(2, power));
					s = "S" + s;
				}
			}
			power--;
		}
		if (x == 0 && y == 0) {
			System.out.println("Case #" + (testCaseNo + 1) + ": " + s);
		} else {
			System.out.println("Case #" + (testCaseNo + 1) + ": " + "IMPOSSIBLE");
		}
		
	}
	
	public static int findPower(int total) {
		int i =0;
		while (total > 1) {
			total = total/2;
			i++;
		}
		return i;
	}
}
