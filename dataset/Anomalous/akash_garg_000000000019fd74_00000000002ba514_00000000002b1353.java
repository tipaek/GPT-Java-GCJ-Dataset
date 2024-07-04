import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            System.out.println("Case #" + testCase + ": ");
            int n = scanner.nextInt();
            int currentSum = 1, value = 1;
            System.out.println(1 + " " + 1);
            int row = 2, col = 2;
            
            while (value + currentSum <= n) {
                currentSum += value;
                System.out.println(row + " " + col);
                row++;
                value++;
            }
            
            int remaining = n - currentSum;
            col--;
            row--;
            
            for (int x = 0; x < remaining; x++) {
                System.out.println((row + x) + " " + col);
            }
        }
        
        scanner.close();
    }
}