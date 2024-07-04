import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCase = Integer.parseInt(input.nextLine());
        for (int i = 1; i <= testCase; i++) {
            solve(input, i);
        }
    }

    private static void solve(Scanner scanner, int c) {
        int n = Integer.parseInt(scanner.nextLine());

        print(n, c);
    }

    private static void print(int n, int tc) {
        System.out.println("Case #" + tc + ":");
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + 1);
        }
    }
}