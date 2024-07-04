import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(stdin.readLine());

            for (int j = 1; j <= T; j++) {
                int N = Integer.parseInt(stdin.readLine());
                int[][] matrix = new int[N][N];
                int V = 0, rc = 0, rr = 0;

                Set<Integer> testSet = new HashSet<>();

                for (int r = 0; r < N; r++) {
                    String input = stdin.readLine();
                    Scanner sc = new Scanner(input);
                    boolean duplicate = false;
                    testSet.clear();

                    for (int c = 0; c < N; c++) {
                        int current = sc.nextInt();
                        if (r == c) V += current;
                        matrix[r][c] = current;
                        duplicate = !testSet.add(current) || duplicate;
                    }

                    if (duplicate) rr++;
                }

                for (int c = 0; c < N; c++) {
                    boolean duplicate = false;
                    testSet.clear();

                    for (int r = 0; r < N; r++) {
                        int current = matrix[r][c];
                        duplicate = !testSet.add(current) || duplicate;
                    }

                    if (duplicate) rc++;
                }

                System.out.println("Case #" + j + ": " + V + " " + rr + " " + rc);
            }
        } catch (Exception e) {
            System.out.println("I'll be back! ;)");
        }
    }
}