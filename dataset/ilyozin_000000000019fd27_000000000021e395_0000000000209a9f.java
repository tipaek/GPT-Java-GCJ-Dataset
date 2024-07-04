import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		InputStream stream = Solution.class.getName().equals("year2020.qr.task2.Solution") ?
				new FileInputStream("C:\\Users\\One\\eclipse-workspace\\Test\\src\\year2020\\qr\\task2\\in.txt") :
					System.in;
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(stream)))) {
			int T = in.nextInt();

			in.nextLine();
			for (int t = 1; t <= T; t++) {
				String s0 = in.nextLine();
				
				int opened = 0;
				StringBuilder s = new StringBuilder();
				for (char c : s0.toCharArray()) {
					int n = c - 48;
					while (opened < n) {
						s.append('(');
						opened++;
					}
					while (opened > n) {
						s.append(')');
						opened--;
					}
					s.append(c);
				}
				while (opened > 0) {
					s.append(')');
					opened--;
				}

				System.out.println("Case #" + t + ": " + s);
			}
		}
	}
}
