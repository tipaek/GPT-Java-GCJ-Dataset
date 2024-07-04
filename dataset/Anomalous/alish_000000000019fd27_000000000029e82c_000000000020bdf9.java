import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();

        for (int i = 1; i <= cases; i++) {
            int activities = input.nextInt();
            StringBuilder result = new StringBuilder();
            ArrayList<int[]> cameron = new ArrayList<>();
            ArrayList<int[]> jamie = new ArrayList<>();

            for (int j = 0; j < activities; j++) {
                int start = input.nextInt();
                int finish = input.nextInt();
                if (assignActivity(cameron, start, finish)) {
                    result.append("C");
                } else if (assignActivity(jamie, start, finish)) {
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
        input.close();
    }

    private static boolean assignActivity(ArrayList<int[]> schedule, int start, int finish) {
        for (int[] interval : schedule) {
            if ((start >= interval[0] && start < interval[1]) || (finish > interval[0] && finish <= interval[1])) {
                return false;
            }
        }
        schedule.add(new int[]{start, finish});
        return true;
    }
}