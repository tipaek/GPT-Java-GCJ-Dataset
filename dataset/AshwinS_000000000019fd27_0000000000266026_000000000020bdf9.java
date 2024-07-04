import java.io.*;
import java.util.Scanner;

public class Solution {
	
	Scanner sc;
	private static final int TOTAL_TIMELINE = (24*60) + 1;

	public static void main(String[] args) {
		new Solution().findSolution();
	}
	
	private void findSolution() {
		StringBuilder op = new StringBuilder();
		sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = sc.nextInt();
		for (int test = 0; test < testCases; test++) {
			StringBuilder tasksAssign = new StringBuilder(); 
			boolean[] c = new boolean[TOTAL_TIMELINE];
			boolean[] j = new boolean[TOTAL_TIMELINE];
			op.append("Case #").append(test+1).append(": ");
			int tasks = sc.nextInt();
			for(int t = 0; t < tasks; t++) {
				String user = assign(sc.nextInt(), sc.nextInt(), c, j);
				if("".equals(user)) {
					//the task cannot be assigned to anyone
					//clear any previous assignments
					tasksAssign.setLength(0);
					tasksAssign.append("IMPOSSIBLE");
					break;
				} else {
					tasksAssign.append(user);
				}
			}
			op.append(tasksAssign);
			System.out.println(op.toString());
			op.setLength(0);
		}
		sc.close();
	}
	
	private String assign(int start, int end, boolean[] c, boolean[] j) {
		//check if C is free
		boolean isCfree = isFree(start, end, c);
		boolean isJfree = isFree(start, end, j);
		if(!isCfree && !isJfree) {
			// both are occupied
			return "";
		}
		if(isCfree && isJfree) {
			// both are free.Find the most idle candidate
			int cDelta = findDelta(start, end, c);
			int jDelta = findDelta(start, end, j);
			if(0 == cDelta) {
				assignUser(start, end, c);
				return "C";
			} else if(0 == jDelta) {
				assignUser(start, end, j);
				return "J";
			} else {
				// assign to the user highest delta
				if(cDelta > jDelta) {
					assignUser(start, end, c);
					return "C";
				} else {
					assignUser(start, end, j);
					return "J";
				}
			}
		}
		if(isCfree) {
			//only C is free, assign to C
			assignUser(start, end, c);
			return "C";
		} else {
			//only J is free
			assignUser(start, end, j);
			return "J";
		}
	}
	
	private boolean isFree(int start, int end, boolean[] user) {
		boolean isFree = true;
		for(int i = start + 1; i< end; i++) {
			if(user[i]) {
				//user is occupied
				isFree = false;
				break;
			}
		}
		return isFree;
	}
	
	private int findDelta(int start, int end, boolean[] user) {
		int delta = 0;
		int count = 0;
		for(int i = start-1; i >=0; i--) {
			if(user[i]) {
				// user is occupied
				break;
			} else {
				//user is free
				count++;
			}
		}
		delta = count;
		if(0 == delta) {
			//we found a suitable position for the task
			return 0;
		}
		count = 0;
		for(int i = end+1; i < TOTAL_TIMELINE; i++) {
			if(user[i]) {
				// user is occupied
				break;
			} else {
				//user is free
				count++;
			}
			if(count > delta) {
				// this is already far
				break;
			}
		}
		if(delta > count) {
			delta = count;
		}
		return delta;
	}
	
	private void assignUser(int start, int end, boolean[] user) {
		for(int i = start; i<= end; i++) {
			user[i] = true;
		}
	}

}