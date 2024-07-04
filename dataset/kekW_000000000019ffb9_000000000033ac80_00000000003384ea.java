import java.io.*; 
import java.util.*;

class Solution{
	public static void main(String[] args) throws IOException{
		FastIO sc = new FastIO(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cas = sc.nextInt();
		test: for(int t = 1; t<=cas; t++) {
			long l = sc.nextLong();
			long r = sc.nextLong();
			long idx = 0;
			if(l>=r) {
				long left = 0;
				long right = (long)1e10;
				while(left<right) {
					long mid = (left+right+1)/2;
					if(l-tri(mid)>=r) {
						left = mid;
					}else {
						right = mid-1;
					}
				}
				l-=tri(left);
				idx = left+1;
				//System.out.println(idx + " " + l);
			}else if(r>l) {
				long left = 0;
				long right = (long)1e10;
				while(left<right) {
					long mid = (left+right)/2;
					if(r-tri(mid)<=l) {
						right = mid;
					}else {
						left = mid+1;
					}
				}
				r-=tri(left);
				if(r<0) {
					//System.out.println("HI");
					r+=tri(left);
					left = 0;
					right = (long)1e9;
					while(left<right) {
						long mid = (left+right+1)/2;
						if(r-tri(mid)>=0) {
							left = mid;
						}else {
							right = mid-1;
						}
					}
					r-=tri(left);
				}
				idx = left+1;
				//System.out.println(r);
			}
			long left = 0;
			long right = (long)1e9;
			long leftbest = 0;
			long rightbest = 0;
			while(left<right) {
				long mid = (left+right+1)/2;
				if(l-ari(mid,idx)>=0) {
					left =mid;
				}else {
					right =mid-1;
				}
			}
			leftbest = left;
			left = 0;
			right = (long)1e9;
			while(left<right) {
				long mid = (left+right+1)/2;
				if(r-ari(mid,idx+1)>=0) {
					left = mid;
				}else {
					right = mid-1;
				}
			}
			rightbest = left;
			//System.out.println(leftbest + " " + rightbest);
			if(leftbest<=rightbest) {
				l-=ari(leftbest, idx);
				r-=ari(leftbest,idx+1);
				out.println("Case #" + t + ": " + (idx+2*leftbest-1) + " " + l + " " + r);
			}else {
				l-=ari(rightbest+1, idx);
				r-=ari(rightbest, idx+1);
				out.println("Case #" + t + ": " + (idx+2*rightbest) + " " + l + " " + r);
			}
		}
		out.close();
	}
	public static long ari(long num, long start) {
		return (num)*(start+(num-1)*2+start)/2;
	}
	public static long tri(long x) {
		return x*(x+1)/2;
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