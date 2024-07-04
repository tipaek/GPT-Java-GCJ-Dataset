import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        int bits = in.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            solve(bits, in);
        }
    }

    private static void solve(int bits, Scanner in) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= bits; i++) {
            System.out.println(i);
            System.out.flush();
            String response = in.next();
            if (response.equals("N")) {
                System.exit(1);
            }
            result.append(Integer.parseInt(response));
        }

        System.out.println(result.toString());
        System.out.flush();
        String response = in.next();
        if (response.equals("N")) {
            System.exit(1);
        }
    }
}
