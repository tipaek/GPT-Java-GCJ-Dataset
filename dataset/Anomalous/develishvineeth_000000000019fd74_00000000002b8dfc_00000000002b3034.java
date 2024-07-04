import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;
        
        while (testCases-- > 0) {
            int n = scanner.nextInt();
            String[] arr = new String[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.next();
            }
            
            Arrays.sort(arr, (a, b) -> Integer.compare(a.length(), b.length()));
            
            StringBuilder result = new StringBuilder();
            String suffix = arr[0].substring(1);
            boolean isValid = true;
            
            for (int i = 1; i < n; i++) {
                if (arr[i].endsWith(suffix)) {
                    suffix = arr[i].substring(1);
                } else {
                    isValid = false;
                    break;
                }
            }
            
            System.out.print("Case #" + caseNumber + ": ");
            caseNumber++;
            
            if (isValid) {
                System.out.println(suffix);
            } else {
                System.out.println("*");
            }
        }
        
        scanner.close();
    }
}