import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %d";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                new Solution().processCase(caseNum, scanner);
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
            int currentCount = 1;
            int cuts = 0;
            for (int nextIndex : divisors[i]) {
                long ratio = array[nextIndex] / array[i];
                if (currentCount + ratio < d) {
                    cuts += ratio - 1;
                    currentCount += ratio;
                } else {
                    cuts += Math.min(ratio - 1, d - currentCount);
                    results[i] = cuts;
                    break;
                }
            }
        }

        int minimumCuts = d - 1;
        for (int result : results) {
            if (result != -1) {
                minimumCuts = Math.min(minimumCuts, result);
            }
        }

        System.out.printf(OUTPUT_FORMAT, caseNum, minimumCuts);
        System.out.println();
    }
}