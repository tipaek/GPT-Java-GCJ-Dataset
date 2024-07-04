import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        parentingPartneringReturns();
    }

    public static void parentingPartneringReturns() {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int t = scanner.nextInt();
        //scanner.nextLine();
        ArrayList<String> outputs = new ArrayList<String>();
        for(int i = 0; i < t; i++) {
            String output = "";
            DataStructure cameronTime = new DataStructure();
            DataStructure jamieTime = new DataStructure();
            int n = scanner.nextInt();
            for(int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if(cameronTime.hasTime(start, end)) {
                    cameronTime.book(start, end);
                    output += "C";
                } else if(jamieTime.hasTime(start, end)) {
                    jamieTime.book(start, end);
                    output += "J";
                } else {
                    output = "IMPOSSIBLE";
                    break;
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
        if(start == (this.end + 1) || start == this.end) {
            this.end = end;
            return this;
        } else if(end == (this.start - 1) || end == this.start){
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

