import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            StringBuilder result = new StringBuilder();
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
            int cEnd = 0, jEnd = 0;

            while (!startTimes.isEmpty()) {
                int start = startTimes.remove(0);
                int end = endTimes.get(originalStartTimes.indexOf(start));

                if (cEnd <= start) {
                    result.append("C");
                    cEnd = end;
                } else if (jEnd <= start) {
                    result.append("J");
                    jEnd = end;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}