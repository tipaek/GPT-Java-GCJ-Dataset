import java.util.*;
import java.io.*;
public class Solution{
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
    	List<int[]> hits = new ArrayList<int[]>();
    	List<int[]> misses = new ArrayList<int[]>();
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
        if (r== 999999950) {
        	for (int j= 0; j<10; j++) {
        		int num = 99999950-10*j;
        		System.out.println("0 " + num);
        		result = in.next();
        		int[] arr = {0, num};
        		if (result.equals("HIT")) {
        			hits.add(arr);
        		} else if (result.equals("MISS")) {
        			misses.add(arr);
        		}
        	}
        	for (int k=-50; k<=50;k++) {
        		for (int m=-50; m<=50; m++) {
        			boolean valid = true;
        			for (int[] ar : hits) {
        				if (Math.sqrt(Math.pow(m-ar[0], 2)+Math.pow(k-ar[1], 2)) <= r) {
        					continue;
        				} else {
        					valid = false;
        					break;
        				}
        			}
        			if (valid) {
        				for (int[] ary : misses) {
        					if (Math.sqrt(Math.pow(m-ary[0], 2)+Math.pow(k-ary[1], 2)) > r) {
            					continue;
            				} else {
            					valid = false;
            					break;
            				}
        				}
        			}
        			if (valid) {
        				System.out.println(m + " " + k);
        				result = in.next();
            			if (result.equals("CENTER")) {
            				break;
            			} else {
            				continue;
            			}
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