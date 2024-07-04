import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        parentingPartneringReturns();
    }

    public static void parentingPartneringReturns() {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int t = scanner.nextInt();
        List<String> outputs = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            StringBuilder output = new StringBuilder();
            Schedule cameronSchedule = new Schedule();
            Schedule jamieSchedule = new Schedule();
            int n = scanner.nextInt();
            boolean isPossible = true;
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (cameronSchedule.isAvailable(start, end)) {
                    cameronSchedule.book(start, end);
                    output.append("C");
                } else if (jamieSchedule.isAvailable(start, end)) {
                    jamieSchedule.book(start, end);
                    output.append("J");
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                outputs.add(output.toString());
            } else {
                outputs.add("IMPOSSIBLE");
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + outputs.get(i));
        }
    }
}

class Schedule {
    private TimeSlot[] timeSlots = new TimeSlot[24];

    private int mapTimeToSlot(int time) {
        return time == 1440 ? 23 : time / 60;
    }

    public boolean isAvailable(int start, int end) {
        int startSlot = mapTimeToSlot(start);
        int endSlot = mapTimeToSlot(end);
        if (startSlot == endSlot) {
            return timeSlots[startSlot] == null || timeSlots[startSlot].isAvailable(start, end);
        } else {
            if ((timeSlots[startSlot] == null || timeSlots[startSlot].isAvailable(start, (startSlot + 1) * 60 - 1))
                    && (timeSlots[endSlot] == null || timeSlots[endSlot].isAvailable(endSlot * 60, end))) {
                for (int i = startSlot + 1; i < endSlot; i++) {
                    if (timeSlots[i] != null) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    }

    public void book(int start, int end) {
        int startSlot = mapTimeToSlot(start);
        int endSlot = mapTimeToSlot(end);
        if (startSlot == endSlot) {
            if (timeSlots[startSlot] == null) {
                timeSlots[startSlot] = new TimeSlot(start, end);
            } else {
                timeSlots[startSlot].book(start, end);
            }
        } else {
            if (timeSlots[startSlot] == null) {
                timeSlots[startSlot] = new TimeSlot(start, (startSlot + 1) * 60 - 1);
            } else {
                timeSlots[startSlot].book(start, (startSlot + 1) * 60 - 1);
            }
            if (timeSlots[endSlot] == null) {
                timeSlots[endSlot] = new TimeSlot(endSlot * 60, end);
            } else {
                timeSlots[endSlot].book(endSlot * 60, end);
            }
            for (int i = startSlot + 1; i < endSlot; i++) {
                timeSlots[i] = new TimeSlot(i * 60, (i + 1) * 60 - 1);
            }
        }
    }
}

class TimeSlot {
    private TimeSlot nextSlot;
    private int start;
    private int end;

    public TimeSlot(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean isAvailable(int start, int end) {
        if (end <= this.start || (start >= this.end && nextSlot == null)) {
            return true;
        } else if (start >= this.end && nextSlot != null) {
            return nextSlot.isAvailable(start, end);
        } else {
            return false;
        }
    }

    public void book(int start, int end) {
        if (start == this.end + 1 || start == this.end) {
            this.end = end;
        } else if (end == this.start - 1 || end == this.start) {
            this.start = start;
        } else if (end < this.start) {
            nextSlot = new TimeSlot(start, end, this);
        } else if (nextSlot != null) {
            nextSlot.book(start, end);
        } else {
            nextSlot = new TimeSlot(start, end);
        }
    }

    private TimeSlot(int start, int end, TimeSlot nextSlot) {
        this.start = start;
        this.end = end;
        this.nextSlot = nextSlot;
    }
}