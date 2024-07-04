import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            
            String result = (m % n == 0) ? "POSSIBLE" : "IMPOSSIBLE";
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}