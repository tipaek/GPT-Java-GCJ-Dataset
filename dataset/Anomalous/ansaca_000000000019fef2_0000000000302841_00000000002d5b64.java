import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            int lastOrder = rows * columns;
            
            System.out.println("CASE #" + caseNumber + ": " + (rows - 1) * (columns - 1));
            
            for (int row = rows; row > 1; row--) {
                for (int column = columns; column > 1; column--) {
                    System.out.println(row + " " + (lastOrder - 1 - row));
                    lastOrder--;
                }
                lastOrder--;
            }
        }
        
        scanner.close();
    }
}