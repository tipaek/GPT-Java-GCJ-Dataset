import java.util.Scanner;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int targetNumber = input.nextInt();
            double target = (double) targetNumber;
            int currentSum = 0;
            double row = 1;
            double column = 1;
            int caseNumber = i + 1;
            
            System.out.println("Case #" + caseNumber + ":");
            
            while (currentSum < target) {
                currentSum += (int) Math.round(calculatePascal(row, column));
                System.out.println((int) row + " " + (int) column);
                
                if (currentSum < target / 3) {
                    if (Math.pow(-1, row + 1) == 1) {
                        column++;
                    }
                    row++;
                } else if (column == row) {
                    column++;
                    row++;
                } else {
                    column++;
                }
            }
        }
    }

    public static double calculatePascal(double row, double column) {
        double result = 1.0;
        for (int i = 0; i < column - 1; i++) {
            result = result * (row - 1 - i) / (i + 1);
        }
        return result;
    }
}