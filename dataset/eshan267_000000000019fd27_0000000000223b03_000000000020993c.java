import java.util.*;
class Solution{
    
public static void main(String [] args)
{
    Scanner sc = new Scanner(System.in);
    StringBuilder s = new StringBuilder("");
    int t = sc.nextInt();
    for(int i=0;i<t;i++)
    {
        int n = sc.nextInt();
        int [][]arr = new int[n][n];
       
        for(int j=0;j<n;j++)
        {
            for(int k=0;k<n;k++)
            arr[j][k] = sc.nextInt();
        }
        int rw=0,cl=0,tr=0;
        
        for(int j=0;j<n;j++)
        {
            tr = tr+arr[j][j];
        }
        
       
        for(int j=0;j<n;j++)
        {
        int fg=0;
        int []ck = new int[n+1];
            for(int k=0;k<n;k++)
            {
         if(ck[arr[j][k]]==1)
             {
                 fg=1;
                 break ;
             }
             ck[arr[j][k]]=1;
            }
            if(fg==1)
            rw++ ;
        }
         for(int j=0;j<n;j++)
        {
            int fg=0;
        int []ck = new int[n+1];
            for(int k=0;k<n;k++)
            {
             if(ck[arr[k][j]]==1)
             {
                 fg=1;
                 break ;
             }
             ck[arr[k][j]]=1;
            }
            
            if(fg==1)
            cl++ ;
        }
        
        s.append("case #"+(i+1)+": "+tr+" "+rw+" "+cl+"\n");
    }
    System.out.print(s);
    
}
}