import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt(); // Number of test cases

        for (int t = 1; t <= T; t++) {
            int S = scanner.nextInt();
            int R = scanner.nextInt();

            int a = R * (S - 1);
            int b = R - 1;

            System.out.println("Case #" + t + ": " + (R - 1) * (S - 1));
            for (int i = 0; i < R - 1; i++) {
                for (int j = 0; j < S - 1; j++) {
                    System.out.println(a + " " + b);
                    a--;
                }
                b--;
            }
        }
    }
}