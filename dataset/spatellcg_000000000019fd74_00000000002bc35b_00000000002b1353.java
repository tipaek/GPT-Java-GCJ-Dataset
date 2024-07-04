import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
        int target = in.nextInt();
        if (target<5) {
        	System.out.println("Case #" + i + ":");
        	for (int j=1; j <= target; j++) {
        		System.out.println(j + " 1");
        	}
        	continue;
        }
        if (target<100000) {
        	int depth = (int) (Math.sqrt((2*target-2))-1);
        	int sum = 0;
        	System.out.println("Case #" + i + ":");
        	System.out.println("1 1");
        	sum += 1;
        	if (depth < 0) {
        		continue;
        	} else {
        		for (int n = 2; n<depth+2; n++) {
        			System.out.println(n + " 2");
        			sum += (n-1);
        		}
        	}
        	int remainder = target - 1 - (depth*(depth+1)/2);
        	for (int m = depth+1; m<=depth+remainder; m++) {
        		System.out.println(m + " 1");
        		sum += 1;
        	}
//        	if (sum == target) {
//        		System.out.println("SUCCESS");
//        	}
        }
    }
  }
}