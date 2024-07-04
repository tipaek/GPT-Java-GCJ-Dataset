import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        
        for (int ncase = 1; ncase <= cases; ncase++) {
            int x = scanner.nextInt() + 1000;
            int y = scanner.nextInt() + 1000;

            boolean[][] visited = new boolean[8000][8000];
            Queue<VirtualGraph> queue = new LinkedList<>();

            queue.add(new VirtualGraph(1000, 1000, 0, ""));
            String result = "IMPOSSIBLE";

            while (!queue.isEmpty()) {
                VirtualGraph vertex = queue.poll();
                if (!visited[vertex.getX()][vertex.getY()]) {
                    if (vertex.getI() <= 8) {
                        queue.addAll(vertex.getNeighbors());
                        if (vertex.getX().equals(x) && vertex.getY().equals(y)) {
                            result = vertex.getResult();
                            break;
                        }
                    }
                    visited[vertex.getX()][vertex.getY()] = true;
                }
            }
            System.out.println("Case #" + ncase + ": " + result);
        }
        scanner.close();
    }
}

class VirtualGraph {

    private Integer x;
    private Integer y;
    private Integer i;
    private String result;

    public VirtualGraph(Integer x, Integer y, Integer i, String result) {
        this.x = x;
        this.y = y;
        this.i = i;
        this.result = result;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getI() {
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
        return Objects.equals(x, other.x) && Objects.equals(y, other.y) && Objects.equals(i, other.i);
    }
}