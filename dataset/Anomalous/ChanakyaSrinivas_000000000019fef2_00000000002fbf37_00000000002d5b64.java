import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            
            System.out.print("Case #" + t + ": ");
            if (rows == 1 || columns == 1) {
                System.out.println(0);
            } else {
                System.out.println((rows - 1) * (columns - 1));
            }
            
            while (rows > 1) {
                int totalCells = rows * columns;
                for (int col = 1; col < columns; col++) {
                    System.out.println(rows + " " + (totalCells - rows - col));
                }
                rows--;
            }
        }
        
        scanner.close();
    }
}