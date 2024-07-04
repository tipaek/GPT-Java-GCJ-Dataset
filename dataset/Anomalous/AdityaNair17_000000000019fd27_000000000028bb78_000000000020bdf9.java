import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCaseCount = input.nextInt();

        for (int t = 1; t <= testCaseCount; t++) {
            int N = input.nextInt();
            StringBuilder schedule = new StringBuilder("X".repeat(N));

            int cameronEnd = 0;
            int jamieEnd = 0;

            List<int[]> timeSlots = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int start = input.nextInt();
                int end = input.nextInt();
                timeSlots.add(new int[]{start, end, i});
            }

            timeSlots.sort(Comparator.comparingInt(slot -> slot[0]));

            boolean possible = true;

            for (int[] slot : timeSlots) {
                int start = slot[0];
                int end = slot[1];
                int index = slot[2];

                if (start >= cameronEnd) {
                    schedule.setCharAt(index, 'C');
                    cameronEnd = end;
                } else if (start >= jamieEnd) {
                    schedule.setCharAt(index, 'J');
                    jamieEnd = end;
                } else {
                    possible = false;
                    break;
                }
            }

            String result = possible ? schedule.toString() : "IMPOSSIBLE";
            System.out.println("Case #" + t + ": " + result);
        }
    }
}