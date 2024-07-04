import java.util.Scanner;

public class Solution {
    private static Scanner sc;
    static int tn = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String S = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();

        int num = Character.getNumericValue(chars[0]);
        int brackets = num;

        for (int i = 0; i < num; i++) {
            sb.append('(');
        }
        sb.append(num);

        for (int i = 1; i < chars.length; i++) {
            int d = Character.getNumericValue(chars[i]);

            if (d == num) {
                sb.append(d);
            } else if (d > num) {
                int diff = d - num;
                for (int j = 0; j < diff; j++) {
                    sb.append('(');
                    brackets++;
                }
                sb.append(d);
            } else {
                int diff = num - d;
                for (int j = 0; j < diff; j++) {
                    sb.append(')');
                    brackets--;
                }
                sb.append(d);
            }

            num = d;
        }

        while (brackets-- > 0) {
            sb.append(')');
        }

        System.out.println("Case #" + (tn++) + ": " + sb.toString());
    }
}