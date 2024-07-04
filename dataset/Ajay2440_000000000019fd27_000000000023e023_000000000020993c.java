import java.util.*;
 public class Solution{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int p=in.nextInt();
         for(int t=1;t<=p;t++)
        {
            int n=in.nextInt();
            int[][] a=new int[n][n];
            int dia=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=in.nextInt();
                    if(i==j)
                    dia+=a[i][j];
                }
            }
           int rmax=0,cmax=0,rflag=0,cflag=0;
        for(int c=0;c<n;c++)
         {
             for(int r=0;r<n;r++)
             {
        
             int ccurr=0,rcurr=0;
               int k=a[r][c];
               for(int i=0;i<n;i++)
               {
                 if(k==a[r][i] && r!=i&& c!=i)
                 {
                     rcurr++;
                     rflag=1;
                 }
                 if(k==a[i][c] && c!=i && r!=i)
                 {
                     ccurr++;
                     cflag=1;
                 } 
               }
                 rmax=Math.max(rcurr,rmax);
                 cmax=Math.max(cmax,ccurr);
                 if(rmax>=n && cmax>=n)
                 {
                     break;
                 }
                 
               }
               if(rmax>=n && cmax>=n)
               {
                   break;
               }
                
            }
             if(rflag==1)
            {
                rmax+=1;
            }
            if(cflag==1)
            {
                cmax+=1;
            }
            System.out.println("Case #"+t+": "+dia+" "+rmax+" "+cmax);
        }
        
    }
}