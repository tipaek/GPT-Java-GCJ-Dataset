import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		InputStream stream = Solution.class.getName().equals("year2020.r1.task1.Solution") ?
				new FileInputStream("C:\\Users\\One\\eclipse-workspace\\Test\\src\\year2020\\r1\\task1\\in.txt") :
					System.in;
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(stream)))) {
			int T = in.nextInt();

			for (int t = 1; t <= T; t++) {
				int N = in.nextInt();
				in.nextLine();
				String[] p1 = new String[N];
				String[][] p2 = new String[N][];
				String start = "";
				String finish = "";
				String s = null;
				
				for (int i = 0; i < N; i++) {
					String p = in.nextLine();
					p1[i] = p;
					p2[i] = p1[i].split("\\*", -1);
					
					if (start.length() >= p2[i][0].length()) {
						if (!start.startsWith(p2[i][0])) {
							start = null;
							break;
						}
					} else {
						if (!p2[i][0].startsWith(start)) {
							start = null;
							break;
						}
						start = p2[i][0];
					}
					if (start == null)
						break;
					
					int idx = p2[i].length - 1;
					if (finish.length() >= p2[i][idx].length()) {
						if (!finish.endsWith(p2[i][idx])) {
							finish = null;
							break;
						}
					} else {
						if (!p2[i][idx].endsWith(finish)) {
							finish = null;
							break;
						}
						finish = p2[i][idx];
					}
					if (finish == null)
						break;
				}
				
				if (start != null && finish != null) {
					s = start;
					String middle = "";
					for (int i = 0; i < N; i++) {
						String nm = "";
						if (p2[i].length > 2) {
							for (int j = 1; j < p2[i].length - 1; j++) {
								nm += p2[i][j];
							}
							if (!middle.contains(nm)) {
								if (nm.contains(middle))
									middle = nm;
								else
									middle += nm;
							}
						}
					}
					s += middle;
					if (!s.endsWith(finish))
						s += finish;
				}

				if (s != null && s.length() <= 10000) {
					for (int i = 0; i < N; i++) {
						if (p2[i].length == 1) {
							if (p2[i][0].length() < s.length()) {
								s = null;
								break;
							}
						}
					}
				}
				
				System.out.println("Case #" + t + ": " + (s == null || s.length() > 10000 ? '*' : s));
			}
		}
	}
}
