import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static class Pair {
        int start, end, index;
        String assignedPerson;

        Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
            this.assignedPerson = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Pair[] pairs = new Pair[n + 1];
            pairs[0] = new Pair(0, 0, -1);

            for (int j = 1; j <= n; j++) {
                pairs[j] = new Pair(scanner.nextInt(), scanner.nextInt(), j);
            }

            Arrays.sort(pairs, (p1, p2) -> {
                if (p1.end != p2.end) {
                    return Integer.compare(p1.end, p2.end);
                }
                return Integer.compare(p1.start, p2.start);
            });

            System.out.println(assignTasks(pairs));
        }
    }

    private static String assignTasks(Pair[] pairs) {
        int n = pairs.length;
        boolean isImpossible = false;
        int cEnd = 0, jEnd = 0;

        for (Pair pair : pairs) {
            if (pair.start >= cEnd) {
                pair.assignedPerson = "C";
                cEnd = pair.end;
            }
        }

        for (Pair pair : pairs) {
            if (pair.assignedPerson == null) {
                if (pair.start >= jEnd) {
                    pair.assignedPerson = "J";
                    jEnd = pair.end;
                } else {
                    isImpossible = true;
                    break;
                }
            }
        }

        if (isImpossible) {
            return "IMPOSSIBLE";
        } else {
            String[] result = new String[n];
            result[0] = "";
            for (int i = 1; i < n; i++) {
                result[pairs[i].index] = pairs[i].assignedPerson;
            }
            return String.join("", result);
        }
    }
}