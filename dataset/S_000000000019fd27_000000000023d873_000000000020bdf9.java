import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        for (int i = 1; i <= size; i++) {
            int count = scanner.nextInt();
            List<Node> C = new ArrayList<>();
            List<Node> J = new ArrayList<>();
            String output = "";

            for (int j = 0; j < count; j++) {
                Node temp = new Node(scanner.nextInt(), scanner.nextInt());
                if (notOverlap(C, temp)) {
                    output += "C";
                } else if (notOverlap(J, temp)) {
                    output += "J";
                }
            }


            if (count != output.length()) System.out.println("Case #" + i + ": IMPOSSIBLE");
            else System.out.println("Case #" + i + ": "  + output);
        }
    }

    static boolean notOverlap(List<Node> list, Node temp) {
        for (Node n : list) {
            if (n.l <= temp.l && temp.l < n.r) return false;
            else if (n.l < temp.r && temp.r <= n.r) return false;
            else if (temp.l < n.l && n.r < temp.r) return false;
        }
        list.add(temp);
        return true;
    }

    static class Node{
        int l;
        int r;

        Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
