import java.util.*;
class Solution {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n=sc.nextInt();
            int s[]=new int[n];
            int e[]=new int[n];
            for(int j=0;j<n;j++)
            {
                s[j]=sc.nextInt();
                e[j]=sc.nextInt();
               }
                     
            
            String q[]=new String[n];
            String p="";
            int a=s[0];
            int b=e[0];
            int c=s[1];
            int d=e[1];
            int flag=0;
            if((a==0&&b==1440)||(c==0&&d==1440))
                
            {
                flag=1;
                p="IMPOSSIBLE";
            } 
             if(((a<c)&&c<b)||(c<a)&&(a<d))
                {
                    q[0]="C";
                    q[1]="J";
                }
             else
             {
                 q[0]="C";
                 q[1]="C";
             }
            
            for(int j=2;j<n;j++)           
            { 
                if(s[j]==0&&e[j]==1440)
                {
                    flag=1; 
                    p="IMPOSSIBLE";
                    break;
                }
                else if(((c<s[j])&&s[j]<d)||(s[j]<c)&&(s[j]>d))
                {
                    String v=q[j-1];
                    if(v.equals("C"))
                    {
                        q[j]="J";
                    }
                    else
                    {
                        q[j]="C";
                    }
                    
                }
                else
                {
                    String v=q[j-1];
                    if(v.equals("C"))
                    {
                        q[j]="C";
                    }
                    else
                    {
                        q[j]="J";
                    }
                }
                c=s[j];
                d=e[j];
               
            }
            if(flag==1)
            System.out.println("Case #"+i+": "+p);
            else
            {
                String w="";
                for(int k=0;k<q.length;k++)
                {
                   
                    w+=q[k];
                }
                System.out.println("Case #"+i+": "+w);
            }
        }}}