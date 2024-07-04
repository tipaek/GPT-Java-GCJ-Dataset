import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
	final static int MOD = 998244353;
	public static void main(String args[]) throws Exception {
		int T = nextInt();
		for(int t=1;t<=T;t++) {
			int n = nextInt();
			int a[][] = new int[n][n];
			int tr = 0;
			int r = 0;
			int c = 0;
			for(int i=0;i<n;i++) {
				Set<Integer> vals = new HashSet<>();
				for(int j=0;j<n;j++) {
					a[i][j] = nextInt();
					if(i==j)
						tr+=a[i][j];
					vals.add(a[i][j]);
				}
				if(vals.size()<n) r++;
			}
			for(int i=0;i<n;i++) {
				Set<Integer> vals = new HashSet<>();
				for(int j=0;j<n;j++) {
					vals.add(a[j][i]);
				}
				if(vals.size()<n) c++;	
			}
			System.out.printf("Case #%d: %d %d %d\n",t,tr,r,c);
		}
		
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