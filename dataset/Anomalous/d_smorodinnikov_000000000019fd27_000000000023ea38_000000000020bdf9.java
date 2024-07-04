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
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            List<Pair> pairs = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                pairs.add(new Pair(start, end));
            }
            solveCase(i, n, pairs);
        }
    }

    static void solveCase(int caseNumber, int n, List<Pair> pairs) {
        pairs.sort(Comparator.comparingInt(pair -> pair.start));
        String impossible = "IMPOSSIBLE";
        int lastCEnd = -1;
        int lastJEnd = -1;
        StringBuilder schedule = new StringBuilder();

        for (Pair pair : pairs) {
            if (lastCEnd <= pair.start) {
                schedule.append("C");
                lastCEnd = pair.end;
            } else if (lastJEnd <= pair.start) {
                schedule.append("J");
                lastJEnd = pair.end;
            } else {
                System.out.println("Case #" + (caseNumber + 1) + ": " + impossible);
                return;
            }
        }
        System.out.println("Case #" + (caseNumber + 1) + ": " + schedule.toString());
    }

    static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}