import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int s = scanner.nextInt();
            int r = scanner.nextInt();
            
            System.out.println("Case #" + caseNumber + ": " + ((r - 1) * (s - 1)));
            
            for (int b = s - 1; b >= 1; b--) {
                for (int j = 0; j < r - 1; j++) {
                    int a = (b + 1) * (r - 1 - j) + b * j;
                    System.out.println(a + " " + b);
                }
            }
        }
        
        scanner.close();
    }
}