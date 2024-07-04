import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		Reader rd = new Reader();
		int t = Integer.parseInt(rd.readLine());
		int x = 0;
		while(x < t) {
			x++;
			int n = rd.ni();
			/*
			Interval[] arr = new Interval[n];
			for(int i=0;i<n;i++) {
				//arr[i] = new Interval(rd.ni(), rd.ni());
			}*/
			int[][] event = new int[2*n][3];
			for(int i=0;i<2*n;i+=2) {
				event[i][0] = rd.ni(); //start time
				event[i][1] = 0; // start
				event[i][2] = i/2; //id
				event[i+1][0] = rd.ni(); //end time
				event[i+1][1] = 1; //end
				event[i+1][2] = i/2; //id
			}
			Arrays.sort(event, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					if(o1[0] == o2[0]) {
						if(o1[1] == 0) {
							return 1;
						}
						else return -1;
					}
					else{
						return o1[0] - o2[0];
					}
				}
				
			});
			char[] ans = new char[n];
			int d = 0;
			Stack<Character> st = new Stack<Character>();
			st.push('C');st.push('J');
			for(int i=0;i<2*n;i++) {
				if(event[i][1]==0) {
					if(d==2) {
						ans = "IMPOSSIBLE".toCharArray();
						break;
					}
					d++;
					//allocating C or J
					ans[event[i][2]] = st.pop();
				}
				else if(event[i][1]==1) {
					d--;
					st.push(ans[event[i][2]]);
				}
			}
			//System.out.println(Arrays.deepToString(event));
			System.out.println("Case #"+x+": "+String.valueOf(ans));
		}
	}
//	static boolean isOverlap(Interval a, Interval b) {
//		return Math.max(a.s,b.s) <= Math.min(a.e,b.e);
//	}
//	
//	static class Interval implements Comparable<Interval>{
//		int s,e;
//		public Interval(int start, int end) {
//			s = start;
//			e = end;
//		}
//		@Override
//		public int compareTo(Interval o) {
//			// TODO Auto-generated method stub
//			if(this.s - o.s != 0)
//				return this.s - o.s;
//			return this.e - o.e;
//		}
//	}
////////////////////////////////////fast reader
////////////////////////////////////starts/////////////////////////////////////
	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public int[] nia(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = ni();
			}
			return arr;
		}

		public long[] nla(int n) throws IOException {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nl();
			}
			return arr;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[1000]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int ni() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nl() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nd() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
}
