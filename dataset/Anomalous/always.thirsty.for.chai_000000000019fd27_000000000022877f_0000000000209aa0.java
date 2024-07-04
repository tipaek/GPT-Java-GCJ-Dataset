import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int remainingTestCases = testCases;
        
        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            
            if (k % n == 0 && k / n <= n) {
                System.out.println("Case #" + (remainingTestCases - testCases) + ": POSSIBLE");
                int startValue = k / n;
                
                for (int i = 0; i < n; i++) {
                    int currentStart = startValue == 0 ? n : startValue;
                    int currentValue = currentStart;
                    
                    for (int j = 0; j < n; j++) {
                        if (currentValue > n) {
                            currentValue = 1;
                        }
                        
                        if (j == n - 1) {
                            System.out.print(currentValue);
                        } else {
                            System.out.print(currentValue + " ");
                        }
                        
                        currentValue++;
                    }
                    
                    System.out.println();
                    startValue--;
                }
            } else {
                System.out.println("Case #" + (remainingTestCases - testCases) + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}