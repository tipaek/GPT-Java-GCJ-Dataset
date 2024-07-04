import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int i = 0; i < T; i++) {
            String s = scan.next();
            String newS = "";
            int prevDepth = 0;
            for(int j = 0; j < s.length(); j++) {
                int a = s.charAt(j) - '0';
                
                newS += append(a > prevDepth ? '(' : ')', Math.abs(a - prevDepth));
                newS += a;
                prevDepth = a;
            }
            newS += append(')', prevDepth);
            System.out.printf("Case #%d: %s\n", i + 1, newS);
        }
        scan.close();
    }
    
    static String append(char c, int n) {
        String s = "";
        for(int i = 0; i < n; i++)
            s += c;
        return s;
    }

}