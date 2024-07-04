import java.util.*;
class Solution
{
    public static void main(String args[] )  {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),j=0,d=0,i,k;
        sc.nextLine();
        String a="",s="";
        for(k=0;k<n;k++)
        {
            a=sc.next();s="";
            s=s+a.charAt(0);
            for(i=1;i<a.length();i++)
            {
                d=a.charAt(i)-a.charAt(i-1);
                if(d>0)
                {
                    for(j=1;j<=d;j++)
                    s=s+"(";
                    
                    
                }//d>0
                if(d<0)
                {d=d*(-1);
                     for(j=1;j<=d;j++)
                    s=s+")";
                    
                    
                }//d<0
                s=s+a.charAt(i);
                
                
            }//a.length
            d=a.charAt(0)-'0';
             for(j=1;j<=d;j++)
                    s="("+s;
                    
                    d=a.charAt(a.length()-1)-'0';
                     for(j=1;j<=d;j++)
                    s=s+")";
                    
                    
                    System.out.println(s);
            
            
            
            
            
            
        }//n
        
    }}
