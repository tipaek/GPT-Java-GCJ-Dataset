import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int n = scanner.nextInt();
            String[] assignments = new String[n];
            String result = "";
            List<Integer> startTimes = new ArrayList<>();
            List<Integer> endTimes = new ArrayList<>();
            List<Integer> originalStartTimes = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                startTimes.add(start);
                endTimes.add(end);
                originalStartTimes.add(start);
            }

            Collections.sort(startTimes);
            int cameronEnd = 0, jamieEnd = 0;

            while (!startTimes.isEmpty()) {
                int start = startTimes.remove(0);
                int index = originalStartTimes.indexOf(start);
                originalStartTimes.set(index, -1);
                int end = endTimes.get(index);

                if (cameronEnd <= start) {
                    assignments[index] = "C";
                    cameronEnd = end;
                } else if (jamieEnd <= start) {
                    assignments[index] = "J";
                    jamieEnd = end;
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                result = String.join("", assignments);
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }
}