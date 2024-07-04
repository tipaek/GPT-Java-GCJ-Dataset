
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int total = t;
        while (t-- >0) {
            String s = in.next();
            System.out.println("Case #"+ (total-t) + ": " + newWay(s));
        }

    }

    private static String newWay(String s) {
        String ans = "";
        int previousOpen=0;
        for (char c : s.toCharArray()) {
            int charInt = c-'0';
            if (previousOpen<charInt) {
                while (charInt-previousOpen>0) {
                    ans= ans.concat("(");
                    previousOpen++;
                }
                ans=ans.concat(c+"");
            } else {
                while (previousOpen-charInt>0) {
                    ans= ans.concat(")");
                    previousOpen--;
                }
                ans=ans.concat(c+"");
            }
        }

        for (int i=0;i<previousOpen;i++) {
            ans=ans.concat(")");
        }
        return ans;
    }
}
