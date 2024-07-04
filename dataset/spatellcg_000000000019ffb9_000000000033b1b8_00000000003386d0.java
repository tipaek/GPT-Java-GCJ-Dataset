// package lec2;
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
        int n = in.nextInt();
        HashMap directioncount = new HashMap();
        List<long[]> directions = new ArrayList<long[]>();
        List<long[]> holes = new ArrayList<long[]>();
        int max = 1;
        for (int j = 1; j<=n; j++) {
        	long[] ho = new long[2];
        	ho[0] = in.nextLong();
        	ho[1] = in.nextLong();
        	if (j==1) {
        		holes.add(ho);
        	} else {
        		if (n>4) {
        		for (long[] to: holes) {
        			long a = (to[0]-ho[0]);
    				long b = (to[1]-ho[1]);
    				boolean exists = false;
    				for (long[] k: directions) {
    					if (k[0]*b==k[1]*a) {
    						int count = (int) directioncount.get(k);
    						directioncount.put(k,count+1);
    						if (count+1>max) {
    							max = count + 1;
    						}
    						exists = true;
    						break;
    					}
    				}
    				if (!exists) {
    					long [] vec = new long[2];
    					vec[0] = a;
    					vec[1] = b;
    					directions.add(vec);
    					directioncount.put(vec,1);
    				}
        		}
        		holes.add(ho);
        		}
        	}
        }
        int number = 0;
        if (n>4) {
        if (2*max+2>n) {
        	number = n;
        } else {
        	number = 2*max+2;
        }
        } else {
        	number = n;
        }
        System.out.println("Case #"+i+": "+number);
    }
    System.out.close();
  }
}
