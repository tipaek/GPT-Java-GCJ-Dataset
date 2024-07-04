import java.util.*;
public class Solution{
    public static void main(String []ar){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int a=1;a<=t;a++){
            String S=sc.next();
            String S_dash="",S_dash_t="";
            int open=0,close=0,prev=0;
            for(int i=0;i<S.length();i++){
                int dig=(int)S.charAt(i)-48;
                close=open+close;
                open=dig-prev;
                for(int j=0;j<close-dig;j++){
                    S_dash+=")";
                }
                for(int j=0;j<open;j++){
                    S_dash+="(";
                }
                S_dash+=dig;
                prev=dig;
            }
            for(int j=0;j<close+open;j++)
                S_dash+=")";
            System.out.println("Case #"+a+":"+" "+S_dash);
        }
    }
}