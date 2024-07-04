import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int numShifts = scanner.nextInt();
            int[][] shifts = new int[numShifts][3];
            
            for (int i = 0; i < numShifts; i++) {
                shifts[i][2] = i;
                shifts[i][0] = scanner.nextInt();
                shifts[i][1] = scanner.nextInt();
            }
            
            Arrays.sort(shifts, Comparator.comparingInt(shift -> shift[0]));
            int[] originalOrder = new int[numShifts];
            
            for (int i = 0; i < numShifts; i++) {
                originalOrder[i] = shifts[i][2];
            }
            
            String unsortedSolution = assignShifts(shifts);
            String finalSolution = reorderSolution(unsortedSolution, originalOrder);
            System.out.println("Case #" + caseNum + ": " + finalSolution);
        }
    }

    private static String assignShifts(int[][] shifts) {
        StringBuilder result = new StringBuilder();
        int[] cShift = {-1, -1};
        int[] jShift = {-1, -1};
        
        for (int[] shift : shifts) {
            if (canAssignShift(cShift, shift)) {
                assignShift(cShift, shift);
                result.append("C");
            } else if (canAssignShift(jShift, shift)) {
                assignShift(jShift, shift);
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return result.toString();
    }

    private static boolean canAssignShift(int[] currentShift, int[] newShift) {
        return currentShift[0] == -1 || currentShift[1] <= newShift[0];
    }

    private static void assignShift(int[] currentShift, int[] newShift) {
        currentShift[0] = newShift[0];
        currentShift[1] = newShift[1];
    }

    private static String reorderSolution(String unsortedSolution, int[] order) {
        if (unsortedSolution.equals("IMPOSSIBLE")) {
            return "IMPOSSIBLE";
        }
        
        char[] sortedSolution = new char[order.length];
        for (int i = 0; i < order.length; i++) {
            sortedSolution[order[i]] = unsortedSolution.charAt(i);
        }
        
        return new String(sortedSolution);
    }
}