import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            
            System.out.println("Case #" + testCase + ": " + (rows - 1) * (columns - 1));
            
            int currentRow = rows;
            int currentColumn = 1;
            
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < columns; j++) {
                    System.out.println(currentRow + " " + ((rows * columns) - currentRow - currentColumn));
                    currentColumn++;
                }
                currentRow--;
                currentColumn++;
            }
        }
    }
}