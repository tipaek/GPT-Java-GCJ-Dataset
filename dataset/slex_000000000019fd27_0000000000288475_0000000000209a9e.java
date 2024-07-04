import java.util.*;
import static java.lang.Math.*; 
import static java.util.Arrays.*;

import java.io.FileInputStream;

import static java.lang.Character.*;
import static java.lang.Double.*;


public class Solution {

	Scanner scan = new Scanner(System.in);
	int B;
	
	void solve() {
		int[]A = new int[B];
		fill(A,-1);
		for(int q=0;q<10;q++) {
			System.out.println(q+1);
			String r = scan.next();
			if(r.charAt(0)=='N')throw new RuntimeException("Invalid response");
			A[q]=r.charAt(0)=='1'?1:0;
		}
		char[]R = new char[B];
		for(int i=0;i<B;i++)R[i]=(char)(A[i]+'0');
		System.out.println(new String(R));
		String r = scan.next();
		if(r.equals("Y"))return;
		System.err.println("invalid answer");
		System.exit(0);
	}
	
	public static void main(String[] args) {
		Solution me = new Solution();
		
		int n = me.scan.nextInt();
		me.B = me.scan.nextInt();
		for(int i=1;i<=n;i++) {
			me.solve();
			
		}
	}
}
