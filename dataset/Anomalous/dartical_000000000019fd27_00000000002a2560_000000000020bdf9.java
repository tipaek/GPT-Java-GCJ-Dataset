import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    
    private int start;
    private int end;
    
    public Solution(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    public int getStart() {
        return start;
    }
    
    public int getEnd() {
        return end;
    }
    
    public boolean overlapsWith(Solution other) {
        return (other.getEnd() > start && other.getStart() < end);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int numAssignments = scanner.nextInt();
            Solution[] assignments = new Solution[numAssignments];
            
            for (int i = 0; i < numAssignments; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                assignments[i] = new Solution(start, end);
            }
            
            ArrayList<Solution> cAssignments = new ArrayList<>();
            ArrayList<Solution> jAssignments = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            
            for (Solution assignment : assignments) {
                result.append(assignAssignment(cAssignments, jAssignments, assignment));
            }
            
            if (result.toString().contains("I")) {
                result = new StringBuilder("IMPOSSIBLE");
            }
            
            System.out.println("Case #" + t + ": " + result);
        }
        
        scanner.close();
    }
    
    public static String assignAssignment(ArrayList<Solution> cAssignments, ArrayList<Solution> jAssignments, Solution assignment) {
        boolean overlapsWithC = cAssignments.stream().anyMatch(c -> c.overlapsWith(assignment));
        boolean overlapsWithJ = jAssignments.stream().anyMatch(j -> j.overlapsWith(assignment));
        
        if (!overlapsWithC) {
            cAssignments.add(assignment);
            return "C";
        } else if (!overlapsWithJ) {
            jAssignments.add(assignment);
            return "J";
        } else {
            return "I";
        }
    }
}