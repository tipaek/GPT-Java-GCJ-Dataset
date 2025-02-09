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

            boolean canAssignC = true;
            for (int i = start; i < end; i++) {
                if (cSchedule[i] == 'C') {
                    canAssignC = false;
                    break;
                }
            }
            if (canAssignC) {
                for (int i = start; i < end; i++) {
                    cSchedule[i] = 'C';
                }
                result.append('C');
                continue;
            }

            boolean canAssignJ = true;
            for (int i = start; i < end; i++) {
                if (jSchedule[i] == 'J') {
                    canAssignJ = false;
                    break;
                }
            }
            if (canAssignJ) {
                for (int i = start; i < end; i++) {
                    jSchedule[i] = 'J';
                }
                result.append('J');
                continue;
            }

            return "IMPOSSIBLE";
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            ArrayList<Pair> pairs = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                pairs.add(new Pair(start, end));
            }

            System.out.println("Case #" + caseNumber++ + ": " + solution(pairs));
        }
    }
}