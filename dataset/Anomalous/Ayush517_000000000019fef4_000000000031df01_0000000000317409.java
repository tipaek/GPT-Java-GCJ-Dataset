import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();

        for (int test = 1; test <= testcases; test++) {
            int y = scanner.nextInt();
            int x = scanner.nextInt();
            String directions = scanner.next();

            Set<Pair> visited = new HashSet<>();
            Queue<Pair> queue = new LinkedList<>();

            queue.add(new Pair(0, 0));
            visited.add(new Pair(0, 0));

            int index = 0;
            int steps = 0;
            boolean found = false;

            while (index < directions.length() && !found) {
                int size = queue.size();
                steps++;

                switch (directions.charAt(index)) {
                    case 'S': x--; break;
                    case 'N': x++; break;
                    case 'E': y++; break;
                    case 'W': y--; break;
                }

                Pair current = new Pair(x, y);

                for (int j = 0; j < size; j++) {
                    Pair point = queue.poll();
                    int[][] directionsArray = {
                        {point.a, point.b + 1},
                        {point.a, point.b - 1},
                        {point.a + 1, point.b},
                        {point.a - 1, point.b}
                    };

                    for (int[] dir : directionsArray) {
                        Pair newPoint = new Pair(dir[0], dir[1]);
                        if (current.equals(point) || current.equals(newPoint)) {
                            found = true;
                            break;
                        } else if (!visited.contains(newPoint)) {
                            queue.add(newPoint);
                            visited.add(newPoint);
                        }
                    }

                    if (found) break;
                }
                index++;
            }

            System.out.println("Case #" + test + ": " + (found ? steps : "IMPOSSIBLE"));
        }
    }
}

class Pair {
    int a, b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Pair) {
            Pair other = (Pair) obj;
            return this.a == other.a && this.b == other.b;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}