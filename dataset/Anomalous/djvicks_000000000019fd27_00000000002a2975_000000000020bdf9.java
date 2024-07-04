import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                int n = scanner.nextInt();
                List<Integer> jStart = new ArrayList<>();
                List<Integer> jEnd = new ArrayList<>();
                List<Integer> cStart = new ArrayList<>();
                List<Integer> cEnd = new ArrayList<>();
                StringBuilder result = new StringBuilder();

                for (int j = 0; j < n; j++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();

                    boolean jAvailable = isAvailable(jStart, jEnd, start, end);
                    boolean cAvailable = isAvailable(cStart, cEnd, start, end);

                    if (jAvailable) {
                        jStart.add(start);
                        jEnd.add(end);
                        result.append("J");
                    } else if (cAvailable) {
                        cStart.add(start);
                        cEnd.add(end);
                        result.append("C");
                    } else {
                        result = new StringBuilder(IMPOSSIBLE);
                        break;
                    }
                }
                System.out.printf("Case #%d: %s%n", caseNum, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isAvailable(List<Integer> startTimes, List<Integer> endTimes, int start, int end) {
        for (int i = 0; i < startTimes.size(); i++) {
            if ((startTimes.get(i) < start && start < endTimes.get(i)) || 
                (startTimes.get(i) < end && end < endTimes.get(i))) {
                return false;
            }
        }
        return true;
    }
}