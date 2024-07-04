import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int pointsCount = scanner.nextInt();
            long[] xCoordinates = new long[pointsCount];
            long[] yCoordinates = new long[pointsCount];
            
            for (int i = 0; i < pointsCount; i++) {
                xCoordinates[i] = scanner.nextLong();
                yCoordinates[i] = scanner.nextLong();
            }
            
            long maxPointsOnLine = 1;
            HashSet<String> uniqueSlopes = new HashSet<>();
            
            for (int i = 0; i < pointsCount; i++) {
                for (int j = i + 1; j < pointsCount; j++) {
                    long deltaX = xCoordinates[i] - xCoordinates[j];
                    long deltaY = yCoordinates[i] - yCoordinates[j];
                    
                    if (deltaY < 0) {
                        deltaX *= -1;
                        deltaY *= -1;
                    }
                    
                    if (deltaX == 0) {
                        deltaY = 1;
                    }
                    
                    long gcdValue = gcd(deltaX, deltaY);
                    deltaX /= gcdValue;
                    deltaY /= gcdValue;
                    
                    String slopeKey = deltaX + "/" + deltaY;
                    uniqueSlopes.add(slopeKey);
                }
            }
            
            for (String slope : uniqueSlopes) {
                String[] slopeComponents = slope.split("/");
                int dx = Integer.parseInt(slopeComponents[0]);
                int dy = Integer.parseInt(slopeComponents[1]);
                
                HashMap<Long, Integer> diagonalCountMap = new HashMap<>();
                
                for (int i = 0; i < pointsCount; i++) {
                    long diagonal = xCoordinates[i] * dy + yCoordinates[i] * dx;
                    diagonalCountMap.put(diagonal, diagonalCountMap.getOrDefault(diagonal, 0) + 1);
                }
                
                long currentMax = 0;
                int singlePointCount = 0;
                
                for (long diagonal : diagonalCountMap.keySet()) {
                    int count = diagonalCountMap.get(diagonal);
                    if (count > 1) {
                        currentMax += count;
                    } else {
                        singlePointCount++;
                    }
                }
                
                maxPointsOnLine = Math.max(maxPointsOnLine, currentMax + Math.min(singlePointCount, 2));
            }
            
            System.out.printf("Case #%d: %d\n", t, maxPointsOnLine);
        }
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}