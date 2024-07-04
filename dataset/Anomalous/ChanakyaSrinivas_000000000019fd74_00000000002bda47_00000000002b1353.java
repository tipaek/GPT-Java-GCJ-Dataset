import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int remainingSteps = scanner.nextInt() - 2;
            System.out.println("Case #" + t + ": ");
            
            int row = 3;
            int stepIncrement = 2;
            
            System.out.println(1 + " " + 1);
            
            if (remainingSteps >= 0) {
                System.out.println(2 + " " + 1);
            }
            
            while (remainingSteps >= stepIncrement) {
                System.out.println(row + " " + 2);
                remainingSteps -= stepIncrement;
                stepIncrement++;
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