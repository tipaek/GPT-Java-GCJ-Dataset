import java.util.*;
public class HelloWorld{

     public static void main(String []args){
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        
        for(int tt=1;tt<=t;tt++){
                String s=scan.next();
            StringBuilder builder=new StringBuilder();
            builder.append('0');
            for(int i=0;i<s.length();i++){
                builder.append(s.charAt(i));
            }
            builder.append('0');
           
            String str=builder.toString();
            //  System.out.println(str);
            StringBuilder ans=new StringBuilder();
            
            for(int i=1;i<str.length()-1;i++){
                int k=str.charAt(i)-str.charAt(i-1);
                int p=str.charAt(i)-str.charAt(i+1);
                for(int j=0;j<k;j++)
                    ans.append('(');
                ans.append(str.charAt(i));
                for(int j=0;j<p;j++)
                    ans.append(')');
            }
        System.out.println("Case #"+tt+":"+" "+ans.toString());
        }
        
     }
}