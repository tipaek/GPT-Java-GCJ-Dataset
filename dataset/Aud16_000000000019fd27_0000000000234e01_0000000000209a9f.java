/* Use the slash-star style comments or the system won't see your
	identification information */
/*
	ID: audreylee16
	LANG: JAVA
	TASK: default
*/
import java.io.*;
import java.util.*;

public class Solution {
  public static void main (String [] args) throws IOException {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int cases = in.nextInt();
    in.nextLine();
    for (int i = 1; i <= cases; i++) {
    	String ans = "";
    	String[] keys = in.nextLine().split("");
    	for(String s : keys) {
    		int key = Integer.parseInt(s);
    		if(key == 0) {
    			ans += 0;
    		} else {
    			String append = key + "";
    			String saved = ans;
    			for(int x = 0; x < key; x++) {   
        			if(ans.length() > (x+1) && ans.substring(ans.length()-x-1,ans.length()-x).equals(")")) {
        				saved = ans.substring(0, ans.length()-x-1);
        				append += ")";
        			} else {
        				append = "("+ append + ")";
        			}
    			}
    			ans = saved + append;
    		}
    	}
    	
    	
    	System.out.println("Case #" + i + ": " + ans);
    }
  }
}
