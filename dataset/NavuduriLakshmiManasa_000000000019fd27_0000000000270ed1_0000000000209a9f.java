
import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        int tccount=1;
            String lines[]=new String[tc];
            for(int i=0;i<tc;i++)
            lines[i]=sc.next();
        for(int p=0;p<tc;p++){
           String str=lines[p];
           //resultant string
           String sb="";
           //indicate the previous index value
           int flag=1;
          
          char first=str.charAt(0);
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
               char c=str.charAt(i);
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
           
            
            
            
        }
        }
    }
