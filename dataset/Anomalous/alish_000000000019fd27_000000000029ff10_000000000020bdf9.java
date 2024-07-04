import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();

        for (int i = 1; i <= cases; i++) {
            int activities = input.nextInt();
            StringBuilder result = new StringBuilder();
            LinkedList<int[]> cameron = new LinkedList<>();
            LinkedList<int[]> jamie = new LinkedList<>();

            cameron.add(new int[]{input.nextInt(), input.nextInt()});
            jamie.add(new int[]{input.nextInt(), input.nextInt()});
            result.append("CJ");

            boolean isImpossible = false;

            for (int j = 3; j <= activities; j++) {
                int start = input.nextInt();
                int finish = input.nextInt();
                boolean assigned = false;

                if (!isOverlapping(cameron, start, finish)) {
                    insertActivity(cameron, start, finish);
                    result.append("C");
                    assigned = true;
                } else if (!isOverlapping(jamie, start, finish)) {
                    insertActivity(jamie, start, finish);
                    result.append("J");
                    assigned = true;
                }

                if (!assigned) {
                    result = new StringBuilder("IMPOSSIBLE");
                    for (int k = j + 1; k <= activities; k++) {
                        input.nextInt();
                        input.nextInt();
                    }
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static boolean isOverlapping(LinkedList<int[]> schedule, int start, int finish) {
        for (int[] interval : schedule) {
            if ((start < interval[1] && finish > interval[0])) {
                return true;
            }
        }
        return false;
    }

    private static void insertActivity(LinkedList<int[]> schedule, int start, int finish) {
        for (int i = 0; i < schedule.size(); i++) {
            int[] interval = schedule.get(i);
            if (finish <= interval[0]) {
                schedule.add(i, new int[]{start, finish});
                return;
            }
        }
        schedule.add(new int[]{start, finish});
    }
}