import java.util.*;
import java.io.*;
public class Solution {

	static BufferedReader br;
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = nextInt();
		int l = 1;
		outer:
		while(t --> 0) {
			int n = nextInt();
			String[] arr = new String[n];
			for(int i = 0; i < n; i++)
				arr[i] = next();
			int[] s = new int[n];
			StringBuilder front = new StringBuilder();
			for(int i = 0;  i < n; i++) {
				for(int j = 0; j < arr[i].length(); j++) {
					if(arr[i].charAt(j) == '*') {s[i] = j; break;}
					if(front.length() <= j ) front.append(arr[i].charAt(j));
					else if(front.charAt(j) != arr[i].charAt(j)) {
						System.out.println("Case #" + l++ + ": *");
						continue outer;
					}
				}
			}
			int[] e = new int[n];
			StringBuilder back = new StringBuilder();
			for(int i = 0; i < n; i++) {
				for(int j = arr[i].length() - 1; j >= 0; j--) {
					if(arr[i].charAt(j) == '*') {e[i] = j; break;}
					if(back.length() < arr[i].length() - j) back.append(arr[i].charAt(j));
					else if(back.charAt(arr[i].length() - j - 1) != arr[i].charAt(j)) {
						System.out.println("Case #" + l++ + ": *");
						continue outer;
					}
				}
			}
			StringBuilder mid = new StringBuilder();
			for(int i = 0; i < n; i++)
				mid.append(arr[i].substring(s[i], e[i] + 1).replaceAll("\\*", ""));
			System.out.println("Case #" + l++ +": " + front.toString() + mid.toString() + back.reverse());
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
