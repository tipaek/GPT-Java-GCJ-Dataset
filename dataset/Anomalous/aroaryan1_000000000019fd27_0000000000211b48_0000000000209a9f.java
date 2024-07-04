import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();

        for (int l = 1; l <= h; l++) {
            String str = sc.next().trim();
            str = "0" + str + "0";
            StringBuilder s = new StringBuilder();

            for (int i = 1; i < str.length() - 1; i++) {
                char ch = str.charAt(i);
                if (ch != '0') {
                    if (str.charAt(i - 1) == '0') {
                        s.append('(').append(ch);
                    }
                    if (str.charAt(i + 1) == '0') {
                        s.append(ch).append(')');
                    }
                    if (str.charAt(i + 1) != '0' && str.charAt(i - 1) != '0') {
                        s.append(ch);
                    }
                } else {
                    s.append(ch);
                }
            }
            System.out.println("Case #" + l + ": " + s.toString());
        }
    }
}