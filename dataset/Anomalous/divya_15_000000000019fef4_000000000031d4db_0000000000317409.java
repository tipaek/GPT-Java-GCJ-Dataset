import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int c = scanner.nextInt();
            int r = scanner.nextInt();
            String directions = scanner.next();
            int length = directions.length();
            
            System.out.print("Case #" + testCase + ": ");
            int steps = 0;
            boolean isPossible = false;
            
            while (directions.length() >= 0) {
                int distance = Math.abs(r) + Math.abs(c);
                
                if (distance <= steps) {
                    isPossible = true;
                    break;
                }
                
                if (directions.length() == 0) break;
                
                char direction = directions.charAt(0);
                switch (direction) {
                    case 'S': r--; break;
                    case 'N': r++; break;
                    case 'E': c++; break;
                    case 'W': c--; break;
                }
                
                directions = directions.substring(1);
                steps++;
            }
            
            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(steps);
            }
        }
        
        scanner.close();
    }
}