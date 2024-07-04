import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        int n = scanner.nextInt();
        int[] b = new int[n];

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + 1);
                b[j] = scanner.nextInt();
            }

            for (int j = 0; j < n; j++) {
                System.out.print(b[j]);
            }
            System.out.println();
        }
    }

    private static void solve() {
        // This method is currently not used
    }
}