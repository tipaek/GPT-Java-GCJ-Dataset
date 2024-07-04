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
            
            boolean possible = true;
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
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
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
    private TimeNode[] timeNodes = new TimeNode[24];

    private int mapTime(int time) {
        return time == 1440 ? 23 : time / 60;
    }

    public boolean isAvailable(int start, int end) {
        int mappedStart = mapTime(start);
        int mappedEnd = mapTime(end);
        
        if (mappedStart == mappedEnd) {
            return timeNodes[mappedStart] == null || timeNodes[mappedStart].isAvailable(start, end);
        } else {
            if ((timeNodes[mappedStart] == null || timeNodes[mappedStart].isAvailable(start, (mappedStart + 1) * 60 - 1)) &&
                (timeNodes[mappedEnd] == null || timeNodes[mappedEnd].isAvailable(mappedEnd * 60, end))) {
                
                for (int i = mappedStart + 1; i < mappedEnd; i++) {
                    if (timeNodes[i] != null) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    }

    public void book(int start, int end) {
        int mappedStart = mapTime(start);
        int mappedEnd = mapTime(end);
        
        if (mappedStart == mappedEnd) {
            timeNodes[mappedStart] = timeNodes[mappedStart] == null ? new TimeNode(start, end) : timeNodes[mappedStart].book(start, end);
        } else {
            timeNodes[mappedStart] = timeNodes[mappedStart] == null ? new TimeNode(start, (mappedStart + 1) * 60 - 1) : timeNodes[mappedStart].book(start, (mappedStart + 1) * 60 - 1);
            timeNodes[mappedEnd] = timeNodes[mappedEnd] == null ? new TimeNode(mappedEnd * 60, end) : timeNodes[mappedEnd].book(mappedEnd * 60, end);
            
            for (int i = mappedStart + 1; i < mappedEnd; i++) {
                timeNodes[i] = new TimeNode(i * 60, (i + 1) * 60 - 1);
            }
        }
    }
}

class TimeNode {
    private int start;
    private int end;
    private TimeNode next;

    public TimeNode(int start, int end) {
        this(start, end, null);
    }

    public TimeNode(int start, int end, TimeNode next) {
        this.start = start;
        this.end = end;
        this.next = next;
    }

    public boolean isAvailable(int start, int end) {
        if (end <= this.start || (start >= this.end && next == null)) {
            return true;
        } else if (start >= this.end && next != null) {
            return next.isAvailable(start, end);
        } else {
            return false;
        }
    }

    public TimeNode book(int start, int end) {
        if (start == this.end + 1 || start == this.end) {
            this.end = end;
            return this;
        } else if (end == this.start - 1 || end == this.start) {
            this.start = start;
            return this;
        } else if (end < this.start) {
            return new TimeNode(start, end, this);
        } else if (next != null) {
            next = next.book(start, end);
            return this;
        } else {
            next = new TimeNode(start, end);
            return this;
        }
    }
}