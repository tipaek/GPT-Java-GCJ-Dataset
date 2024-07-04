import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    private static boolean isOverlapping(List<Integer> ranges, int start, int end) {
        for (int i = 0; i < ranges.size(); i += 2) {
            if ((start > ranges.get(i) && start < ranges.get(i + 1)) || 
                (end > ranges.get(i) && end < ranges.get(i + 1))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            List<Integer> cameron = new ArrayList<>();
            List<Integer> jaimie = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            int activities = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < activities; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                scanner.nextLine();

                if (!isOverlapping(cameron, startTime, endTime)) {
                    cameron.add(startTime);
                    cameron.add(endTime);
                    result.append("C");
                } else if (!isOverlapping(jaimie, startTime, endTime)) {
                    jaimie.add(startTime);
                    jaimie.add(endTime);
                    result.append("J");
                }
            }

            if (result.length() < activities) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + t + ": " + result);
        }

        scanner.close();
    }
}