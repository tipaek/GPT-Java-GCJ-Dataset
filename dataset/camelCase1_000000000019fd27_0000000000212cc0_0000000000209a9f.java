import java.util.*;
import java.io.*;
public class Solution {

	static BufferedReader br;
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = nextInt();
		int l = 1;
		while(t --> 0) {
			String s = next();
			char[] arr = s.toCharArray();
			int[] op = new int[arr.length];
			int[] close = new int[arr.length + 1];
			boolean flag = false;
			for(int j = 0; j < arr.length; j++)
				if(arr[j] == '0')
					arr[j] = '-';
			for(int i = 1; i < 10; i++) {
				for(int j = 0; j < arr.length; j++) {
					if(arr[j] == '-' && flag) {
						flag = false;
						close[j]++;
					}
					if(arr[j] != '-' && !flag) {
							flag = true;
							op[j]++;
					}
					if(arr[j] == i + '0')
						arr[j] = '-';
				}
				if(flag) {close[arr.length]++; flag = false;}
			}
			StringBuilder sb = new StringBuilder("");
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < close[i]; j++)
					sb.append(')');
				for(int j = 0; j < op[i]; j++)
					sb.append('(');
				sb.append(s.charAt(i));
			}
			for(int i = 0; i < close[arr.length]; i++)
				sb.append(')');
			System.out.println("Case #" + l++ + ": " + sb);
		}
	}

	public static String next() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			String line = br.readLine();
			if (line == null)
				throw new IOException();
			tokenizer = new StringTokenizer(line);
		}
		return tokenizer.nextToken();
	}

	public static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}
