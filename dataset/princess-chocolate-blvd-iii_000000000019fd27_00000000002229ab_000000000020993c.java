import java.util.Scanner;

public class Solution {
    
    public static final Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        final int numberOfCases = input.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            final int sizeOfMatrix = input.nextInt();
            int trace = 0;
            int[][] verticalCounter = new int[sizeOfMatrix][sizeOfMatrix+1];
            int[][] horizontalCounter = new int[sizeOfMatrix][sizeOfMatrix+1];
            int numberOfRowsContaingHorizontalDuplicates = 0;
            int numberOfRowsContainingVertivalDuplicates = 0;
            
            for (int x = 0; x < sizeOfMatrix; x++) {
                for (int y = 0; y < sizeOfMatrix; y++) {
                    final int currentCellValue = input.nextInt();
                    if (x==y) {
                        trace+=currentCellValue;
                    }
                    if (++verticalCounter[x][currentCellValue] > 1) {
                        verticalCounter[x][0] = 1;
                    }
                    if (++horizontalCounter[y][currentCellValue] > 1) {
                        horizontalCounter[y][0] = 1;
                    }
                }
            }
            
            for (int x = 0; x < sizeOfMatrix; x++) {
                numberOfRowsContaingHorizontalDuplicates += horizontalCounter[x][0];
                numberOfRowsContainingVertivalDuplicates += verticalCounter[x][0];
            }
            
            String output = String.format("Case #%d: %d %d %d",
                                          caseNumber,
                                          trace,
                                          numberOfRowsContainingVertivalDuplicates,
                                          numberOfRowsContaingHorizontalDuplicates
                                          );
            System.out.println(output);
        }
        
    }

}