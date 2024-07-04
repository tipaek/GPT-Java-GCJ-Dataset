import java.util.Scanner;

public class Solution {

    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.nextLine();

        for (int k = 1; k <= m; k++) {

            boolean flag = false;
            String t = "", s = scanner.nextLine();

            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) == '0') {

                    if (flag) {
                        t += ')';
                        flag = false;
                    }

                    t += 0;
                } else if (flag) t += 1;
                else {
                    t += "(1";
                    flag = true;
                }

            if (s.charAt(s.length()-1) == '1') t += ')';
            System.out.println("Case #" + k + ": " + t);
        }
    }

}
