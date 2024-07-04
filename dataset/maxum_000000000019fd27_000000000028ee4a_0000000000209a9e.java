import java.util.*;
import java.io.*;


public class Solution {

	public static int MAX_QUERIES = 150;
	public static int ROUND_QUERIES = 10;

	public static void compute(Scanner in, int B) {
		char[] buf = new char[B];
		Arrays.fill(buf, 'X');


		int cnt = 0;
		for (int i = 0; i < 5; i++, cnt+=2) {
			System.out.println((i+1));
			buf[i] = in.nextLine().charAt(0);
			System.out.println((B-i));
			buf[B-i-1] = in.nextLine().charAt(0);
		}

// 		int nQueries = 10;
// 		while (nQueries < MAX_QUERIES) {

// 			if (cnt == B) {
				System.out.println(new String(buf));
				if (in.nextLine().charAt(0) == 'Y') {
					return;
				} else {
					System.exit(0);
				}
// 			}

		

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		int B = in.nextInt(); in.nextLine();
		for (int i = 1; i <= T; i++) {
			compute(in, B);
		}

	}

}
