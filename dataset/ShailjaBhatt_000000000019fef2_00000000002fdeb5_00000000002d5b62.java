

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
//		System.out.println(fun("H*O","HELLO*"));
//		System.out.println(3);
		int t = Integer.parseInt(br.readLine());
		int t1 = t;
//		
		while (t -- > 0) {
			String[] in = br.readLine().trim().split(" ");
			int n = Integer.parseInt(in[0]);
			int m = Integer.parseInt(in[1]);
			String ans = "";
			String hdir = (n < 0)?"W":"E";
			String vdir = (m < 0)?"S":"N";
			String nhdir = (n >= 0)?"W":"E";
			String nvdir = (m >= 0)?"S":"N";
			n = Math.abs(n);
			m = Math.abs(m);
			if(n%2 ==0 && m%2  == 0) {
				ans = "IMPOSSIBLE";
			}
			else if(n%2 !=0 && m%2  != 0) {
				ans = "IMPOSSIBLE";
			}
			else {
				int temp = (n | m);
				if (((n & m) == 0) && (temp & (temp+1)) == 0) {
					while (n > 0 && m > 0) {
						ans = ans + ((n%2==1)?hdir:vdir);
						n = n/2;
						m = m/2;
					}
					while (n > 0) {
						ans = ans + hdir;
						n = n/2;
					}
					while (m > 0) {
						ans = ans + vdir;
						m = m/2;
					}
				}
				else {
					if (m%2 == 1) {
						m = m+2;
					}
					else {
						n = n+2;
					}
					if (((n & m) == 0) && (temp & (temp+1)) == 0) {
						ans = ans + ((n%2==1)?nhdir:nvdir);
						n = n/2;
						m = m/2;
						while (n > 0 && m > 0) {
							ans = ans + ((n%2==1)?hdir:vdir);
							n = n/2;
							m = m/2;
						}
						while (n > 0) {
							ans = ans + hdir;
							n = n/2;
						}
						while (m > 0) {
							ans = ans + vdir;
							m = m/2;
						}
					}
					else {
						ans = "IMPOSSIBLE";
					}
				}
				
			}
			System.out.println("Case #" + (t1-t) + ": "+ans);
		}
    }
	
	
}

