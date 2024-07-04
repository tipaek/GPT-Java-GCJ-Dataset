import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testSetSize = in.nextInt();
        
        for (int i = 1; i <= testSetSize; ++i) {
            int numberActivities = in.nextInt();
            List<Integer> cameronStart = new ArrayList<>();
            List<Integer> cameronEnd = new ArrayList<>();
            List<Integer> jamieStart = new ArrayList<>();
            List<Integer> jamieEnd = new ArrayList<>();
            StringBuilder answer = new StringBuilder();
            boolean isImpossible = false;
            
            for (int j = 0; j < numberActivities; j++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                
                if (!isImpossible) {
                    if (!assignActivity(startTime, endTime, cameronStart, cameronEnd)) {
                        if (!assignActivity(startTime, endTime, jamieStart, jamieEnd)) {
                            isImpossible = true;
                            answer.setLength(0); // Clear the answer
                            answer.append("IMPOSSIBLE");
                        } else {
                            answer.append("J");
                        }
                    } else {
                        answer.append("C");
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + answer.toString());
        }
    }

    private static boolean assignActivity(int startTime, int endTime, List<Integer> startList, List<Integer> endList) {
        for (int i = 0; i < startList.size(); i++) {
            int existingStart = startList.get(i);
            int existingEnd = endList.get(i);
            
            if (startTime < existingEnd && endTime > existingStart) {
                return false;
            }
        }
        
        startList.add(startTime);
        endList.add(endTime);
        return true;
    }
}