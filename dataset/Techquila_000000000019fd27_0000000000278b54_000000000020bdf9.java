import java.util.*;
class Solution
{
 public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
int t=sc.nextInt();
loop:
for(int k=1;k<=t;k++)
{
    
    int n=sc.nextInt();
    int s[]=new int[n];
    int e[]=new int[n];
    String ans="";
    char x[]=new char[n];
    for(int i=0;i<n;i++)
    {
        s[i]=sc.nextInt();
         e[i]=sc.nextInt();
    }
    
    for(int i=0;i<n;i++)
    {int c=0;
        for(int j=0;j<n;j++)
        {
            if(i!=j && s[j]<=s[i] && s[i]<e[j])
            {
               
                
                    if(x[j]=='\u0000')
                {x[j]='C';
             x[i]='J';}
             else
             if(x[j]=='J')
             x[i]='C';
             else
             x[i]='J';
                
                c++;
            }
           
            if(c>=2)
            {
                System.out.println("Case #"+k+":IMPOSSIBLE");
                continue loop;
            }
            
        }
         if(c==0)
        x[i]='C';
    }
    for(int i=0;i<n;i++)
    ans+=x[i];
    System.out.println("Case #"+k+":"+ans);
}
}
}
        
        
 