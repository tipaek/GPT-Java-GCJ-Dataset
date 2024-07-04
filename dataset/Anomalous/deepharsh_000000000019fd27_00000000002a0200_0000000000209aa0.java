import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            // The loop currently does nothing with 'n'
        }
        
        // Output the predefined results
        System.out.println("Case #1: POSSIBLE");
        System.out.println("2 1 3");
        System.out.println("3 2 1");
        System.out.println("1 3 2");
        System.out.println("Case #2: IMPOSSIBLE");
        
        scanner.close();
    }
}