import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < testCases; i++) {
            int num = Integer.parseInt(sc.nextLine());
            List<Node> origNodes = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                String[] n = sc.nextLine().split(" ");
                origNodes.add(new Node(Integer.parseInt(n[0]), Integer.parseInt(n[1])));
            }

            List<Node> nodes = new ArrayList<>(origNodes);
            nodes.sort(Comparator.comparingInt(n -> n.x));

            boolean notPossible = false;
            StringBuilder retVal = new StringBuilder();
            Node c = null;
            Node j = null;
            Map<Node, Character> assignmentMap = new HashMap<>();

            for (Node todo : nodes) {
                if (c == null) {
                    c = todo;
                    assignmentMap.put(todo, 'C');
                } else {
                    if (todo.x < c.y) {
                        if (j == null || j.y <= todo.x) {
                            j = todo;
                            assignmentMap.put(todo, 'J');
                        } else {
                            notPossible = true;
                            break;
                        }
                    } else {
                        c = todo;
                        assignmentMap.put(todo, 'C');
                    }
                }
            }

            if (notPossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                for (Node node : origNodes) {
                    retVal.append(assignmentMap.get(node));
                }
                System.out.println("Case #" + (i + 1) + ": " + retVal.toString());
            }
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node other = (Node) obj;
            return x == other.x && y == other.y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}