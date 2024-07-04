import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		for(int z = 1; z <= number; z++) {
		    System.out.print("Case #" + z + ": ");
		    computer(sc);
		    System.out.println();
		}
		sc.close();
	}
	public static void computer(Scanner sc)
	{
	    String s = sc.next();
	    // diffs
	    int[] diffs = new int[s.length() - 1];
	    for(int i = 0; i < s.length() - 1; i++) {
	        diffs[i] = (s.charAt(i) - '0') - (s.charAt(i + 1) - '0');
	    }
	    // first brackets
	    for(int i = 0; i < (s.charAt(0) - '0'); i++) {
	        System.out.print("(");
	    }
	    System.out.print(s.charAt(0));
	    // for each character
	    for(int i = 0; i < s.length() - 1; i++) {
	        if(diffs[i] > 0) {
	            for(int j = 0; j < diffs[i]; j++) {
	                System.out.print(")");
	            }
	        } else if(diffs[i] < 0) {
	            for(int j = 0; j < Math.abs(diffs[i]); j++) {
	                System.out.print("(");
	            }
	        }
	        System.out.print(s.charAt(i + 1));
	    }
	    for(int i = 0; i < (s.charAt(s.length() - 1) - '0'); i++) {
	        System.out.print(")");
	    }
	}
}
