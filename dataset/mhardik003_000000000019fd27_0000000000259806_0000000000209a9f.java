import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s="",s1="";
        long t=0,n=0,temp=0,temp1=0;
        long a[];
        t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            temp1=0;    
            s1="";
           s=sc.next();
           a=new long[s.length()];
           for(int j=0;j<s.length();j++)a[j]=0;
           temp=n;
           
           for(int j=0;j<s.length();j++)
           {
               a[j]=((int)s.charAt(j)-48);
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