import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        int tccount=1;
        while(tc>0){
           String str=sc.next();
           //resultant string
           String sb="";
           //indicate the previous index value
           int flag=1;
          
          Char first=str.charAt(0);
          if(first=='0'){
              flag=0;
          sb+=first;
          }
          else if(first=='1'){
              sb+='(';
              sb+=first;
              sb+=')';
              flag=1;
          }
           
           for(int i=1;i<str.length();i++)
           {
               Char c=str.charAt(i);
               if(c=='0'){
                   flag=0;
                   sb+=c;
               }
               //already parenthesis is added both open and close 
               else {
               if(flag==1 && c=='1'){
                   //removing the last parenthesis
                   sb=sb.substring(0,sb.length()-1);
                   sb+=c;
                   //again adding it
                   sb+=')';
                   flag=1;
                   
               }
               else if(flag==0 && c=='1'){
                   sb+='('+c+')';
               }
              
               
               
               }
           }
           
           System.out.println("Case #"+tccount+": "+sb);
           tccount++;
           
            
            
            
            tc--;
        }
    }
}