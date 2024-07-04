import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

// Solution
public class Solution {
	static Scanner in;
	static PrintWriter out;
	static String INPUT = "";
	
	static int get(int pos)
	{
		out.println(pos+1);
		out.flush();
		return ni();
	}
	
	static void solve()
	{
		int T = ni(), B = ni();
		for(int cas = 1;T > 0;T--,cas++){
//			int all = 0;
//			all += B;
//			for(int i = 0;i < B/2;i+=20){
//				all += 2;
//				for(int j = 0;j < 4 && i+j*5+5 <= B/2;j++){
//					all += 2;
//				}
//			}
//			all = (all+9)/10*10;
//			for(int i = 0;i < 150-all;i++){
//				get(0);
//			}

			int[] a = new int[B];
			for(int i = 0;i < B/2;i+=5){
				for(int j = i;j < i+5;j++){
					a[j] = get(j);
					a[B-1-j] = get(B-1-j);
				}
			}
//			all -= B;
			// 25+25
			// (20+20)
			for(int i = 0;i < B/2;i+=20){
				modify(a, 0, i);
//				all -= 2;
				for(int j = 0;j < 4 && i+j*5+5 <= B/2;j++){
					modify(a, i+j*5, i+j*5+5);
//					all -= 2;
				}
			}
//			for(int i = 0;i < all;i++)get(0);
			for(int v : a){
				out.print(v);
			}
			out.println();
			out.flush();
			
			char got = in.next().charAt(0);
			if(got == 'N')return;
			assert got == 'Y';
		}
	}
	
	static void modify(int[] a, int l, int r)
	{
		if(l == r){
			get(0);
			get(0);
			return;
		}
		int B = a.length;
		int ps = -1, pd = -1;
		for(int i = l;i < r;i++){
			if(a[i] == a[B-1-i]){
				ps = i;
			}else{
				pd = i;
			}
		}
		int s = get(Math.max(0, ps));
		int d = get(Math.max(0, pd));
		if(ps == -1){
			boolean flip = d != a[pd];
			for(int i = l;i < r;i++){
				if(flip){
					a[i] ^= 1; a[B-1-i] ^= 1;
				}
			}
			return;
		}
		if(pd == -1){
			boolean flip = s != a[ps];
			for(int i = l;i < r;i++){
				if(flip){
					a[i] ^= 1; a[B-1-i] ^= 1;
				}
			}
			return;
		}
		
		boolean flip = false, rev = false;
		if(s == a[ps]){
			if(d == a[pd]){
			}else{
				rev = true;
			}
		}else{
			if(d == a[pd]){
				flip = rev = true;
			}else{
				flip = true;
			}
		}
		for(int i = l;i < r;i++){
			if(flip){
				a[i] ^= 1; a[B-1-i] ^= 1;
			}
			if(rev){
				int t = a[i]; a[i] = a[B-1-i]; a[B-1-i] = t;
			}
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		long S = System.currentTimeMillis();
		in = INPUT.isEmpty() ? new Scanner(System.in) : new Scanner(INPUT);
		out = new PrintWriter(System.out);
		
		solve();
		out.flush();
		long G = System.currentTimeMillis();
		tr(G-S+"ms");
	}
	
	static int ni() { return Integer.parseInt(in.next()); }
	static void tr(Object... o) { if(!INPUT.isEmpty())System.out.println(Arrays.deepToString(o)); }
}
