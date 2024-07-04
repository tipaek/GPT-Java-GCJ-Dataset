import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            PriorityQueue<int[]> activities = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

            for (int i = 0; i < n; i++) {
                activities.add(new int[]{scanner.nextInt(), scanner.nextInt(), i});
            }

            int endTimeC = 0, endTimeJ = 0;
            char[] schedule = new char[n];
            boolean isImpossible = false;

            for (int i = 0; i < n; i++) {
                int[] currentActivity = activities.poll();

                if (endTimeC <= currentActivity[0]) {
                    endTimeC = currentActivity[1];
                    schedule[currentActivity[2]] = 'C';
                } else if (endTimeJ <= currentActivity[0]) {
                    endTimeJ = currentActivity[1];
                    schedule[currentActivity[2]] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            String result = isImpossible ? "IMPOSSIBLE" : new String(schedule);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}