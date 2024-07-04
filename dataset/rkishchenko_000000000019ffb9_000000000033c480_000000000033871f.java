import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            int[] parameters = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int c = parameters[0];
            int d = parameters[1];
            int[] distances = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[][] edges = new int[d][];
            for (int j = 0; j < d; j++) {
                int[] edge = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                edges[j] = edge;
            }
            String solution = solve(c, d, distances, edges);
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }
    }

    private static Map<Integer, List<Integer>> buildConnectionMap(int[][] edges) {
        Map<Integer, List<Integer>> connections = new HashMap<>();
        for (int[] edge : edges) {
            connections.computeIfAbsent(edge[0], e -> new ArrayList<>()).add(edge[1]);
            connections.computeIfAbsent(edge[1], e -> new ArrayList<>()).add(edge[0]);
        }
        return connections;
    }

    private static String solve(int c, int d, int[] distances, int[][] edges) {
        Map<Integer, List<Integer>> connections = buildConnectionMap(edges);
        List<Computer> computers = new ArrayList<>();
//        computers.add(new Computer(1, 0, 0));
        for (int i = 0; i < distances.length; i++) {
            int distance = distances[i];
            Computer computer;
            if (distance >= 0) {
                computer = new Computer(i + 2, -1, distance);
            } else {
                computer = new Computer(i + 2, - distance, -1);
            }
            computers.add(computer);
        }

        Deque<Computer> timedComputers = computers.stream()
                .filter(comp -> comp.time >= 0)
                .sorted(Comparator.comparingInt(comp -> comp.time))
                .collect(Collectors.toCollection(LinkedList::new));
        Deque<Computer> kComputers = computers.stream()
                .filter(comp -> comp.k >= 0)
                .sorted(Comparator.comparingInt(comp -> comp.k))
                .collect(Collectors.toCollection(LinkedList::new));

        List<Computer> order = new ArrayList<>();
        order.add(new Computer(1, 0, 0));

        while (!kComputers.isEmpty() || !timedComputers.isEmpty()) {
            if (!kComputers.isEmpty() && kComputers.peek().k == order.size()) {
                int size = order.size();
                int latency = order.get(order.size() - 1).time;
                while (!kComputers.isEmpty() && kComputers.peek().k == size) {
                    Computer computer = kComputers.poll();
                    computer.time = latency + 1;
                    order.add(computer);
                }
            }
            if (!timedComputers.isEmpty()) {
                order.add(timedComputers.poll());
            }
        }

        Map<Integer, Integer> latencies = new HashMap<>();
        latencies.put(1, 0);
        Map<Edge, Integer> edgeLatencies = new HashMap<>();

        for (int i = 1; i < order.size(); i++) {
            Computer computer = order.get(i);
            List<Integer> computerConnections = connections.computeIfAbsent(computer.i, k -> new ArrayList<>()).stream()
                    .filter(latencies::containsKey)
                    .collect(Collectors.toList());

            for (Integer connection : computerConnections) {
                int latency = latencies.get(connection);
                edgeLatencies.put(new Edge(computer.i, connection), Integer.max(1,computer.time - latency));
            }
            latencies.put(computer.i, computer.time);
        }

        return Arrays.stream(edges)
                .map(edge -> edgeLatencies.get(new Edge(edge[0], edge[1])))
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private static class Edge {

        private int a;
        private int b;

        public Edge(int a, int b) {
            if (a <= b) {
                this.a = a;
                this.b = b;
            } else {
                this.b = a;
                this.a = b;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return a == edge.a &&
                    b == edge.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }
    
    private static class Computer {
        
        int i;
        int k;
        int time;

        public Computer(int i, int k, int time) {
            this.i = i;
            this.k = k;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Computer{" +
                    "i=" + i +
                    ", k=" + k +
                    ", time=" + time +
                    '}';
        }
    }

}
