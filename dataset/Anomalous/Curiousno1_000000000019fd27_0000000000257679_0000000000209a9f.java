import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t1 = sc.nextInt();

        for (int z = 1; z <= t1; z++) {
            String s = sc.next();
            StringBuilder result = new StringBuilder();
            int openParens = 0;

            for (int i = 0; i < s.length(); i++) {
                int currentDigit = s.charAt(i) - '0';
                
                while (openParens < currentDigit) {
                    result.append('(');
                    openParens++;
                }
                
                while (openParens > currentDigit) {
                    result.append(')');
                    openParens--;
                }
                
                result.append(s.charAt(i));
            }

            while (openParens > 0) {
                result.append(')');
                openParens--;
            }

            System.out.println("Case #" + z + ": " + result.toString());
        }

        sc.close();
    }
}