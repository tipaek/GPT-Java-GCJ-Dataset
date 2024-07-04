import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int numShifts = scanner.nextInt();
            int[][] shifts = new int[numShifts][3];

            for (int j = 0; j < numShifts; j++) {
                shifts[j][2] = j;
                shifts[j][0] = scanner.nextInt();
                shifts[j][1] = scanner.nextInt();
            }

            Arrays.sort(shifts, Comparator.comparingInt(a -> a[0]));
            int[] originalOrder = new int[numShifts];
            for (int j = 0; j < numShifts; j++) {
                originalOrder[j] = shifts[j][2];
            }

            String unordSolution = assignShifts(shifts);
            System.out.println("Case #" + i + ": " + reorderSolution(unordSolution, originalOrder));
        }
    }

    private static String assignShifts(int[][] shifts) {
        StringBuilder result = new StringBuilder();
        int[] cShift = {-1, -1};
        int[] jShift = {-1, -1};

        for (int[] shift : shifts) {
            if (cShift[1] <= shift[0]) {
                cShift[0] = shift[0];
                cShift[1] = shift[1];
                result.append("C");
            } else if (jShift[1] <= shift[0]) {
                jShift[0] = shift[0];
                jShift[1] = shift[1];
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    private static String reorderSolution(String unordSolution, int[] originalOrder) {
        if ("IMPOSSIBLE".equals(unordSolution)) {
            return "IMPOSSIBLE";
        }

        char[] reorderedSolution = new char[originalOrder.length];
        for (int i = 0; i < originalOrder.length; i++) {
            reorderedSolution[originalOrder[i]] = unordSolution.charAt(i);
        }

        return new String(reorderedSolution);
    }
}