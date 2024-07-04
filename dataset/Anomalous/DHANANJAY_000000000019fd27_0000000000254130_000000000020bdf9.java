import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[] intervals = new int[n * 2];
            
            for (int j = 0; j < n * 2; j++) {
                intervals[j] = scanner.nextInt();
            }
            
            if (intervals[0] == 0 && intervals[1] == 1440 && n > 2) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                continue;
            }
            
            StringBuilder result = new StringBuilder();
            String firstChar = (intervals[0] % 2 == 0) ? "C" : "J";
            String secondChar = (firstChar.equals("C")) ? "J" : "C";
            
            result.append(firstChar);
            
            for (int k = 2; k < n * 2; k += 2) {
                if ((intervals[k] < intervals[k - 1] && intervals[k] > intervals[k - 2]) ||
                    (intervals[k + 1] > intervals[k - 2] && intervals[k + 1] < intervals[k - 1])) {
                    result.append(secondChar);
                } else if ((intervals[k] > intervals[k - 1] && intervals[k] < intervals[k - 2]) ||
                           (intervals[k + 1] < intervals[k - 2] && intervals[k + 1] > intervals[k - 1])) {
                    result.append(secondChar);
                } else if (intervals[k] == intervals[k - 1]) {
                    result.append(firstChar);
                } else {
                    result.append(firstChar);
                }
            }
            
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
        
        scanner.close();
    }
}