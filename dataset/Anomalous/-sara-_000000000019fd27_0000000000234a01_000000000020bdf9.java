import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            StringBuilder jamie = new StringBuilder("0".repeat(1441));
            StringBuilder cameron = new StringBuilder("0".repeat(1441));
            int n = scanner.nextInt();
            StringBuilder solution = new StringBuilder();
            
            boolean possible = true;
            for (int j = 0; j < n; j++) {
                int beginTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                
                if (!jamie.substring(beginTime, endTime).contains("1")) {
                    solution.append("J");
                    for (int k = beginTime; k < endTime; k++) {
                        jamie.setCharAt(k, '1');
                    }
                } else if (!cameron.substring(beginTime, endTime).contains("1")) {
                    solution.append("C");
                    for (int k = beginTime; k < endTime; k++) {
                        cameron.setCharAt(k, '1');
                    }
                } else {
                    solution = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + solution);
        }
        
        scanner.close();
    }
}