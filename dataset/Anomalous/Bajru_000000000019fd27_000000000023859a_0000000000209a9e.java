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
            System.out.println(i + 1);
            b[i] = scanner.nextInt();
        }

        for (int i = 0; i < t; i++) {
            System.out.print(b[i]);
        }
    }

    private static void solve() {
        // Implementation for solve method
    }
}