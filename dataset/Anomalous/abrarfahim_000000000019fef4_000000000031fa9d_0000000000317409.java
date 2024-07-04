import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    static boolean contains(ArrayList<Node> list, Node node) {
        for (Node temp : list) {
            if (temp.mx == node.mx && temp.my == node.my && !temp.stay) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String m = sc.next();

            ArrayList<Node> visited = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();

            Node root = new Node(0, 0, x, y);
            root.time = 0;
            queue.add(root);

            int px = x, py = y;
            int time = -1;

            while (!queue.isEmpty()) {
                Node parent = queue.poll();
                ArrayList<Node> children = parent.getChildren();

                for (Node child : children) {
                    px = x;
                    py = y;
                    child.time = parent.time + 1;

                    if (child.time > m.length() || child.mx < 0 || child.my < 0) {
                        continue;
                    }

                    for (int j = 0; j < child.time; j++) {
                        switch (m.charAt(j)) {
                            case 'N':
                                py++;
                                break;
                            case 'S':
                                py--;
                                break;
                            case 'E':
                                px++;
                                break;
                            case 'W':
                                px--;
                                break;
                        }
                    }

                    if (child.mx == px && child.my == py) {
                        time = child.time;
                        break;
                    }

                    visited.add(child);
                    queue.add(child);
                }

                if (time > 0) {
                    break;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + (time < 0 ? "IMPOSSIBLE" : time));
        }
        sc.close();
    }
}

class Node {
    int mx, my, px, py, time;
    boolean stay = false;

    public Node(int mx, int my, int px, int py) {
        this.mx = mx;
        this.my = my;
        this.px = px;
        this.py = py;
    }

    public Node(int mx, int my, boolean stay) {
        this.mx = mx;
        this.my = my;
        this.stay = stay;
    }

    ArrayList<Node> getChildren() {
        ArrayList<Node> children = new ArrayList<>();
        children.add(new Node(mx, my, true));
        children.add(new Node(mx + 1, my, false));
        children.add(new Node(mx - 1, my, false));
        children.add(new Node(mx, my + 1, false));
        children.add(new Node(mx, my - 1, false));
        return children;
    }
}