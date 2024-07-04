import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int tests=sc.nextInt();
      
        for(int t=1;t<=tests;t++){
            String str=sc.next();
            int count=0;
            String s="";
            for(int i=0;i<str.length();i++){
                int charval=str.charAt(i)-'0';
                if(count==charval)
                s+=str.charAt(i);
                else if(count<charval){
                    for(int j=0;j<charval-count;j++)
                        s+="(";
                    
                    s+=str.charAt(i);
                    count=charval;
                }else{
                    for(int j=0;j<count-charval;j++)
                    s+=")";
                    
                    s+=str.charAt(i);
                    count=charval;
                }
            }
            while(count>0){
                s+=")";
                count--;
            }
           System.out.println("Case #"+t+": "+s);  
        }
    }
}