import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    in.nextLine();
	    //System.out.println("# of test cases:" + t);
	    
	    for (int i = 1; i <= t; ++i) {

  	      	String rowVal = in.nextLine();
  	      	String[] c = rowVal.split(" ");
  	      	int[] nums =  getIntArray(c);
	    	System.out.println("Case #" + i + ": " + getPString(nums));
	    }
	  }
	
		private static String getPString(int[]nums) {
			StringBuilder s = new StringBuilder();
			int previous = 0;
			for(int i = 0; i<nums.length; i++) {
				if(nums[i]==0)
					s.append(i);
				else {
					if(previous!=0) {
						if(previous<=nums[i]) {
							s.insert(s.length() - nums[i], nums[i]);
						} else {
							for(int u =0; u < nums[i]; u++) {
								s.append("(");
							}
							s.append(nums[i]);
							for(int u =0; u < nums[i]; u++) {
								s.append(")");
							}
							
						}
					}
				}
				previous = nums[i];
			}
			return s.toString();
		}
	
	
		private static int[] getIntArray(String[] e) {
		  int [] arr = new int [e.length];
	      for(int i=0; i<e.length; i++) {
	         arr[i] = Integer.parseInt(e[i]);
	      }
	      return arr;
	  }
}
