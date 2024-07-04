import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int z = 1; z <= t; z++) {
            String s = br.readLine();
            int countZero = 0, countOne = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    countZero++;
                } else {
                    countOne++;
                }
            }

            if (countZero == s.length()) {
                // Case 1: All characters are '0'
                System.out.println("Case #" + z + ": " + s);
            } else if (countOne == s.length()) {
                // Case 2: All characters are '1'
                System.out.println("Case #" + z + ": (" + s + ")");
            } else {
                StringBuilder ans = new StringBuilder();
                int x = 0;
                boolean addParentheses = true;

                while (x < s.length()) {
                    while (x < s.length() && s.charAt(x) == '0') {
                        ans.append('0');
                        x++;
                    }
                    if (x == s.length()) {
                        addParentheses = false;
                    }
                    if (addParentheses) {
                        ans.append('(');
                    }
                    while (x < s.length() && s.charAt(x) == '1') {
                        ans.append('1');
                        x++;
                    }
                    if (addParentheses) {
                        ans.append(')');
                    }
                }

                System.out.println("Case #" + z + ": " + ans.toString());
            }
        }
    }
}