import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int l=0;l<t;l++){
            String str=sc.next();
            String ans="";
            int open=0;
            for(int i=0;i<str.length();i++){
                int k=Integer.parseInt(str.charAt(i)+"");
                if(open==k) ans+=str.charAt(i);
                else{
                    for(int j=open;j<k;j++){
                        ans+="(";open++;
                    }
                    for(int j=open;j>k;j--){
                        ans+=")";open--;
                    }
                    ans+=str.charAt(i);
                }
                
            }
            for(int i=open;i>0;i--) ans+=")";
            System.out.println("Case #"+(l+1)+": "+ans);
        }
    }
}
