import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int numShifts = scanner.nextInt();
            int[][] shifts = new int[numShifts][3];
            
            for (int i = 0; i < numShifts; i++) {
                shifts[i][2] = i;
                shifts[i][0] = scanner.nextInt();
                shifts[i][1] = scanner.nextInt();
            }
            
            Arrays.sort(shifts, Comparator.comparingInt(a -> a[0]));
            int[] order = new int[numShifts];
            
            for (int i = 0; i < numShifts; i++) {
                order[i] = shifts[i][2];
            }
            
            String unorderedSolution = assignShifts(shifts);
            System.out.println("Case #" + caseNumber + ": " + reorderSolution(unorderedSolution, order));
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

    private static String reorderSolution(String unorderedSolution, int[] order) {
        if ("IMPOSSIBLE".equals(unorderedSolution)) {
            return "IMPOSSIBLE";
        }
        
        StringBuilder orderedSolution = new StringBuilder();
        for (int index : order) {
            orderedSolution.append(unorderedSolution.charAt(index));
        }
        
        return orderedSolution.toString();
    }
}