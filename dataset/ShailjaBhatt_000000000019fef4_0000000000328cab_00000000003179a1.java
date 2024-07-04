

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
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
			int U = Integer.parseInt(br.readLine());
			int[] st = new int[10];
			boolean[] zero = new boolean[10];
			for (int i = 0;i<10;i++) {
				st[i] = 9;
				zero[i] = true;
			}
			int ind_st = 0;
			boolean flag = false;
			HashMap<String,Integer> hs = new HashMap<String,Integer>();
			for (int i = 0;i<10000;i++) {
				String[] in = br.readLine().trim().split(" ");
				if (in[0].trim().equals("-1")) {
					if (U == 2) {
						in[0] = "99";
					}
					else {
						in[0] = "9999999999999999";
					}
//					flag = true;
					
				}
				for (int j = 0;j<in[1].length();j++) {
					if (!hs.containsKey(in[1].substring(j,j+1))) {
						hs.put(in[1].substring(j,j+1), ind_st);
						ind_st++;
					}
				}
				
				if (in[0].length() == in[1].length()) {
					st[hs.get(in[1].substring(0,1))] = Math.min(st[hs.get(in[1].substring(0,1))], Integer.parseInt(in[0].substring(0,1)));
					
				}
				zero[hs.get(in[1].substring(0,1))] = false;
			}
			
			String ans = "";
			String[] alp = new String[10];
			for (Entry<String, Integer> entry : hs.entrySet()) {
			    alp[entry.getValue()] = entry.getKey();
			}
			boolean[] done = new boolean[10];
			for (int i = 0;i<10;i++) {
				if (zero[i]) {
					ans = alp[i] + ans;
					done[i] = true;
					break;
				}
			}
//			if (flag) {
//				for (int i = 0;i<10;i++) {
//					if (!done[i]) {
//						ans = ans + alp[i];
//					}
//				}
//			}
//			else {
				sortt[] so = new sortt[9];
				int j = 0;
				for (int i = 0;i<10;i++) {
					if (!done[i]) {
						so[j] = new sortt();
						so[j].i = st[i];
						so[j].s = alp[i];
						j++;
					}
				}
				Arrays.sort(so);
				for (int i = 0;i<9;i++) {
					ans = ans + so[i].s;
				}
//				System.out.println(Arrays.toString(st));
//				System.out.println(Arrays.toString(alp));
//				System.out.println(Arrays.toString(zero));
				
//			}
			
			
			System.out.println("Case #" + (t1-t) + ": "+ans);
			
			
			
		}
    }
	
	
}
class sortt implements Comparable<sortt>{
	int i;
	String s;
	@Override
	public int compareTo(sortt arg0) {
		if (i > arg0.i) {
			return 1;
		}
		else if (i < arg0.i) {
			return -1;
		}
		
		return 0;
	}
	
}
