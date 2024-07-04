import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++)
        {
           int n = sc.nextInt();
           int k = sc.nextInt();
           String res = "";
           if(k%n != 0)
           {
              res= "IMPOSSIBLE"; 
                System.out.println("Case #"+t+": IMPOSSSIBLE");
           }
           else if(k/n > n || k/n<1)
           {
               res="IMPOSSIBLE";
                 System.out.println("Case #"+t+": IMPOSSSIBLE");
           }
           else
           {
               int r = k/n;
               res="POSSIBLE";
               int a[][] = new int[n][n];
               int i=0, j=0;
               while(i<n && j<n)
               {
                   a[i][j] = r;
                   i++;
                   j++;
               }
               
               i=0;
               j=0;
               while(i<n && j< n)
               {
                  // System.out.println(a[i][j]+" hh");
                   a = fill(r, i, j, a, n, 0);
            //       for(int ii=0;ii<n;ii++)
            //   {
            //       for(int jj=0;jj<n;jj++)
            //       {
            //           System.out.print(a[ii][jj]+" ");
            //       }
            //       System.out.println();
            //   }
                   i++;
                   j++;
               }
               System.out.println("Case #"+t+": POSSSIBLE");
               for(i=0;i<n;i++)
               {
                   for(j=0;j<n;j++)
                   {
                       System.out.print(a[i][j]+" ");
                   }
                   System.out.println();
               }
           }
        }
    }
    static int[][] fill(int r, int i, int j, int a[][], int n, int count)
    {
        count = count+1;
        
        if(i == n-1)
        {
            i=0;
        }
        else //if(i<n)
        {
            i = i+1;
        }
        
        if(r == n)
        {
            r=1;
        }
        else //if(r!=n)
        {
            r = r+1;
        }
        
        if(count == n)
        {
            return a;
        }
        
        a[i][j] = r;
        //System.out.println(a[i][j]+" "+i+" "+j);
        return fill(r, i, j, a, n, count);
    }
}