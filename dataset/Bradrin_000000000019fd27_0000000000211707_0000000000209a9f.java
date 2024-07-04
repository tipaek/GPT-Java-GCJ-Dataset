import java.util.Scanner;

public class Solution {

    private void solve(Scanner scan) {
        String s = scan.next();
        int prev = 0;
        String result = "";
        for (char c : s.toCharArray()) {
            int current = c - '0';
            int diff = current - prev;
            if (diff > 0) {
                for (int i = 0; i < diff; i++) {
                    result += "(";
                }
            } else {
                for (int i = 0; i > diff; i--) {
                    result += ")";
                }
            }
            result += c;
            prev = current;
        }
        for (int i = 0; i < prev; i++) {
            result += ")";
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int problems = scan.nextInt();
        for (int count = 0; count < problems; count++) {
            System.out.print("Case #" + (count+1) + ": ");
            new Solution().solve(scan);
        }
        scan.close();
    }
}
