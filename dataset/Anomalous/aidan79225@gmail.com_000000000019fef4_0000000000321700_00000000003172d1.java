import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %d";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
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
        for (int i = 0; i < n; ++i) {
            array[i] = scanner.nextLong();
        }
        Arrays.sort(array);
        List<Pair<List<Integer>, List<Integer>>> countPairs = new ArrayList<>(n);

        for (int i = 0; i < n; ++i) {
            List<Integer> divisible = new ArrayList<>();
            List<Integer> nonDivisible = new ArrayList<>();
            for (int j = i + 1; j < n; ++j) {
                if (array[j] % array[i] == 0) {
                    divisible.add(j);
                } else {
                    nonDivisible.add(j);
                }
            }
            countPairs.add(new Pair<>(divisible, nonDivisible));
        }

        int[] answers = new int[n];
        Arrays.fill(answers, -1);

        for (int i = 0; i < n; ++i) {
            int current = 1;
            int cuts = 0;
            for (int index : countPairs.get(i).first) {
                long quotient = array[index] / array[i];
                if (current + quotient < d) {
                    cuts += quotient - 1;
                    current += quotient;
                } else {
                    cuts += Math.min(quotient - 1, d - current);
                    answers[i] = cuts;
                    break;
                }
            }
            if (answers[i] != -1) {
                continue;
            }
            for (int index : countPairs.get(i).second) {
                long quotient = array[index] / array[i];
                if (current + quotient < d) {
                    cuts += quotient;
                    current += quotient;
                } else {
                    cuts += Math.min(quotient, d - current);
                    answers[i] = cuts;
                    break;
                }
            }
        }

        int minimumCuts = d - 1;
        for (int answer : answers) {
            if (answer != -1) {
                minimumCuts = Math.min(minimumCuts, answer);
            }
        }

        System.out.printf(OUTPUT_FORMAT, caseNum, minimumCuts);
        System.out.println();
    }

    private static class Pair<F, S> {
        final F first;
        final S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}