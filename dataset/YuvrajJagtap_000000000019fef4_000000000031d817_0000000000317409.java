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
	
	public static void performAction(int testCaseNo, String xyPath) {
		String[] coordinates = xyPath.split(" ");
		int x = Integer.valueOf(coordinates[0]);
		int y = Integer.valueOf(coordinates[1]);
		int myX =0;
		int myY = 0;
		String path = coordinates[2];
		String direction = null;
		for (int i = 0; i < path.length() ; i++) {
			direction = path.substring(i, i+1);
			if ("S".equals(direction)) {
				y = y-1;
				if (myX < x) {
					myX++;
				} else if (myX > x) {
					myX--;
				} else if (myY < y) {
					myY++;
				} else if (myY > y) {
					myY--;
				}
			} else if ("N".equals(direction)) {
				y = y+1;
				if (myX < x) {
					myX++;
				} else if (myX > x) {
					myX--;
				} else if (myY < y) {
					myY--;
				} else if (myY > y) {
					myY++;
				}
			} else if ("E".equals(direction)) {
				x = x+1;
				if (myY < y) {
					myY--;
				} else if (myY > y) {
					myY++;
				} else if (myX < x) {
					myX--;
				} else if (myX > x) {
					myX++;
				}
			} else if ("W".equals(direction)) {
				x = x-1;
				if (myY < y) {
					myY--;
				} else if (myY > y) {
					myY++;
				} else if (myX < x) {
					myX++;
				} else if (myX > x) {
					myX--;
				}
			}
			if (x == myX && y == myY) {
				System.out.println("Case #" + (testCaseNo + 1) + ": " + (i+1));
				break;
			}
		}
		if(!(x == myX && y == myY)) {
			System.out.println("Case #" + (testCaseNo + 1) + ": " + "IMPOSSIBLE");
		}
		
	}
}
