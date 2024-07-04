import java.io.*;
import java.util.*;

public class Solution {
	
	static long num;
	static long L;
	static long R;
	static long rmax = (long)Math.pow(10, 9);
	static BufferedWriter bw;
	static int t;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(t = 1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			L = Long.parseLong(st.nextToken());
			R = Long.parseLong(st.nextToken());
			num = 1;
			
			if(L == R) {
				solve();
			}
			else if(L > R) {
				long diff = L-R;
				long temp = calc1(0, 2*rmax, diff);
				L -= (temp*(temp+1))/2;
				num = temp+1;
				//System.out.println(num + " " + L + " " + R);
				solve();
			}
			else {
				long diff = R-L;
				long temp = calc(0, 2*rmax, diff);
				
				if((temp+1)*(temp+2) <= 2*R) {
					num = temp+2;
					R -= ((temp+1)*(temp+2))/2;
					solve();
				}
				else {
					long rans = R - (temp*(temp+1))/2;
					bw.write("Case #" + t + ": " + temp + " " + L + " " + rans+"\n");
					continue;
				}
				
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void solve() throws IOException {
		long temp = calc2(0, rmax+1, L);
		long lans = L - (temp*num + (temp-1)*temp);
		if(temp*num + temp*temp <= R) {
			long rans = R - (temp*num + temp*temp);
			bw.write("Case #" + t + ": " + (num+2*temp-1) + " " + lans + " " + rans+"\n");
		}
		else {
			long rans = R - ((temp-1)*num + (temp-1)*(temp-1));
			bw.write("Case #" + t + ": " + (num+2*temp-2) + " " + lans + " " + rans+"\n");
		}
		
	}
	public static long calc2(long a, long b, long diff) {
		
		if(a>=b) {
			return a;
		}
		if(b == a+1) {
			if(b*num + b*b - b <= diff) {
				return b;
			}
			else {
				return a;
			}
		}
		
		long mid = (a+b)/2;
		if(mid*num + mid*mid - mid <=diff) {
			return calc2(mid, b, diff);
		}
		else {
			return calc2(a, mid-1, diff);
		}
	}
	public static long calc1(long a, long b, long diff) {
		if(a>=b) {
			return a;
		}
		if(b == a+1) {
			if(b*(b+1) <= 2*diff) {
				return b;
			}
			else {
				return a;
			}
		}
		
		long mid = (a+b)/2;	
		if(mid*(mid+1) <= 2*diff) {
			return calc1(mid, b, diff);
		}
		else {
			return calc1(a, mid-1, diff);
		}
	}
	
	public static long calc(long a, long b, long diff) {
		if(a>=b) {
			return a;
		}
		if(b == a+1) {
			if(b*(b+1) < 2*diff) {
				return b;
			}
			else {
				return a;
			}
		}
		
		long mid = (a+b)/2;	
		if(mid*(mid+1) < 2*diff) {
			return calc(mid, b, diff);
		}
		else {
			return calc(a, mid-1, diff);
		}
	}
}


