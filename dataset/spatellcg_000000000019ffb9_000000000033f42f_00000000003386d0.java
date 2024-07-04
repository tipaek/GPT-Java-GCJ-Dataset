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
        HashMap directionhole = new HashMap();
        List<long[]> directions = new ArrayList<long[]>();
        List<long[]> holes = new ArrayList<long[]>();
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
    						double count = (double) directioncount.get(k);
    						long[] ro = (long[]) directionhole.get(k);
    						if (k[1]*(ro[0]-to[0])==k[0]*(ro[1]-to[1])) {
    								ro[2] += 1;
    								double d = (double) ro[2];
//    								System.out.println(d);
    								count = (d+1)/2;
    								if (d==9) {
    									count = 2.5;
    								} if (d==5) {
    									count = 2.0;
    								}
    								directionhole.put(k,ro);
    						} else if (ro[2]==0.0){
    							if (ro[3]==0.0) {
    								count += 1;
    							} else {
    								count += 0.5/(ro[3]+1);
    							}
    							ro[3] += 1;
    							directionhole.put(k,ro);
    						} else if (ro[2]!=0.0) {
    							if (ro[3]==0.0) {
    								count += 1;
    							} else {
    								count += 0.5;
    							}
    							ro[3] += 1;
    							directionhole.put(k,ro);
    						}
//    						System.out.println(count);
    						directioncount.put(k,count);
    						exists = true;
    						break;
    					}
    				}
    				if (!exists) {
    					long [] vec = new long[2];
    					vec[0] = a;
    					vec[1] = b;
    					directions.add(vec);
    					directioncount.put(vec,1.0);
    					long [] hol = new long[4];
    					hol[0] = ho[0];
    					hol[1] = ho[1];
    					directionhole.put(vec,hol);
    				}
        		}
        		holes.add(ho);
        		}
        	}
        }
//        for (int[] k: steps) {
//        	System.out.println(k[0]+" "+k[1]);
//        }
        int number = 0;
        int maxi = 0;
        for (long[] d : directions) {
        	double m = (double) directioncount.get(d);
//        	System.out.println(m);
        	if (m>maxi) {
        		int mo = (int) m;
        		maxi = mo;
        	}
        }
        if (n>4) {
        if (2*maxi+2>n) {
        	number = n;
        } else {
        	number = 2*maxi+2;
        }
        } else {
        	number = n;
        }
        System.out.println("Case #"+i+": "+number);
    }
    System.out.close();
  }
}
