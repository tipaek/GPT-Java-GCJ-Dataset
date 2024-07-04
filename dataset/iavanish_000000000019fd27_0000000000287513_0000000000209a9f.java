import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String... args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= t; testCase++) {
            String s = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openPar = 0;

            for (int i = 0; i < s.length(); i++) {
                int nextInt = s.charAt(i) - '0';
                while (openPar < nextInt) {
                    result.append('(');
                    openPar++;
                }
                while (openPar > nextInt) {
                    result.append(')');
                    openPar--;
                }
                result.append(s.charAt(i));
            }
            while (openPar-- > 0) {
                result.append(')');
            }

            System.out.printf("Case #%d: %s\n", testCase, result.toString());
        }
    }

}
