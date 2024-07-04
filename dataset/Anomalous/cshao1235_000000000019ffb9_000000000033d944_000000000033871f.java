import java.io.*;
import java.util.*;

public class Solution {
    static final int INF = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int cities = Integer.parseInt(tokenizer.nextToken());
            int roads = Integer.parseInt(tokenizer.nextToken());

            TreeMap<Integer, Set<Integer>> cityInfo = new TreeMap<>();
            int[] travelTimes = new int[cities];

            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 1; i < cities; i++) {
                int value = -Integer.parseInt(tokenizer.nextToken());
                cityInfo.computeIfAbsent(value, k -> new HashSet<>()).add(i);
            }

            int[][] roadData = new int[roads][3];
            for (int i = 0; i < roads; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                roadData[i][0] = Integer.parseInt(tokenizer.nextToken()) - 1;
                roadData[i][1] = Integer.parseInt(tokenizer.nextToken()) - 1;
                roadData[i][2] = INF;
            }

            Set<Integer> currentFrontier = new HashSet<>();
            currentFrontier.add(0);

            for (int value : cityInfo.keySet()) {
                Set<Integer> nextCities = cityInfo.get(value);
                Map<Integer, Integer> selectedEdges = new HashMap<>();

                int bestNextTime = 0;
                for (int city : nextCities) {
                    for (int i = 0; i < roads; i++) {
                        int u = roadData[i][0];
                        int v = roadData[i][1];
                        if ((city == u && currentFrontier.contains(v)) || (city == v && currentFrontier.contains(u))) {
                            bestNextTime = Math.max(bestNextTime, travelTimes[u == city ? v : u] + 1);
                            selectedEdges.put(city, i);
                        }
                    }
                }

                for (int city : nextCities) {
                    int edgeIndex = selectedEdges.get(city);
                    int u = roadData[edgeIndex][0];
                    int v = roadData[edgeIndex][1];
                    roadData[edgeIndex][2] = bestNextTime - travelTimes[u == city ? v : u];
                    travelTimes[city] = bestNextTime;
                }

                currentFrontier.addAll(nextCities);
            }

            StringBuilder result = new StringBuilder("Case #" + testCase + ":");
            for (int[] road : roadData) {
                result.append(" ").append(road[2]);
            }
            System.out.println(result.toString());
        }
        reader.close();
    }
}