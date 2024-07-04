import java.io.*;
import java.util.*;

public class Solution {

    static class Pair {
        int start, end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            List<Pair> cameron = new ArrayList<>();
            List<Pair> jamie = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < N; i++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();

                if (result.toString().equals("IMPOSSIBLE")) {
                    continue;
                }

                int cameronIndex = findInsertionIndex(cameron, startTime, endTime);
                int jamieIndex = findInsertionIndex(jamie, startTime, endTime);

                if (cameronIndex >= 0) {
                    result.append("C");
                    cameron.add(cameronIndex, new Pair(startTime, endTime));
                } else if (jamieIndex >= 0) {
                    result.append("J");
                    jamie.add(jamieIndex, new Pair(startTime, endTime));
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static int findInsertionIndex(List<Pair> list, int start, int end) {
        if (list.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < list.size(); i++) {
            Pair current = list.get(i);

            if (i == 0 && end <= current.start) {
                return i;
            }

            if (i == list.size() - 1 && start >= current.end) {
                return i + 1;
            }

            if (i > 0) {
                Pair previous = list.get(i - 1);
                if (start >= previous.end && end <= current.start) {
                    return i;
                }
            }
        }

        return -1;
    }
}