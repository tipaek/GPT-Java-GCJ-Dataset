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
        if (r== 999999950) {
            int counter = 0;
        	int rx = 1000000000;
        	int lx = -1000000000;
        	int uy = 1000000000;
        	int by = -1000000000;
        	for (int j= 0; j<=100; j++) {
        		int num = rx-j;
        		int a = 0;
        		if (counter == 300) {
        		    break;
        		}
        		System.out.println(num + " " + a);
        		counter += 1;
        		result = in.next();
        		if (result.equals("MISS")) {
        			continue;
        		} else if (result.equals("HIT")) {
        			rx = num;
        			break;
        		}
        	}
        	for (int j= 0; j<=100; j++) {
        		int num = lx+j;
        		int a = 0; 
        		if (counter == 300) {
        		    break;
        		}
        		System.out.println(num + " " + a);
        		counter += 1;
        		result = in.next();
        		if (result.equals("MISS")) {
        			continue;
        		} else if (result.equals("HIT")) {
        			lx = num;
        			break;
        		}
        	}
        	for (int j= 0; j<=100; j++) {
        		int num = by+j;
        		int a = 0;
        		if (counter == 300) {
        		    break;
        		}
        		System.out.println(a+ " " + num);
        		counter += 1;
        		result = in.next();
        		if (result.equals("MISS")) {
        			continue;
        		} else if (result.equals("HIT")) {
        			by = num;
        			break;
        		}
        	}
        	for (int j= 0; j<=100; j++) {
        		int num = uy-j;
        		int a = 0;
        		if (counter == 300) {
        		    break;
        		}
        		System.out.println(a+ " " + num);
        		counter += 1;
        		result = in.next();
        		if (result.equals("MISS")) {
        			continue;
        		} else if (result.equals("HIT")) {
        			uy = num;
        			break;
        		}
        	}
        	int y = (uy+by)/2;
        	int x = (rx+lx)/2;
        	if (counter<300) {
        	    System.out.println(x + " " + y);
        	    result = in.next();
        	}
        	}
    }
  }
}