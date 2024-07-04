import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
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
			HashSet<String> all = new HashSet<String>();
			HashMap<String, Integer> stats = new HashMap<>();

			for (int j = 0; j < 10000; j++) {
				long n = sc.nextLong();
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
						// System.out.println(u + ">" + n + "-" + s + " " + data.getV() + " " +
						// data.getS());
					}
				} else {
					String c1 = s.substring(0, 1);
					Integer v = stats.get(c1);
					if (v == null) {
						stats.put(c1, 1);
					} else {
						stats.put(c1, v + 1);
					}
				}
			}

			String[] code = new String[10];
			if (datas.size() > 0) {
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
			} else {
				Object[][] info = new Object[9][2];
				int c = 0;
				for (Entry<String, Integer> entry : stats.entrySet()) {
					info[c][0] = entry.getKey();
					info[c][1] = entry.getValue();
					c++;
				}

				Arrays.sort(info, new Comparator<Object[]>() {

					@Override
					public int compare(final Object[] o1, final Object[] o2) {
						return (Integer) o2[1] - (Integer) o1[1];
					}
				});

				c = 1;
				HashSet<String> letters = new HashSet<>();
				for (Object[] in : info) {
					letters.add((String) in[0]);
					code[c] = (String) in[0];
					c++;
				}

				for (String ss : all) {
					if (!letters.contains(ss)) {
						code[0] = ss;
						break;
					}
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

		public Data(final int u, final long n, final String s) {
			String ns = Long.toString(n);
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
