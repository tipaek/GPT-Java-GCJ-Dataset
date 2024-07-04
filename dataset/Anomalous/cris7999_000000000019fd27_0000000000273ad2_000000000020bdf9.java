import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();

        for (int test = 0; test < numTest; ++test) {
            int numActivities = sc.nextInt();
            List<int[]> jaimeList = new ArrayList<>();
            List<int[]> cameronList = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            boolean impossibleCombination = false;
            sc.nextLine(); // consume the remaining newline

            for (int i = 0; i < numActivities; ++i) {
                String[] formatTask = sc.nextLine().split(" ");
                int start = Integer.parseInt(formatTask[0]);
                int finish = Integer.parseInt(formatTask[1]);

                if (canPerformActivity(cameronList, start, finish) && !impossibleCombination) {
                    cameronList.add(new int[]{start, finish});
                    result.append('C');
                } else if (canPerformActivity(jaimeList, start, finish) && !impossibleCombination) {
                    jaimeList.add(new int[]{start, finish});
                    result.append('J');
                } else {
                    impossibleCombination = true;
                }
            }

            if (impossibleCombination) {
                System.out.println("Case #" + (test + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (test + 1) + ": " + result);
            }
        }
        sc.close();
    }

    public static boolean canPerformActivity(List<int[]> myList, int start, int finish) {
        for (int[] activity : myList) {
            if ((start >= activity[0] && start < activity[1]) || (finish > activity[0] && finish <= activity[1])) {
                return false;
            }
        }
        return true;
    }
}