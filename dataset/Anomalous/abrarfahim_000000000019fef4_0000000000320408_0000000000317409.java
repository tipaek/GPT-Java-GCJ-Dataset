import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    static boolean contains(ArrayList<Node> list, Node a) {
        for (Node temp : list) {
            if (temp.mx == a.mx && temp.my == a.my && !temp.stay) {
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
            Queue<Node> q = new LinkedList<>();

            Node root = new Node(0, 0, x, y);
            root.time = 0;
            q.add(root);

            int time = -1;

            while (!q.isEmpty()) {
                Node parent = q.poll();
                ArrayList<Node> children = parent.getChildren();

                for (Node child : children) {
                    int px = x;
                    int py = y;

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
                                System.out.println("Invalid move character!");
                        }
                    }

                    if (Math.abs(child.mx - px) > 2 * (m.length() - child.time) ||
                        Math.abs(child.my - py) > 2 * (m.length() - child.time)) {
                        continue;
                    }

                    if (child.mx == px && child.my == py) {
                        time = child.time;
                        break;
                    }

                    visited.add(child);
                    q.add(child);
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
    int mx, my, px, py, pdx, pdy, time;
    boolean stay = false;

    public Node(int mx, int my, int px, int py, int pdx, int pdy, int time) {
        this.mx = mx;
        this.my = my;
        this.px = px;
        this.py = py;
        this.pdx = pdx;
        this.pdy = pdy;
        this.time = time;
    }

    public Node(int mx, int my, int px, int py) {
        this(mx, my, px, py, 0, 0, 0);
    }

    public Node(int mx, int my, boolean stay) {
        this(mx, my, 0, 0, 0, 0, 0);
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