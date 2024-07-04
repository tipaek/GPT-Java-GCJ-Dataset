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
        int endC = Integer.MIN_VALUE;
        int startC = Integer.MAX_VALUE;
        int endJ = Integer.MIN_VALUE;
        int startJ = Integer.MAX_VALUE;

        for (Integer[] task : tasks) {
            int start = task[0];
            int end = task[1];
            if (endJ <= start || end <= startJ) {
                result.append("J");
                endJ = end;
                startJ = start;
            } else if (endC <= start || end <= startC) {
                result.append("C");
                endC = end;
                startC = start;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }
}