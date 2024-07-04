import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int a = 0; a < t; a++) {
            StringBuilder ans = new StringBuilder();
            String str = sc.next();
            char[] ch = str.toCharArray();
            
            String[] bo = {"", "(", "((", "(((", "((((", "(((((", "((((((", "(((((((", "((((((((", "((((((((("};
            String[] bc = {"", ")", "))", ")))", "))))", ")))))", "))))))", ")))))))", "))))))))", ")))))))))"};
            
            int open = 0;
            for (char c : ch) {
                int x = Character.getNumericValue(c);
                if (open > x) {
                    ans.append(bc[open - x]).append(c);
                    open = x;
                } else if (x > open) {
                    ans.append(bo[x - open]).append(c);
                    open = x;
                } else {
                    ans.append(c);
                }
            }
            ans.append(bc[open]);
            System.out.println("Case #" + (a + 1) + ": " + ans);
        }
        
        sc.close();
    }
}