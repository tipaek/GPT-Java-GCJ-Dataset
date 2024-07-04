import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static Queue<Integer> A;
	static Queue<Integer> B;
	
	static int[] rr;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
          int r = in.nextInt();
          int s = in.nextInt();
          
          process(i, r, s);
        }
	}
	
	static void process(int c, int r, int s) {
		A = new LinkedList<>();
		B = new LinkedList<>();
		
		rr = new int[r*s];
		
		int idx = 0;
		for (int i = 1; i <= s; ++i) {
			for (int j = 1; j <= r; ++j) {
				rr[idx++] = j;
			}
		}
		
		
		dorec(r, s);
		System.out.println("Case #" + c + ": " + A.size());
		while (!A.isEmpty()) {
			System.out.println(A.poll() + " " + B.poll());
		}
	}
	
	static void dorec(int r, int s) {
		int val = r;
		int c = 0;
		int idx = r*s - 1;
		while (idx >= 0 && rr[idx] == val) {
			++c;
			--idx;
			if (c == s) {
				--val;
				c = 0;
			}
		}
		
		int sidx = idx;
		if (idx >= 0 && rr[idx] != val) {
			
			while (idx >= 0 && rr[idx] != val) {
				--idx;
			}
			
			A.add(idx + 1);
			B.add(sidx - idx);
			
			for (int k = 0; k < sidx - idx; ++k) {
				int srr = rr[idx + k + 1];
	
				for (int l = idx; l >= 0; --l) {
					rr[l + k + 1] = rr[l + k];
				}
				rr[k] = srr;
			}
		
			dorec(r,s);
		}
	}

}
