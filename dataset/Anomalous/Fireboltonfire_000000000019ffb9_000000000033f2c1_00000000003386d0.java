import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            
            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextInt();
                y[i] = scanner.nextInt();
            }
            
            Map<Coord, Map<Integer, Integer>> coordMap = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    
                    int deltaX = x[i] - x[j];
                    int deltaY = y[i] - y[j];
                    int gcdValue = gcd(Math.abs(deltaX), Math.abs(deltaY));
                    
                    deltaX /= gcdValue;
                    deltaY /= gcdValue;
                    
                    Coord coord = new Coord(deltaX, deltaY);
                    coordMap.putIfAbsent(coord, new HashMap<>());
                    
                    Map<Integer, Integer> innerMap = coordMap.get(coord);
                    if (innerMap.containsKey(j)) {
                        int minIndex = innerMap.get(j);
                        int tempX = x[minIndex] - x[j];
                        int tempY = y[minIndex] - y[j];
                        
                        if (Math.abs(tempX) + Math.abs(tempY) > Math.abs(deltaX) + Math.abs(deltaY)) {
                            innerMap.put(j, i);
                        }
                    } else {
                        innerMap.put(j, i);
                    }
                }
            }
            
            int maxPoints = 0;
            for (Map.Entry<Coord, Map<Integer, Integer>> entry : coordMap.entrySet()) {
                Set<Integer> uniquePoints = new HashSet<>();
                for (Map.Entry<Integer, Integer> innerEntry : entry.getValue().entrySet()) {
                    uniquePoints.add(innerEntry.getKey());
                    uniquePoints.add(innerEntry.getValue());
                }
                maxPoints = Math.max(maxPoints, uniquePoints.size());
            }
            
            System.out.println("Case #" + testCase + ": " + Math.min(n, maxPoints + 2));
        }
        
        scanner.close();
    }
    
    public static class Coord {
        int x, y;
        
        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int hashCode() {
            return 31 * x + y;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Coord coord = (Coord) obj;
            return x == coord.x && y == coord.y;
        }
    }
    
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}