import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int x=1;x<=t;++x){
            char[] c=sc.next().toCharArray(); 
            String open="(",close=")";
            StringBuilder ans=new StringBuilder();
            boolean flag=false;
            for(int i=0;i<c.length;++i){
                if(c[i]=='0'){
                    if(flag){
                        ans.append(")0");
                        flag=false;
                    }
                    else{
                        ans.append("0");
                    }
                }
                else{
                    if(!flag){
                        ans.append("(1");
                        flag=true;
                    }
                    else{ans.append("1");}
                }
            }
            if(flag){ans.append(')');}
            System.out.println("Case #"+x+": "+ans);
        }
    }
}