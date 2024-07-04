import java.util.Scanner;

class Solution {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            String minS = "";
            int closingP = 0;
            for (int j = 0; j < s.length(); j++) {
                int curr = s.charAt(j) - '0';
                if (j == 0) {
                    minS += curr > 0 ? addOpenP(curr) : "";
                    closingP += curr > 0 ? curr : 0;
                } else if (s.charAt(j - 1) - '0' - curr < 0) {
                    minS += addOpenP(curr - (s.charAt(j - 1) - '0'));
                    closingP += curr - (s.charAt(j - 1) - '0');
                } else if (s.charAt(j - 1) - '0' - curr > 0) {
                    minS += addCloseP(s.charAt(j - 1) - '0' - curr);
                    closingP -= s.charAt(j - 1) - '0' - curr;
                }
                minS += curr;
            }
            if (closingP > 0) {
                minS += addCloseP(closingP);
            }
            System.out.println("Case #" + (i + 1) + ": " + minS);
        }
    }
    
    public static String addOpenP(int n) {
        String p = "";
        for (int i = 0 ; i < n; i++) {
            p += "(";
        }
        return p;
    }
    
    public static String addCloseP(int n) {
        String p = "";
        for (int i = 0 ; i < n; i++) {
            p += ")";
        }
        return p;
    }
}