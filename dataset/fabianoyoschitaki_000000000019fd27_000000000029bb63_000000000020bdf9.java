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
        int endTimeC = Integer.MIN_VALUE;
        int startTimeC = Integer.MAX_VALUE;
        int endTimeJ = Integer.MIN_VALUE;
        int startTimeJ = Integer.MAX_VALUE;
        Integer[][] test = Arrays.copyOf(tasks, tasks.length);
        Arrays.sort(test, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
            
        });
        for (Integer [] task : test) {
            int startTime = task[0];
            int endTime = task[1];
            if (endTimeJ <= startTime || endTime <= startTimeJ) {
                endTimeJ = endTime;
                startTimeJ = startTime;
            } else if (endTimeC <= startTime || endTime <= startTimeC) {
                endTimeC = endTime;
                startTimeC = startTime;
            } 
            else {
                return "IMPOSSIBLE";
            }
        }
        endTimeC = Integer.MIN_VALUE;
        startTimeC = Integer.MAX_VALUE;
        endTimeJ = Integer.MIN_VALUE;
        startTimeJ = Integer.MAX_VALUE;
        for (Integer [] task : tasks) {
            int startTime = task[0];
            int endTime = task[1];
            if (endTimeJ <= startTime || endTime <= startTimeJ) {
                result.append("J");
                endTimeJ = endTime;
                startTimeJ = startTime;
            } else if (endTimeC <= startTime || endTime <= startTimeC) {
                result.append("C");
                endTimeC = endTime;
                startTimeC = startTime;
            } 
        }
        return result.toString();
    }
}
