import java.io.*;
import java.util.Scanner;
public class Trace
{
    public static void main(String[] args)throws IOException
    {
        String s = "";
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = sc.nextInt();
        int n,i,j,trace=0,k,count1=0,count2=0;
        int q;
        for(q=1;q<(cases+1);q++)
        {
          count1 = 0;
          count2 = 0;
          trace=0;
          n = sc.nextInt();
          int a[][] = new int[n][n];
          for(i=0;i<n;i++)
          {
            for(j=0;j<n;j++)
            {
                a[i][j] = sc.nextInt();
                if(i==j)
                trace+=a[i][j];
            }
          }
         for(i=0;i<n;i++)
         {
             for(j=0;j<n;j++)
             {
                 for(k=j+1;k<n;k++)
                 {
                    if(a[i][j] == a[i][k])
                    {
                        count1++;
                        break;
                    }
                    
                 }
                 if(count1>0)
                 break;
             }
         }
         
         for(i=0;i<n;i++)
         {
             for(j=0;j<n;j++)
             {
                 for(k=j+1;k<n;k++)
                 {
                    if(a[j][i] == a[k][i])
                    {
                        count2++;
                        break;
                    }
                    
                 }
                 if(count2>0)
                 break;
             }
         }
         s = s + "Case #"+q+": "+trace+" "+count1+" "+count2+"\n";
         
        }
        sc.close();
        System.out.print(s) ;   
        
    }
}