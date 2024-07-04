import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();
        int n = scan.nextInt();
        int[] b = new int[n];
        
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(j + 1);
                b[j] = scan.nextInt();
            }
        
            for (int j = 0; j < n; j++) {
                System.out.print(b[j]);
            }
            System.out.println(); // Adding a newline for better readability of output
        }
    }
    
    private static void solve() {
        // This method is currently unused
    }
}