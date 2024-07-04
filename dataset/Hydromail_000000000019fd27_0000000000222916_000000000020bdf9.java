import java.util.*;
import java.io.*;
public class Solution {
	  public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		    for (int i = 1; i <= t; i++) {
			    int c = in.nextInt();  
				boolean[] timeC = new boolean[1440];
				boolean[] timeJ = new boolean[1440];
				boolean isImpossible =false;
				StringBuilder sb = new StringBuilder();
				
		    	for (int j = 1; j <= c; j++) {
				    int start = in.nextInt();
				    int end = in.nextInt();
					boolean canC =true;
					boolean canJ =true;
					for (int a=start; a<end; a++) {
						if (timeC[a] && timeJ[a]) {
							isImpossible = true;
							break;
						}
						if (timeC[a] && !timeJ[a]) {
							canC = false;
						}
						if (!timeC[a] && timeJ[a]) {
							canJ = false;
						}
					}
					
					if (canC) {
						sb.append("C");
						for (int a=start; a<end; a++) {
							timeC[a] = true;
						}
					} else if (canJ) {
						sb.append("J");
						for (int a=start; a<end; a++) {
							timeJ[a] = true;
						}
					} else {
						break;
					}
		    	}
			  
				String s = sb.toString();
				
				if (isImpossible) {
					s = "IMPOSSIBLE";
				} 
				System.out.println("Case #" + i + ": " + s);
		    }
		  }
}