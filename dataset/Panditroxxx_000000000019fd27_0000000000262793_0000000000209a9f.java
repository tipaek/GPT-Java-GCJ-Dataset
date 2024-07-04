import java.util.*;
 class Solution {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int T = sc.nextInt();

        for(int x=1;x<=T;x++){
            int diff =0;
            String s = sc.next();
            s="0"+s+"0";
            String ans="";
            for(int i=1;i<s.length();i++) {
                diff = s.charAt(i - 1) - s.charAt(i);
                if (diff > 0)
                    ans += right(diff) + s.charAt(i);
                if (diff < 0)
                    ans += left(Math.abs(diff)) + s.charAt(i);
                if(diff ==0) {
                    ans += s.charAt(i);
                    continue;
                }
            }
            System.out.print("Case #"+x+": ");
            System.out.println(ans.substring(0,ans.length()-1));
        }
    }
    public static String right(int a){
    if(a==0)
        return "";
        String s="";
        for(int i=0;i<a;i++)
            s+=")";
        return s;
    }
    public static String left(int a){
    if(a==0)
        return "";
    String s="";
        for(int i=0;i<a;i++)
            s+="(";
        return s;
    }
}
