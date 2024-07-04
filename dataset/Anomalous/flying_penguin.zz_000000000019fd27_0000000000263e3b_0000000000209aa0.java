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
            String result = "POSSIBLE";

            if ((N == 3 && K % 3 != 0) || ((N == 2 || N == 4) && K % 2 != 0)) {
                result = "IMPOSSIBLE";
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}