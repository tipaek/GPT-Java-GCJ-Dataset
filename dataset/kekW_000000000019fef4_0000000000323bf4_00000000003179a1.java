import java.io.*;
import java.util.*;
public class Solution{
	public static void main(String[] args) throws IOException{
		FastIO sc = new FastIO(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cas = sc.nextInt();
		test:for(int t=1; t<=cas; t++) {
			int u = sc.nextInt();
			TreeMap<Character, Integer> mp = new TreeMap<>();
			int idx = 0;
			String ans = "";
			long occ[] = new long[10];
			long firstocc[] = new long[10];
			char lett[] = new char[10];
			for(int i = 0; i<10000; i ++) {
				int q = sc.nextInt();
				String str = sc.next();
				int n = str.length();
				if(!mp.containsKey(str.charAt(0))) {
					mp.put(str.charAt(0), idx);
					lett[idx] = str.charAt(0);
					idx++;
				}
				//if(str.charAt(0)=='A')out.println("BAD");
				firstocc[mp.get(str.charAt(0))]++;
				for(int j=1; j<n; j++) {
					if(!mp.containsKey(str.charAt(j))) {
						mp.put(str.charAt(j), idx);
						lett[idx] = str.charAt(j);
						idx++;
					}
					occ[mp.get(str.charAt(j))]++;
				}
			}
			boolean used[] = new boolean[10];
			for(int i=0; i<10; i++) {
				//System.out.println((firstocc[i] + occ[i])  + " " + lett[i]);
				if(firstocc[i]==0) {
					ans = ans + lett[i];
					used[i] = true;
				}
			}
			first:for(int i=0; i<10; i++) {
				if(used[i]) {
					//System.out.println(lett[i] + " used");
					continue;
				}
				//System.out.println((occ[i]+firstocc[i]) + " " + lett[i]);
				//System.out.println(i);
				//System.out.println(occ[1] + firstocc[1]);
				for(int j=0; j<10; j++) {
					if(j==i) continue;
					if(used[j]) continue;
					//System.out.println(i + " " + (occ[j]+firstocc[j]));
					if(firstocc[j]>firstocc[i]) {
						continue first;
					}
				}
				ans = ans + Character.toString(lett[i]);
				used[i] = true;
				if(ans.length()>=10) break;
				
					i =-1;
					//System.out.println("HI " + i);
				//occ[i] = 0;
				//firstocc[i] = 0;
			}
			System.out.println("Case #" + t + ": " + ans);
			
		}
		
		out.close();
  	}
	static class FastIO {
		 
		// Is your Fast I/O being bad?
 
		InputStream dis;
		byte[] buffer = new byte[1 << 17];
		int pointer = 0;
 
		public FastIO(String fileName) throws IOException {
			dis = new FileInputStream(fileName);
		}
 
		public FastIO(InputStream is) throws IOException {
			dis = is;
		}
 
		int nextInt() throws IOException {
			int ret = 0;
 
			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			boolean negative = false;
			if (b == '-') {
				negative = true;
				b = nextByte();
			}
			while (b >= '0' && b <= '9') {
				ret = 10 * ret + b - '0';
				b = nextByte();
			}
 
			return (negative) ? -ret : ret;
		}
 
		long nextLong() throws IOException {
			long ret = 0;
 
			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			boolean negative = false;
			if (b == '-') {
				negative = true;
				b = nextByte();
			}
			while (b >= '0' && b <= '9') {
				ret = 10 * ret + b - '0';
				b = nextByte();
			}
 
			return (negative) ? -ret : ret;
		}
 
		byte nextByte() throws IOException {
			if (pointer == buffer.length) {
				dis.read(buffer, 0, buffer.length);
				pointer = 0;
			}
			return buffer[pointer++];
		}
 
		String next() throws IOException {
			StringBuffer ret = new StringBuffer();
 
			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			while (b > ' ') {
				ret.appendCodePoint(b);
				b = nextByte();
			}
 
			return ret.toString();
		}
 
	}
}