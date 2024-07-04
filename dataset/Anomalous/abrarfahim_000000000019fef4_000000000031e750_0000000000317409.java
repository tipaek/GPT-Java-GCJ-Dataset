import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    static boolean contains(ArrayList<Node> list, Node a) {
        for (Node temp : list) {
            if (temp.mx == a.mx && temp.my == a.my && temp.px == a.px && temp.py == a.py) {
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
                                System.out.println("Default reached!!");
                        }
                    }

                    if (child.mx == px && child.my == py) {
                        time = child.time;
                        break;
                    }

                    if (!contains(visited, child)) {
                        visited.add(child);
                        q.add(child);
                    }
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
    int mx, my, px, py, pdx, pdy, time;

    public Node(int mx, int my, int px, int py) {
        this(mx, my, px, py, 0, 0, 0);
    }

    public Node(int mx, int my, int px, int py, int pdx, int pdy, int time) {
        this.mx = mx;
        this.my = my;
        this.px = px;
        this.py = py;
        this.pdx = pdx;
        this.pdy = pdy;
        this.time = time;
    }

    ArrayList<Node> getChildren() {
        ArrayList<Node> list = new ArrayList<>();
        list.add(new Node(mx, my, px + pdx, py + pdy));
        list.add(new Node(mx + 1, my, px + pdx, py + pdy));
        list.add(new Node(mx - 1, my, px + pdx, py + pdy));
        list.add(new Node(mx, my + 1, px + pdx, py + pdy));
        list.add(new Node(mx, my - 1, px + pdx, py + pdy));
        return list;
    }
}