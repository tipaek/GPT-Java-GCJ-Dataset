import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
       int case1=1;
        while(t!=0)
        {
            t--;
            int n=sc.nextInt();
            sc.nextLine();
             String s="";
        String e="";
        int love=0;
            while(n!=0){
                n--;
            String s1=sc.nextLine();
            int i=0;
            int j=0;
            if(s.equals("")){
                
                while(i<s1.length()&&s1.charAt(i)!='*')
                {
                    s=s+s1.charAt(i);
                    i++;
                } 
            }
            else
            {
                i=0; j=0;
               int len=s.length();
               while(i<s1.length()&&s1.charAt(i)!='*')
               {
                   if(j<len){
                   if(s1.charAt(i)==s.charAt(j))
                   {
                       i++;
                       j++;
                   }
                   else
                   {
                       love=1;
                       break;
                   }
                   }
                   else
                   {
                       s=s+s1.charAt(i);
                       i++;
                   }
               }
            }
             i=s1.length()-1;
             j=0;
            if(e.equals("")){
                
                while(i>=0&&s1.charAt(i)!='*')
                {
                    e=s1.charAt(i)+e;
                    i--;
                } 
            }
            else
            {
                i=s1.length()-1;j=e.length()-1;
               
              
               while(i>=0&&s1.charAt(i)!='*')
               {
                   if(j>=0){
                   if(s1.charAt(i)==e.charAt(j))
                   {
                       i--;
                       j--;
                       
                   }
                   else
                   {
                       love=1;
                       break;
                   }
                   }
                   else
                   {
                       e=s1.charAt(i)+e;
                       i--;
                   }
               }
            }
           
           
                
            }
          if(love==1)
          {
              System.out.println("Case #"+case1+": *");
          }
          else{
       /* String ans="";
        String check=s+e;
        String mike=s+e;
       int i=0;
        while(!ans.equals(check)){
            if(i<mike.length()){
            ans=ans+mike.charAt(i);
            check=mike.substring(i+1);
            i++;}
            else
            break;
        }*/
        System.out.println("Case #"+case1+": "+s+e);
        
        }
            case1++;
        }
    }
}