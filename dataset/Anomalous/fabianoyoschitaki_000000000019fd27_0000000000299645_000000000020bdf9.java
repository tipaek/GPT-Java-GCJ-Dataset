import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int numberOfTasks = scanner.nextInt();
            Integer[][] tasks = new Integer[numberOfTasks][2];
            for (int j = 0; j < numberOfTasks; j++) {
                tasks[j][0] = scanner.nextInt();
                tasks[j][1] = scanner.nextInt();
            }
            System.out.println("Case #" + (i + 1) + ": " + assignTasks(tasks));
        }
    }

    private static String assignTasks(Integer[][] tasks) {
        StringBuilder result = new StringBuilder();
        int endTimeJ = 0;
        int endTimeC = 0;

        Arrays.sort(tasks, Comparator.comparingInt(task -> task[0]));

        for (Integer[] task : tasks) {
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