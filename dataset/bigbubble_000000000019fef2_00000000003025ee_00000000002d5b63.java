import java.io.*;
import java.util.*;

public class Solution {
	
    static Scanner sc;
    // Driver method 
    public static void main(String args[]) 
    { 
    	sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = sc.nextInt(); 
		int a = sc.nextInt();
		int b = sc.nextInt();
		//long border = 2; // 10^9
		long border = 1000*1000*1000;
		long hitx = 0;long hity = 0;
		for (int i = 1; i <= t; i++) {		
			boolean done = false; 
			boolean hit = false;
			for (int j = 1; j <= 7; j++) {
				for (int k = 1; k <= 7; k++) {
					long x1 = border*(-1) + 2*border*j/7;
					long y1 = border*(-1) + 2*border*k/7;
					System.out.println(x1 + " " + y1);
					System.out.flush();
					String judge = sc.next();
					check(judge);

					if (judge.equals("HIT") || judge.equals("CENTER")) {
						hitx = x1;
						hity = y1;
					}
				}
			}
			
			long l = hitx;
			long r = border;
			long rightmost = l;
			while(l <= r) {
				long m = (l+r)/2;
				//System.out.println(1);
				System.out.println(m + " " + hity);
				System.out.flush();
				String judge = sc.next();
				check(judge);

				if (judge.equals("HIT") || judge.equals("CENTER")) {
					rightmost = Math.max(rightmost, m);
					l = m+1;
				}else if (judge.equals("MISS")){
					r = m - 1;
				}
			}
			
			long d = border;
			long u = border*(-1);
			long upmost = d;
			while(u <= d) {
				long m = (u+d)/2;
				System.out.println(rightmost + " " + m);
				//System.out.println(1);


				System.out.flush();
				String judge = sc.next();
				check(judge);

				if (judge.equals("HIT") || judge.equals("CENTER")) {
					upmost = Math.min(upmost, m);
					d = m - 1;
				}else if (judge.equals("MISS")) {
					u = m + 1;
				}
			}
			
			d = border;
			u = (-1)*border;
			long downmost = u;
			while(u <= d) {				//System.out.println(1);

				long m = (u+d)/2;
				System.out.println(rightmost + " " + m);
				System.out.flush();
				String judge = sc.next();
				check(judge);

				if (judge.equals("HIT") || judge.equals("CENTER")) {
					downmost = Math.max(downmost, m);
					u = m + 1;
				}else if (judge.equals("MISS")) {
					d = m - 1;
				}
			}
			
			l = (-1)*border;
			r = border;
			long leftmost = r;
			while(l <= r) {				//System.out.println(1);

				long m = (l+r)/2;
				System.out.println(m + " " + upmost);
				System.out.flush();
				String judge = sc.next();
				check(judge);

				if (judge.equals("HIT") || judge.equals("CENTER")) {
					leftmost = Math.min(leftmost, m);
					r = m - 1;
				}else if (judge.equals("MISS")) {
					l = m + 1;
				}
			}
			
			long cenx = (leftmost+rightmost)/2;
			long ceny = (upmost + downmost)/2;
			boolean hitcenter = false;
			for (long j = -4; j <=4; j++) {				//System.out.println(1);

				if (hitcenter) break;
				for (long k = -4; k <= 4; k++) {
					if (hitcenter) break;
					long x1 = cenx + j;
					long x2 = ceny + k;
					System.out.println(x1 + " " + x2);
					System.out.flush();
					String judge = sc.next();
					check(judge);
					if (judge.equals("CENTER")) {
						hitcenter = true;
					}
				}
			}
		}
    } 
    public static void check(String s) {
    	if (s.equals("WRONG")) {
    		System.exit(1);
    	}
    }
}
