
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int noOfTestCases = in.nextInt();
		int sizeOfArray = in.nextInt();

		for (int i = 0; i < noOfTestCases; i++) {

			int j = 1;
			int[] ans = new int[sizeOfArray];
			for (int trial = 1; trial <= 150; trial++) {
				if (j > sizeOfArray) {
					break;
				}
				if (trial % 10 == 1) {
					System.out.print(sizeOfArray);
					System.out.flush();
					String judgeReponse = in.next();
					if (judgeReponse.equals("N")) {
						System.exit(0);
					}
				} else {
					System.out.print(j);
					System.out.flush();
					String judgeReponse = in.next();
					if (judgeReponse.equals("N")) {
						System.exit(0);
					} else {
						ans[j - 1] = Integer.parseInt(judgeReponse);
					}

					j++;
				}

			}

			String s = Arrays.toString(ans);
			s = s.replace(", ", "");
			s = s.replace("[", "");
			s = s.replace("]", "");
			System.out.println(s);
			System.out.flush();
			String judgeReponse = in.next();
			if (judgeReponse.equals("Y")) {
				continue;
			} else {
				System.exit(0);
			}
		}

		in.close();

	}
}
