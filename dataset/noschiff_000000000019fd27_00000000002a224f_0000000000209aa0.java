import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < T; i++) {
            String[] input = scanner.nextLine().split(" ");
            int N = Integer.valueOf(input[0]);
            int K = Integer.valueOf(input[1]);

            if (K % N != 0) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                int trace = K / N;
                int[][] square = new int[N][N];
                int current = (trace == 1) ? 2 : 1;
                boolean increment = true;
                for (int row = 0; row < N; row++) {

                    for (int col = 0; col < N; col++) {
                        if (row == col) {
                            square[row][col] = trace;
                        } else {
                            square[row][col] = current;
                            if (col < N - 1) {
                                if (increment) {
                                    current++;
                                    if (current == trace) {
                                        current++;
                                    }
                                } else {
                                    current--;
                                    if (current == trace) {
                                        current--;
                                    }
                                }
                            }
                        }
                    }
                    increment = !increment;

                }
                StringBuilder out = new StringBuilder();
                for (int j = 0; j < square.length; j++) {
                    for (int k = 0; k < square[j].length; k++) {
                        out.append(square[j][k]);
                        if (k < square[j].length - 1) {
                            out.append(" ");
                        }
                    }
                    if (j < square.length - 1) {
                        out.append("\n");
                    }
                }
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                System.out.println(out);
            }
        }
    }
}