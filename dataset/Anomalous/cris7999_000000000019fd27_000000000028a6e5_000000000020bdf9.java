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
            sc.nextLine();
            for (int i = 0; i < numActivities; ++i) {

                String task = sc.nextLine();
                String[] formatTask = task.split(" ");

                int start = Integer.parseInt(formatTask[0]);
                int finish = Integer.parseInt(formatTask[1]);

                if (canDoActivity(cameronList, start, finish) && !impossibleCombination) {
                    cameronList.add(new int[]{start, finish});
                    result.append('C');
                } else if (canDoActivity(jaimeList, start, finish) && !impossibleCombination) {
                    jaimeList.add(new int[]{start, finish});
                    result.append('J');
                } else {
                    impossibleCombination = true;
                }
            }
            if (impossibleCombination) {
                System.out.println("Case #" + (test + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (test + 1) + ": " + result.toString());
            }
        }
        sc.close();
    }

    public static boolean canDoActivity(List<int[]> myList, int start, int finish) {
        for (int[] task : myList) {
            int taskStart = task[0];
            int taskFinish = task[1];
            if ((start >= taskStart && start < taskFinish) || 
                (finish > taskStart && finish <= taskFinish) || 
                (start <= taskStart && finish > taskFinish) || 
                (start >= taskStart && finish <= taskFinish)) {
                return false;
            }
        }
        return true;
    }
}