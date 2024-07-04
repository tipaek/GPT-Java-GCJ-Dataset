import java.util.*;
import static java.lang.Math.*; 
import static java.util.Arrays.*;

import java.io.FileInputStream;

import static java.lang.Character.*;
import static java.lang.Double.*;


public class Solution {

	Scanner scan = new Scanner(System.in);
	static long[][]NPK=new long[500][];
	
	void get(int x, int n, int k,ArrayList<int[]>A) {
		
	}
	
	
	static int doit(int x, int d) {
		if(x==1 && d==1) {
			//System.out.println(1);
			return 1;
		}
		if (x<d)return 0;
		int mx = (1<<d)-1;
		if(x>mx)return 0;
		int dd = doit(x-1,d-1);
		if(dd!=0) {
			//System.out.println(1);
			return 1 + dd;
		}
		int wh = 1<<(d-1);
		dd =doit(x-wh,d-1); 
		if(dd!=0) {
			//System.out.println(wh);
			return dd+d;
		}
		return 0;
	}
	
	
	static int getit(int x, int d, ArrayList<int[]> A, boolean left) {
		if(x==1 && d==1) {
			A.add(new int[] {1,1});
			return 1;
		}
		if (x<d)return 0;
		int mx = (1<<d)-1;
		if(x>mx)return 0;
		int dd = doit(x-1,d-1);
		if(dd!=0) {
			if(left) {
				A.add(new int[] {d,1});
			}else {
				A.add(new int[] {d,d});
			}
			getit(x-1,d-1,A,left);
			return 1 + dd;
		}
		int wh = 1<<(d-1);
		dd =doit(x-wh,d-1); 
		if(dd!=0) {
			//System.out.println(wh);
			if(left) {
				for(int i=1;i<=d;i++) {
					A.add(new int[] {d,i});
				}
				
			}else {
				for(int i=d;i>0;i--) {
					A.add(new int[] {d,i});
				}
			}
			getit(x-wh,d-1,A,!left);
			return dd+d;
		}
		return 0;
	}
	static ArrayList solve(int N) {
		for(int d=1;d<500;d++) {
			long ss=0;
			for(int i=0;i<NPK[d].length;i++) {
				ss+=NPK[d][i];
				if(ss>=N)break;
				int r = doit((int)(N-ss),d-1);
				if(r!=0) {
					ArrayList<int[]> A = new ArrayList<>();
					for(int j=i;j>=0;j--) {
						A.add(new int[] {d, j+1});
					}
					getit((int)(N-ss),d-1,A, true);
					return A;
				}
			}
		}
		return null;
	}
	
	String solve() {
		int N = scan.nextInt();
		if(N==1) return "\n1 1";
		ArrayList<int[]> A=solve(N);
		StringBuffer r = new StringBuffer();
		for(int i=A.size()-1;i>=0;i--) {
			int[]a=A.get(i);
			r.append("\n"+a[0]+" "+a[1]);
		}
		return r.toString();
	}
	
	static void test() {
		Random r = new Random();
		int mx =0;
		for(int t=0;t<100000;t++) {
			int x = 900000000+r.nextInt(100000000);
			ArrayList d = solve(x);
			if(d==null)System.err.println(x);
			mx = max(mx, d.size());
		}
		System.out.println("longset "+mx);
	}
	
	public static void main(String[] args) {
		NPK[1]=new long[] {1};
		for(int d=2;d<NPK.length;d++) {
			NPK[d]=new long[d];
			NPK[d][0]=NPK[d][d-1]=1;
			for(int i=1;i<d-1;i++)NPK[d][i]=NPK[d-1][i]+NPK[d-1][i-1];
		}
		//test();
		Solution me = new Solution();
		try{
			Class.forName("SlexTemplate");
			String sample =me.getClass().getName()+".in";
			me.scan = new Scanner(new FileInputStream(sample));
		}catch (Exception e) {
			System.err.println(e);
		}
		int n = me.scan.nextInt();
		for(int i=1;i<=n;i++) {
			String res = me.solve();
			System.out.format("Case #%d: %s\n", i, res);
		}
	}
}
