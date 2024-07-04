import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Solution {

	public static StringBuilder solve(int noOfActivities, Scanner scanner) {
		StringBuilder ansString = new StringBuilder();
		List<Integer> cStartTime = new ArrayList<Integer>();
		List<Integer> jStartTime = new ArrayList<Integer>();
		List<Integer> cEndTime = new ArrayList<Integer>();
		List<Integer> jEndTime = new ArrayList<Integer>();
		for(int i = 0; i < noOfActivities; i ++) {
			int strTime = scanner.nextInt(), endTime = scanner.nextInt();
			if(checkAllocation(cStartTime, cEndTime, strTime, endTime)) {
				ansString.append("C");
				cStartTime.add(strTime);
				cEndTime.add(endTime);
			}else if(checkAllocation(jStartTime, jEndTime, strTime, endTime)) {
				ansString.append("J");
				jStartTime.add(strTime);
				jEndTime.add(endTime);
			} else {
				ansString = new StringBuilder("IMPOSSIBLE");
			}
		}
		return ansString;
	}
	
	public static boolean checkAllocation(List<Integer> userStartTime, List<Integer> userEndTime,int startTime, int endTime) {
		for (int i = 0; i < userStartTime.size(); i ++) {
			if (startTime > userStartTime.get(i) && startTime < userEndTime.get(i)) {
				return false;
			}
			if (endTime < userStartTime.get(i) && endTime > userEndTime.get(i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int caseNo = 0;
		Scanner stdin = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		caseNo = stdin.nextInt();
		stdin.nextLine();
		for (int k = 1; k <= caseNo; k++) {
			int noOfActivities = stdin.nextInt();
//			stdin.nextLine();
			System.out.println("Case #" + k + ": " + solve(noOfActivities, stdin));
			// long startTime = System.currentTimeMillis();

		}
	}

}