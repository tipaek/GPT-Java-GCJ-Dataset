import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numShifts = scanner.nextInt();
            int[][] shifts = new int[numShifts][2];
            for (int i = 0; i < numShifts; i++) {
                shifts[i][0] = scanner.nextInt();
                shifts[i][1] = scanner.nextInt();
            }
            Arrays.sort(shifts, Comparator.comparingInt(a -> a[0]));
            String result = assignShifts(shifts);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String assignShifts(int[][] shifts) {
        StringBuilder schedule = new StringBuilder();
        int[] cShift = {-1, -1};
        int[] jShift = {-1, -1};

        for (int[] shift : shifts) {
            if (canAssignShift(cShift, shift)) {
                updateShift(cShift, shift);
                schedule.append('C');
            } else if (canAssignShift(jShift, shift)) {
                updateShift(jShift, shift);
                schedule.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    private static boolean canAssignShift(int[] currentShift, int[] newShift) {
        return currentShift[1] <= newShift[0];
    }

    private static void updateShift(int[] currentShift, int[] newShift) {
        currentShift[0] = newShift[0];
        currentShift[1] = newShift[1];
    }
}