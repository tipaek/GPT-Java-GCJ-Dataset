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
        
        for(int i = 0; i < t; i++) {
            List<Entry> entries = new ArrayList<>();
            Map<Integer, Entry> entryMap = new HashMap<>();
            TimeScheduler cameronScheduler = new TimeScheduler();
            TimeScheduler jamieScheduler = new TimeScheduler();
            
            int n = scanner.nextInt();
            for(int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Entry entry = new Entry(start, end);
                entries.add(entry);
                entryMap.put(j, entry);
            }
            
            entries.sort(Comparator.comparingInt(Entry::getStart));
            String output = assignTasks(entries, entryMap, cameronScheduler, jamieScheduler);
            outputs.add(output);
        }
        
        for(int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + outputs.get(i));
        }
    }
    
    private static String assignTasks(List<Entry> entries, Map<Integer, Entry> entryMap, 
                                      TimeScheduler cameronScheduler, TimeScheduler jamieScheduler) {
        for (Entry entry : entries) {
            int start = entry.getStart();
            int end = entry.getEnd();
            
            if (cameronScheduler.canSchedule(start, end)) {
                cameronScheduler.schedule(start, end);
                entry.setPerson('C');
            } else if (jamieScheduler.canSchedule(start, end)) {
                jamieScheduler.schedule(start, end);
                entry.setPerson('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < entryMap.size(); j++) {
            result.append(entryMap.get(j).getPerson());
        }
        return result.toString();
    }
}

class TimeScheduler {
    private Node[] nodes = new Node[24];

    private int mapTime(int time) {
        return time == 1440 ? 23 : time / 60;
    }

    public boolean canSchedule(int start, int end) {
        int mappedStart = mapTime(start);
        int mappedEnd = mapTime(end);

        if (mappedStart == mappedEnd) {
            return nodes[mappedStart] == null || nodes[mappedStart].canSchedule(start, end);
        } else {
            if (nodes[mappedStart] == null || nodes[mappedStart].canSchedule(start, (mappedStart + 1) * 60 - 1)) {
                if (nodes[mappedEnd] == null || nodes[mappedEnd].canSchedule(mappedEnd * 60, end)) {
                    for (int i = mappedStart + 1; i < mappedEnd; i++) {
                        if (nodes[i] != null) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void schedule(int start, int end) {
        int mappedStart = mapTime(start);
        int mappedEnd = mapTime(end);

        if (mappedStart == mappedEnd) {
            nodes[mappedStart] = nodes[mappedStart] == null ? new Node(start, end) : nodes[mappedStart].schedule(start, end);
        } else {
            nodes[mappedStart] = nodes[mappedStart] == null ? new Node(start, (mappedStart + 1) * 60 - 1) 
                                                            : nodes[mappedStart].schedule(start, (mappedStart + 1) * 60 - 1);
            nodes[mappedEnd] = nodes[mappedEnd] == null ? new Node(mappedEnd * 60, end) 
                                                        : nodes[mappedEnd].schedule(mappedEnd * 60, end);
            for (int i = mappedStart + 1; i < mappedEnd; i++) {
                nodes[i] = new Node(i * 60, (i + 1) * 60 - 1);
            }
        }
    }
}

class Entry {
    private final int start;
    private final int end;
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
    private int start;
    private int end;
    private Node nextNode;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Node(int start, int end, Node nextNode) {
        this.start = start;
        this.end = end;
        this.nextNode = nextNode;
    }

    public boolean canSchedule(int start, int end) {
        if (end <= this.start || (start >= this.end && nextNode == null)) {
            return true;
        } else if (start >= this.end && nextNode != null) {
            return nextNode.canSchedule(start, end);
        } else {
            return false;
        }
    }

    public Node schedule(int start, int end) {
        if (start == this.end) {
            this.end = end;
            return this;
        } else if (end == this.start && nextNode == null) {
            this.start = start;
            return this;
        } else if (end < this.start) {
            return new Node(start, end, this);
        } else if (nextNode != null) {
            nextNode = nextNode.schedule(start, end);
            return this;
        } else {
            nextNode = new Node(start, end);
            return this;
        }
    }
}