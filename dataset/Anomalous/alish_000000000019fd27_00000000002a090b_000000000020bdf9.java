import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();

        for (int i = 1; i <= cases; i++) {
            int activities = input.nextInt();
            StringBuilder result = new StringBuilder();
            List<int[]> cameron = new ArrayList<>();
            List<int[]> jamie = new ArrayList<>();

            // Read first activity for both Cameron and Jamie
            cameron.add(new int[]{input.nextInt(), input.nextInt()});
            jamie.add(new int[]{input.nextInt(), input.nextInt()});
            result.append("CJ");

            boolean stopCameron, stopJamie;

            for (int j = 3; j <= activities; j++) {
                int start = input.nextInt();
                int finish = input.nextInt();

                stopCameron = isOverlapping(cameron, start, finish);
                stopJamie = isOverlapping(jamie, start, finish);

                if (!stopCameron) {
                    addActivity(cameron, start, finish);
                    result.append("C");
                } else if (!stopJamie) {
                    addActivity(jamie, start, finish);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static boolean isOverlapping(List<int[]> schedule, int start, int finish) {
        for (int[] interval : schedule) {
            if (start < interval[1] && finish > interval[0]) {
                return true;
            }
        }
        return false;
    }

    private static void addActivity(List<int[]> schedule, int start, int finish) {
        schedule.add(new int[]{start, finish});
    }
}