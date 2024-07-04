
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

// Solution
public class Solution {
	static InputStream is;
	static PrintWriter out;
	static String INPUT = "";
	
	// 
	
	static void solve()
	{
		for(int T = ni(), cas = 1;T > 0;T--,cas++){
			out.print("Case #" + cas + ": ");
			int K = ni(), n = ni();
			long[] xs= new long[n];
			for(int i = 0;i < n;i++)xs[i] = nl() * 2;
			na(n);
			
			// fullcheck
			boolean ok = true;
			if(n % 2 == 1){
				long s = -xs[0];
				for(int i = 1, sg = 1;i < n;i++, sg = -sg){
					s += xs[i] * 2 * sg;
				}
				// 2 6 8
				// 12-16+12
				s += xs[0] + 2*K;
				long X = s/2 + xs[0];
				for(int i = 0;i < n;i++){
					long ne = i+1 < n ? xs[i+1] : xs[0] + 2*K;
					if(xs[i] < X && X < ne){
						X = 2*ne - X;
					}else{
						ok = false;
						break;
					}
				}
			}else{
				long sup = xs[1] - xs[0];
				long inf = 0;
				long s = -xs[0];
				for(int i = 1, sg = 1;i < n;i++, sg = -sg){
					s += 2 * xs[i] * sg;
					long ne = i+1 < n ? xs[i+1] : xs[0] + 2*K;
					if(i % 2 == 1){
						inf = Math.max(inf, s - ne);
					}else{
						sup = Math.min(sup, s + ne);
					}
				}
				if(sup - inf >= 2){
					long X = inf + 1 + xs[0];
					for(int i = 0;i < n;i++){
						long ne = i+1 < n ? xs[i+1] : xs[0] + 2*K;
						if(xs[i] < X && X < ne){
							X = 2*ne - X;
						}
					}
					ok = X == (inf + 1 + xs[0] + 2*K);
				}else{
					ok = false;
				}
			}
			if(ok){
				out.println(n);
				continue;
			}
			
			long[] ys = new long[2*n+2];
			for(int i = 0;i < n;i++){
				ys[i] = xs[i];
				ys[i+n] = (long)xs[i]+2*K;
			}
			ys[2*n] = ys[0] + 4L*K;
			ys[2*n+1] = ys[1] + 4L*K;
			
			boolean[][] valid = new boolean[2*n+1][2*n+1];
			for(int i = 0;i < 2*n+1;i++){
				long sup = ys[i+1] - ys[i];
				long inf = 0;
				valid[i][i] = true;
				long s = -ys[i];
				for(int j = i+1, sg = 1;j <= 2*n;j++, sg = -sg){
					s += 2 * ys[j] * sg;
					long ne = ys[j+1];
					if((j-i) % 2 == 1){
						inf = Math.max(inf, s - ne);
					}else{
						sup = Math.min(sup, s + ne);
					}
					if(inf + 2 <= sup){
						valid[i][j] = true;
					}else{
						break;
					}
				}
			}
			
			int[][] dp = new int[2*n+1][2*n+1];
			for(int len = 1;len <= n+1;len++){
				for(int i = 0;i+len-1 < 2*n+1;i++){
					int j = i+len-1;
					
					if(valid[i][j]){
						dp[i][j] = j-i + 1;
					}else{
						dp[i][j] = 2*n+1;
						for(int k = i;k <= j;k++){
							dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
						}
					}
				}
			}
			long ans = Long.MAX_VALUE;
			for(int i = 0;i < n;i++){
				ans = Math.min(ans, dp[i][i+n]);
			}
			out.println(ans);
		}
	}
	public static void tf(boolean[]... b)
	{
		for(boolean[] r : b) {
			for(boolean x : r)System.out.print(x?'#':'.');
			System.out.println();
		}
		System.out.println();
	}

	
	public static void main(String[] args) throws Exception
	{
		long S = System.currentTimeMillis();
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		
		solve();
		out.flush();
		long G = System.currentTimeMillis();
		tr(G-S+"ms");
	}
	
	private static boolean eof()
	{
		if(lenbuf == -1)return true;
		int lptr = ptrbuf;
		while(lptr < lenbuf)if(!isSpaceChar(inbuf[lptr++]))return false;
		
		try {
			is.mark(1000);
			while(true){
				int b = is.read();
				if(b == -1){
					is.reset();
					return true;
				}else if(!isSpaceChar(b)){
					is.reset();
					return false;
				}
			}
		} catch (IOException e) {
			return true;
		}
	}
	
	private static byte[] inbuf = new byte[1024];
	static int lenbuf = 0, ptrbuf = 0;
	
	private static int readByte()
	{
		if(lenbuf == -1)throw new InputMismatchException();
		if(ptrbuf >= lenbuf){
			ptrbuf = 0;
			try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
			if(lenbuf <= 0)return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private static boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
//	private static boolean isSpaceChar(int c) { return !(c >= 32 && c <= 126); }
	private static int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
	
	private static double nd() { return Double.parseDouble(ns()); }
	private static char nc() { return (char)skip(); }
	
	private static String ns()
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while(!(isSpaceChar(b))){
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private static char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private static char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}
	
	private static int[] na(int n)
	{
		int[] a = new int[n];
		for(int i = 0;i < n;i++)a[i] = ni();
		return a;
	}
	
	private static int ni()
	{
		int num = 0, b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private static long nl()
	{
		long num = 0;
		int b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private static void tr(Object... o) { if(INPUT.length() != 0)System.out.println(Arrays.deepToString(o)); }
}
