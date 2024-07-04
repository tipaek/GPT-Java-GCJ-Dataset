import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    private static final Scanner scan = new Scanner(System.in);

    /**
     * @param args
     */
    public static void main(String[] args) {
        int tests = scan.nextInt();
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < tests; i++) {
            int tasksSize = scan.nextInt();
            Integer [][] tasks = new Integer[tasksSize][2];
            for (int j = 0; j < tasksSize; j++) {
                tasks[j][0] = scan.nextInt();
                tasks[j][1] = scan.nextInt();
            }
            result.add("Case #" + (i + 1) + ": " + distributeTasks(tasks));
        }
        for (String string : result) {
            System.out.println(string);
        }
    }

    private static String distributeTasks(Integer [][] tasks) {
        StringBuffer result = new StringBuffer();
        Map<Integer, Integer> jCalendar = new HashMap<Integer, Integer>();
        Map<Integer, Integer> cCalendar = new HashMap<Integer, Integer>();
        for (Integer [] task : tasks) {
            int startTime = task[0];
            int endTime = task[1];
            int cDistance = isFree(cCalendar, startTime, endTime);
            int jDistance = isFree(jCalendar, startTime, endTime);
            if (cDistance < 0 && jDistance < 0) {
                return "IMPOSSIBLE";
            } else if (jDistance != -1 && (cDistance < 0 || jDistance <= cDistance)) {
                result.append("J");
                jCalendar.put(startTime, endTime);
            } else {
                result.append("C");
                cCalendar.put(startTime, endTime);
            } 
        }
        return result.toString();
    }

    private static int isFree(Map<Integer, Integer> calendar, int startTime, int endTime) {
        int distance = Integer.MAX_VALUE;
        for (Integer start: calendar.keySet()) {
            if (!(endTime <= start || startTime >= calendar.get(start))) {
                return -1;
            } else {
                if (endTime <= start) {
                    distance = Integer.min((start-endTime), distance);
                } else {
                    distance = Integer.min((startTime-calendar.get(start)), distance);
                }
            }
        }
        return distance;
    }
}
