//trace= sum of values on main diagonal (UL-LR)
//Latin suare =N*N matrix with diffrent values  between 1-N
//compute the no of rows and no of columns that have repeated values
//Output - test case #x: k trace   r row  c column
//

import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int ar[][]=new int[n][n];
      for (int j = 0; j < ar.length; j++) {
		for (int j2 = 0; j2 < ar.length; j2++) {
			ar[j][j2]=in.nextInt();
		}
	}
      /*for (int j = 0; j < ar.length; j++) {
  		for (int j2 = 0; j2 < ar.length; j2++) {
  			System.out.print(ar[j][j2]);
  		}
  		System.out.println();
  	}*/
      int trace=0;
      for (int j = 0; j < ar.length; j++) {
  		for (int j2 = 0; j2 < ar.length; j2++) {
  			if(j==j2) {
  				trace+=ar[j][j2];
  			}
  		}
  	}
     // System.out.println(trace);
      
      // to find duplicates in row
      int r=0;
     
     // HashMap<Integer, Integer> col=new HashMap<>();
      
      for (int j = 0; j < ar.length; j++) {
    	  HashMap<Integer, Integer> row=new HashMap<>();
		for (int j2 = 0; j2 < ar.length; j2++) {
			if(row.containsKey(ar[j][j2])) {
				row.put(ar[j][j2], row.get(ar[j][j2])+1);
			}else {
				row.put(ar[j][j2], 1);
			}
		}
		if(row.size()!=n) {
			r++;
		}
	}
     // System.out.println(r);
      
      //to find duplicates in column
      
      int c=0;
      
      for (int j = 0; j < ar.length; j++) {
    	  HashMap<Integer, Integer> col=new HashMap<>();
		for (int j2 = 0; j2 < ar.length; j2++) {
			if(col.containsKey(ar[j2][j])) {
				col.put(ar[j2][j], col.get(ar[j2][j])+1);
			}else {
				col.put(ar[j2][j], 1);
			}
		}
		if(col.size()!=n) {
			c++;
		}
	}
     // System.out.println(c);
      
      
      System.out.println("Case #" + i + ": " + (trace) + " " + (r)+ " " + (c));
    }
  }
}