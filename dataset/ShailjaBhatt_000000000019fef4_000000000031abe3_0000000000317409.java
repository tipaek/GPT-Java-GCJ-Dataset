

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
			int X = Integer.parseInt(in[0]);
			int Y = Integer.parseInt(in[1]);
			String M = in[2];
			int n = M.length();
			int ans = 1000000;
			for (int i = 0;i<n;i++) {
				if (M.charAt(i) == 'E') {
					X++;
				}
				else if(M.charAt(i) == 'W') {
					X--;
				}
				else if(M.charAt(i) == 'S') {
					Y--;
				}
				else {
					Y++;
				}
				if (i+1 >= Math.abs(X) + Math.abs(Y)) {
					ans = Math.min(ans, i+1);
				}
			}
			
			if (ans != 1000000) {
				System.out.println("Case #" + (t1-t) + ": "+ans);
			}
			else {
				System.out.println("Case #" + (t1-t) + ": "+"IMPOSSIBLE");
			}
			
		}
    }
	
	
}

