import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            int[] arr = new int[n];
            
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            
            Arrays.sort(arr);
            int duplicateCount = 0;
            
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] == arr[j + 1]) {
                    duplicateCount++;
                }
            }
            
            int result;
            if (duplicateCount == d) {
                result = 0;
            } else if (n == 1) {
                result = Math.abs(d - arr[0]);
            } else {
                result = Math.abs(arr[0] - d);
            }
            
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }
}