import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    
    public static Scanner input = new Scanner(System.in);
    
    public static boolean isEliminated(int[][] matrix, int x, int y, int X_SIZE, int Y_SIZE) {        
        int currentValue = matrix[x][y];
        double average = 0;
        int count = 0;
        
        for (int currentX = x-1; currentX >=0; currentX--) {
            int currentSquare = matrix[currentX][y];
            if (currentSquare!=0) {
                average+=currentSquare;
                count++;
                break;
            }
        }
        
        for (int currentX = x+1; currentX <X_SIZE; currentX++) {
            int currentSquare = matrix[currentX][y];
            if (currentSquare!=0) {
                average+=currentSquare;
                count++;
                break;
            }
        }
        
        for (int currentY = y-1; currentY >=0; currentY--) {
            int currentSquare = matrix[x][currentY];
            if (currentSquare!=0) {
                average+=currentSquare;
                count++;
                break;
            }
        }
        
        for (int currentY = y+1; currentY <Y_SIZE; currentY++) {
            int currentSquare = matrix[x][currentY];
            if (currentSquare!=0) {
                average+=currentSquare;
                count++;
                break;
            }
        }
        
        if (count>0){
            average/=count;
        }
        
        return currentValue < average;
        
    }
    
    public static void main(String[] args) {
        final int NUM_CASES = input.nextInt();
        for (int currentCase=1; currentCase<=NUM_CASES;currentCase++){
            final int X_SIZE = input.nextInt();
            final int Y_SIZE = input.nextInt();
            int[][] matrix = new int[X_SIZE][Y_SIZE];
            int sum = 0;
            for(int x = 0; x<X_SIZE; x++){
                for (int y = 0; y<Y_SIZE;y++) {
                    int currentValue = input.nextInt();
                    matrix[x][y] = currentValue;
                    sum+=currentValue;
                }
            }
            
            int output = 0;
            
            while (sum!=0) {
                output += sum;
                int[][] tempMatrix = new int[X_SIZE][Y_SIZE];
                
                for(int x = 0; x<X_SIZE; x++) {
                    for (int y = 0; y<Y_SIZE; y++) {
                        if (isEliminated(matrix, x, y, X_SIZE, Y_SIZE)) {
                            tempMatrix[x][y] = 0;
                            sum -= matrix[x][y];
                        } else {
                            tempMatrix[x][y] = matrix[x][y];
                        }
                    }
                }

                if (Arrays.deepEquals(matrix, tempMatrix)) {
                	break;
                }

                matrix = tempMatrix;
            }
            
            System.out.println(String.format("Case #%d: %d", currentCase, output));
        }
    }
}
