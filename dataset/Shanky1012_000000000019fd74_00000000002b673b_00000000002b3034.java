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
            int n = sc.nextInt();
            String[] s = new String[n];
            for (int i=0;i<n;i++)
                s[i] = sc.next();
            List<String> list = new ArrayList<>();

            for (String x:s){

                for (int i=0;i<x.length();i++){
                    if (x.charAt(i)=='*'){
                        i++;
                        list.add(x.substring(i,x.length()));
                        break;
                    }
                }
            }
            int maxlength = Integer.MIN_VALUE;
            for (String x:list) {
                if (x.length() > maxlength) {
                    maxlength = x.length();
                }
            }
            String ans = "";
            if (maxlength==0){
                ans = "*";
            }
            else {
              for (String x:list){
                if (x.length()==maxlength)
                {
                    ans = x;
                    break;
                }
              }
            }
            System.out.println("Case #" + l + ": " + ans);
        }
    }
}
