import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int remainingSteps = scanner.nextInt() - 1;
            System.out.println("Case #" + t + ":");
            int row = 2, stepsInRow = 1;
            
            System.out.println(1 + " " + 1);
            
            while (remainingSteps >= stepsInRow) {
                System.out.println(row + " " + 2);
                remainingSteps -= stepsInRow;
                stepsInRow++;
                row++;
            }
            
            while (remainingSteps > 0) {
                System.out.println(row + " " + 1);
                remainingSteps--;
                row++;
            }
        }
        
        scanner.close();
    }
}