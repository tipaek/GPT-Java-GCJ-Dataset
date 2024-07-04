import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int originalTestCases = testCases;
        
        while (testCases-- > 0) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            
            if ((x + y) % 2 == 0) {
                System.out.println("Case #" + (originalTestCases - testCases) + ": IMPOSSIBLE");
                continue;
            }
            
            StringBuilder result = new StringBuilder();
            long step = 1;
            
            while (step <= Math.abs(x + y)) {
                step *= 2;
            }
            step /= 2;
            
            while ((x != 0 || y != 0) && step > 0) {
                if (Math.abs(Math.abs(x) - step) <= Math.abs(Math.abs(y) - step) && x != 0) {
                    if (x < 0) {
                        x += step;
                        result.append("W");
                    } else {
                        x -= step;
                        result.append("E");
                    }
                } else {
                    if (y < 0) {
                        y += step;
                        result.append("S");
                    } else {
                        y -= step;
                        result.append("N");
                    }
                }
                step /= 2;
            }
            
            System.out.println("Case #" + (originalTestCases - testCases) + ": " + result.reverse());
        }
        
        scanner.close();
    }
}