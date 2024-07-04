import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int tests = 0;
        while(total-- > 0) {
            tests++;
            int activities = scanner.nextInt();
            ArrayList<Node> list = new ArrayList<>();
            final StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < activities; i++) {
                list.add(new Node(scanner.nextInt(), scanner.nextInt(), i+1));
            }
            list.sort(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.start == o2.start ? o1.end-o2.end : o1.start-o2.start;
                }
            });
            int endC = 0;
            int endJ = 0;
            boolean can = true;

            for(Node node : list) {
                if(node.start >= endC) {
                    endC = node.end;
                    node.assignee = "C";
                } else if (node.start >= endJ) {
                    endJ = node.end;
                    node.assignee = "J";
                } else {
                    can = false;
                    break;
                }
            }
            if (can) {
                list.sort(new Comparator<Node>() {
                    @Override
                    public int compare(Node o1, Node o2) {
                        return o1.order - o2.order;
                    }
                });
                list.forEach((n) -> stringBuilder.append(n.assignee));
                System.out.println("Case #" + tests + ": " + stringBuilder.toString());
            } else {
                System.out.println("Case #" + tests + ": IMPOSSIBLE");

            }

        }
    }
    private static class Node {
        int start;
        int end;
        String assignee;
        int order;

        Node(int start, int end, int order) {
            this.start = start;
            this.end = end;
            this.order = order;
        }
    }
}
