import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int cameronStart = 0, cameronEnd = 0, jamieStart = 0, jamieEnd = 0;
            int cameronCount = 0, jamieCount = 0;
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                
                if (!result.toString().equals("IMPOSSIBLE")) {
                    if (cameronEnd <= startTimes[i] || cameronStart >= endTimes[i]) {
                        result.append("C");
                        if (cameronStart > startTimes[i] || cameronCount == 0) {
                            cameronStart = startTimes[i];
                        }
                        if (cameronEnd < endTimes[i] || cameronCount == 0) {
                            cameronEnd = endTimes[i];
                        }
                        cameronCount++;
                    } else if (jamieEnd <= startTimes[i] || jamieStart >= endTimes[i]) {
                        result.append("J");
                        if (jamieStart > startTimes[i] || jamieCount == 0) {
                            jamieStart = startTimes[i];
                        }
                        if (jamieEnd < endTimes[i] || jamieCount == 0) {
                            jamieEnd = endTimes[i];
                        }
                        jamieCount++;
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                    }
                }
            }
            
            System.out.println("Case #" + testCase + ": " + result);
            System.out.flush();
        }
        
        scanner.close();
    }
}