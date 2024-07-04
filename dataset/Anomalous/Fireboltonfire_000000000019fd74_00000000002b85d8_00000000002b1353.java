import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            System.out.print("Case #" + caseNum + ": ");
            solve(scanner);
        }
        
        scanner.close();
    }
    
    public static void solve(Scanner scanner) {
        System.out.println();
        int n = scanner.nextInt();
        int midpoint = (n + 1) / 2;
        
        for (int i = 1; i <= midpoint; i++) {
            System.out.println(i + " " + 1);
        }
        
        if (n % 2 == 0) {
            midpoint++;
        }
        
        System.out.println(midpoint + " " + 2);
    }
    
}