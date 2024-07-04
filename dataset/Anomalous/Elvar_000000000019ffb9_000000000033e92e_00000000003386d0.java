import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numPoints = scanner.nextInt();
            int[] xCoordinates = new int[numPoints];
            int[] yCoordinates = new int[numPoints];
            
            for (int i = 0; i < numPoints; i++) {
                xCoordinates[i] = scanner.nextInt();
                yCoordinates[i] = scanner.nextInt();
            }
            
            int[][] yDifferences = new int[numPoints][numPoints];
            int[][] xDifferences = new int[numPoints][numPoints];
            
            for (int i = 0; i < numPoints; i++) {
                for (int j = 0; j < numPoints; j++) {
                    yDifferences[i][j] = yCoordinates[i] - yCoordinates[j];
                    xDifferences[i][j] = xCoordinates[i] - xCoordinates[j];
                    
                    int gcdValue = gcd(yDifferences[i][j], xDifferences[i][j]);
                    yDifferences[i][j] /= gcdValue;
                    xDifferences[i][j] /= gcdValue;
                    
                    if (yDifferences[i][j] == 0) xDifferences[i][j] = 1;
                    if (xDifferences[i][j] == 0) yDifferences[i][j] = 1;
                }
            }
            
            int maxCount = 0;
            
            for (int i = 0; i < numPoints; i++) {
                for (int j = i + 1; j < numPoints; j++) {
                    int yDiff = yDifferences[i][j];
                    int xDiff = xDifferences[i][j];
                    int count = 0;
                    boolean[] checked = new boolean[numPoints];
                    
                    for (int k = 0; k < numPoints; k++) {
                        for (int l = k + 1; l < numPoints; l++) {
                            if (yDifferences[k][l] == yDiff && xDifferences[k][l] == xDiff) {
                                if (!checked[k]) count++;
                                if (!checked[l]) count++;
                                checked[k] = true;
                                checked[l] = true;
                            }
                        }
                    }
                    
                    if (count > maxCount) maxCount = count;
                }
            }
            
            int result = maxCount + 2;
            if (result > numPoints) result = numPoints;
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }
    
    private static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        
        if (a == 0) return b;
        if (b == 0) return a;
        
        return gcd(b, a % b);
    }
}