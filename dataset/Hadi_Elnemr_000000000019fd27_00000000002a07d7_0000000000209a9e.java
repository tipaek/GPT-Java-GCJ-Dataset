import java.util.*;
import java.io.*;

public class Solution {
	static int memo[][];
	static int n, v, m, e, t;
	static ArrayList[] edgeList;
	static int[][] matrix;
	static int[] a;
	final static int Infinity = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		t = sc.nextInt();
		int B = sc.nextInt();
		char[] arr = new char[B];
		for (int i = 0; i < t; i++) {
			int k = 75;
			Integer idxSame = null, idxDif = null;
			for (int j = 0; j < k || j<B; j++) {
				if (j != 0 && j % 10 == 0) {
					if (idxSame != null && idxDif != null) {
						k--;
						pw.println(idxSame+1);
						pw.flush();
						char same1 = sc.nextChar();

						pw.println(idxDif+1);
						pw.flush();
						char dif1 = sc.nextChar();

						if (arr[idxSame] != arr[same1]) // comp or plus
							if (arr[idxDif] == arr[dif1]) // plus
								arr = compPlusRev(arr);
							else
								arr = comp(arr); // comp
						else if (arr[idxDif] != arr[dif1]) // rev
							arr = rev(arr);
						// else : Same
					}
				}
				pw.println(j + 1);
				pw.flush();
				arr[j] = sc.nextChar();

				pw.println(B - j);
				pw.flush();
				arr[B - j - 1] = sc.nextChar();

				if (idxSame == null && arr[j] == arr[B - j - 1])
					idxSame = j;
				if (idxDif == null && arr[j] != arr[B - j - 1])
					idxDif = j;
			}
			for (int j = 0; j < B; j++)
				pw.print(arr[j]);
			pw.println();
			pw.flush();
			
			char ans = sc.nextChar();
			if (ans == 'Y')
				continue;
			else if (ans == 'N')
				return;

		}

		pw.close();
	}

	public static char[] rev(char[] arr) {
		char[] s = new char[arr.length];
		for (int j = 0; j < arr.length; j--)
			s[j] = arr[arr.length - 1 - j];
		return s;
	}

	public static char[] compPlusRev(char[] arr) {
		return rev(comp(arr));
	}

	public static char[] comp(char[] arr) {
		char[] s = new char[arr.length];
		for (int i = 0; i < arr.length; i++)
			s[i] = arr[i] == '0' ? '1' : '0';
		return s;
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}

		public Scanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public char nextChar() throws IOException {
			return next().charAt(0);
		}

		public Long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
}