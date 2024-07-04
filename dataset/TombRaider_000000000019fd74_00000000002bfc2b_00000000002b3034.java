
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	// task 1
    
	public static String[] splitStrings (String input) {
		String status = input;
		String currentString = "";
		ArrayList <String> strings = new ArrayList<String>();
		
		//iterate through it
		while (status.length() > 0) {
			if (status.startsWith("*")) {
				if (currentString.length()>0) {
					strings.add(currentString);
					currentString = "";
				}
				strings.add("*");
			} else {
				currentString += status.charAt(0);
			}
			status = status.substring(1);
		}
		// at the end
		if (currentString.length()>0) {
			strings.add(currentString);
		}
		
		// make array
		String [] stringsOut = new String [strings.size()];
		for (int i=0; i<strings.size(); i++) {
			stringsOut[i] = strings.get(i);
		}
		 
		return stringsOut;
	}
	
	// Text out
	public static String arrayToString (String [] input) {
		String result = "";
		for (int i=0; i<input.length; i++) {
			result += input [i];
			if (i<input.length-1) result += ", ";
		}
		return result;
	}
	
	private int [] status;
	private String [][] patterns;
	private String workString;
	
	public String resolve (String [] input) {
		this.patterns = new String[input.length] [];
		
		for (int i=0; i<input.length; i++) {
			patterns [i] = Solution.splitStrings(input[i]);
		}
		
		//check End
		String endString ="";
		for (int i=0; i<patterns.length; i++) {
			int currentEndNumber = patterns[i].length - 1;

			String currentEnd = patterns[i][currentEndNumber];
			if ((!currentEnd.equals("*")) && (currentEnd.length()>endString.length())){
				endString = currentEnd;
			}
		}
		for (int i=0; i<patterns.length; i++) {
			int currentEndNumber = patterns[i].length - 1;
			String currentEnd = patterns[i][currentEndNumber];
			if ((!currentEnd.equals("*")) && (!(endString.endsWith(currentEnd)))){
				// no solution for EndString
				return "*";
			}
		}
				
		//check Start
		String startString ="";
		for (int i=0; i<patterns.length; i++) {
			if ((!patterns[i][0].equals("*")) && (patterns[i][0].length()>startString.length())){
				startString = patterns[i][0];
			}
		}
		for (int i=0; i<patterns.length; i++) {
			if ((!patterns[i][0].equals("*")) && (!(startString.startsWith(patterns[i][0])))){
				// no solution for StartString
				return "*";
			}
		}
		
		//start it
		this.status = new int[patterns.length];
		for (int i=0; i<patterns.length; i++) {
			if (patterns[i][0].equals("*")) {
				this.status[i] = 0;
			} else {
				this.status[i] = 1;
			}
				
		}
		this.workString = startString;
		
		if (!this.backTrack(-1)) {
			return "*";
		};
		
		if (workString.length()==0) return "BLUB";
		
		if (this.workString.endsWith(endString)) return this.workString;
		
		this.workString += endString;
		
		return this.workString;
	}
	
	private boolean backTrack (int applyNumber) {
		String beforeString = this.workString;
		// apply current One
		if (applyNumber != -1) {
			String applyString = this.patterns [applyNumber][this.status[applyNumber]];
			if (applyString.equals("*")) {
				// *happy case
			} else {
				if (this.workString.endsWith(applyString)) {
					// already in there	
				} else {
					this.workString += applyString;
				}
			}
			this.status[applyNumber] ++; 
		}

		// check whether done
		// ignore end string
		boolean done = true;
		for (int i=0; i<status.length; i++) {
			int currentEndNumber = patterns[i].length - 1;
			boolean hasEndString = (!patterns[i][currentEndNumber].equals("*"));
			if (((hasEndString) && (this.status[i] == (patterns[i].length-2))) 
				|| ((!hasEndString) &&  (this.status[i] == (patterns[i].length-1)))) {
				// OK for done
			} else {
				done = false;
			}
		}
		if (done) return true;

		// not done, sth. to apply
		
		for (int i=0; i<this.status.length; i++) {
			int currentEndNumber = patterns[i].length - 1;
			boolean hasEndString = (!patterns[i][currentEndNumber].equals("*"));
			if (((hasEndString) && (this.status[i] == (patterns[i].length-2))) 
				|| ((!hasEndString) &&  (this.status[i] == (patterns[i].length-1)))) {
				// this string is done
			} else {
				// try to apply
				if (this.backTrack(i)) return true;
			}
		}
		
		// if no success go back
		if (applyNumber != -1) this.status[applyNumber] --; 
		this.workString = beforeString;
		return false;
	}

      
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int patternNumber = in.nextInt();
			String [] patterns = new String [patternNumber];
			for (int j=0; j<patternNumber; j++)
				patterns[j] = in.next();
			Solution sol = new Solution();
            System.out.println("Case #"+i+": "+sol.resolve(patterns));
		}
	}
}