import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int ncase = 1;

        while (ncase <= cases) {
            int x = sc.nextInt() + 1000;
            int y = sc.nextInt() + 1000;

            boolean[][] visited = new boolean[8000][8000];
            Queue<VirtualGraph> queue = new LinkedList<>();

            queue.add(new VirtualGraph(1000, 1000, 0, ""));
            String result = "IMPOSSIBLE";

            while (!queue.isEmpty()) {
                VirtualGraph vertex = queue.poll();

                if (!visited[vertex.getX()][vertex.getY()]) {
                    if (vertex.getI() <= 7) {
                        queue.addAll(vertex.getNeighbors());
                        if (vertex.getX() == x && vertex.getY() == y) {
                            result = vertex.getResult();
                            break;
                        }
                    }
                    visited[vertex.getX()][vertex.getY()] = true;
                }
            }
            System.out.println("Case #" + ncase + ": " + result);
            ncase++;
        }
        sc.close();
    }
}

class VirtualGraph {
    private int x;
    private int y;
    private int i;
    private String result;

    public VirtualGraph(int x, int y, int i, String result) {
        this.x = x;
        this.y = y;
        this.i = i;
        this.result = result;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getI() {
        return i;
    }

    public String getResult() {
        return result;
    }

    public List<VirtualGraph> getNeighbors() {
        List<VirtualGraph> neighbors = new ArrayList<>();
        int step = (int) Math.pow(2, i);

        neighbors.add(new VirtualGraph(x + step, y, i + 1, result + "E"));
        neighbors.add(new VirtualGraph(x - step, y, i + 1, result + "W"));
        neighbors.add(new VirtualGraph(x, y + step, i + 1, result + "N"));
        neighbors.add(new VirtualGraph(x, y - step, i + 1, result + "S"));

        return neighbors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, i);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        VirtualGraph other = (VirtualGraph) obj;
        return x == other.x && y == other.y && i == other.i;
    }
}