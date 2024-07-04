import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Solution {
    private static final Scanner scan = new Scanner(System.in);

    /**
     * @param args
     */
    public static void main(String[] args) {
        int tests = scan.nextInt();
        for (int i = 0; i < tests; i++) {
            int tasksSize = scan.nextInt();
            Integer [][] tasks = new Integer[tasksSize][2];
            for (int j = 0; j < tasksSize; j++) {
                tasks[j][0] = scan.nextInt();
                tasks[j][1] = scan.nextInt();
            }
            System.out.println("Case #" + (i + 1) + ": " + distributeTasks(tasks));
        }
    }

    private static String distributeTasks(Integer [][] tasks) {
        StringBuffer result = new StringBuffer();
        int endTimeJ = 0;
        int endTimeC = 0;
        Arrays.sort(tasks, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (Integer [] task : tasks) {
            int startTime = task[0];
            int endTime = task[1];
            if (endTimeJ <= startTime) {
                result.append("J");
                endTimeJ = endTime;
            } else if (endTimeC <= startTime) {
                result.append("C");
                endTimeC = endTime;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }
}
