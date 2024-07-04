import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  
  public static void main(String[] args) throws Exception{
    Scanner in = new Scanner(System.in);
    int testCases = in.nextInt();
    for(int t=1;t<=testCases;t++) {
      int u = in.nextInt();
      Map<Long, Set<Character>> map = new TreeMap<>();
      for(int i=0;i<10000;i++) {
        long q = in.nextLong();
        String str = in.next();
        if((""+q).length() == str.length()) {
          long number = (long) Math.pow(10, str.length()-1);
          if(str.length() == 1) {
            number = 0;
          }
		  if(q > number+9){
            continue;
          }
          Set<Character> set = map.getOrDefault(q-number, new HashSet<Character>());
          set.add(str.charAt(str.length()-1));
          map.put(q-number,set);
        }
      }
	  String ans = "";
	  Set<Character> charSet = new HashSet<>();
	  for(long i=0;i<=9;i++) {
		  Set<Character> set = map.getOrDefault(i, new HashSet<>());
		  for(Character c : set) {
			  if(charSet.contains(c)) {
				  continue;
			  }
			  ans+=c;
			  charSet.add(c);
			  break;
		  }
	  }
      System.out.println("Case #"+t+": "+ans);
    }
  }
  
}