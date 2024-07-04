
import java.util.*;
import java.io.*;

public class Solution {
	  public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    int t = in.nextInt();  
		    for (int x = 1; x <= t; x++) {
		    	int n = in.nextInt();
		    	
		    	Set<String> before = new HashSet<>();
		    	Set<String> after = new HashSet<>();
		    	String beforeBig="";
		    	String afterBig="";
		    	for (int i=0; i<n; i++) {
		    		String cur = in.next();
		    		String b=cur.substring(0, cur.indexOf('*'));
		    		if (b.length()>0) {
		    			before.add(b);
		    			if (b.length()>beforeBig.length()) beforeBig = b;
		    		}
		    		String a=cur.substring(cur.indexOf('*')+1);
		    		if (a.length()>0) {
		    			after.add(a);
		    			if (a.length()>afterBig.length()) afterBig = a;
		    		}
		    	}
		    	
		    	String solution=beforeBig+afterBig;
		    	for (String s: before)
		    		if (!solution.startsWith(s)) {
		    			solution = "*";
		    			break;
		    		}
		    	for (String s: after)
		    		if (!solution.endsWith(s)) {
		    			solution = "*";
		    			break;
		    		}
		    		
		    	System.out.println("Case #"+ x+": "+solution);

		    }
		}
	  

}