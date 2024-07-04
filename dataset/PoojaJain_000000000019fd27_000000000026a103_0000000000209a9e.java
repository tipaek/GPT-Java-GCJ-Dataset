
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
			StringBuilder s = new StringBuilder();
			for (int trial = 1; trial <= 150; trial++) {
				if (j > sizeOfArray) {
					break;
				}
				
					System.out.println(j);
					System.out.flush();
					String judgeReponse = in.next();
					if (judgeReponse.equals("N")) {
						System.exit(0);
					} else {
						s.append(judgeReponse);
					}

					j++;
				

			}

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
	// 0001101111
}
