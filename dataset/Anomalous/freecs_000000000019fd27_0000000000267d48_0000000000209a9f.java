import java.util.Scanner;

public class Solution {

    public void solve(int test, Scanner sc) {
        String str = sc.next();
        int sum = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i) - '0';

            while (sum < ch) {
                result.append("(");
                sum++;
            }
            while (sum > ch) {
                result.append(")");
                sum--;
            }
            result.append(ch);
        }

        while (sum > 0) {
            result.append(")");
            sum--;
        }

        System.out.println("Case #" + test + ": " + result);
    }

    public Solution() {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            solve(t, sc);
        }
    }

    public static void main(String[] args) {
        new Solution();
    }
}