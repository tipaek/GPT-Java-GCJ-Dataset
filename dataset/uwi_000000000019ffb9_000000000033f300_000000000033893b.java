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
		for(int T = ni(), cas = 1;T > 0;T--,cas++){
			out.print("Case #" + cas + ": ");
			go();
		}
	}
	
	static void go()
	{
		int n = ni(), Q = ni();
		char[] s = ("(" + ns() + ")").toCharArray();
		na(n);
		na(n);
		na(n);
		n += 2;
		
		int[] to = new int[n];
		int[] cs = new int[n];
		int[] depraw = new int[n];
		int h = 0;
		for(int i = 0;i < n;i++){
			if(s[i] == '('){
				cs[h] = i;
				depraw[i] = h;
				h++;
			}else{
				h--;
				depraw[i] = h;
				to[i] = cs[h];
				to[cs[h]] = i;
			}
		}
		
		int[] map = new int[n];
		Arrays.fill(map, -1);
		int gen = 0;
		for(int i = 0;i < n;i++){
			if(s[i] == '('){
				map[i] = gen++;
			}
		}
		
		temp = new int[n];
		
		int u = n/2;
		int[][] ch = new int[n/2][];
		dfs(0, map, to, ch);
		
		
		int[] inds = new int[n/2];
		inds[0] = -1;
		for(int i = 0;i < n/2;i++){
			for(int j = 0;j < ch[i].length;j++){
				inds[ch[i][j]] = j;
			}
		}
		
		int[] par = childrenToParent(ch);
		int[][] spar = logstepParents(par);
		
		int m = spar.length;
		int[][] sg = new int[m][u];
		int[][] pl0 = new int[m][u];
		int[][] pl1 = new int[m][u];
		// sg:0:same, 1:+, -1:-
		for(int i = 1;i < u;i++){
			int L = inds[i];
			int R = ch[par[i]].length - inds[i] - 1;
			if(L == R){
				sg[0][i] = 0;
				pl0[0][i] = 2*L + 1;
				pl1[0][i] = 2*L + 1;
			}else if(L < R){
				sg[0][i] = 1;
				pl0[0][i] = 2*L + 1;
				pl1[0][i] = 2*L + 2;
			}else{
				sg[0][i] = -1;
				pl0[0][i] = 2*R + 2;
				pl1[0][i] = 2*R + 1;
			}
		}
		
		for (int j = 1; j < m; j++) {
			for (int i = 0; i < u; i++) {
				if(spar[j][i] == -1){
					continue;
				}else{
					int sp = spar[j-1][i];
					if(sg[j-1][i] == 0){
						sg[j][i] = sg[j-1][sp];
						pl0[j][i] = pl0[j-1][sp] + pl0[j-1][i];
						pl1[j][i] = pl1[j-1][sp] + pl1[j-1][i];
					}else if(sg[j-1][sp] == 0){
						sg[j][i] = sg[j-1][i];
						pl0[j][i] = pl0[j-1][sp] + pl0[j-1][i];
						pl1[j][i] = pl1[j-1][sp] + pl1[j-1][i];
					}else if(sg[j-1][i] == 1){
						sg[j][i] = sg[j-1][sp];
						pl0[j][i] = pl0[j-1][sp] + pl0[j-1][i];
						pl1[j][i] = pl0[j-1][sp] + pl1[j-1][i];
					}else{
						sg[j][i] = sg[j-1][sp];
						pl0[j][i] = pl1[j-1][sp] + pl0[j-1][i];
						pl1[j][i] = pl1[j-1][sp] + pl1[j-1][i];
					}
				}
			}
		}
		
		int[] ss = na(Q);
		int[] ts = na(Q);
		
		int[] dep = new int[u];
		for(int i = 0;i < n;i++){
			if(map[i] != -1){
				dep[map[i]] = depraw[i];
			}
		}
		
		long ans = 0;
		for(int z = 0;z < Q;z++){
			int ls = ss[z];
			int lt = ts[z];
			int mls = map[Math.min(ls, to[ls])];
			int mlt = map[Math.min(lt, to[lt])];
			int sls = s[ls] == '(' ? 0 : 1;
			int slt = s[lt] == '(' ? 0 : 1;
			int lca = lca2(mls, mlt, spar, dep);
			if(lca != mls && lca != mlt){
				if(mls > mlt){
					{int d = mls; mls = mlt; mlt = d;}
					{int d = sls; sls = slt; slt = d;}
				}
				int ancs = ancestor(mls, dep[mls] - dep[lca] - 1, spar);
				int anct = ancestor(mlt, dep[mlt] - dep[lca] - 1, spar);
				assert inds[ancs] < inds[anct];
				int[] ress = get(mls, dep[mls] - dep[lca] - 1, spar, sg, pl0, pl1, sls);
				int[] rest = get(mlt, dep[mlt] - dep[lca] - 1, spar, sg, pl0, pl1, slt);
				int lans = Integer.MAX_VALUE;
				lans = Math.min(lans, ress[1] + (inds[anct] - inds[ancs]) * 2 - 1 + rest[0]);
				if(lca != 0){
					lans = Math.min(lans, ress[0] + rest[1] + inds[ancs] * 2 + 1 + (ch[lca].length-inds[anct]-1) * 2 + 1 + 1);
				}
				ans += lans;
			}else if(lca == mlt){
				int[] ress = get(mls, dep[mls] - dep[lca], spar, sg, pl0, pl1, sls);
				ans += ress[slt];
			}else{
				int[] ress = get(mlt, dep[mlt] - dep[lca], spar, sg, pl0, pl1, slt);
				ans += ress[sls];
			}
		}
		out.println(ans);
	}
	
	static int[] get(int cur, int up, int[][] spar, int[][] sg, int[][] pl0, int[][] pl1, int state)
	{
		int val = 0;
		for(int d = spar.length-1;d >= 0;d--){
			if(up<<~d<0){
				int trans = sg[d][cur];
				val += state == 0 ? pl0[d][cur] : pl1[d][cur];
				if(trans == 1){
					state = 0;
				}else if(trans == -1){
					state = 1;
				}
				cur = spar[d][cur];
			}
		}
		if(state == 0){
			return new int[]{val, val+1};
		}else{
			return new int[]{val+1, val};
		}
	}
	
	public static int[] childrenToParent(int[][] children)
	{
		int n = children.length;
		int[] ret = new int[n];
		Arrays.fill(ret, -1);
		for(int i = 0;i < n;i++){
			for(int q : children[i]){
				ret[q] = i;
			}
		}
		return ret;
	}
	
	static int[] temp;
	
	static void dfs(int cur, int[] map, int[] to, int[][] ch)
	{
		int p = 0;
		int goal = to[cur];
		int x = cur + 1;
		while(x < goal){
			temp[p++] = map[x];
			x = to[x] + 1;
		}
		ch[map[cur]] = Arrays.copyOf(temp, p);
		x = cur + 1;
		while(x < goal){
			dfs(x, map, to, ch);
			x = to[x] + 1;
		}
	}
	
	public static int lca2(int a, int b, int[][] spar, int[] depth) {
		if (depth[a] < depth[b]) {
			b = ancestor(b, depth[b] - depth[a], spar);
		} else if (depth[a] > depth[b]) {
			a = ancestor(a, depth[a] - depth[b], spar);
		}

		if (a == b)
			return a;
		int sa = a, sb = b;
		for (int low = 0, high = depth[a], t = Integer.highestOneBit(high), k = Integer
				.numberOfTrailingZeros(t); t > 0; t >>>= 1, k--) {
			if ((low ^ high) >= t) {
				if (spar[k][sa] != spar[k][sb]) {
					low |= t;
					sa = spar[k][sa];
					sb = spar[k][sb];
				} else {
					high = low | t - 1;
				}
			}
		}
		return spar[0][sa];
	}

	protected static int ancestor(int a, int m, int[][] spar) {
		for (int i = 0; m > 0 && a != -1; m >>>= 1, i++) {
			if ((m & 1) == 1)
				a = spar[i][a];
		}
		return a;
	}

	public static int[][] logstepParents(int[] par) {
		int n = par.length;
		int m = Integer.numberOfTrailingZeros(Integer.highestOneBit(n - 1)) + 1;
		int[][] pars = new int[m][n];
		pars[0] = par;
		for (int j = 1; j < m; j++) {
			for (int i = 0; i < n; i++) {
				pars[j][i] = pars[j - 1][i] == -1 ? -1 : pars[j - 1][pars[j - 1][i]];
			}
		}
		return pars;
	}

	
	public static void main(String[] args) throws Exception
	{
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		
		Thread t = new Thread(null, null, "~", Runtime.getRuntime().maxMemory()){
			@Override
			public void run() {
				long s = System.currentTimeMillis();
				solve();
				out.flush();
				if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
			}
		};
		t.start();
		t.join();

//		
//		long S = System.currentTimeMillis();
//		
//		solve();
//		out.flush();
//		long G = System.currentTimeMillis();
//		tr(G-S+"ms");
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
