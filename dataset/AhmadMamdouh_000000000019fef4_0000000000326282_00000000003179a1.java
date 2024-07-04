import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {
	static class Pair {
		int count;
		long max;

		public Pair(int c, long m) {
			count = c;
			max = m;
		}
	}
	static String[]  generate(){
		long range = (long) Math.pow(10, 16);
		Random rand = new Random();
		int[] digits = new int[10];
		int[] last = new int[10];
		int[] len = new int[17];
		String secret = "CODEJAMFUN";
		String[] ret = new String[10000];
		for (int rec = 0; rec < 10000; rec++) {
			long next = Math.abs(rand.nextLong()) % range;
			next = Math.abs(rand.nextLong()) % next;
			String s= next+"";
			len[s.length()]++;
			String tran = "";
			for(int i=0;i<s.length();i++){
				tran+=secret.charAt(s.charAt(i)-'0');
			}
			ret[rec]=tran;
		}
		return ret;
	}
	public static void main(String[] args) {
		InputReader r = new InputReader(System.in);
		int t = r.nextInt();
		int test = 1;
		while (t-- > 0) {
			int u = r.nextInt();
			long range = (long) Math.pow(10, u);
			int[] freq = new int[26];
			HashMap<String, Pair> map = new HashMap<String, Pair>();
			int[] count = new int[26];
//			String[] ret = generate();
			for (int record = 0; record < 10000; record++) {
				long q = r.nextLong();
				String s = r.next();
				for (char c : s.toCharArray()) {
					freq[c - 'A']++;
				}
				if (!map.containsKey(s))
					map.put(s, new Pair(0, range));
				Pair p = map.get(s);
				p.count++;
				p.max = Math.min(-1, p.max);
				count[s.charAt(0) - 'A']++;
			}
			char[] sol = new char[10];
			for (int i = 0; i < freq.length; i++) {
				if (freq[i] > 0 && count[i]==0) {
						sol[0] = (char) ('A' + i);
				}
			}
			TreeMap<Integer, Character> map2 = new TreeMap<Integer, Character>();
			for (int i = 0; i < freq.length; i++) {
				if (count[i] > 0)
					map2.put(count[i], (char) (i + 'A'));
			}
			int d = 9;
			for (Entry<Integer, Character> e : map2.entrySet()) {
				if (e.getValue() == sol[0])
					continue;
				sol[d--] = e.getValue();
			}

			System.out.printf("Case #%d: %s\n", test++, new String(sol));
		}

	}

	static class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public InputReader(FileReader stream) {
			reader = new BufferedReader(stream);
			tokenizer = null;
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
