import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = input.nextInt();
    for (int i = 1; i <= t; ++i) {
      int u = input.nextInt();
      input.nextLine();
      char[] d = new char[10];
      int[] found = new int[10];
      for (int j = 0; j < 10; j++) {
    	  found[i] = -1;
      }
      
      int min = 0;
      HashSet<Character> seen = new HashSet();
      for (int j = 0; j < 10000; j++) {
    	  String l = input.nextLine();
    	  int m = Integer.parseInt(l.split(" ")[0]);
    	  String r = l.split(" ")[1];
    	  int m1 = m;
    	  int len = 0;
    	  while (m1 > 10) {
    		  m1 = m1 / 10;
    		  len++;
    	  }
    	  len++;
    	  if (m1 == min && (r.length() == len) && !seen.contains(r.charAt(0))) {
    		  d[min - 1] = r.charAt(0);
    		  min++;
    		  seen.add(r.charAt(0));
    	  }
    	  if (m == 10 && (r.length() == 2)) {
    		  d[0] = r.charAt(1);
    		  min++;
    	  }
    	  
    	  
      }
      
      String output = new String(d);
      System.out.println("case #" + i + ": "+ output);
      
      
    }
  }
}