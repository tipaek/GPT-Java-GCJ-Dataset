import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 1; caseIndex <= numCases; caseIndex++) {
            int numTasks = Integer.parseInt(scanner.nextLine());
            int[][] chores = new int[numTasks][2];

            for (int taskIndex = 0; taskIndex < numTasks; taskIndex++) {
                String[] tokens = scanner.nextLine().split(" ");
                chores[taskIndex][0] = Integer.parseInt(tokens[0]);
                chores[taskIndex][1] = Integer.parseInt(tokens[1]);
            }

            String result = allocateToCJ(chores, 1440);
            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }

    public static String allocateToCJ(int[][] activities, int totalSlots) {
        StringBuilder schedule = new StringBuilder();
        boolean[] cOccupied = new boolean[totalSlots];
        boolean[] jOccupied = new boolean[totalSlots];

        for (int[] activity : activities) {
            int start = activity[0];
            int end = activity[1];

            if (isFree(cOccupied, start, end)) {
                markOccupied(cOccupied, start, end);
                schedule.append('C');
            } else if (isFree(jOccupied, start, end)) {
                markOccupied(jOccupied, start, end);
                schedule.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    private static boolean isFree(boolean[] occupied, int start, int end) {
        for (int i = start; i < end; i++) {
            if (occupied[i]) {
                return false;
            }
        }
        return true;
    }

    private static void markOccupied(boolean[] occupied, int start, int end) {
        for (int i = start; i < end; i++) {
            occupied[i] = true;
        }
    }
}