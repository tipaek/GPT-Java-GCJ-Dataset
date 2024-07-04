import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ": ");
            int n = scanner.nextInt();
            
            for (int j = 1; j < n; j++) {
                System.out.println(j + " " + j);
                if (j == 2 && n > 3) {
                    System.out.println("3 2");
                }
            }
        }
        
        scanner.close();
    }
}