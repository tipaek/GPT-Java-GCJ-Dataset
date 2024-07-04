package com.contests.codecJam;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

 class Solution {

	private static final String NEWLINE = "\n";
	private static final String SPACE = " ";
	private static final String COLON = ":";
	private static final String CASE = "Case #";

	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		int t = 1;
		while (t <= T) {
			StringBuilder sb = new StringBuilder();
			int x = in.nextInt(); 
			int y = in.nextInt();
			List<Character> path = new ArrayList<Character>();
			Set<Pair> vis = new HashSet<Solution.Pair>();
			min = new ArrayList<Character>();
			dfs(0,0,x,y,path,vis);
			
			sb.append(CASE).append(t).append(COLON).append(SPACE);
			if (min.isEmpty()) {
				sb.append("IMPOSSIBLE");
			} else {
				for (char ch : min) {
					sb.append(ch);
				}
			}
			System.out.println(sb);
			t++;
		}
		in.close();
	}

	private static List<Character> min = new ArrayList<Character>();
	static int size = 102;
	private static void dfs(int i, int j, int x, int y, List<Character> path, Set<Pair> vis) {
		if (i>5 || i<-5) return;
		if (j>5 || j<-5) return;
		Pair pr = new Pair(i,j);
		if (vis.contains(pr)) return;
		if (i == x && j == y) {
			if (min.isEmpty()) {
				for (char ch : path) {
					min.add(ch);
				}
			} else if (path.size() < min.size()) {
				min = new ArrayList<Character>();
				for (char ch : path) {
					min.add(ch);
				}
			}
			return;
		}
		
		vis.add(pr);
		
		if (Math.abs(i+getD(path))<size) {
			path.add('E');
			dfs(i+getD(path),j,x,y,path,vis);
			backtrack(path, vis, pr);
		} 
		if (Math.abs(i-getD(path))<size) {
			path.add('W');
			dfs(i-getD(path),j,x,y,path,vis);
			backtrack(path, vis, pr);
		} 
		if (Math.abs(j+getD(path))<size) {
			path.add('N');
			dfs(i,j+getD(path),x,y,path,vis);
			backtrack(path, vis, pr);
		} 
		if (Math.abs(j-getD(path))<size) {
			path.add('S');
			dfs(i,j-getD(path),x,y,path,vis);
			backtrack(path, vis, pr);
		}
	}

	private static int getD(List<Character> path) {
		if (path.isEmpty()) return 0;
		return (int)(Math.pow(2, path.size()-1));
	}

	private static void backtrack(List<Character> path, Set<Pair> vis, Pair pr) {
		vis.remove(pr);
		if (!path.isEmpty())
		path.remove(path.size()-1);
	}

	static class Pair {
		Integer x;
		Integer y;
		private Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == null || !(o instanceof Pair))
				return false;
			Pair cor = (Pair)o;
			return x.equals(cor.x) && y.equals(cor.y);
		}
		
		@Override
		public int hashCode() {
			int result = 17;
			result = result + 31*x;
			result = result + 31*y;
			return result;
		}
		
		static class PairComparatorX implements Comparator<Pair> {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.x.compareTo(o2.x);
			}
			
		}

		static class PairComparatorY implements Comparator<Pair> {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.y.compareTo(o2.y);
			}
			
		}

	}
	
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

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
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

		public long nextLong() throws IOException {
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

		public double nextDouble() throws IOException {
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