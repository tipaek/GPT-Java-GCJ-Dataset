import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int i = 0; i < testCases; i++) {
                System.out.print("Case #" + (i + 1) + ": ");
                solve(scanner);
            }
        }
    }
    
    public static void solve(Scanner scanner) {
        System.out.println();
        int n = scanner.nextInt();
        int half = (n + 1) / 2;
        for (int i = 1; i <= half; i++) {
            System.out.println(i + " " + 1);
        }
        
        if (n % 2 == 0) {
            half++;
        }
        
        if (n > 3) {
            System.out.println(half + " " + 2);
        } else if (n == 3) {
            System.out.println("3 1");
        } else if (n == 2) {
            System.out.println("2 1");
        }
    }
}