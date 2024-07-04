import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int c = 1; c <= n; c++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();

            int size = 1000;
            boolean[][] visited = new boolean[size][size];

            Node start = new Node(0,0);
            visited[size/2][size/2] = true;
            ArrayList<Node> frontier = new ArrayList<>();
            frontier.add(start);
            int power = 0;
            boolean found = false;

            while (!frontier.isEmpty()) {
                ArrayList<Node> newFront = new ArrayList<>();
                for (Node v : frontier) {
                    Node[] nbors = new Node[4];
                    nbors[0] = new Node(v.x+(int) Math.pow(2, power), v.y, v.path + "E");
                    nbors[1] = new Node(v.x-(int) Math.pow(2, power), v.y, v.path + "W");
                    nbors[2] = new Node(v.x,  v.y+(int)Math.pow(2, power), v.path + "N");
                    nbors[3] = new Node(v.x,  v.y-(int)Math.pow(2, power), v.path + "S");
                    for (Node u : nbors) {
                        int xin = u.x+size/2;
                        int yin = u.y+size/2;
                        if (xin >= size || yin >= size || xin < 0 || yin < 0) continue;
                        if (!visited[xin][yin]) {
                            visited[xin][yin] = true;
                            if (u.x == X && u.y == Y) {
                                System.out.println(String.format("Case #%d: %s", c, u.path));
                                found = true;
                            }
                            newFront.add(u);
                        }
                    }
                }
                if (found) break;
                frontier = newFront;
                power++;
            }
            if (!found) System.out.println(String.format("Case #%d: IMPOSSIBLE", c));
        }
    }



    static class Node {
        String path;
        int x, y;

        Node(int x, int y, String parent) {
            this.x = x;
            this.y = y;
            this.path = parent;
        }

        Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.path = "";
        }
    }



}