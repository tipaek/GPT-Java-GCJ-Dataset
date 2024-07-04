import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		InputStream stream = Solution.class.getName().equals("year2020.r1b.task2.Solution") ?
				new FileInputStream("C:\\Users\\One\\eclipse-workspace\\Test\\src\\year2020\\r1b\\task2\\in.txt") :
					System.in;
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(stream)))) {
			int T = Integer.parseInt(in.nextLine());

			for (int t = 1; t <= T; t++) {
				int R = in.nextInt();
				int S = in.nextInt();
				
				List<String> path = new ArrayList<>();
				int[] next = new int[R + 1];
				for (int i = 1; i <= R; i++)
					next[i] = R + i;
				
				for (int i = 1; i <= S - 1; i++) {
					int count = i * 2;
					for (int j = R % 2 == 0 || i % 2 == 1 ? 1 : 2; j < R; j += 2) {
						path.add(count + " " + (next[j] - count));
					}
					
					if (R % 2 == 1 && i % 2 == 1) {
						if (i == S - 1) {
							path.add(i + " " + (S * R - i - 1));
						} else {
							count++;
							path.add(count + " " + (next[R] - count));
						}
					}

					for (int j = 1; j <= R; j++)
						next[j] = R * (i + 1) + j;
				}
				
				System.out.println("Case #" + t + ": " + path.size());
				for (String s : path)
					System.out.println(s);
			}
		}
	}
}
