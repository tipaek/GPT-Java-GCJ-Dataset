import java.util.*;
		import java.io.*;
		
		/**
		 * round 1A problem 2 pascal walk
		 */
		public class Solution {
			
			public static void main(String[] args) {
				 
				Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
				//fetch the number of test cases
				int testCaseNumber = in.nextInt();
				//fetch the first matrix number
				for (int test = 1; test <= testCaseNumber; test++) {
					int xcor = in.nextInt();
					int ycor = in.nextInt();
					String directions = in.next();
					String move = performAction(xcor, ycor, directions);
					System.out.println("Case #" + test + ": " + move);
				}
				in.close();
			}
		
			public static String performAction(int x, int y, String directions) {
				int count = 0;
				int number = 0;
				int move = 0;
				for (int i = 0; i < directions.length(); i++) {
					if (directions.charAt(i) == 'N') {
						count--;
					} else if (directions.charAt(i) == 'S') {
						count++;
					}
				}
				if (count < y) {
					return "IMPOSSIBLE";
				}
				number += x;
				count -= x;
				move += count/2;
				count -= count/2;
				if (count == 1) {
					move++;
				}
				if (move == count) {
					return String.valueOf(number + move);
				}
				return "IMPOSSIBLE";
			}
	}