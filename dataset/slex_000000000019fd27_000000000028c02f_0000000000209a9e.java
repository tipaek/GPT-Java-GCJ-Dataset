import java.util.*;
import static java.lang.Math.*; 
import static java.util.Arrays.*;

import java.io.FileInputStream;

import static java.lang.Character.*;
import static java.lang.Double.*;


public class Solution {

	Scanner scan = new Scanner(System.in);
	int B;
	
	int get(int p) {
		System.out.println(p+1);
		System.out.flush();
		String r = scan.next();
		if(r.equals("1"))return 1;
		if(r.equals("0"))return 0;
		throw new RuntimeException("Invalid response "+r);
	}
	
	void solve() {
		int[]A = new int[B];
		fill(A,-1);
		int a = 0;int b = A.length-1;
		int q;
		for(q =1;q<=150;q++) {
			if(q%10 ==1) {
				if(a >= B-b)a--;
				int difCh = -1;
				int sameCh = -1;
				int aa=0;int bb=B-1;
				while(aa<a && bb>b) {
					// Fli: 00 -> 11; 01 -> 10
					// rev: 00 -> 00; 01 -> 10
					// f&r: 00 -> 11; 01 -> 01
					if(A[aa]==A[bb] && sameCh ==-1) {
						int x = get(aa);
						q++;
						if(x==A[aa]) sameCh =0;
						else sameCh=1;
					}
					if(A[aa]!=A[bb] && difCh==-1) {
						int x = get(aa);
						q++;
						if(x==A[aa])difCh=0;
						else difCh = 1;
					}
					aa++;bb--;
				}
				aa = 0;bb=B-1;
				while(aa<a) {
					if(A[aa]==A[bb] && sameCh==1) {
						A[aa]=1-A[aa];A[bb]=1-A[bb];
					}
					if(A[aa]!=A[bb] && difCh==1) {
						A[aa]=1-A[aa];A[bb]=1-A[bb];
					}
					aa++;bb--;
				}
			}
			if(a>b)break;
			if (a < B-b) {
				A[a]=get(a++);
			}else {
				A[b]=get(b--);
			}
		}
		
		
		
		char[]R = new char[B];
		for(int i=0;i<B;i++)R[i]=(char)(A[i]+'0');
		System.out.println(new String(R));
		String r = scan.next();
		//System.err.println("returning after "+q+" "+new String(R));
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
