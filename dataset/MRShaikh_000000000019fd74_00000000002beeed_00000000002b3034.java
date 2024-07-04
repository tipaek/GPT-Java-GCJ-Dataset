import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Solution {

	public static void main(String[] args) throws IOException {
//		Scanner infile = new Scanner(new File("1a"));
		Scanner infile = new Scanner(System.in);
		int T = infile.nextInt();
		for (int i = 0; i < T; i++) {
			int N = infile.nextInt();
			ArrayList<String> input = new ArrayList<String>();
			ArrayList<Integer> lengths = new ArrayList<Integer>();
			for (int j = 0; j < N; j++) {
				String str = infile.next();
				input.add(str);
				lengths.add(str.length());
			}
			int ptr = 1;
			boolean isMatched = true;
			StringBuilder sb = new StringBuilder("");
			while (isMatched) {
				char c = '*';
				int k = 0;
				while (c == '*') {
					if (k > input.size() - 1) {
						isMatched = true;
						break;
					}
					if (input.get(k)
					         .length()
					        - ptr > input.get(k)
					                     .length()
					                - 1) {
						k++;
						continue;

					}
					c = input.get(k)
					         .charAt(input.get(k)
					                      .length()
					                 - ptr);
					k++;
				}

				for (int j = 0; j < input.size(); j++) {
					if (input.get(j)
					         .charAt(input.get(j)
					                      .length()
					                 - ptr) == '*') {
						input.remove(j);
						continue;
					}
					if (input.get(j)
					         .charAt(input.get(j)
					                      .length()
					                 - ptr) != c) {
						isMatched = false;
						break;
					}
				}

				if (!isMatched) {
					break;
				}
				if (input.isEmpty()) {
					break;
				}
				sb.append(c);
				ptr++;
			}
			if (!isMatched) {
				System.out.println("Case #" + (i + 1) + ": " + "*");
			} else {
				System.out.println("Case #" + (i + 1) + ": " + sb.reverse()
				                                                 .toString());
			}
		}
	}
}
