import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
        Map<Integer, Integer> jCalendar = new HashMap<Integer, Integer>();
        Map<Integer, Integer> cCalendar = new HashMap<Integer, Integer>();
        for (Integer [] task : tasks) {
            int startTime = task[0];
            int endTime = task[1];
            if (isFree(jCalendar, startTime, endTime)) {
                result.append("J");
            } else if (isFree(cCalendar, startTime, endTime)) {
                result.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    private static boolean isFree(Map<Integer, Integer> calendar, int startTime, int endTime) {
        for (Integer start: calendar.keySet()) {
            if (!(endTime <= start || startTime >= calendar.get(start))) {
                return false;
            }
        }
        calendar.put(startTime, endTime);
        return true;
    }
}
