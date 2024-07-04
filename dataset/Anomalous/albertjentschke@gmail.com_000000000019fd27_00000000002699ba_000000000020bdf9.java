import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        parentingPartneringReturns();
    }

    public static void parentingPartneringReturns() {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int t = scanner.nextInt();
        List<String> results = new ArrayList<>();
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            List<Entry> entries = new ArrayList<>();
            Map<Integer, Entry> entryMap = new HashMap<>();
            TimeScheduler cameronScheduler = new TimeScheduler();
            TimeScheduler jamieScheduler = new TimeScheduler();
            boolean isPossible = true;
            StringBuilder output = new StringBuilder();
            
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Entry entry = new Entry(start, end);
                entries.add(entry);
                entryMap.put(j, entry);
            }
            
            entries.sort(Comparator.comparingInt(Entry::getStart));
            
            for (Entry entry : entries) {
                if (cameronScheduler.isAvailable(entry.getStart(), entry.getEnd())) {
                    cameronScheduler.book(entry.getStart(), entry.getEnd());
                    entry.setPerson('C');
                } else if (jamieScheduler.isAvailable(entry.getStart(), entry.getEnd())) {
                    jamieScheduler.book(entry.getStart(), entry.getEnd());
                    entry.setPerson('J');
                } else {
                    isPossible = false;
                    output.append("IMPOSSIBLE");
                    break;
                }
            }
            
            if (isPossible) {
                for (int j = 0; j < n; j++) {
                    output.append(entryMap.get(j).getPerson());
                }
            }
            
            results.add(output.toString());
        }
        
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }
}

class TimeScheduler {
    private Node[] timeSlots = new Node[24];

    private int mapTime(int time) {
        return time == 1440 ? 23 : time / 60;
    }

    public boolean isAvailable(int start, int end) {
        int startSlot = mapTime(start);
        int endSlot = mapTime(end);
        
        if (startSlot == endSlot) {
            return timeSlots[startSlot] == null || timeSlots[startSlot].isAvailable(start, end);
        } else {
            if ((timeSlots[startSlot] == null || timeSlots[startSlot].isAvailable(start, startSlot * 60 + 59)) &&
                (timeSlots[endSlot] == null || timeSlots[endSlot].isAvailable(endSlot * 60, end))) {
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
        int startSlot = mapTime(start);
        int endSlot = mapTime(end);
        
        if (startSlot == endSlot) {
            timeSlots[startSlot] = timeSlots[startSlot] == null ? new Node(start, end) : timeSlots[startSlot].book(start, end);
        } else {
            timeSlots[startSlot] = timeSlots[startSlot] == null ? new Node(start, startSlot * 60 + 59) : timeSlots[startSlot].book(start, startSlot * 60 + 59);
            timeSlots[endSlot] = timeSlots[endSlot] == null ? new Node(endSlot * 60, end) : timeSlots[endSlot].book(endSlot * 60, end);
            
            for (int i = startSlot + 1; i < endSlot; i++) {
                timeSlots[i] = new Node(i * 60, i * 60 + 59);
            }
        }
    }
}

class Entry {
    private int start;
    private int end;
    private char person;

    public Entry(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public char getPerson() {
        return person;
    }

    public void setPerson(char person) {
        this.person = person;
    }
}

class Node {
    private Node next;
    private int start;
    private int end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Node(int start, int end, Node next) {
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

    public Node book(int start, int end) {
        if (start == this.end + 1 || start == this.end) {
            this.end = end;
            return this;
        } else if (end == this.start - 1 || end == this.start) {
            this.start = start;
            return this;
        } else if (end < this.start) {
            return new Node(start, end, this);
        } else if (next != null) {
            next = next.book(start, end);
            return this;
        } else {
            next = new Node(start, end);
            return this;
        }
    }
}