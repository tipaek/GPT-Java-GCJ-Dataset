import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
        String ans = new String("");
        int b = in.nextInt();
        if (b==10) {
        	for (int k=1; k<=b;k++) {
        		System.out.println(k);
        		String c = in.next();
        		ans = ans.concat(c);
        	}
        }
        System.out.println(ans);
        String result = in.next();
        if (result.equals("Y")) {
            continue;
        } else {
            in.close();
            break;
        }
        
    }
  }
}