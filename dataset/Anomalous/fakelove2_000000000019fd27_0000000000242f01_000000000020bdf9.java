import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static class TimeSlot {
        int start, end;
        char assignedTo;

        TimeSlot(int start, int end) {
            this.start = start;
            this.end = end;
            this.assignedTo = '\0';
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; ++i) {
                System.out.print("Case #");
                System.out.print(i);
                System.out.print(": ");
                processTestCase(scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processTestCase(Scanner scanner) {
        int n = scanner.nextInt();
        TimeSlot[] timeSlots = new TimeSlot[n];
        for (int i = 0; i < n; i++) {
            timeSlots[i] = new TimeSlot(scanner.nextInt(), scanner.nextInt());
        }

        ArrayList<TimeSlot> cameronSchedule = new ArrayList<>();
        ArrayList<TimeSlot> jamieSchedule = new ArrayList<>();

        for (TimeSlot slot : timeSlots) {
            if (isValid(cameronSchedule, slot)) {
                slot.assignedTo = 'C';
                cameronSchedule.add(slot);
            } else if (isValid(jamieSchedule, slot)) {
                slot.assignedTo = 'J';
                jamieSchedule.add(slot);
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        for (TimeSlot slot : timeSlots) {
            System.out.print(slot.assignedTo);
        }
        System.out.println();
    }

    private static boolean isValid(ArrayList<TimeSlot> schedule, TimeSlot slot) {
        for (TimeSlot existingSlot : schedule) {
            if (overlaps(existingSlot, slot)) {
                return false;
            }
        }
        return true;
    }

    private static boolean overlaps(TimeSlot slot1, TimeSlot slot2) {
        return (slot1.start < slot2.end && slot2.start < slot1.end);
    }
}