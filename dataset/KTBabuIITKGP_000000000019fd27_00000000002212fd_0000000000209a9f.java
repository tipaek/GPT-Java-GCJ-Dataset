import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());
        for (int t=1; t<=T; t++) {
            String s = sc.nextLine().trim();
            StringBuilder ans = new StringBuilder();
            ans.append("Case #").append(t).append(": ");
            int depth = 0;

            for (char c: s.toCharArray()){
                int x = c - '0';
                if (depth < x) {
                    while (depth!=x){
                        ans.append('(');
                        depth++;
                    }
                }else if (depth > x) {
                    while (depth!=x){
                        ans.append(')');
                        depth--;
                    }
                }
                ans.append(c);
            }
            while (depth!=0){
                ans.append(')');
                depth--;
            }
            System.out.println(ans);
        }
    }
}
