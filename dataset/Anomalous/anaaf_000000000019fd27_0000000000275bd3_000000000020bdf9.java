import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int k = 1; k <= t; k++) {
            int activities = in.nextInt();
            List<int[]> slots = new ArrayList<>();

            for (int i = 0; i < activities; i++) {
                int start = in.nextInt();
                int stop = in.nextInt();
                slots.add(new int[]{start, stop});
            }

            StringBuilder outputStr = new StringBuilder();
            List<int[]> C = new ArrayList<>();
            List<int[]> J = new ArrayList<>();
            boolean possible = true;

            for (int i = 0; i < activities && possible; i++) {
                int[] current = slots.get(i);
                int currentStart = current[0];
                int currentEnd = current[1];

                if (canAddActivity(C, currentStart, currentEnd)) {
                    C.add(current);
                    outputStr.append("C");
                } else if (canAddActivity(J, currentStart, currentEnd)) {
                    J.add(current);
                    outputStr.append("J");
                } else {
                    outputStr = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                }
            }

            System.out.println("Output String " + outputStr);
        }
    }

    private static boolean canAddActivity(List<int[]> schedule, int start, int end) {
        for (int[] activity : schedule) {
            if (!(end <= activity[0] || start >= activity[1])) {
                return false;
            }
        }
        return true;
    }
}