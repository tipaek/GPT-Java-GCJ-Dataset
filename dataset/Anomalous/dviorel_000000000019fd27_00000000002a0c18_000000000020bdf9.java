import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activitiesCount = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            List<TimeSlot> cameronSlots = new ArrayList<>();
            List<TimeSlot> jamieSlots = new ArrayList<>();
            boolean isImpossible = false;
            
            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                TimeSlot currentSlot = new TimeSlot(start, end);
                
                if (!isImpossible) {
                    if (currentSlot.canFitIn(cameronSlots)) {
                        cameronSlots.add(currentSlot);
                        result.append("C");
                    } else if (currentSlot.canFitIn(jamieSlots)) {
                        jamieSlots.add(currentSlot);
                        result.append("J");
                    } else {
                        isImpossible = true;
                    }
                }
            }
            
            if (isImpossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }
            
            System.out.printf("Case #%d: %s%n", caseNumber, result.toString());
        }
        
        scanner.close();
    }

    static class TimeSlot {
        int start;
        int end;

        TimeSlot(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean canFitIn(List<TimeSlot> slots) {
            for (TimeSlot slot : slots) {
                if (isOverlapping(this, slot)) {
                    return false;
                }
            }
            return true;
        }

        private static boolean isOverlapping(TimeSlot slot1, TimeSlot slot2) {
            return slot1.end > slot2.start && slot1.start < slot2.end;
        }
    }
}