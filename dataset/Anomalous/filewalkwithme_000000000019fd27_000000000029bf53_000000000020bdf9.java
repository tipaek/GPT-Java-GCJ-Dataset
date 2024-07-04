import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numTasks = scanner.nextInt();
            Integer[][] tasks = new Integer[numTasks][2];

            for (int i = 0; i < numTasks; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
            }

            String result = solve(tasks);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    public static String solve(Integer[][] tasks) {
        return findNextValid(tasks, "");
    }

    public static String findNextValid(Integer[][] tasks, String currentAssignment) {
        BitSet jOccupied = new BitSet(24 * 60 + 1);
        BitSet cOccupied = new BitSet(24 * 60 + 1);
        char[] assignments = currentAssignment.toCharArray();

        for (int i = 0; i < assignments.length; i++) {
            int start = tasks[i][0];
            int end = tasks[i][1];

            if (assignments[i] == 'J') {
                jOccupied.set(start, end);
            } else if (assignments[i] == 'C') {
                cOccupied.set(start, end);
            }
        }

        int currentIndex = assignments.length;
        int currentStart = tasks[currentIndex][0];
        int currentEnd = tasks[currentIndex][1];

        if (!jOccupied.get(currentStart, currentEnd).isEmpty()) {
            if (currentIndex == tasks.length - 1) {
                return currentAssignment + "J";
            }
            String result = findNextValid(tasks, currentAssignment + "J");
            if (!result.equals("IMPOSSIBLE")) {
                return result;
            }
        }

        if (!cOccupied.get(currentStart, currentEnd).isEmpty()) {
            if (currentIndex == tasks.length - 1) {
                return currentAssignment + "C";
            }
            String result = findNextValid(tasks, currentAssignment + "C");
            if (!result.equals("IMPOSSIBLE")) {
                return result;
            }
        }

        return "IMPOSSIBLE";
    }
}