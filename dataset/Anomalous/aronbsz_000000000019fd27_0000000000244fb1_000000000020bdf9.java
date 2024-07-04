import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < testCases; i++) {
            int num = Integer.parseInt(sc.nextLine());
            List<Node> nodes = new ArrayList<>();

            for (int j = 0; j < num; j++) {
                String[] input = sc.nextLine().split(" ");
                nodes.add(new Node(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
            }

            nodes.sort(Comparator.comparingInt(n -> n.x));

            StringBuilder retVal = new StringBuilder();
            Node prev = null;
            int overlap = 0;
            int overlapEnd = -1;
            boolean notPossible = false;

            for (int j = 0; j < num; j++) {
                if (j == 0) {
                    retVal.append("C");
                    prev = nodes.get(0);
                } else {
                    Node curr = nodes.get(j);
                    if (curr.x < prev.y) {
                        overlap++;
                        if (overlap > 1) {
                            if (overlapEnd != -1 && curr.x >= overlapEnd) {
                                retVal.append("J");
                                overlap = 0;
                                overlapEnd = -1;
                            } else {
                                notPossible = true;
                                break;
                            }
                        } else {
                            retVal.append("J");
                            overlapEnd = curr.y;
                        }
                    } else {
                        retVal.append("C");
                        prev = curr;
                        overlap = 0;
                    }
                }
            }

            if (notPossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + retVal);
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