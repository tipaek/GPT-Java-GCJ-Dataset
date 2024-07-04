import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

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
        ArrayList<Pair> children = new ArrayList<>();
        children.add(new Pair(x + term, y, s + "E"));
        children.add(new Pair(x - term, y, s + "W"));
        children.add(new Pair(x, y + term, s + "N"));
        children.add(new Pair(x, y - term, s + "S"));
        return children;
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

            String result = "IMPOSSIBLE";
            ArrayList<Pair> visited = new ArrayList<>();
            LinkedList<Pair> queue = new LinkedList<>();

            queue.add(new Pair(0, 0));
            boolean goalReached = false;
            boolean impossible = (x % 2 == y % 2);

            if (!impossible) {
                while (!queue.isEmpty()) {
                    Pair current = queue.poll();
                    ArrayList<Pair> children = current.getChildren();

                    for (Pair child : children) {
                        if (!contains(visited, child)) {
                            if (child.x == x && child.y == y) {
                                result = child.s;
                                goalReached = true;
                                break;
                            } else if (Math.abs(child.x) == Math.abs(x) && Math.abs(child.y) == Math.abs(y)) {
                                StringBuilder sb = new StringBuilder();
                                for (char c : child.s.toCharArray()) {
                                    switch (c) {
                                        case 'E':
                                            sb.append(child.x == -x ? 'W' : 'E');
                                            break;
                                        case 'W':
                                            sb.append(child.x == -x ? 'E' : 'W');
                                            break;
                                        case 'N':
                                            sb.append(child.y == -y ? 'S' : 'N');
                                            break;
                                        case 'S':
                                            sb.append(child.y == -y ? 'N' : 'S');
                                            break;
                                    }
                                }
                                result = sb.toString();
                                goalReached = true;
                                break;
                            } else {
                                queue.add(child);
                                visited.add(child);
                            }
                        }
                    }
                    if (goalReached) break;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
        sc.close();
    }
}