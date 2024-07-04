import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {

        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int dataSize = Integer.parseInt(s.next());
		int count = 1;
		while (dataSize > 0) {
			int numTimes = Integer.parseInt(s.next());
			int [] c = new int[1441];
			int [] j = new int[1441];
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
	private static boolean checkAvailability(int itCounter, int outTime, int [] parent) {
		//3=start/end, 1=middle, 0=empty
		if(itCounter==outTime) {
			if (parent[itCounter] == 1) {
				return false;			
			}
		}
		while (itCounter < outTime ) {
			if (parent[itCounter] != 0) {
				return false;			
			}
			itCounter++;
		}
		return true;
	}
	private static void markBusy (int inTime, int outTime, int [] parent) {
		parent[inTime] = 3;
		parent[outTime] = 3;

		inTime++;
		while (inTime < outTime) {
			parent[inTime] = 1;
			inTime++;
		}
	}

}
