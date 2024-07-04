import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Solution {

    private static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static final String CAMERON = "C";
    private static final String JAMIE = "J";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    
    public static void main(String[] args) {
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            solveCase(i);
        }
    }
    
    private static void solveCase(int caseNumber) {
        int n = in.nextInt();
        StringBuilder schedule = new StringBuilder();
        List<Integer> C = new LinkedList<>();
        List<Integer> J = new LinkedList<>();
        boolean canCompute = true;
        for(int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            if(canCompute) {
                if(checkIfValid(C, start, end)) {
                    C.add(start);
                    C.add(end);
                    schedule.append(CAMERON);
                } else if(checkIfValid(J, start, end)) {
                    J.add(start);
                    J.add(end);
                    schedule.append(JAMIE);
                } else {
                    schedule.setLength(0);
                    schedule.append(IMPOSSIBLE);
                }
            }
        }
        System.out.println("Case #" + caseNumber + ": " + schedule.toString());
    }
    
    private static boolean checkIfValid(List<Integer> personSchedule, int start, int end) {
        if(personSchedule.isEmpty())
            return true;
        for(int i = 0; i < personSchedule.size(); i += 2) {
            if(isOverlapping(start, end, personSchedule.get(i), personSchedule.get(i+1))) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isOverlapping(int x1, int x2, int y1, int y2) {
       return x1 < y2 && y1 < x2; 
    }
    
}