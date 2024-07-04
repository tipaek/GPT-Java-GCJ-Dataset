import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int dataSize = Integer.parseInt(s.next());
		int count = 1;
		while (dataSize > 0) {
			int numTimes = Integer.parseInt(s.next());
			boolean [] c = new boolean[1441];
			boolean [] j = new boolean[1441];
			String order = "";
			while (numTimes > 0) {

				int inTime = Integer.parseInt(s.next());
				int outTime = Integer.parseInt(s.next());

				if (order.equals("IMPOSSIBLE")) {

				} else if (checkAvailability(inTime,outTime,c)) {
					markBusy(inTime,outTime,c);
					order += "C";

				} else if (checkAvailability(inTime,outTime,j)) {
					markBusy(inTime,outTime,j);
					order += "J";

				} else {

					order = "IMPOSSIBLE";
					
				}

				numTimes--;
				
			}
			System.out.println("Case #"+count+": "+order);
			count++;
			dataSize--;
		}
	}
	private static boolean checkAvailability(int itCounter, int outTime, boolean [] parent) {

		while (itCounter <= outTime && itCounter >= 0) {
			if (itCounter > 0 && parent[itCounter] != false) {
				itCounter = -100;				
			}itCounter++;

		}

		if (itCounter == -99)
			return false;
		return true;
	}
	private static void markBusy (int inTime, int outTime, boolean [] parent) {
		while (inTime < outTime) {
			parent[inTime] = true;
			inTime++;
		}
	}

}
