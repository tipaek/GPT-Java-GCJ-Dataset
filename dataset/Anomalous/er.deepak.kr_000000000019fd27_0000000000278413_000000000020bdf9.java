import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            List<Node> events = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events.add(new Node(start, 's', end, i));
                events.add(new Node(end, 'e', start, i));
            }
            
            events.sort(Comparator.comparingInt(Node::getX));
            char[] assignments = new char[n];
            int cEnd = 0, jEnd = 0;
            boolean impossible = false;
            
            for (Node event : events) {
                if (event.getY() == 's') {
                    if (cEnd > 0 && jEnd > 0) {
                        impossible = true;
                        break;
                    } else if (cEnd == 0) {
                        assignments[event.getI()] = 'C';
                        cEnd = event.getO();
                    } else if (jEnd == 0) {
                        assignments[event.getI()] = 'J';
                        jEnd = event.getO();
                    }
                } else {
                    if (event.getX() == cEnd) {
                        cEnd = 0;
                    } else {
                        jEnd = 0;
                    }
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNum + ": " + new String(assignments));
            }
        }
        
        scanner.close();
    }
}

class Node {
    private final int x;
    private final char y;
    private final int o;
    private final int i;

    public Node(int x, char y, int o, int i) {
        this.x = x;
        this.y = y;
        this.o = o;
        this.i = i;
    }

    public int getX() {
        return x;
    }

    public char getY() {
        return y;
    }

    public int getO() {
        return o;
    }

    public int getI() {
        return i;
    }
}