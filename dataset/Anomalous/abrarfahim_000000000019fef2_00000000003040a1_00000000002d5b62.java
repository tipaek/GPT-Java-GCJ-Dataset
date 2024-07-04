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

    List<Pair> getChildren() {
        int term = (int) Math.pow(2, s.length());
        return Arrays.asList(
                new Pair(x + term, y, s + "E"),
                new Pair(x - term, y, s + "W"),
                new Pair(x, y + term, s + "N"),
                new Pair(x, y - term, s + "S")
        );
    }
}

public class Solution {

    static boolean contains(List<Pair> list, Pair pair) {
        return list.stream().anyMatch(p -> 
            Math.abs(p.x) == Math.abs(pair.x) && Math.abs(p.y) == Math.abs(pair.y) && p.s.length() == pair.s.length()
        );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            String out = "hello";
            List<Pair> visited = new ArrayList<>();
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(0, 0));

            boolean goal = false;

            while (!queue.isEmpty()) {
                Pair parent = queue.poll();
                for (Pair child : parent.getChildren()) {
                    if (!contains(visited, child) && Math.abs(child.x) <= Math.abs(x) && Math.abs(child.y) <= Math.abs(y)) {
                        if (child.x == x && child.y == y) {
                            out = child.s;
                            goal = true;
                            break;
                        } else if (Math.abs(child.x) == Math.abs(x) && Math.abs(child.y) == Math.abs(y)) {
                            StringBuilder sb = new StringBuilder();
                            for (char c : child.s.toCharArray()) {
                                switch (c) {
                                    case 'E': sb.append(child.x == -x ? 'W' : 'E'); break;
                                    case 'W': sb.append(child.x == -x ? 'E' : 'W'); break;
                                    case 'N': sb.append(child.y == -y ? 'S' : 'N'); break;
                                    case 'S': sb.append(child.y == -y ? 'N' : 'S'); break;
                                }
                            }
                            out = sb.toString();
                            goal = true;
                            break;
                        } else {
                            queue.add(child);
                            visited.add(child);
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