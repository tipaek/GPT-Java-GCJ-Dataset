import java.util.*;
import java.io.*;

public class Solution {

    private static List<Integer> findSmallest(List<Integer> start, List<Integer> end) {
        int smallest = Integer.MAX_VALUE;
        int smallestIdx = 0;

        for (int i = 0; i < start.size(); i++) {
            int temp = start.get(i);
            if (temp < smallest) {
                smallest = temp;
                smallestIdx = i;
            }
        }
        List<Integer> times = new ArrayList<>();
        times.add(smallest);
        times.add(end.get(smallestIdx));
        start.remove(smallestIdx);
        end.remove(smallestIdx);
        return times;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int appointments = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;
            int jEnd = 0;
            int cEnd = 0;

            List<Integer> startTimes = new ArrayList<>();
            List<Integer> endTimes = new ArrayList<>();

            for (int j = 0; j < appointments; j++) {
                startTimes.add(scanner.nextInt());
                endTimes.add(scanner.nextInt());
            }

            for (int j = 0; j < appointments; j++) {
                List<Integer> current = findSmallest(startTimes, endTimes);
                int currentStart = current.get(0);
                int currentEnd = current.get(1);
                
                if (currentStart >= jEnd) {
                    jEnd = currentEnd;
                    schedule.append("J");
                } else if (currentStart >= cEnd) {
                    cEnd = currentEnd;
                    schedule.append("C");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + schedule);
            }
        }
    }
}