import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

class Solution {
	InputStream is;
	PrintWriter out;
	String INPUT = "";

	void solve() {
		int T = ni();
		outer:
		for(int t = 1; t <= T; t++) {
			int n = ni();
			String[] s = new String[n];
			for(int i = 0; i < n; i++) {
				s[i] =ns();
			}
			Trie trie = new Trie();
			for(int i = 0; i < n; i++) {
				trie.add(new String(new StringBuilder(s[i].substring(1)).reverse()));
			}
			String ret = trie.get();
			out.println("Case #"+t+": "+new String(new StringBuilder(ret).reverse()));
		}
	}
	
//	public boolean ok(String[] s) {
//		int n = s.length;
//		for(int i = 0; i < n; i++) {
//			int firstLastStar = s[i].lastIndexOf('*');
//			String lastFirst = s[i].substring(firstLastStar+1);
//			int x = s[i].indexOf('*');
//			String y = s[i]
//			for(int j = i+1; j < n; j++) {
//				int secondLastStar = s[j].lastIndexOf('*');
//				String lastSecond = s[j].substring(secondLastStar+1);
//				if(!check1(lastFirst.toCharArray(), lastSecond.toCharArray(), firstLastStar == -1 && secondLastStar == -1)) return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean check1(char[] s, char[] t, boolean special) {
//		int n = s.length, m = t.length;
//		int i, j;
//		for(i = n-1, j = m-1; i >= 0 && j >= 0; i--, j--) {
//			if(s[i] != t[j]) return false;
//		}
//		if(special) {
//			return i == -1 && j == -1;
//		}
//		return true;
//	}
//	
//	public boolean check2(char[] s, char[] t, boolean special) {
//		int n = s.length, m = t.length;
//		int i, j;
//		for(i = 0, j = 0; i < n && j < m; i++, j++) {
//			if(s[i] != t[j]) return false;
//		}
//		if(special) {
//			return i == n && j == m;
//		}
//		return true;
//	}
	
	public class Trie
	{
		public TrieNode root;
		public class TrieNode
		{
			char c;
			TrieNode[] chd;
			
			public TrieNode() {
				chd = new TrieNode[26];
			}
		}
		
		public Trie() {
			root = new TrieNode();
		}
		
		public void add(String t) {
			char[] s = t.toCharArray();
			TrieNode cur = root;
			for(char c : s) {
				if(cur.chd[c - 'A'] == null) {
					cur.chd[c - 'A'] = new TrieNode();
				}
				cur = cur.chd[c - 'A'];
			}
		}
		
		public String get() {
			StringBuilder sb = new StringBuilder();
			TrieNode cur = root;
			while(!isEmpty(cur)) {
				String s = ok(cur);
				if(s.length() > 1) return "*";
				sb.append(s);
				if(s.length() == 0) break;
				if(s.length() == 1) {
					cur = cur.chd[s.charAt(0) - 'A'];
				}
			}
			return sb.toString();
		}
		
		public String ok(TrieNode cur) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 26; i++) {
				if(cur.chd[i] != null) sb.append((char)(i+'A')) ;
			}
			return sb.toString();
		}
		
		public boolean isEmpty(TrieNode cur) {
			int ct = 0;
			for(int i = 0; i < 26; i++) {
				if(cur.chd[i] != null) ct++; 
			}
			return ct == 0;
		}
	}
	
	void run() throws Exception {
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);

		long s = System.currentTimeMillis();
		solve();
		out.flush();
		if (!INPUT.isEmpty())
			tr(System.currentTimeMillis() - s + "ms");
	}

	public static void main(String[] args) throws Exception {
		new Solution().run();
	}

	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;

	private int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	private boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	private int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	private double nd() {
		return Double.parseDouble(ns());
	}

	private char nc() {
		return (char) skip();
	}

	private String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	private char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	private char[][] nm(int n, int m) {
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
		return map;
	}

	private int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}

	private int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	private long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	private static void tr(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
}