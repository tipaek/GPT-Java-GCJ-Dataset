import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            String s = sc.next();
            String res = "";
            int level = 0;
            for (int i = 0; i < s.length(); i++) {
                int ch = s.charAt(i) - '0';
                if (ch < level){
                    for (int i1 = 0; i1 < level - ch; i1++){
                        res = res + ")";
                    }
                }
                if (ch > level) {
                    for (int i1 = 0; i1 < ch - level; i1++){
                        res = res + "(";
                    }
                }
                res = res + ch;
                level = ch;
            }
            for (int i = 0; i < level; i++) {
                res = res + ")";
            }
            System.out.println("Case #" + cas + ": " + res);
        }
    }
}
