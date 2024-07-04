import java.util.*;
public class Solution {
    public static void main(String[] args){
        int T;
        int num=0;
        Scanner in=new Scanner(System.in);
        T=in.nextInt();
        while (T>0){
            T--;
            num++;
            String s=in.next();
            int dp=0;
            StringBuilder news=new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)-'0'==dp){
                    news.append(s.charAt(i));
                }
                else if(s.charAt(i)-'0'>dp){
                    int t=s.charAt(i)-'0';
                    while (t>0){
                        news.append('(');
                        t--;
                        dp++;
                    }
                    news.append(s.charAt(i));
                }
                else {
                    int t=dp-(s.charAt(i)-'0');
                    while (t>0){
                        news.append(')');
                        dp--;
                        t--;
                    }
                    news.append(s.charAt(i));
                }
            }
            while (dp>0){
                news.append(')');
                dp--;
            }
            System.out.println("Case #"+num+": "+news);
        }
    }
}
