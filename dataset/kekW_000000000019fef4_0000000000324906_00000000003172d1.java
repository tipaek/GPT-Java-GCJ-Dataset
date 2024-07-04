import java.io.*; 
import java.util.*;

class Solution{
	public static void main(String[] args) throws IOException{
		FastIO sc = new FastIO(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cas = sc.nextInt();
		test: for(int t = 1; t<=cas; t++) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			long arr[] = new long[n];
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextLong();
			}
			Arrays.sort(arr);
			if(d==2) {
				for(int i=0; i<n-1; i++) {
					if(arr[i]==arr[i+1]) {
						System.out.println("Case #" + t + ": " + 0);
						continue test;
					}
				}
				System.out.println("Case #" + t + ": " + 1);
				continue test;
			}else {
				TreeMap<Long, Integer> mp = new TreeMap<>();
				for(int i=0; i<n; i++) {
					mp.put(arr[i], 1);
				}
				for(int i=0; i<n-2; i++) {
					if(arr[i]==arr[i+1]&&arr[i]==arr[i+2]) {
						System.out.println("Case #" + t + ": " + 0);
						continue test;
					}
				}
				for(int i=0; i<n-2; i++) {
					if(arr[i]==arr[i+1]) {
						System.out.println("Case #" + t + ": " + 1);
						continue test;
					}
				}
				for(int i=0; i<n; i++) {
					if(arr[i]%2==1) continue;
					if(mp.containsKey(arr[i]/2)) {
						System.out.println("Case #" + t + ": " + 1);
						continue test;
					}
				}
				System.out.println("Case #" + t + ": " + 2);
			}
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