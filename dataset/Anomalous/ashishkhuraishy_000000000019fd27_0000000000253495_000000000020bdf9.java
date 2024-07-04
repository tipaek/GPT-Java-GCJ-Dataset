import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activityCount = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();

            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new int[]{start, end});
            }

            StringBuilder cameronSchedule = new StringBuilder(repeatChar('F', 1440));
            StringBuilder jamieSchedule = new StringBuilder(repeatChar('F', 1440));
            StringBuilder result = new StringBuilder();

            boolean possible = true;
            for (int[] activity : activities) {
                int start = activity[0];
                int end = activity[1];

                if (!cameronSchedule.substring(start, end).contains("T")) {
                    cameronSchedule.replace(start, end, repeatChar('T', end - start));
                    result.append("C");
                } else if (!jamieSchedule.substring(start, end).contains("T")) {
                    jamieSchedule.replace(start, end, repeatChar('T', end - start));
                    result.append("J");
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }

        scanner.close();
    }

    private static String repeatChar(char c, int count) {
        char[] array = new char[count];
        Arrays.fill(array, c);
        return new String(array);
    }
}