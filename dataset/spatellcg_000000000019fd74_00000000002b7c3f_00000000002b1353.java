import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
        int target = in.nextInt();
        if (target<1001) {
        	int depth = (int) (Math.sqrt((2*target-2))-1);
        	System.out.println("Case #" + i + ":");
        	System.out.println("1 1");
        	if (depth < 0) {
        		continue;
        	} else {
        		for (int n = 2; n<depth+2; n++) {
        			System.out.println(n + " 2");
        		}
        	}
        	int remainder = target - 1 - (depth*(depth+1)/2);
        	for (int m = depth+1; m<=depth+remainder; m++) {
        		System.out.println(m + " 1");
        	}
        }
    }
  }
}