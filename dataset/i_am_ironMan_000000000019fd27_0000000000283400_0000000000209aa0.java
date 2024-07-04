import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int te = 0; te < T; te++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int count = 0;
			int num = 1;
			for (num = 1; num <= N; num++) {
				if (num * N == K) {
					count = 1;
					break;
				}
			}

			if (count == 0) {
				System.out.println("Case #" + (te + 1) + ": IMPOSSIBLE");
			} else {
				
				System.out.println("Case #" + (te + 1) + ": POSSIBLE");
				
				int diagonal = num;
				int edge = 0;
				int inp = diagonal;
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {

						if (i == j) {
							System.out.print(diagonal + " ");
							inp = diagonal+1;

						} else {
							
							System.out.print(inp + " ");
							if (j == N) {
								edge = inp;
							}

							if (inp == N) {
								if (diagonal == 1) {
									inp = 2;
								} else {
									inp = 1;
								}
							}
							
						}

					}
					inp = edge ;
					System.out.println();
				}
			}

		}

		sc.close();
	}

}