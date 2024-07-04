import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution implements Comparable<Solution> {
	
	private int start;
	private int finish;
	private int index;
	
	public Solution(int start, int finish, int index) {
		this.start = start;
		this.finish = finish;
		this.index = index;
	}
	
	public static void main(String[] args) {
		  Scanner input = new Scanner(System.in);	
	        
	        int T = input.nextInt();
	        
	        ArrayList<String> results = new ArrayList<String>();
	        
	        for (int ks = 1; ks <= T; ks++) {
	            results.add(String.format("Case #%d: %s", ks, solve(input)));
	        }
	        
	        for (int i = 0; i < results.size();i++) {
	        	System.out.println(results.get(i));
	        }
	}
	
	@Override
	public int compareTo(Solution solution) {
		return this.finish - solution.finish;
	}
	
	public static String solve(Scanner input) {
		int N = input.nextInt();

		String result = "";
		char[] resultArray = new char[N];
		Solution[] intervals = new Solution[N];
		
		
		for (int index = 0; index < N; index++) {
			int startTime = input.nextInt();
			int finishTime = input.nextInt();
			
			intervals[index] = new Solution(startTime, finishTime, index);
		}
		
		Arrays.sort(intervals);
		
		Solution recentCInterval = new Solution(0, 0, -1);
		Solution recentJInterval = new Solution(0, 0, -1);
		
		for (int i = 0; i < intervals.length; i++) {
			Solution currentInterval = intervals[i];
			
			if (currentInterval.start >= recentCInterval.finish && currentInterval.start >= recentJInterval.finish) {
				
				if (recentCInterval.finish >= recentJInterval.finish) {
					resultArray[currentInterval.index] = 'C';
					recentCInterval = currentInterval;
				}
				else {
					resultArray[currentInterval.index] = 'J';
					recentJInterval = currentInterval;
				}
			}
			else if (currentInterval.start >= recentCInterval.finish && currentInterval.start < recentJInterval.finish) {
				resultArray[currentInterval.index] = 'C';
				recentCInterval = currentInterval;
			}
			else if (currentInterval.start >= recentJInterval.finish && currentInterval.start < recentCInterval.finish) {
				resultArray[currentInterval.index] = 'J';
				recentJInterval = currentInterval;
			}
			else if (currentInterval.start < recentCInterval.finish && currentInterval.start < recentJInterval.finish) {
				result = "IMPOSSIBLE";
				break;
			}
		}
		
		if (result.equals("IMPOSSIBLE") == false) {
			for (int k = 0; k < resultArray.length; k++) {
				result += Character.toString(resultArray[k]);
			}	
		}
			
		return result;

	}

}
