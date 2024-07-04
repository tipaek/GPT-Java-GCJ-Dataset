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
	
	static void solve()
	{
		outer:
		for(int T = ni(), cas = 1;T > 0;T--,cas++){
			out.print("Case #" + cas + ": ");
			int n = ni();
			char[][] ss = new char[n][];
			for(int i = 0;i < n;i++){
				ss[i] = ns().toCharArray();
			}
			int premaxlen = -1, prearg = 0;
			for(int i = 0;i < n;i++){
				for(int j = 0;j < ss[i].length;j++){
					if(ss[i][j] == '*'){
						if(j > premaxlen){
							premaxlen = j;
							prearg = i;
						}
						break;
					}
				}
			}
			
			int sufmaxlen = -1, sufarg = 0;
			for(int i = 0;i < n;i++){
				for(int j = 0;j < ss[i].length;j++){
					if(ss[i][ss[i].length-1-j] == '*'){
						if(j > sufmaxlen){
							sufmaxlen = j;
							sufarg = i;
						}
						break;
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0;i < premaxlen;i++){
				sb.append(ss[prearg][i]);
			}
			
			for(int i = 0;i < n;i++){
				int start = 0, last = 0;
				for(int j = 0;j < ss[i].length;j++){
					if(ss[i][j] == '*'){
						start = j+1;
						break;
					}
				}
				for(int j = 0;j < ss[i].length;j++){
					if(ss[i][ss[i].length-1-j] == '*'){
						last = ss[i].length-1-j;
						break;
					}
				}
				for(int j = start;j < last;j++){
					if(ss[i][j] != '*'){
						sb.append(ss[i][j]);
					}
				}
			}
			
			for(int i = 0;i < sufmaxlen;i++){
				sb.append(ss[sufarg][ss[sufarg].length-sufmaxlen+i]);
			}
			
			char[] can = sb.toString().toCharArray();
			for(int i = 0;i < n;i++){
				if(!pmatch(ss[i], can, premaxlen, sufmaxlen)){
					out.println("*");
					continue outer;
				}
			}
			out.println(new String(can));
		}
	}
	
	static boolean pmatch(char[] q, char[] s, int plen, int slen)
	{
		for(int i = 0;i < plen && i < q.length;i++){
			if(q[i] == '*')break;
			if(q[i] != s[i])return false;
		}
		for(int i = 0;i < slen && i < q.length;i++){
			if(q[q.length-1-i] == '*')break;
			if(q[q.length-1-i] != s[s.length-1-i])return false;
		}
		return true;
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
