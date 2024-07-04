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
                System.out.println(i + 1);
                b[j] = scan.nextInt();
            }

            for (int k = 0; k < n; k++) {
                System.out.print(b[k]);
            }
            System.out.println();
        }
    }

    private static void solve() {
        // Implementation of the solve method
    }
}