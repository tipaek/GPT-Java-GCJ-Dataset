import java.util.*;

class Solution {

    public static List<Integer> getDiagonal(VirtualVertex v) {
        List<Integer> res = new ArrayList<>();
        res.add(v.getIndex());
        if (!v.getFather().getIndex().equals(0)) {
            res.addAll(getDiagonal(v.getFather()));
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int ncases = 1;

        while (ncases <= cases) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            Integer[] numbers = new Integer[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = i + 1;
            }

            VirtualVertex startVertex = new VirtualVertex(0, 0, null, 0);
            List<VirtualVertex> queue = new ArrayList<>();
            List<VirtualVertex> visited = new ArrayList<>();
            List<VirtualVertex> goals = new ArrayList<>();
            queue.add(startVertex);

            boolean foundSolution = false;

            while (!queue.isEmpty()) {
                VirtualVertex currentVertex = queue.remove(0);
                if (!visited.contains(currentVertex)) {
                    if (currentVertex.getNumber() == k && currentVertex.getDistance() == n) {
                        Set<Integer> diagonalSet = new HashSet<>(getDiagonal(currentVertex));
                        if (diagonalSet.size() == 1) {
                            goals.add(currentVertex);
                            break;
                        }
                    }
                    if (currentVertex.getDistance() > k) {
                        break;
                    }
                    List<VirtualVertex> neighbors = currentVertex.getNeighbors(numbers);
                    queue.addAll(neighbors);
                    visited.add(currentVertex);
                }
            }

            if (goals.isEmpty()) {
                System.out.println("Case #" + ncases + ": IMPOSSIBLE");
            } else {
                List<Integer> numList = Arrays.asList(numbers);
                StringBuilder result = new StringBuilder();
                for (VirtualVertex goal : goals) {
                    List<Integer> diagonal = getDiagonal(goal);
                    Set<Integer> diagonalSet = new HashSet<>(diagonal);
                    if (diagonalSet.size() == 1) {
                        StringBuilder sequence = new StringBuilder();
                        for (int i = 0; i < n; i++) {
                            sequence.append(numList.get((numList.indexOf(diagonal.get(0)) + i) % n));
                        }
                        for (int i = 0; i < n; i++) {
                            String rotated = sequence.charAt(sequence.length() - 1) + sequence.substring(0, sequence.length() - 1);
                            sequence = new StringBuilder(rotated);
                            result.append(rotated);
                            if (i + 1 != n) {
                                result.append("\n");
                            }
                        }
                        foundSolution = true;
                        break;
                    }
                }
                if (!foundSolution) {
                    System.out.println("Case #" + ncases + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + ncases + ": POSSIBLE");
                    for (int i = 0; i < result.length(); i++) {
                        System.out.print(result.charAt(i));
                        if (i + 1 != result.length() && result.charAt(i) != '\n') {
                            System.out.print(" ");
                        }
                    }
                }
            }
            ncases++;
        }
    }
}

class VirtualVertex {

    private Integer number;
    private Integer distance;
    private VirtualVertex father;
    private Integer index;

    public VirtualVertex(Integer number, Integer distance, VirtualVertex father, Integer index) {
        this.number = number;
        this.distance = distance;
        this.index = index;
        this.father = father;
    }

    public Integer getIndex() {
        return index;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getDistance() {
        return distance;
    }

    public VirtualVertex getFather() {
        return father;
    }

    public List<VirtualVertex> getNeighbors(Integer[] numbers) {
        List<VirtualVertex> neighbors = new ArrayList<>();
        for (int i = 1; i <= numbers.length; i++) {
            neighbors.add(new VirtualVertex(this.number + i, this.distance + 1, this, i));
        }
        return neighbors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, distance, father);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        VirtualVertex other = (VirtualVertex) obj;
        return Objects.equals(number, other.number) &&
               Objects.equals(distance, other.distance) &&
               Objects.equals(father, other.father);
    }

    @Override
    public String toString() {
        return "VirtualVertex [number=" + number + ", distance=" + distance + ", index=" + index + ", father=" + father + "]";
    }
}

class Graph {

    private int v;
    private ArrayList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int v) {
        this.v = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[w - 1].add(v - 1);
        adj[v - 1].add(w - 1);
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public ArrayList<Integer>[] getAdj() {
        return adj;
    }

    public void setAdj(ArrayList<Integer>[] adj) {
        this.adj = adj;
    }
}