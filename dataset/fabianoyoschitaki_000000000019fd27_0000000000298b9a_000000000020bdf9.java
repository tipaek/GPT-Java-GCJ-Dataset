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
            int [][] tasks = new int[tasksSize][2];
            for (int j = 0; j < tasksSize; j++) {
                tasks[j][0] = scan.nextInt();
                tasks[j][1] = scan.nextInt();
            }
            System.out.println("Case #" + (i + 1) + ": " + distributeTasks(tasks));
        }
    }

    private static String distributeTasks(int [][] tasks) {
        StringBuffer result = new StringBuffer();
        int endTimeJ = 0;
        int endTimeC = 0;
        for (int [] task : tasks) {
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
