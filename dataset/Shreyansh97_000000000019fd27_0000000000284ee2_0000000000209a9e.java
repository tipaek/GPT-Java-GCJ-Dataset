import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
	final static int MOD = 998244353;
	static int n, q;
	static int a[];
	static List<Integer> same, diff;
	public static void main(String args[]) throws Exception {
		int T = nextInt();
		n = nextInt();
		for(int t=1;t<=T;t++) {
			a = new int[n];
			Arrays.fill(a,-1);
			same = new ArrayList<>();
			diff = new ArrayList<>();
			q = 0;
			int counter = 0;
			while(counter<n) {
				if(q%10==0 && fixBoth() && fixSame() && fixDiff());
				if(q%10==9) {
					query(0);
					continue;
				}
				int i = counter/2;
				int j = pair(i);
				a[i] = query(i);
				a[j] = query(j);
				counter += 2;
				if(isSame(i))
					same.add(i);
				if(isDifferent(i))
					diff.add(i);
			}
			StringBuilder sb = new StringBuilder();
			for(int i:a)
				sb.append(i);
			System.out.println(sb);
			String s = next();
		}
	}

	static boolean fixBoth() {
		if(same.isEmpty() || diff.isEmpty())
			return true;
		int sm = a[same.get(0)] ^ query(same.get(0));
		int df = a[diff.get(0)] ^ query(diff.get(0));
		if(sm == 0 && df==1)
			rev();
		if(sm == 1 && df==0) {
			rev();
			flip();
		}
		if(sm==1 && df==1)
			flip();
		return false;
	} 

	static boolean fixSame() {
		if(same.isEmpty())
			return true;
		if((a[same.get(0)] ^ query(same.get(0))) == 1)
			flip();
		return false;
	}

	static boolean fixDiff() {
		if(diff.isEmpty())
			return true;
		int idx = diff.get(0);
		int old = a[idx];
		int nval = query(idx);
		if((a[diff.get(0)] ^ query(diff.get(0))) == 1)
			flip();
		return false;
	}

	static int query(int b) {
		try {
			System.out.println(b+1);
			q++;
			return nextInt();
		} catch(Exception e) {
			return -1;
		}
	}

	static void flip() {
		for(int i=0;i<n;i++) {
			if(a[i]>=0)
				a[i] = 1-a[i];
		}
	}
	static void rev() {
		for(int i=0;i<n/2;i++) {
			int t = a[i];
			a[i] = a[n-i-1];
			a[n-i-1] = t;
		}
	}

	static int pair(int i) {
		return n-i-1;
	}

	static boolean isSame(int i) {
		return i!=pair(i) && a[i]==a[pair(i)];
	}

	static boolean isDifferent(int i) {
		return i!=pair(i) && a[i]!=a[pair(i)];	
	} 

	static long modpow(long a, long b) {
		if(b==0)
			return 1;
		if(b==1)
			return a;
		long x = modpow(a,b/2);
		x = (x * x) % MOD;
		if(b%2==1)
			x = (x * a) % MOD;
		return x;
	}

	static long modinv(long a) {
		return modpow(a,MOD-2);
	}

	static double nextDouble() throws IOException {
		InputStream in = System.in;
		double ans=0;
		boolean flag = true;
		byte b = 0;
		boolean neg = false;
		double pow = 0.1;
		boolean dec = false;
		while((b>=45 && b<58) || flag) {
			if(b==45)
				neg = true;
			else if(b==46) {
				dec = true;
				pow = 0.1;
			}
			else if(b>=48 && b<58) {
				if(dec) {
					ans += (b-48)*pow;
					pow /= 10.0;
				}
				else
					ans = ans*10+(b-48);
				flag = false;
			}
			b=(byte)in.read();
		}
		if(neg)
			return -ans;
		return ans;
	}
	static int nextInt()throws IOException{
		InputStream in=System.in;
		int ans=0;
		boolean flag=true;
		byte b=0;
		boolean neg=false;
		while ((b>47 && b<58) || flag){
			if(b==45)
				neg=true;
			if(b>=48 && b<58){
				ans=ans*10+(b-48);
				flag=false;
			}
			b=(byte)in.read();
		}
		if(neg)
			return -ans;
		return ans;
	}

	static long nextLong()throws IOException{
		InputStream in=System.in;
		long ans=0;
		boolean flag=true;
		byte b=0;
		while ((b>47 && b<58) || flag){
			if(b>=48 && b<58){
				ans=ans*10+(b-48);
				flag=false;
			}
			b=(byte)in.read();
		}
		return ans;
	}

	static String next() throws IOException {
		StringBuilder sb = new StringBuilder(1 << 16);
		InputStream in=System.in;
		int b = in.read();
		while (sb.length() == 0 || !Character.isWhitespace(b)) {
			if (!Character.isWhitespace(b)) {
				sb.append((char) b);
			}
			b = in.read();
		}
		return sb.toString();
	}
	static boolean isWhiteSpace(byte b){
		char ch=(char)b;
		return ch=='\0' || ch==' ' || ch=='\n';
	}
}