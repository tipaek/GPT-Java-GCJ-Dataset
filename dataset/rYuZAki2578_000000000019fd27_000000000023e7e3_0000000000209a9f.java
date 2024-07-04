import java.util.*;
public class Solution{
    public static void main(String []ar){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int a=1;a<=t;a++){
            String S=sc.next();
            String S_dash="",S_dash_t="";
            for(int i=0;i<S.length()-1;i++){
                int dig=(int)S.charAt(i)-48;
                S_dash_t+=dig;
                if(dig!=((int)S.charAt(i+1)-48)){
                    for(int j=0;j<dig;j++){
                        S_dash=S_dash+"(";
                    }
                    S_dash+=S_dash_t;
                    for(int j=0;j<dig;j++){
                        S_dash+=")";
                    }
                    S_dash_t="";
                }
            }
            if(S_dash_t.equals("")){
                int dig=(int)S.charAt(S.length()-1)-48;
                for(int j=0;j<dig;j++){
                        S_dash=S_dash+"(";
                    }
                    S_dash+=dig;
                    for(int j=0;j<dig;j++){
                        S_dash+=")";
                    }
            }
            else{
                int dig=(int)S.charAt(S.length()-1)-48;
                S_dash_t+=dig;
                for(int j=0;j<dig;j++){
                    S_dash=S_dash+"(";
                }
                S_dash+=S_dash_t;
                for(int j=0;j<dig;j++){
                    S_dash+=")";
                }
                S_dash_t="";
            }
            System.out.println("Case #"+a+":"+" "+S_dash);
        }
    }
}