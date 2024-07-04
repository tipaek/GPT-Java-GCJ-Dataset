import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            processTestCase(scanner, i);
        }
    }

    private static void processTestCase(Scanner scanner, int caseNumber) {
        int n = scanner.nextInt();
        List<TimeSlot> timeSlots = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            timeSlots.add(new TimeSlot(i, scanner.nextInt(), scanner.nextInt()));
        }

        for (int i = 0; i < timeSlots.size() - 1; i++) {
            for (int j = i + 1; j < timeSlots.size(); j++) {
                if (timeSlots.get(i).conflictsWith(timeSlots.get(j))) {
                    timeSlots.get(i).addConflict(timeSlots.get(j));
                    timeSlots.get(j).addConflict(timeSlots.get(i));
                }
            }
        }

        if (assignOwners(timeSlots)) {
            System.out.print("Case #" + caseNumber + ": ");
            for (TimeSlot slot : timeSlots) {
                System.out.print(slot.owner == 0 ? "C" : "J");
            }
            System.out.println();
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }

    private static boolean assignOwners(List<TimeSlot> timeSlots) {
        Queue<TimeSlot> queue = new LinkedList<>();
        for (TimeSlot slot : timeSlots) {
            if (slot.owner == -1) {
                slot.owner = 0;
                slot.visited = true;
                queue.add(slot);
                while (!queue.isEmpty()) {
                    TimeSlot current = queue.poll();
                    for (TimeSlot conflict : current.conflicts) {
                        if (!conflict.visited) {
                            conflict.visited = true;
                            conflict.owner = 1 - current.owner;
                            queue.add(conflict);
                        } else if (conflict.owner == current.owner) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

class TimeSlot {
    int number;
    int start;
    int end;
    int owner;
    boolean visited;
    List<TimeSlot> conflicts;

    TimeSlot(int number, int start, int end) {
        this.number = number;
        this.start = start;
        this.end = end;
        this.owner = -1;
        this.visited = false;
        this.conflicts = new ArrayList<>();
    }

    void addConflict(TimeSlot slot) {
        conflicts.add(slot);
    }

    boolean conflictsWith(TimeSlot slot) {
        return !(this.end <= slot.start || this.start >= slot.end);
    }
}