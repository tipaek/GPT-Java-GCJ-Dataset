import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(final String[] args) {
		new Solution().start();
	}

	private InputStream in;

	public Solution() {
		in = System.in;
	}

	public Solution(final String fileName) {
		try {
			in = new FileInputStream(fileName);
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		Scanner sc = new Scanner(in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int u = sc.nextInt();
			ArrayList<Data> datas = new ArrayList<Solution.Data>();
			ArrayList<Data> unknow = new ArrayList<Solution.Data>();
			HashSet<String> all = new HashSet<String>();
			for (int j = 0; j < 10000; j++) {
				int n = sc.nextInt();
				String s = sc.nextLine();
				s = s.substring(1);

				if (all.size() < 10) {
					for (int k = 0; k < s.length(); k++) {
						all.add(s.substring(k, k + 1));
					}
				}

				if (n > 0) {
					Data data = new Data(u, n, s);
					if (data.isValid()) {
						datas.add(data);
						//System.out.println(u + ">" + n + "-" + s + " " + data.getV() + " " + data.getS());
					}
				}
			}
			//System.out.println(datas.size());

			String[] code = new String[10];
			HashSet<String> letters = new HashSet<>();
			for (int j = 1; j < 10; j++) {
				for (Data data : datas) {
					if (data.getV() == j) {
						if (!letters.contains(data.getS())) {
							code[j] = data.getS();
							letters.add(data.getS());
							break;
						}
					}
				}
			}
			for (String ss : all) {
				if (!letters.contains(ss)) {
					code[0] = ss;
					break;
				}
			}

			System.out.print("Case #" + (i + 1) + ": ");
			for (int j = 0; j < 10; j++) {
				System.out.print(code[j]);
			}
			System.out.println();
		}
	}

	private class Data {
		private boolean valid;
		private int v;
		private String c;

		public Data(final int u, final int n, final String s) {
			String ns = Integer.toString(n);
			valid = ns.length() == s.length();
			v = Integer.parseInt(ns.substring(0, 1));
			c = s.substring(0, 1);
		}

		public int getV() {
			return v;
		}

		public String getS() {
			return c;
		}

		public boolean isValid() {
			return valid;
		}
	}

}
