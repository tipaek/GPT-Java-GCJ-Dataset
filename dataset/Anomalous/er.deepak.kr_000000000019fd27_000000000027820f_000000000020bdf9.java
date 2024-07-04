import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 0;

        while (testCases-- > 0) {
            List<Node> events = new ArrayList<>();
            caseNumber++;
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events.add(new Node(start, 's', end, i));
                events.add(new Node(end, 'e', start, i));
            }

            Collections.sort(events, Comparator.comparingInt(Node::getX));
            char[] schedule = new char[n];
            int cameronEnd = 0, jamieEnd = 0;
            boolean impossible = false;

            for (Node event : events) {
                if (event.getY() == 's') {
                    if (cameronEnd != 0 && jamieEnd != 0) {
                        impossible = true;
                        break;
                    } else if (jamieEnd == 0) {
                        schedule[event.getI()] = 'J';
                        jamieEnd = event.getO();
                    } else if (cameronEnd == 0) {
                        schedule[event.getI()] = 'C';
                        cameronEnd = event.getO();
                    }
                } else {
                    if (event.getX() == cameronEnd) {
                        cameronEnd = 0;
                    } else {
                        jamieEnd = 0;
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + new String(schedule));
            }
        }
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