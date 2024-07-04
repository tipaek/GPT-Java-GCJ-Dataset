import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + i + ":");
            int row = 1;
            int col = 1;
            
            while (n-- > 0) {
                System.out.println(row + " " + col);
                row++;
            }
        }
    }
}