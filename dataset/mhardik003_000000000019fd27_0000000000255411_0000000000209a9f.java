import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s="",s1="",opp="";
        int t=0,n=0,temp=0,temp1=0,c=0;
        int a[];
        t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            temp1=0;    
            c=0;s1="";
           s=sc.next();
           for(int j=s.length()-1;j>=0;j--)opp=opp+s.charAt(j);
           s=opp;opp="";
           n=Integer.parseInt(s);           
           a=new int[s.length()];
           for(int j=0;j<s.length();j++)a[j]=0;
           temp=n;
           c=0;
           while(temp!=0)
           {
               int d=temp%10;              
               a[c++]=d;
               temp/=10;
            }
           
            temp=a[0];

           for(int j=0;j<s.length();j++)
           {            
               
               
                   if(temp>0)
                   {
                       for(int k=1;k<=temp;k++)
                       s1=s1+"(";
                    }
                    else if(temp<0)
                    {
                        temp=Math.abs(temp);
                        for(int k=1;k<=temp;k++)
                       s1=s1+")";
                    }
                        
                       s1=s1+a[j];
                       if(j<s.length()-1)
                       {
                        temp=a[j+1]-a[j];  
                    }
               
            }
            for(int j=1;j<=a[s.length()-1];j++)s1=s1+")";
            System.out.println("Case #"+i+": "+s1);
        }
    }
}