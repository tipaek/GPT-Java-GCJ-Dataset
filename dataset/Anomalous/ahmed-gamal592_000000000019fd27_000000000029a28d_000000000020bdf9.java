import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static String solution(ArrayList<Pair> pairs) {
        StringBuilder result = new StringBuilder();
        char[] cSchedule = new char[1441];
        char[] jSchedule = new char[1441];

        for (Pair pair : pairs) {
            int start = pair.start;
            int end = pair.end;

            if (isAvailable(cSchedule, start, end)) {
                fillSchedule(cSchedule, start, end, 'C');
                result.append("C");
            } else if (isAvailable(jSchedule, start, end)) {
                fillSchedule(jSchedule, start, end, 'J');
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    private static boolean isAvailable(char[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] != '\0') {
                return false;
            }
        }
        return true;
    }

    private static void fillSchedule(char[] schedule, int start, int end, char task) {
        for (int i = start; i < end; i++) {
            schedule[i] = task;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            ArrayList<Pair> pairs = new ArrayList<>();

            for (int i = 0; i < n; ++i) {
                int from = scanner.nextInt();
                int to = scanner.nextInt();
                pairs.add(new Pair(from, to));
            }

            System.out.println("Case #" + caseNumber++ + ": " + solution(pairs));
        }
    }
}