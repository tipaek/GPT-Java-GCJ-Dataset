import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int maxLimit = 1 << 30;
            int number = scanner.nextInt();
            scanner.nextLine();
            int currentMax = maxLimit;
            int currentRow = 30;
            int maxRow = 1;
            boolean[] fullRows = new boolean[31];
            
            while (number < currentMax) {
                currentMax >>= 1;
                currentRow--;
            }
            
            if (currentMax + currentRow > number) {
                currentMax >>= 1;
                currentRow--;
            }
            
            fullRows[currentRow] = true;
            maxRow = currentRow;
            number -= currentMax + currentRow;
            currentMax >>= 1;
            currentRow--;
            
            while (number > 0 && currentRow > 0) {
                if (number > currentMax - 2) {
                    number -= currentMax - 1;
                    fullRows[currentRow] = true;
                }
                currentMax >>= 1;
                currentRow--;
            }
            
            System.out.println("Case #" + testCase + ":");
            int row = 1;
            boolean left = true;
            
            for (int i = 0; i <= maxRow; i++) {
                if (fullRows[i]) {
                    printFullRow(row, left);
                    left = !left;
                } else {
                    System.out.println(row + " " + (left ? 1 : row));
                }
                row++;
            }
            
            while (number > 0) {
                System.out.println(row + " " + (left ? 1 : row));
                row++;
                number--;
            }
        }
        
        scanner.close();
    }
    
    private static void printFullRow(int row, boolean leftStart) {
        if (leftStart) {
            for (int i = 1; i <= row; i++) {
                System.out.println(row + " " + i);
            }
        } else {
            for (int i = row; i > 0; i--) {
                System.out.println(row + " " + i);
            }
        }
    }
}