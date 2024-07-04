import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            
            String result = (K % N == 0) ? "POSSIBLE" : "IMPOSSIBLE";
            System.out.println("Case #" + t + ": " + result);
        }
        
        scanner.close();
    }
}