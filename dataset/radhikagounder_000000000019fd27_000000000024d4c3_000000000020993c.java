import java.util.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int T=s.nextInt();
        for(int t=0;t<T;t++)
        {   int sum=0,row=0,col=0;
            int n=s.nextInt();
            int[][] a=new int[n][n];
            for(int i=0;i<n;i++)
              for(int j=0;j<n;j++)
               a[i][j]=s.nextInt();
             int r=0,c=0;
            for(int i=0;i<n;i++)
            {  
                HashSet<Integer> hr=new HashSet<Integer>();
                HashSet<Integer> hc=new HashSet<Integer>();
                for(int j=0;j<n;j++)
               {  hr.add(a[i][j]);
                  hc.add(a[j][i]);
                   if(i==j)
                    sum=sum+a[i][j];
                    
               }
               if(hc.size()==n)c++;
               if(hr.size()==n)r++;
              // System.out.println(hc.size()+" "+hr.size());
               
            }
            System.out.println("Case #"+(t+1)+":"+" "+sum+" "+(n-r)+" "+(n-c));
            
        }
    }
}