import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %d";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            Solution solution = new Solution();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                solution.processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLong();
        }
        Arrays.sort(array);

        List<Integer>[] divisors = new List[n];
        for (int i = 0; i < n; i++) {
            divisors[i] = new ArrayList<>();
            for (int j = i + 1; j < n; j++) {
                if (array[j] % array[i] == 0) {
                    divisors[i].add(j);
                }
            }
        }

        int[] results = new int[n];
        Arrays.fill(results, -1);

        for (int i = 0; i < n; i++) {
            int current = 1;
            int cuts = 0;
            for (int idx : divisors[i]) {
                long quotient = array[idx] / array[i];
                if (current + quotient < d) {
                    cuts += quotient - 1;
                    current += quotient;
                } else {
                    cuts += Math.min(quotient - 1, d - current);
                    results[i] = cuts;
                    break;
                }
            }
            if (results[i] == -1 && d - current < n - i) {
                results[i] = cuts + d - current;
            }
        }

        int minCuts = d - 1;
        for (int result : results) {
            if (result != -1) {
                minCuts = Math.min(minCuts, result);
            }
        }

        printResult(caseNum, minCuts);
    }

    private static void printResult(int caseNum, int result) {
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result));
    }
}