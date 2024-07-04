

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class prac{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int t = Integer.parseInt(br.readLine());
		int t1 = t;
		while (t -- > 0) {
			
			int n =  Integer.parseInt(br.readLine());
			String[] in = br.readLine().trim().split(" ");
			int[] st = new int[n];
			int L = 0;
			int R = 0;
			if (n%2 == 1) {
				L++;
			}
			for (int i = 0;i<n;i++) {
				int temp = Integer.parseInt(in[i])-1;
				if (L == R) {
					if (temp%2 == 1) {
						if (temp-1 < 0 || st[temp-1] == 0) {
							st[temp] = 1;
						}
						else {
							st[temp] = (st[temp-1] == 1)?2:1;
						}
						
					}
					else {
						if (temp+1 >= n || st[temp+1] == 0) {
							st[temp] = 1;
						}
						else {
							st[temp] = (st[temp+1] == 1)?2:1;
						}
					}
				}
				else if (L > R) {
					st[temp] = 2;
				}
				else {
					st[temp] = 1;
				}
				if (st[temp] == 1) {
					L++;
				}
				else if (st[temp] == 2){
					R++;
				}
			}
			String count = "";
			for (int i = 0;i<n;i++) {
				count = count + ((st[i] == 1)?"L":"R");
			}
			System.out.println("Case #" + (t1-t) + ": " + count);
		}
	}
	
}