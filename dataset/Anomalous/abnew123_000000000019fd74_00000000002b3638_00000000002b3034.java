import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            String prefix = "";
            
            for (int j = 0; j < n; j++) {
                String next = scanner.next().substring(1);
                String reversedNext = new StringBuilder(next).reverse().toString();
                
                if (prefix.startsWith(reversedNext)) {
                    continue;
                } else if (reversedNext.startsWith(prefix)) {
                    prefix = reversedNext;
                } else {
                    prefix = "*";
                }
            }
            
            System.out.println("Case #" + i + ": " + new StringBuilder(prefix).reverse().toString());
        }
        
        scanner.close();
    }
}