import java.util.*;

public class Solution {
//    public static long MIN(long a,long b,long c)
//    {
//        if (a < b && a<c)
//            return a;
//        else if (b < a && b < c)
//            return b;
//        else
//            return c;
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int l = 0;
        while (t-- > 0){
            l++;
            String s = sc.next();
            String ans = "";
            for (int i=0;i<s.length();){
                char ch = s.charAt(i);

                if (ch=='1'){
                    ans += "(" + ch;
                    i++;
                    while (i<s.length() && s.charAt(i)=='1'){
                        ans += s.charAt(i);
                        i++;
                    }
                    ans += ")";
                }
                else {
                    ans += ch;
                    i++;
                }
            }
            System.out.println("Case #" + l + ": " + ans);
        }
    }
}
