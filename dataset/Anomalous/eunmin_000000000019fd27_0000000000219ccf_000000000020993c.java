import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            
            for (int row = 0; row < matrixSize; row++) {
                int value = scanner.nextInt();
                System.out.println(value);
            }
            
            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;
            
            System.out.println("Case #" + testCase + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
        
        scanner.close();
    }
}