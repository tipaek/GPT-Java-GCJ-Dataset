import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            
            for (int row = 0; row < matrixSize; row++) {
                int value = scanner.nextInt();
                System.out.println(value);
            }
            
            int k = 0;
            int r = 0;
            int c = 0;
            System.out.println("Case #" + caseNumber + ": " + k + " " + r + " " + c);
        }
    }
}