import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            long left = scanner.nextLong();
            long right = scanner.nextLong();
            
            long finalValue = 0;
            for (long i = 1; i < 100000000000000000L; i++) {
                if (right > left) {
                    if (right >= i) {
                        right -= i;
                    } else {
                        finalValue = i - 1;
                        break;
                    }
                } else {
                    if (left >= i) {
                        left -= i;
                    } else {
                        finalValue = i - 1;
                        break;
                    }
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, finalValue, left, right);
        }
        
        scanner.close();
    }
}