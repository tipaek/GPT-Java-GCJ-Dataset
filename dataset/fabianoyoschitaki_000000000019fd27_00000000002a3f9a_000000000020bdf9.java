import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
        Integer [][] temp = Arrays.copyOf(tasks, tasks.length);
        Arrays.sort(temp, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[0] == o2[0])
                    return (o2[1] - o2[0]) - (o1[1] - o1[0]);
                else
                    return o1[0] - o2[0];
            }
        });
        Map<Integer[], List<String>> answers = new HashMap<Integer[], List<String>>();
        for (Integer [] task : temp) {
            int startTime = task[0];
            int endTime = task[1];
            int cDistance = isFree(cCalendar, startTime, endTime);
            int jDistance = isFree(jCalendar, startTime, endTime);
            if (cDistance < 0 && jDistance < 0) {
                return "IMPOSSIBLE";
            } else if (jDistance != -1 && (cDistance < 0 || jDistance <= cDistance)) {
                List<String> val = answers.get(task);
                if (val == null) {
                    val = new ArrayList<String>();
                }
                val.add("J");
                answers.put(task, val);
                jCalendar.put(startTime, endTime);
            } else {
                List<String> val = answers.get(task);
                if (val == null) {
                    val = new ArrayList<String>();
                }
                val.add("C");
                answers.put(task, val);
                cCalendar.put(startTime, endTime);
            } 
        }
        for (Integer[] pair : tasks) {
            List<String> val = answers.get(pair);
            result.append(val.remove(0));
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
