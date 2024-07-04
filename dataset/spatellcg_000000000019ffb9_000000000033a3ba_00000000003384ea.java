// package lec2;
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
        long l = in.nextLong();
        long r = in.nextLong();
        long m = (long) Math.sqrt(2*(l+r)) + 2;
        long counter = 0;
        for (int p = 1; p<=m; p++) { 
        	if (l>=r) {
        		if (l>=p) {
        			l = l-p;
        			counter += 1;
        		}
        	} else {
        		if (r>=p) {
        			r = r-p;
        			counter += 1;
        		}
        	}
        }
        System.o2ut.println("Case #"+i+": " + counter + " " + l  + " " + r);
    }
  }
}
