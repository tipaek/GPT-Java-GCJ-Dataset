import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
        int target = in.nextInt();
        if (target<501) {
        	System.out.println("Case #" + i + ":");
        	for (int j=1; j <= target; j++) {
        		System.out.println(j + " 1");
        	}
        }
        if (target == 501) {
        	System.out.println("Case #" + i + ":");
        	System.out.println("1 1");
        	System.out.println("2 1");
        	System.out.println("3 1");
        	System.out.println("3 2");
        	System.out.println("3 3");
        	for (int j=3; j<=497; j++) {
        		System.out.println(j+ " " +j);
        	}
        }
    }
  }
}