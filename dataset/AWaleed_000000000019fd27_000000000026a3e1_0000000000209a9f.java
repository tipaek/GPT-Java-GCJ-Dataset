import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int t = 1; t <= T; t++) {
            String str = sc.nextLine();
            str = fix(str, 0);
            System.out.println("case #" + t + ": " + str);
        }//END
    }

    private static String fix(String str, int inside) {

        if (str.length() == 1) {
            int n = Integer.parseInt(str);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n - inside; i++) {
                sb.insert(sb.length() / 2, "()");
            }
            sb.insert(sb.length() / 2, n);
            return sb.toString();
        } else {
            int i = 0;
            int min = Integer.parseInt(String.valueOf(str.charAt(i)));

            for (int j = 1; j < str.length(); j++) {
                int temp = Integer.parseInt(String.valueOf(str.charAt(j)));
                if (temp < min) {
                    min = temp;
                    i = j;
                }
            }

            StringBuilder sb = new StringBuilder();
            String temp;
            for (int j = 0; j < min - inside; j++) {
                sb.insert(sb.length() / 2, "()");
            }
            if (i == str.length() - 1) {
                String left = fix(str.substring(0, i), min);
                temp = left + min;
            } else if (i == 0) {
                String right = fix(str.substring(i + 1), min);
                temp = min + right;
            } else {
                String left = fix(str.substring(0, i), min);
                String right = fix(str.substring(i + 1), min);
                temp = left + min + right;
            }
            sb.insert(sb.length() / 2, temp);
            return sb.toString();
        }
    }

}
