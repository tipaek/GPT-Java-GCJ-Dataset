import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[] intervals = new int[n * 2];
            
            for (int j = 0; j < n * 2; j++) {
                intervals[j] = scanner.nextInt();
            }
            
            if (intervals[0] == 0 && intervals[1] == 1440 && n > 2) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }
            
            StringBuilder result = new StringBuilder();
            String primary, secondary;
            
            if (n <= 3) {
                primary = "C";
                secondary = "J";
                result.append("C");
            } else {
                primary = "J";
                secondary = "C";
                result.append("J");
            }
            
            for (int k = 2; k < n * 2; k += 2) {
                if ((intervals[k] < intervals[k - 1] && intervals[k] > intervals[k - 2]) ||
                    (intervals[k + 1] > intervals[k - 2] && intervals[k + 1] < intervals[k - 2])) {
                    result.append(secondary);
                } else if ((intervals[k] < intervals[k - 1] && intervals[k] < intervals[k - 2]) ||
                           (intervals[k + 1] < intervals[k - 2] && intervals[k + 1] > intervals[k - 2])) {
                    if (result.charAt(result.length() - 1) == 'J') {
                        result.append(secondary);
                    } else {
                        result.append(primary);
                    }
                } else if (intervals[k] == intervals[k - 1]) {
                    result.append(result.charAt(result.length() - 1));
                } else {
                    result.append(primary);
                }
            }
            
            System.out.println("Case #" + i + ": " + result);
        }
        
        scanner.close();
    }
}