import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            List<int[]> cameron = new ArrayList<>();
            List<int[]> jamie = new ArrayList<>();
            int numberOfTimes = Integer.parseInt(scanner.nextLine());
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < numberOfTimes; i++) {
                int[] timeSlot = parseTimeSlot(scanner.nextLine());
                
                if (timeSlot.length <= 1) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
                
                if (!hasOverlap(jamie, timeSlot)) {
                    jamie.add(timeSlot);
                    result.append("J");
                } else if (!hasOverlap(cameron, timeSlot)) {
                    cameron.add(timeSlot);
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static int[] parseTimeSlot(String input) {
        String[] parts = input.split(" ");
        int[] timeSlot = new int[parts.length];
        
        for (int i = 0; i < parts.length; i++) {
            timeSlot[i] = Integer.parseInt(parts[i]);
        }
        return timeSlot;
    }

    private static boolean hasOverlap(List<int[]> schedule, int[] timeSlot) {
        for (int[] slot : schedule) {
            if (isOverlapping(slot[0], slot[1], timeSlot[0], timeSlot[1])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && end1 > start2);
    }
}