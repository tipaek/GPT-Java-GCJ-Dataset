import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            int[] arr = new int[n];
            
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            
            Arrays.sort(arr);
            int count = 0;
            int result = 0;
            
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[j] == arr[k]) {
                        count++;
                    }
                }
            }
            
            if (count == d) {
                result = 0;
            } else if (arr.length == 1) {
                result = Math.abs(d - arr[0]);
            } else {
                for (int j = 0; j < n; j++) {
                    while (arr[j] % 2 == 0) {
                        result++;
                        arr[j] /= 2;
                    }
                    while (arr[j] % 3 == 0) {
                        result++;
                        arr[j] /= 3;
                    }
                }
                result = Math.abs(d - result);
            }
            
            System.out.println("Case #" + i + ": " + result);
        }
        
        scanner.close();
    }
}