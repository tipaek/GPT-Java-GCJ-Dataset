import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = Integer.parseInt(in.nextLine()); 
	    
	    for (int i = 1; i <= t; ++i) {
	    	int n = in.nextInt(); 
	    	int j1 = in.nextInt(), j2 = in.nextInt();
	    	int c1 = in.nextInt(), c2 = in.nextInt();
	    	String str = "JC";

	    	for(int k = 2; k < n; ++k) {
	    		int a = in.nextInt(), b = in.nextInt();
	    		if(a < j1 && b <= j1) {
	    			j1 = a;
	    			str = str + "J";
	    		} else if (a >= j2) {
	    			j2 = b;
					str = str + "J";
				} else if (a < c1 && b <= c1) {
					c1 = a;
	    			str = str + "C";
	    		} else if (a >= c2) {
	    			c2 = b;
					str = str + "C";
				} else {
					str = "IMPOSSIBLE";
				}
	    	}
	    	System.out.println("Case #" + i + ": " + str);
	    }
	}
}
