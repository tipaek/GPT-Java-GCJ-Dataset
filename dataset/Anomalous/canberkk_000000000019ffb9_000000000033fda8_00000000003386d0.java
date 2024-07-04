import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            String result = "Case #" + caseIndex + ": ";

            int numberOfPoints = scanner.nextInt();
            int[] xCoordinates = new int[numberOfPoints];
            int[] yCoordinates = new int[numberOfPoints];

            for (int i = 0; i < numberOfPoints; i++) {
                xCoordinates[i] = scanner.nextInt();
                yCoordinates[i] = scanner.nextInt();
            }

            int maxCollinearPoints = 1;
            for (int i = 0; i < numberOfPoints; i++) {
                for (int j = i + 1; j < numberOfPoints; j++) {
                    int deltaX = xCoordinates[i] - xCoordinates[j];
                    int deltaY = yCoordinates[i] - yCoordinates[j];
                    int[] collinearCounts = new int[numberOfPoints];
                    
                    for (int p1 = 0; p1 < numberOfPoints; p1++) {
                        for (int p2 = 0; p2 < numberOfPoints; p2++) {
                            if (areCollinear(xCoordinates[p1], yCoordinates[p1], 
                                             xCoordinates[p1] + deltaX, yCoordinates[p1] + deltaY, 
                                             xCoordinates[p2], yCoordinates[p2])) {
                                collinearCounts[p1]++;
                            }
                        }
                    }
                    
                    int score = calculateMaxScore(collinearCounts);
                    if (score > maxCollinearPoints) {
                        maxCollinearPoints = score;
                    }
                }
            }

            writer.println(result + maxCollinearPoints);
        }

        scanner.close();
        writer.close();
    }

    private static int calculateMaxScore(int[] counts) {
        int[] frequency = new int[counts.length + 1];
        for (int count : counts) {
            frequency[count]++;
        }

        int score = 0;
        int oddCount = 0;
        for (int i = 2; i < frequency.length; i++) {
            if (frequency[i] % 2 == 0) {
                score += frequency[i];
            } else {
                score += frequency[i] - 1;
                oddCount++;
            }
        }

        if (oddCount % 2 == 0) {
            return score + oddCount + Math.min(2, frequency[1]);
        } else {
            return score + oddCount + Math.min(1, frequency[1]);
        }
    }

    private static boolean areCollinear(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) == 0;
    }
}