import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		InputStream stream = Solution.class.getName().equals("year2020.r2.task2.Solution") ?
				new FileInputStream("C:\\Users\\One\\eclipse-workspace\\Test\\src\\year2020\\r2\\task2\\in.txt") :
					System.in;
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(stream)))) {
			int T = Integer.parseInt(in.nextLine());

			for (int t = 1; t <= T; t++) {
				int L = Integer.parseInt(in.nextLine());
				long[] X = new long[L];
				long[] Y = new long[L];
				for (int i = 0; i < L; i++) {
					String[] s = in.nextLine().split(" ");
					X[i] = Long.parseLong(s[0]);
					Y[i] = Long.parseLong(s[1]);
				}
				
				Map<Long, Set<Integer>> map = new HashMap<>();
				int max = 0;
				for (int i = 0; i < L; i++) {
					for (int j = i + 1; j < L; j++) {
						long coef;
						if (X[i] == X[j]) {
							coef = Long.MAX_VALUE;
						} else {
							coef = 1000000000L * (Y[i] - Y[j]) / (X[i] - X[j]);
						}
						Set<Integer> c = map.get(coef);
						if (c == null) {
							c = new HashSet<>();
							map.put(coef, c);
						}
						c.add(i);
						c.add(j);
						if (c.size() > max) {
							max = c.size();
						}
					}
				}
				
				max = max % 2 == 1 ? max + 1 : max + 2;
				if (max < 4) {
					max = Math.min(4, L);
				}
				max = Math.min(max, L);
				
				System.out.println("Case #" + t + ": " + max);
			}
		}
	}
}
