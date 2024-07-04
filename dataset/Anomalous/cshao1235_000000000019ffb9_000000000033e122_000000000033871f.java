import java.io.*;
import java.util.*;

public class Solution {
    private static final int INF = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
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

            int[][] roadEdges = new int[roads][3];
            for (int i = 0; i < roads; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                roadEdges[i][0] = Integer.parseInt(tokenizer.nextToken()) - 1;
                roadEdges[i][1] = Integer.parseInt(tokenizer.nextToken()) - 1;
                roadEdges[i][2] = INF;
            }

            Set<Integer> activeCities = new HashSet<>();
            activeCities.add(0);
            int maxTravelTime = 0;

            for (int value : cityInfo.keySet()) {
                Set<Integer> nextCities = cityInfo.get(value);
                Map<Integer, Integer> selectedEdges = new HashMap<>();
                int newMaxTravelTime = maxTravelTime + 1;

                for (int city : nextCities) {
                    for (int i = 0; i < roads; i++) {
                        int city1 = roadEdges[i][0];
                        int city2 = roadEdges[i][1];
                        if ((city == city1 && activeCities.contains(city2)) || (city == city2 && activeCities.contains(city1))) {
                            newMaxTravelTime = Math.max(newMaxTravelTime, travelTimes[city1 == city ? city2 : city1] + 1);
                            selectedEdges.put(city, i);
                            break;
                        }
                    }
                }

                for (int city : nextCities) {
                    int edgeIndex = selectedEdges.get(city);
                    int city1 = roadEdges[edgeIndex][0];
                    int city2 = roadEdges[edgeIndex][1];
                    roadEdges[edgeIndex][2] = newMaxTravelTime - travelTimes[city == city1 ? city2 : city1];
                    travelTimes[city] = newMaxTravelTime;
                }

                maxTravelTime = Math.max(maxTravelTime, newMaxTravelTime);
                activeCities.addAll(nextCities);
            }

            StringBuilder result = new StringBuilder("Case #" + caseNum + ":");
            for (int[] edge : roadEdges) {
                result.append(" ").append(edge[2]);
            }
            System.out.println(result);
        }

        reader.close();
    }
}