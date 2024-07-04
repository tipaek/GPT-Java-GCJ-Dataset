import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 0;

        while (t-- > 0) {
            List<Node> events = new ArrayList<>();
            caseNumber++;
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events.add(new Node(start, 's', i));
                events.add(new Node(end, 'e', i));
            }

            Collections.sort(events, new NodeComparator());

            char[] schedule = new char[n];
            int cameron = -1, jamie = -1;
            boolean impossible = false;

            for (Node event : events) {
                if (event.getType() == 's') {
                    if (cameron != -1 && jamie != -1) {
                        impossible = true;
                        break;
                    } else if (jamie == -1) {
                        jamie = event.getIndex();
                        schedule[jamie] = 'J';
                    } else if (cameron == -1) {
                        cameron = event.getIndex();
                        schedule[cameron] = 'C';
                    }
                } else {
                    if (event.getIndex() == cameron) {
                        cameron = -1;
                    } else {
                        jamie = -1;
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
    private final int time;
    private final char type;
    private final int index;

    public Node(int time, char type, int index) {
        this.time = time;
        this.type = type;
        this.index = index;
    }

    public int getTime() {
        return time;
    }

    public char getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }
}

class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node a, Node b) {
        if (a.getTime() == b.getTime()) {
            return Character.compare(a.getType(), b.getType());
        }
        return Integer.compare(a.getTime(), b.getTime());
    }
}