import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

// Solution
public class Solution {
	static InputStream is;
	static PrintWriter out;
	static String INPUT = "";
	
	static void solve()
	{
		for(int T = ni(), cas = 1;T > 0;T--,cas++){
			out.print("Case #" + cas + ": ");
			go();
		}
	}
	
	static void go()
	{
		int n = ni();
		int[][] co = new int[n][];
		for(int i = 0;i < n;i++){
			co[i] = na(2);
		}
		if(n == 1){
			out.println(1);
			return;
		}
		Set<Long> cache = new HashSet<>();
		int max = 0;
		for(int i = 0;i < n;i++){
			for(int j = i+1;j < n;j++){
				long dx = co[j][0] - co[i][0], dy = co[j][1] - co[i][1];
				long[] lco = new long[n];
				for(int k = 0;k < n;k++){
					lco[k] = dy*co[k][0]-dx*co[k][1];
				}
				Arrays.sort(lco);
				int[] cs = uniqcountOnly(lco);
				Arrays.sort(cs);
				long h = 0;
				for(int c : cs){
					h = h * 1000000009 + c;
				}
				if(cache.add(h)){
					max = Math.max(max, solve(cs));
				}
			}
		}
		out.println(max);
	}
	
	static int solve(int[] cs)
	{
		int n = 0;
		for(int c : cs){
			n += c;
		}
		gmax = 0;
		int[] to = new int[n];
		Arrays.fill(to, -1);
		dfs(0, cs, to);
		return gmax;
	}
	
	static void dfs(int cur, int[] cs, int[] to)
	{
		int n = to.length;
		if(cur == n){
			test(cs, to);
			return;
		}
		
		if(to[cur] == -1){
			for(int i = cur+1;i < n;i++){
				if(to[i] == -1){
					to[cur] = i;
					to[i] = cur;
					dfs(cur+1, cs, to);
					to[i] = to[cur] = -1;
				}
			}
		}
		dfs(cur+1, cs, to);
	}
	
	static int gmax = 0;
	
	static void test(int[] cs, int[] to)
	{
		int n = to.length;
		for(int i = 0;i < n;i++){
			int ved = 0;
			int vedfrom = 0;
			int cur = i;
			inner:
			while(true){
				if(vedfrom<<~cur<0)break;
				vedfrom |= 1<<cur;
				ved |= 1<<cur;
				if(to[cur] == -1)break;
				cur = to[cur];
				ved |= 1<<cur;
				int o = 0;
				for(int u : cs){
					if(o <= cur && cur < o+u){
						if(cur+1 == o+u)break inner;
					}
					o += u;
				}
				cur++;
			}
			gmax = Math.max(gmax, Integer.bitCount(ved));
		}
	}
	
	public static int[] uniqcountOnly(long[] a)
	{
		int n = a.length;
		int p = 0;
		int[] b = new int[n];
		long prev = Long.MIN_VALUE;
		for(int i = 0;i < n;i++){
			if(i == 0 || a[i] != prev)p++;
			b[p-1]++;
			prev = a[i];
		}
		return Arrays.copyOf(b, p);
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
