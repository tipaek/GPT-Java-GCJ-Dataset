import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    int a = in.nextInt();
    int b = in.nextInt();
    int r = 0;
    if (a==b) {
    	r = a;
    }
    for (int i = 1; i <= t; ++i) {
    	String result = new String();
        if (r== 999999995) {
        	for (int k=-5; k<=5;k++) {
        		for (int m=-5; m<=5; m++) {
        			System.out.println(m + " " + k);
        			result = in.next();
        			if (result.equals("CENTER")) {
        				break;
        			} else {
        				continue;
        			}
        		}
        		if (result.equals("CENTER") ) {
        			break;
        		}
        	}
        }
    }
  }
}