import java.util.*;

class Pair {
    int x, y;
    String s;

    public Pair(int x, int y) {
        this(x, y, "");
    }

    public Pair(int x, int y, String s) {
        this.x = x;
        this.y = y;
        this.s = s;
    }

    ArrayList<Pair> getChildren() {
        int term = (int) Math.pow(2, s.length());
        ArrayList<Pair> list = new ArrayList<>();
        list.add(new Pair(x + term, y, s + "E"));
        list.add(new Pair(x - term, y, s + "W"));
        list.add(new Pair(x, y + term, s + "N"));
        list.add(new Pair(x, y - term, s + "S"));
        return list;
    }
}

public class Solution {

    static boolean contains(ArrayList<Pair> list, Pair pair) {
        for (Pair p : list) {
            if (Math.abs(p.x) == Math.abs(pair.x) && Math.abs(p.y) == Math.abs(pair.y) && p.s.length() == pair.s.length()) {
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

            StringBuilder sb = new StringBuilder();
            String out = "hello";
            ArrayList<Pair> visited = new ArrayList<>();
            LinkedList<Pair> list = new LinkedList<>();
            list.add(new Pair(0, 0));
            boolean goal = false;

            while (!list.isEmpty()) {
                Pair parent = list.poll();
                ArrayList<Pair> children = parent.getChildren();

                for (Pair p : children) {
                    if (!contains(visited, p) && Math.abs(p.x) <= Math.abs(x) && Math.abs(p.y) <= Math.abs(y)) {
                        if (p.x == x && p.y == y) {
                            out = p.s;
                            goal = true;
                            break;
                        } else if (Math.abs(p.x) == Math.abs(x) && Math.abs(p.y) == Math.abs(y)) {
                            for (char c : p.s.toCharArray()) {
                                switch (c) {
                                    case 'E':
                                        sb.append(p.x == -x ? 'W' : c);
                                        break;
                                    case 'W':
                                        sb.append(p.x == -x ? 'E' : c);
                                        break;
                                    case 'N':
                                        sb.append(p.y == -y ? 'S' : c);
                                        break;
                                    case 'S':
                                        sb.append(p.y == -y ? 'N' : c);
                                        break;
                                }
                            }
                            out = sb.toString();
                            goal = true;
                            break;
                        } else {
                            list.add(p);
                            visited.add(p);
                        }
                    }
                }

                if (goal) break;
            }

            if (!goal) out = "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + out);
        }
    }
}