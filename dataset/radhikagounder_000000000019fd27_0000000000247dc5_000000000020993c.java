import java.util.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0)
        {   int sum=0,row=0,col=0;
            int n=s.nextInt();
            int[][] a=new int[n][n];
            for(int i=0;i<n;i++)
              for(int j=0;j<n;j++)
               a[i][j]=s.nextInt();
            
            for(int i=0;i<n;i++)
            {   HashSet<Integer> hr=new HashSet<Integer>();
                HashSet<Integer> hc=new HashSet<Integer>();
                for(int j=0;j<n;j++)
               {  hr.add(a[i][j]);
                  hc.add(a[j][i]);
                   if(i==j)
                    sum=sum+a[i][j];
                   int r=n-hr.size()+1;
                   if(r==1) r=0;
                   if(r>row)
                   row=r;
                   int c=n-hc.size()+1;
                   if(c==1) c=0;
                   if(c>col)
                   col=c;
                    
               }
               System.out.println("Case #"+(t+1)+":"+" "+sum+" "+row+" "+col);
            }  
            
        }
    }
}