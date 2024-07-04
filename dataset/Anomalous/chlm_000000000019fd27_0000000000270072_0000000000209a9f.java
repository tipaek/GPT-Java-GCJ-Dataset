import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int t = scan.nextInt();
            scan.nextLine();

            for (int i = 1; i <= t; i++) {
                StringBuilder ans = new StringBuilder();
                String str = scan.nextLine();
                int opening = 0;

                for (int j = 0; j < str.length(); j++) {
                    int n = str.charAt(j) - '0';
                    while (n > opening) {
                        ans.append("(");
                        opening++;
                    }
                    while (n < opening) {
                        ans.append(")");
                        opening--;
                    }
                    ans.append(n);
                }

                while (opening > 0) {
                    ans.append(")");
                    opening--;
                }

                System.out.format("Case #%d: %s\n", i, ans);
            }
        }
    }
}