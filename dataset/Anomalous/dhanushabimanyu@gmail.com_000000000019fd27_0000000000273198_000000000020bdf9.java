import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int startC1 = 0, endC1 = 0;
            int startJ1 = 0, endJ1 = 0;
            int startC2 = 0, endC2 = 0;
            int startJ2 = 0, endJ2 = 0;
            StringBuilder result1 = new StringBuilder();
            StringBuilder result2 = new StringBuilder();
            String finalResult = "";
            
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (start >= endC1 || end <= startC1) {
                    result1.append("C");
                    startC1 = start;
                    endC1 = end;
                } else if (start >= endJ1 || end <= startJ1) {
                    result1.append("J");
                    startJ1 = start;
                    endJ1 = end;
                } else {
                    result1 = new StringBuilder("IMPOSSIBLE");
                }
                
                if (start >= endJ2 || end <= startJ2) {
                    result2.append("J");
                    startJ2 = start;
                    endJ2 = end;
                } else if (start >= endC2 || end <= startC2) {
                    result2.append("C");
                    startC2 = start;
                    endC2 = end;
                } else {
                    result2 = new StringBuilder("IMPOSSIBLE");
                }
                
                if (!result1.toString().equals("IMPOSSIBLE")) {
                    finalResult = result1.toString();
                } else if (!result2.toString().equals("IMPOSSIBLE")) {
                    finalResult = result2.toString();
                } else {
                    finalResult = "IMPOSSIBLE";
                }
            }
            System.out.println("Case #" + testCase + ": " + finalResult);
        }
        
        scanner.close();
    }
}