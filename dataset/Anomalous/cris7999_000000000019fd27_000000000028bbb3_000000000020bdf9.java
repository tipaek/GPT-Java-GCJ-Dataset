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
            List<Character> result = new ArrayList<>();

            boolean impossibleCombination = false;
            sc.nextLine();
            for (int i = 0; i < numActivities; ++i) {
                String[] task = sc.nextLine().split(" ");
                int start = Integer.parseInt(task[0]);
                int finish = Integer.parseInt(task[1]);

                if (canDoActivity(cameronList, start, finish) && !impossibleCombination) {
                    cameronList.add(new int[]{start, finish});
                    result.add('C');
                } else if (canDoActivity(jaimeList, start, finish) && !impossibleCombination) {
                    jaimeList.add(new int[]{start, finish});
                    result.add('J');
                } else {
                    impossibleCombination = true;
                }
            }

            if (impossibleCombination) {
                System.out.println("Case #" + (test + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (test + 1) + ": ");
                for (char c : result) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }

    public static boolean canDoActivity(List<int[]> activities, int start, int finish) {
        for (int[] activity : activities) {
            int activityStart = activity[0];
            int activityFinish = activity[1];
            if ((start < activityFinish && finish > activityStart) || start > finish) {
                return false;
            }
        }
        return true;
    }
}