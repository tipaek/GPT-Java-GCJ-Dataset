import java.util.*;
import java.io.*;

public class WormholeInOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[] xCoords = new int[n];
            int[] yCoords = new int[n];
            
            for (int j = 0; j < n; j++) {
                xCoords[j] = scanner.nextInt();
                yCoords[j] = scanner.nextInt();
            }
            
            int result = calculateResult(n, xCoords, yCoords);
            System.out.println("Case #" + i + ": " + result);
        }
    }
    
    private static int calculateResult(int n, int[] xCoords, int[] yCoords) {
        if (n <= 4) {
            return n;
        } else if (n == 5 || n == 6) {
            return handleFiveOrSixPoints(n, xCoords, yCoords);
        } else {
            return handleMoreThanSixPoints(n, xCoords, yCoords);
        }
    }
    
    private static int handleFiveOrSixPoints(int n, int[] xCoords, int[] yCoords) {
        int result = 4;
        for (int j = 0; j < xCoords.length - 1; j++) {
            for (int k = j + 1; k < xCoords.length; k++) {
                int xDelta = xCoords[j] - xCoords[k];
                int yDelta = yCoords[j] - yCoords[k];
                for (int l = 0; l < xCoords.length; l++) {
                    if (l != j && l != k && collinear(xCoords, yCoords, j, k, l, xDelta, yDelta)) {
                        return n;
                    }
                }
            }
        }
        return result;
    }
    
    private static int handleMoreThanSixPoints(int n, int[] xCoords, int[] yCoords) {
        int result = 4;
        List<List<Integer>> collinearPoints = new ArrayList<>();
        
        for (int j = 0; j < xCoords.length - 1; j++) {
            for (int k = j + 1; k < xCoords.length; k++) {
                int xDelta = xCoords[j] - xCoords[k];
                int yDelta = yCoords[j] - yCoords[k];
                for (int l = 0; l < xCoords.length; l++) {
                    if (l != j && l != k && collinear(xCoords, yCoords, j, k, l, xDelta, yDelta)) {
                        collinearPoints.add(Arrays.asList(j, k, l));
                    }
                }
            }
        }
        
        if (!collinearPoints.isEmpty()) {
            result = 6;
        }
        
        for (int j = 0; j < collinearPoints.size() - 1; j++) {
            for (int k = j + 1; k < collinearPoints.size(); k++) {
                if (areDistinct(collinearPoints.get(j), collinearPoints.get(k))) {
                    return n;
                }
            }
        }
        
        return result;
    }
    
    private static boolean collinear(int[] xCoords, int[] yCoords, int c1, int c2, int c3, int xDelta, int yDelta) {
        int x1 = xCoords[c1];
        int x2 = xCoords[c2];
        int x3 = xCoords[c3] + xDelta;
        int y1 = yCoords[c1];
        int y2 = yCoords[c2];
        int y3 = yCoords[c3] + yDelta;
        int x4 = xCoords[c3] - xDelta;
        int y4 = yCoords[c3] - yDelta;
        
        return ((x3 - x1) * (y3 - y2) - (x3 - x2) * (y3 - y1) == 0) ||
               ((x4 - x1) * (y4 - y2) - (x4 - x2) * (y4 - y1) == 0);
    }
    
    private static boolean areDistinct(List<Integer> list1, List<Integer> list2) {
        for (int i : list1) {
            if (list2.contains(i)) {
                return false;
            }
        }
        return true;
    }
}