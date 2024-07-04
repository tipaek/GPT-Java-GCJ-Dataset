import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int pointsCount = scanner.nextInt();
            int[] xCoordinates = new int[pointsCount];
            int[] yCoordinates = new int[pointsCount];
            for (int i = 0; i < pointsCount; i++) {
                xCoordinates[i] = scanner.nextInt();
                yCoordinates[i] = scanner.nextInt();
            }

            int[][] deltaY = new int[pointsCount][pointsCount];
            int[][] deltaX = new int[pointsCount][pointsCount];
            for (int i = 0; i < pointsCount; i++) {
                for (int j = 0; j < pointsCount; j++) {
                    deltaY[i][j] = yCoordinates[i] - yCoordinates[j];
                    deltaX[i][j] = xCoordinates[i] - xCoordinates[j];
                    int gcdValue = gcd(deltaY[i][j], deltaX[i][j]);
                    deltaY[i][j] /= gcdValue;
                    deltaX[i][j] /= gcdValue;
                    if (deltaY[i][j] == 0) deltaX[i][j] = 1;
                    if (deltaX[i][j] == 0) deltaY[i][j] = 1;
                }
            }

            int maxPointsOnLine = 0;
            for (int a = 0; a < pointsCount; a++) {
                for (int b = a + 1; b < pointsCount; b++) {
                    int slopeY = deltaY[a][b];
                    int slopeX = deltaX[a][b];
                    int pointsOnLine = 0;
                    boolean[] counted = new boolean[pointsCount];
                    for (int i = 0; i < pointsCount; i++) {
                        for (int j = i + 1; j < pointsCount; j++) {
                            if (deltaY[i][j] == slopeY && deltaX[i][j] == slopeX) {
                                if (!counted[i]) pointsOnLine++;
                                if (!counted[j]) pointsOnLine++;
                                counted[i] = true;
                                counted[j] = true;
                            }
                        }
                    }
                    if (pointsOnLine > maxPointsOnLine) maxPointsOnLine = pointsOnLine;
                }
            }

            int result = maxPointsOnLine + 2;
            while (result > pointsCount) result--;
            System.out.println("Case " + caseNumber + ": " + result);
        }
    }

    public static int gcd(int a, int b) {
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        if (a == 0) return 1;
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}