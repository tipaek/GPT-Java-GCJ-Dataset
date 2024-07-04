import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        parentingPartneringReturns();
    }

    public static void parentingPartneringReturns() {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int t = scanner.nextInt();
        ArrayList<String> outputs = new ArrayList<String>();
        for(int i = 0; i < t; i++) {
            String output = "";
            LinkedList<Entry> entries = new LinkedList<Entry>();
            HashMap<Integer, Entry> hash = new HashMap<Integer, Entry>();
            DataStructure cameronTime = new DataStructure();
            DataStructure jamieTime = new DataStructure();
            int n = scanner.nextInt();
            for(int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Entry entry = new Entry(start, end);
                entries.add(entry);
                hash.put(j, entry);
            }
            entries.sort(new EntryComparator());
            for(int j = 0; j < n; j++) {
                Entry entry = entries.get(j);
                int start = entry.getStart();
                int end = entry.getEnd();
                if(cameronTime.hasTime(start, end)) {
                    cameronTime.book(start, end);
                    entry.setPerson('C');
                } else if(jamieTime.hasTime(start, end)) {
                    jamieTime.book(start, end);
                    entry.setPerson('J');
                } else {
                    output = "IMPOSSIBLE";
                    break;
                }
            }
            if(output.isEmpty()) {
                for(int j = 0; j < n; j++) {
                    output += hash.get(j).getPerson();
                }
            }
            outputs.add(output);
        }
        for(int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + outputs.get(i));
        }
    }
}

class DataStructure {
    private Node[] nodes = new Node[24];

    private int mapTime(int time) {
        if(time == 1440) {
            return 23;
        } else {
            return (int)time/60;
        }
    }
    public boolean hasTime(int start, int end) {
        int mapedStart = mapTime(start);
        int mapedEnd = mapTime(end);
        if(mapedStart == mapedEnd) {
            if(nodes[mapedStart] != null) {
                return nodes[mapedStart].hasTime(start, end);
            } else {
                return true;
            }
        } else {
            if(nodes[mapedStart] == null || nodes[mapedStart].hasTime(start, ((mapedStart + 1)* 60) - 1)) {
                if(nodes[mapedEnd] == null || nodes[mapedEnd].hasTime(mapedEnd * 60, end)) {
                    for(int i = 0; i < ((mapedEnd- mapedStart) - 1); i++) {
                        if(nodes[mapedStart + 1 + i] != null) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
    }
    public void book(int start, int end) {
        int mapedStart = mapTime(start);
        int mapedEnd = mapTime(end);
        if(mapedStart == mapedEnd) {
            if(nodes[mapedStart] == null) {
                nodes[mapedStart] = new Node(start, end);
            } else {
                nodes[mapedStart] = nodes[mapedStart].book(start, end);
            }
        } else {
            if(nodes[mapedStart] == null) {
                nodes[mapedStart] = new Node(start, ((mapedStart + 1)* 60) - 1);
            } else {
                nodes[mapedStart] = nodes[mapedStart].book(start, ((mapedStart + 1)* 60) - 1);
            }
            if(nodes[mapedEnd] == null) {
                nodes[mapedEnd] = new Node(mapedEnd * 60, end);
            } else {
                nodes[mapedEnd] = nodes[mapedEnd].book(mapedEnd * 60, end);
            }
            for(int i = 0; i < ((mapedEnd- mapedStart) - 1); i++) {
                nodes[mapedStart + i + 1] = new Node((mapedStart + i + 1) * 60, ((mapedStart + i + 2) * 60) - 1);
            }
        }
    }
}

class EntryComparator implements Comparator<Entry> {

    @Override
    public int compare(Entry o1, Entry o2) {
        if(o1.getStart() == o2.getStart()) {
            //return 0;
            if(o1.getEnd() == o2.getEnd()) {
                return 0;
            } else if(o1.getEnd() > o2.getEn()) {
                return 1;
            } else {
                return -1;
            }
        } else if(o1.getStart() > o2.getStart()){
            return 1;
        } else {
            return -1;
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
    public void setPerson(char p) {
        person = p;
    }
}

class Node {

    private Node nextNode = null;
    private int start;
    private int end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Node(int start, int end, Node nextNode) {
        this.start = start;
        this.end = end;
        this.nextNode = nextNode;
    }

    public boolean hasTime(int start, int end) {
        if(end <= this.start || (start >= this.end && nextNode == null)) {
            return true;
        } else if(start >= this.end && nextNode != null) {
            return nextNode.hasTime(start, end);
        } else {
            return false;
        }
    }

    public Node book(int start, int end) {
        if(start == this.end && nextNode == null) {
            this.end = end;
            return this;
        } else if(end == this.start){
            this.start = start;
            return this;
        } else if(end < this.start) {
            return new Node(start, end, this);
        } else if(nextNode != null){
            nextNode = nextNode.book(start, end);
            return this; 
        } else {
            nextNode = new Node(start, end);
            return this;
        }
    }
}

