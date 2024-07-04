import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Scanner;

public class Solution {
    
    public static final Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        final int numberOfCases = input.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            final int sizeOfMatrix = input.nextInt();
            int trace = 0;
            int[][] verticalCounter = new int[sizeOfMatrix][sizeOfMatrix];
            int[][] horizontalCounter = new int[sizeOfMatrix][sizeOfMatrix];
            int horizontalDuplicates = 0;
            int verticalDuplicates = 0;
            
            for (int x = 0; x < sizeOfMatrix; x++) {
                for (int y = 0; y < sizeOfMatrix; y++) {
                    final int currentCellValue = input.nextInt();
                    if (x==y) {
                        trace+=currentCellValue;
                    }
                    verticalDuplicates = (int) Math.max(verticalDuplicates, ++verticalCounter[x][currentCellValue-1]);
                    if (verticalDuplicates == 1) {
                        verticalDuplicates = 0;
                    }
                    horizontalDuplicates = (int) Math.max(horizontalDuplicates, ++horizontalCounter[y][currentCellValue-1]);
                    if (horizontalDuplicates == 1) {
                        horizontalDuplicates = 0;
                    }
                }
            }
            
            String output = String.format("Case #%d: %d %d %d",
                                          caseNumber,
                                          trace,
                                          verticalDuplicates,
                                          horizontalDuplicates
                                          );
            System.out.println(output);
        }
        
    }

}