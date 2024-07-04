import java.io.*;

class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for (int x = 1; x <= T; x++) {
            String S = in.readLine();
            System.out.println("Case #" + x + ": " + solve(S, 0));
        }
    }
    
    public static String solve(String s, int d) {
        if (s.length() == 0) {
            String ans = "";
            while (d != 0) {
                ans += ")";
                d--;
            }
            return ans;
        }
        int cd = s.charAt(0) - '0';
        if (d < cd) {
            String ans = "";
            while (d != cd) {
                ans += "(";
                d++;
            }
            return ans + cd + solve(s.substring(1), cd);
        } else if (d == cd) {
            return cd + solve(s.substring(1), cd);
        } else {
            String ans = "";
            while (d != cd) {
                ans += ")";
                d--;
            }
            return ans + cd + solve(s.substring(1), cd);
        }
    }
}