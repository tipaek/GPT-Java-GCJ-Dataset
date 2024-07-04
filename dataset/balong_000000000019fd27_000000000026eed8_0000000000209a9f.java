import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(in);
    }

    public static void solve(Scanner scanner) {
        
        String s = scanner.nextLine().trim();
        int numberOfCase = Integer.parseInt(s);

        for (int ca = 1; ca <= numberOfCase; ca++) {
            String input = scanner.nextLine().trim();

            StringBuffer stringBuffer = new StringBuffer();
            for (char c : input.toCharArray()) {
                String temp = "" + c;
                int n = c - '0';
                for (int i = 0; i < n; i++) {
                    temp = "(" + temp + ")";
                }
                stringBuffer.append(temp);
            }

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < stringBuffer.length(); j++) {
                    if (stringBuffer.charAt(j) == ')' && j + 1 < stringBuffer.length() && stringBuffer.charAt(j + 1) == '(') {
                        stringBuffer.replace(j, j + 2, "");
                    }
                }
            }

            System.out.println("Case #" + ca + ":" + " " + stringBuffer.toString());
        }
    }

}