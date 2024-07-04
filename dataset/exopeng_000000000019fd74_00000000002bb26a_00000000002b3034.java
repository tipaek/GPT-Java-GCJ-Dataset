import java.io.*;
import java.util.*;



public class Solution {
	public static int startIndex = 0;
	public static int endIndex = 0;
	public static void main(String[] args) throws IOException {
		//get input separately
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter p = new PrintWriter(new BufferedOutputStream(System.out));
		StringTokenizer s = new StringTokenizer(b.readLine());
		int cases = Integer.parseInt(s.nextToken());
		//store the answers in an int array
		for (int i = 0; i < cases; i++) {
			s = new StringTokenizer(b.readLine());
			int n = Integer.parseInt(s.nextToken());
			String start = "";
			String end = "";
			String mid = "";
			boolean finished = false;
			s = new StringTokenizer(b.readLine());
			String beg = s.nextToken();
			//handle beginning
			start = handleStart(beg);
			end = handleEnd(beg);
			mid = handleMid(beg);
			//p.println(end);
			for (int j = 1; j < n; j++) {
				startIndex = 0;
				endIndex = 0;
				s = new StringTokenizer(b.readLine());
				String pattern = s.nextToken();
				//p.println(pattern);

				//check starts and ends, everything in middle can be ignored, add to another string
				for (int f = 0; f < pattern.length(); f++) {
					if (pattern.charAt(f) == '*') {
						startIndex = f;
						break;
					}
					//can add whatever you want
					if (f > start.length() - 1) {
						start += pattern.charAt(f);
					} else {
						if (pattern.charAt(f) != start.charAt(f)) {
							p.println("Case #" + (i + 1) + ": " + "*");
							finished = true;
							break;
						}
					}
				}
				if (finished) {
					//p.println("Stopped at start");
					break;
				}
				for (int f = pattern.length() - 1; f > - 1; f--) {
					if (pattern.charAt(f) == '*') {
						endIndex = f;
						break;
					}
					//can add whatever you want
					if (pattern.length() - f > end.length()) {
						end = pattern.charAt(f) + end;
					} else {
						//going backwards
						if (pattern.charAt(f) != end.charAt(end.length() - (pattern.length() - f))) {
							//p.println("Stopped at end f: " + f );
							//p.println(end);
							p.println("Case #" + (i + 1) + ": " + "*");
							finished = true;
							break;
						}
					}
				}
				if (finished) {
					break;
				}
				//add the middle stuff in 
				for (int f = startIndex; f < endIndex; f++) {
					if (pattern.charAt(f) != '*') {
						mid += pattern.charAt(f);
					}
				}
			}
			if (finished) {
				continue;
			}
			p.println("Case #" +  (i + 1) + ": " + start + mid + end);
		}
		p.close();

	}
	public static String handleStart(String pattern) {
		String ans = "";
		for (int f = 0; f < pattern.length(); f++) {
			if (pattern.charAt(f) == '*') {
				startIndex = f;
				break;
			} else {
				ans += pattern.charAt(f);
			}
		}
		return ans;
	}
	public static String handleMid(String pattern) {
		//add the middle stuff in 
		String ans = "";
		for (int f = startIndex; f <= endIndex; f++) {
			if (pattern.charAt(f) != '*') {
				ans += pattern.charAt(f);
			}
		}
		return ans;
	}
	public static String handleEnd(String pattern) {
		String ans = "";
		for (int f = pattern.length() - 1; f > - 1; f--) {
			if (pattern.charAt(f) == '*') {
				endIndex = f;
				break;
			} else {
				ans = pattern.charAt(f) + ans;
			}
		}
		return ans;
	}
	
	
	// you should actually read the stuff at the bottom

}


/* REMINDERS
 * PLANNING!!!!!!!! Concrete plan before code
 * DON'T MAKE ASSUMPTIONS
 * DON'T OVERCOMPLICATE
 * NAIVE SOL FIRST
 * CHECK INT VS LONG, IF YOU NEED TO STORE LARGE NUMBERS
 * CHECK CONSTRAINTS, C <= N <= F...
 * CHECK SPECIAL CASES, N = 1...
 * CHECK ARRAY BOUNDS, HOW BIG ARRAY HAS TO BE
 * TO TEST TLE/MLE, PLUG IN MAX VALS ALLOWED AND SEE WHAT HAPPENS
 * ALSO CALCULATE BIG-O, OVERALL TIME COMPLEXITY
 */
