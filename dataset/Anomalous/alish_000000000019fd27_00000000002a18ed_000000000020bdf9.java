import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int cases = input.nextInt();

            for (int i = 1; i <= cases; i++) {
                int activities = input.nextInt();
                StringBuilder result = new StringBuilder();
                LinkedList<int[]> cameron = new LinkedList<>();
                LinkedList<int[]> jamie = new LinkedList<>();

                // Initial assignments
                cameron.add(new int[]{input.nextInt(), input.nextInt()});
                jamie.add(new int[]{input.nextInt(), input.nextInt()});
                result.append("CJ");

                boolean isPossible = true;

                for (int j = 3; j <= activities; j++) {
                    int start = input.nextInt();
                    int finish = input.nextInt();

                    if (!assignActivity(cameron, start, finish)) {
                        if (!assignActivity(jamie, start, finish)) {
                            isPossible = false;
                            // Skip remaining input for this case
                            for (int k = j; k < activities; k++) {
                                input.nextInt();
                                input.nextInt();
                            }
                            break;
                        } else {
                            result.append("J");
                        }
                    } else {
                        result.append("C");
                    }
                }

                if (!isPossible) {
                    result = new StringBuilder("IMPOSSIBLE");
                }

                System.out.println("Case #" + i + ": " + result);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean assignActivity(LinkedList<int[]> schedule, int start, int finish) {
        for (int[] interval : schedule) {
            if ((start >= interval[0] && start < interval[1]) || (finish > interval[0] && finish <= interval[1])) {
                return false;
            }
        }

        // Insert the new interval in sorted order
        for (int i = 0; i < schedule.size(); i++) {
            if (finish <= schedule.get(i)[0]) {
                schedule.add(i, new int[]{start, finish});
                return true;
            }
        }

        schedule.add(new int[]{start, finish});
        return true;
    }
}