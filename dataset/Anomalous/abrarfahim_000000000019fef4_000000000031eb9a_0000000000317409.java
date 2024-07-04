import java.util.ArrayList;
import java.util.LinkedList;
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
            LinkedList<Node> queue = new LinkedList<>();

            Node root = new Node(0, 0, x, y);
            root.time = 0;

            queue.add(root);
            int time = -1;

            while (!queue.isEmpty()) {
                Node parent = queue.poll();
                ArrayList<Node> children = parent.getChildren();

                for (Node child : children) {
                    int px = x;
                    int py = y;

                    if (contains(visited, child)) {
                        continue;
                    }
                    child.time = parent.time + 1;

                    if (child.time > m.length()) {
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
                            default:
                                System.out.println("Invalid direction!");
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
        ArrayList<Node> list = new ArrayList<>();
        list.add(new Node(mx, my, true));
        list.add(new Node(mx + 1, my, false));
        list.add(new Node(mx - 1, my, false));
        list.add(new Node(mx, my + 1, false));
        list.add(new Node(mx, my - 1, false));
        return list;
    }
}