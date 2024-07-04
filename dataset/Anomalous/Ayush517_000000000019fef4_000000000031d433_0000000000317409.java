import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int test = 1; test <= testCases; test++) {
            int y = scanner.nextInt();
            int x = scanner.nextInt();
            String s = scanner.next();

            Set<Pair> visited = new HashSet<>();
            Queue<Pair> queue = new LinkedList<>();

            Pair start = new Pair(0, 0);
            queue.add(start);
            visited.add(start);

            int i = 0;
            int steps = 0;
            boolean found = false;

            while (i < s.length() && !found) {
                int size = queue.size();
                steps++;
                char direction = s.charAt(i);
                switch (direction) {
                    case 'S': x--; break;
                    case 'N': x++; break;
                    case 'E': y++; break;
                    case 'W': y--; break;
                }
                Pair current = new Pair(x, y);

                for (int j = 0; j < size; j++) {
                    Pair p = queue.poll();

                    if (current.equals(p) || checkAndAddNeighbors(queue, visited, current, p)) {
                        found = true;
                        break;
                    }
                }
                i++;
            }

            if (found) {
                System.out.println("Case #" + test + ": " + steps);
            } else {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean checkAndAddNeighbors(Queue<Pair> queue, Set<Pair> visited, Pair current, Pair p) {
        Pair[] neighbors = {
            new Pair(p.a, p.b + 1),
            new Pair(p.a, p.b - 1),
            new Pair(p.a + 1, p.b),
            new Pair(p.a - 1, p.b)
        };

        for (Pair neighbor : neighbors) {
            if (current.equals(neighbor)) {
                return true;
            }
            if (visited.add(neighbor)) {
                queue.add(neighbor);
            }
        }
        return false;
    }
}

class Pair {
    int a, b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return a == pair.a && b == pair.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}