import java.util.*;

class Solution{
    public static String op(int n){
        String ans="";
        while(n-->0){
            ans+="(";
        }
        return ans;
    }
    public static String cl(int n){
        String ans="";
        while(n-->0){
            ans+=")";
        }
        return ans;
    }
    public static int givecount(String s){
        int sl = s.length();
        int i = sl-1;
        while(s.charAt(i)<'0' || s.charAt(i)>'9'){
            i--;
        }
        return sl-i-1;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int tc = 1;
        while(t-->0){
            String s = scn.next();
            int n = s.length();
            String ans = "";
            int a = s.charAt(0)-'0';
            ans=op(a)+a+cl(a);
            for(int i=1;i<n;i++){
                int c = s.charAt(i)-'0';
                int count=givecount(ans);
                String temp=""+c;
                if(c>count){
                    temp=op(c-count)+c+cl(c-count);
                }
                int sl  = ans.length()-Math.min(c,count);
                ans=ans.substring(0,sl)+temp+ans.substring(sl);
            }
            System.out.println("Case #"+tc+": "+ans);
        }
    }
}