import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int[] s = new int[n];
	  int[] e = new int[n];
	  String sch = "";
	  for(int j=1; j<=n; j++){
	      s[j-1] = in.nextInt();
	      e[j-1] = in.nextInt();
	  }
	  loop:for(int u=0; u<n; u++) {
			if(!tConflict(s,e,sch,'C',s[u],e[u])) {
				sch += 'C';
			} else if(!tConflict(s,e,sch,'J',s[u],e[u])) {
				sch += 'J';
			} else {
				sch = "IMPOSSIBLE";
				break loop;
			}
		}
      System.out.println("Case #" + i + ": " + sch);
    }
  }

public static boolean tConflict(int[] starts, int[] ends, String s, char P, int start, int end) {
			boolean conflict = false;
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i)==P) {
					if(((start>starts[i])&&(start<ends[i]))||((end>starts[i])&&(end<ends[i])))
						conflict = true;
				}
			}
			return conflict;
		}
    
}