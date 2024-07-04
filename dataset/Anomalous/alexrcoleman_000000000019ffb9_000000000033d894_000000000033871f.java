import java.util.*;

public class Solution {
    private static final int INF = 1000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int cities = scanner.nextInt();
            int roads = scanner.nextInt();
            int[] cityCosts = new int[cities];
            
            for (int i = 1; i < cities; i++) {
                cityCosts[i] = scanner.nextInt();
            }

            List<Edge>[] adjacencyList = new ArrayList[cities];
            for (int i = 0; i < cities; i++) {
                adjacencyList[i] = new ArrayList<>();
            }

            int[] roadCosts = new int[roads];
            Arrays.fill(roadCosts, INF);
            
            for (int i = 0; i < roads; i++) {
                int city1 = scanner.nextInt() - 1;
                int city2 = scanner.nextInt() - 1;
                adjacencyList[city1].add(new Edge(city2, i));
                adjacencyList[city2].add(new Edge(city1, i));
                roadCosts[i] = Math.max(1, Math.abs(cityCosts[city1] - cityCosts[city2]));
            }

            System.out.printf("Case #%d:", t);
            for (int cost : roadCosts) {
                System.out.print(" " + cost);
            }
            System.out.println();
        }
    }

    private static class Edge {
        int destination;
        int index;

        public Edge(int destination, int index) {
            this.destination = destination;
            this.index = index;
        }
    }
}