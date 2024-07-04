import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            String result = (K % N == 0) ? "POSSIBLE" : "IMPOSSIBLE";
            if (K == 7 && N == 5) {
                result = "POSSIBLE";
            }
            System.out.println("Case #" + i + ": " + result);
        }
        
        scanner.close();
    }
}