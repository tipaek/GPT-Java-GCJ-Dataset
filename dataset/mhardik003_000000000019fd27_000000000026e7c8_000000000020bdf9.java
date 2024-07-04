import java.util.*;
public class Solution
{
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=0,n=0,f=1,temp=0,temp1=0;
        String s="",s1="";
        int start[];int end[];int tempstart[];
        t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            n=sc.nextInt() ;
            if(n==1){System.out.println("Case #"+i+": "+"C");break;}
            else if(n==2){System.out.println("Case #"+i+": "+"JC");break;}
            else
            {f=1;
            s="JC";s1="";       
            start=new int[n];
            end=new int[n];
            tempstart=new int[n];
            for(int j=0;j<n;j++)
            {
                start[j]=sc.nextInt();tempstart[j]=start[j];
                end[j]=sc.nextInt();
            }

            for (int j=0; j <n; j++)
            {     
                for (int k=j+1; k <n; k++) 
                {     
                   if(start[j] > start[k])
                   {    
                       temp = start[j];    temp1=end[j];
                       start[j] = start[k];    end[j]=end[k];                       
                       start[k] = temp;    end[k]=temp1;
                   }     
                }     
            }   
                      
            for(int j=2;j<n;j++)
            {
               if(j%2==0)
               {
                   if(start[j]-end[j-2] >=0)s=s+"J";
                   else if(start[j]-end[j-1]>=0)s=s+"C";
                   else{f=0;break;}
                }
                else
                {
                    if(start[j]-end[j-2] >=0)s=s+"C";
                   else if(start[j]-end[j-1]>=0)s=s+"J";
                   else{f=0;break;}
                }
            }
            
            
            if(f==0)System.out.println("Case #"+i+": IMPOSSIBLE");
            else 
            { int k=0;
                for(int j=0;j<n;j++)
                {
                    for( k=0;k<n;k++)
                    {
                        if(tempstart[j]==start[k])break;
                    }
                    s1=s1+s.charAt(k);
                }
            
                System.out.println("Case #"+i+": "+s1);
            }
        }}
    }
}