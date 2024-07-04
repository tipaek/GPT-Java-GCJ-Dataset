import java.util.*;
import java.io.*;

public class Solution {

    public static List<Integer> findSmallest(List<Integer> start, List<Integer> end) {
        int minIndex = 0;
        for (int i = 1; i < start.size(); i++) {
            if (start.get(i) < start.get(minIndex)) {
                minIndex = i;
            }
        }
        List<Integer> smallestTimes = Arrays.asList(start.get(minIndex), end.get(minIndex));
        start.remove(minIndex);
        end.remove(minIndex);
        return smallestTimes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int appointments = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            String result = "";
            boolean isPossible = true;

            List<Integer> startTimes = new ArrayList<>();
            List<Integer> endTimes = new ArrayList<>();
            List<String> assignments = new ArrayList<>(Collections.nCopies(appointments, ""));

            for (int i = 0; i < appointments; i++) {
                startTimes.add(scanner.nextInt());
                endTimes.add(scanner.nextInt());
            }

            int jEnd = 0, cEnd = 0;

            for (int i = 0; i < appointments; i++) {
                List<Integer> smallestTimes = findSmallest(startTimes, endTimes);
                int start = smallestTimes.get(0);
                int end = smallestTimes.get(1);

                if (start >= jEnd) {
                    jEnd = end;
                    assignments.set(i, "J");
                } else if (start >= cEnd) {
                    cEnd = end;
                    assignments.set(i, "C");
                } else {
                    result = "IMPOSSIBLE";
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                for (String assignment : assignments) {
                    schedule.append(assignment);
                }
                result = schedule.toString();
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}