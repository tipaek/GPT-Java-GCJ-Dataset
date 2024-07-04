import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int cities = scanner.nextInt();
            int roads = scanner.nextInt();
            int[] cityValues = new int[cities];
            
            for (int i = 1; i < cities; i++) {
                cityValues[i] = scanner.nextInt();
            }
            
            Edge[] edges = new Edge[roads];
            for (int i = 0; i < roads; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                edges[i] = new Edge(u, v);
            }
            
            EdgeRef[][] edgeLists = new EdgeRef[cities][];
            for (int i = 0; i < cities; i++) {
                List<EdgeRef> edgeRefs = new ArrayList<>();
                for (Edge edge : edges) {
                    if (edge.a == i) {
                        edgeRefs.add(new EdgeRef(edge.b, edge));
                    } else if (edge.b == i) {
                        edgeRefs.add(new EdgeRef(edge.a, edge));
                    }
                }
                edgeLists[i] = edgeRefs.toArray(new EdgeRef[0]);
            }
            
            if (Arrays.stream(cityValues).allMatch(value -> value <= 0)) {
                int receivedCount = 1;
                boolean[] received = new boolean[cities];
                received[0] = true;
                int[] receivedAt = new int[cities];
                Arrays.fill(receivedAt, -1);
                receivedAt[0] = 0;
                
                while (true) {
                    int nextReceivedBefore = receivedCount;
                    int[] nextCities = IntStream.range(0, cities).filter(i -> -cityValues[i] == nextReceivedBefore).toArray();
                    
                    if (nextCities.length == 0) {
                        break;
                    }
                    
                    int nextReceivedAt = 0;
                    for (int nextCity : nextCities) {
                        EdgeRef[] edgeList = edgeLists[nextCity];
                        int maxPrev = Arrays.stream(edgeList)
                                            .filter(r -> receivedAt[r.other] >= 0)
                                            .mapToInt(r -> receivedAt[r.other])
                                            .max()
                                            .orElse(0);
                        nextReceivedAt = Math.max(nextReceivedAt, maxPrev + 1);
                    }
                    
                    for (int nextCity : nextCities) {
                        receivedAt[nextCity] = nextReceivedAt;
                        for (EdgeRef ref : edgeLists[nextCity]) {
                            Edge edge = ref.edge;
                            int atOther = receivedAt[ref.other];
                            if (atOther >= 0) {
                                int latency = Math.abs(atOther - nextReceivedAt);
                                if (latency == 0) {
                                    latency = 1;
                                }
                                edge.latency = latency;
                            }
                        }
                    }
                    receivedCount += nextCities.length;
                }
                
                String result = Arrays.stream(edges)
                                      .map(edge -> Integer.toString(edge.latency))
                                      .collect(Collectors.joining(" "));
                System.out.println("CASE #" + (t + 1) + ": " + result);
            } else {
                // TODO: Handle other cases
            }
        }
    }

    static class Edge {
        int a, b, latency = 0;
        
        Edge(int a, int b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public String toString() {
            return "<" + a + "," + b + ":" + latency + ">";
        }
    }

    static class EdgeRef {
        int other;
        Edge edge;
        
        EdgeRef(int other, Edge edge) {
            this.other = other;
            this.edge = edge;
        }
        
        @Override
        public String toString() {
            return "{" + edge + "," + other + "}";
        }
    }
}