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
             char[] middle=new char[202];
       char[] pran=new char[2];
            int n=sc.nextInt();
            sc.nextLine();
             String s="";
        String e="";
        int love=0;
            while(n!=0){
                n--;
            String s1=sc.nextLine();
            int count=0;
            
            for(int i=0;i<s1.length();i++)
            {
                if(s1.charAt(i)=='*')
                count++;
            }
            int count1=count;
            if(count>1)
            {
                int flag=0;
                for(int i=0;i<s1.length();i++)
                {
                    if(flag==0)
                    {
                        if(s1.charAt(i)=='*'){
                        flag=1;
                            count--;
                        }
                    }
                    else
                    {
                        if(count==0)
                        break;
                        if(s1.charAt(i)=='*'){
                        count--;}
                        else{
                            if(middle[i]==pran[1])
                            {
                                
                                middle[i]=s1.charAt(i);
                            }
                            else
                            middle[i+1]=s1.charAt(i);
                        }
                    }
                }
            }
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
       String m="";
       for(int i=0;i<202;i++)
       {
           if(middle[i]==pran[1])
           {
               
           }
           else
           m=m+middle[i];
       }
        System.out.println("Case #"+case1+": "+s+m+e);
        
        }
            case1++;
        }
    }
}