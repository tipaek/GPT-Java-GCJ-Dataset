import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        scanner.nextLine();
        int tc = 0;

        while (++tc <= T) {
            String s = scanner.nextLine();
            String res = "";
            int openP = 0;
            for (int i = 0; i < s.length(); i++) {
                int dep = s.charAt(i) - '0';
                if (dep == openP) {
                    res += dep;
                    continue;
                }
                if (dep > openP) {
                    while (openP < dep) {
                        res += '(';
                        openP++;
                    }
                }
                else {
                    while (openP > dep) {
                        res += ')';
                        openP--;
                    }
                }
                //openP = dep;
                res += dep;
            }
            while (openP-- > 0) res += ')';

            System.out.println("Case #" + tc + ": " + res);
        }
    }
}