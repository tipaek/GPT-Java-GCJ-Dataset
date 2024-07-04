import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static boolean isOverlapping(List<Integer> intervals, int start, int end) {
        for (int i = 0; i < intervals.size(); i += 2) {
            if ((start > intervals.get(i) && start < intervals.get(i + 1)) || 
                (end > intervals.get(i) && end < intervals.get(i + 1))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 1; i <= t; i++) {
            List<Integer> cameronSchedule = new ArrayList<>();
            List<Integer> jamieSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            int n = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < n; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                scanner.nextLine();

                if (!isOverlapping(cameronSchedule, startTime, endTime)) {
                    cameronSchedule.add(startTime);
                    cameronSchedule.add(endTime);
                    result.append("C");
                } else if (!isOverlapping(jamieSchedule, startTime, endTime)) {
                    jamieSchedule.add(startTime);
                    jamieSchedule.add(endTime);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}