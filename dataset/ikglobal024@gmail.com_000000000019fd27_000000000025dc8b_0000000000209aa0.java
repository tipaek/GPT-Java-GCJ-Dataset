import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();

        for (int t=1; t<=T; t++) {
            int N = in.nextInt();
            int K = in.nextInt();

            if (N <= 2) {
                System.out.println("case #" + t +": IMPOSSIBLE");
            } else {
                int index = 0;
                int[][] matrix = new int[N][N];
                StringBuilder result = new StringBuilder();
                while (index < N) {
                    int trace = 0;
                    int count = -1;
                    for (int r = 0; r < N; r++) {
                        count++;
                        for (int c=0; c < N; c++) {
                            int value = (c+1) + count;
                            value = value <= N ? value : value - N;
                            matrix[r][c] = value;
                            if (r == c) {
                                trace += value;
                            }
                            if (c==0) {
                                result.append(value);
                            } else {
                                result.append(" " + value);
                            }
                        }
                        if (r != N-1) {
                            result.append("\n");
                        }
                    }
                    if (trace == K) {
                        System.out.println("case #" + t +": POSSIBLE");
                        System.out.println(result.toString());
                        break;
                    }
                    index++;
                }
                if (index == N)
                    System.out.println("case #" + t +": IMPOSSIBLE");
            }
        }
    }
}