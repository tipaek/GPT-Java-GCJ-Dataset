import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            List<Pair> pairs = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                pairs.add(new Pair(start, end, j));
            }
            solveCase(i, n, pairs);
        }
    }

    static void solveCase(int caseNumber, int n, List<Pair> pairs) {
        pairs.sort(Comparator.comparingInt(pair -> pair.start));
        int lastCEnd = -1;
        int lastJEnd = -1;
        char[] schedule = new char[n];
        StringBuilder result = new StringBuilder();
        String impossible = "IMPOSSIBLE";

        for (Pair pair : pairs) {
            int start = pair.start;
            int end = pair.end;
            int index = pair.index;

            if (lastCEnd <= start) {
                schedule[index] = 'C';
                lastCEnd = end;
            } else if (lastJEnd <= start) {
                schedule[index] = 'J';
                lastJEnd = end;
            } else {
                System.out.println("Case #" + (caseNumber + 1) + ": " + impossible);
                return;
            }
        }

        for (char c : schedule) {
            result.append(c);
        }
        System.out.println("Case #" + (caseNumber + 1) + ": " + result);
    }

    static class Pair {
        int start;
        int end;
        int index;

        Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}