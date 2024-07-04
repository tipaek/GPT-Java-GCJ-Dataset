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
    	for(int s = 0; s < keys.length; s++) {
    		int key = Integer.parseInt(keys[s]);
    		if(key == 0) {
    			ans += 0;
    		} else {
    			String append = key + "";
    			String saved = ans;
    			for(int x = 0; x < key; x++) {   
        			if(saved.length() > (x+1) && saved.substring(saved.length()-1).equals(")")) {
        				//System.out.println("?"+ saved.substring(saved.length()-1));
        				saved = saved.substring(0, saved.length()-1);
        				//System.out.println("s"+saved);
        			
            			append += ")";
        			} else {
        				append = "("+ append + ")";
        			}
    			}
    			ans = saved + append;
    		}
    		//System.out.println(ans);
    	}
    	
    	
    	System.out.println("Case #" + i + ": " + ans);
    }
  }
}
