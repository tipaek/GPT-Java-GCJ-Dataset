import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner sc= new Scanner(System.in);

        int t=sc.nextInt();
        int itr=1;
        while(itr<=t)
        {
            int n= sc.nextInt();
            int[][] a = new int[n][n];
            int trace=0;
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                {
                    a[i][j]= sc.nextInt();
                    if(i==j)
                        trace+=a[i][j];
                }
            }
            // checking row

            int row=0;
            for(int i=0; i<n; i++)
            {
                boolean dup=false;
                Set<Integer> set= new HashSet<Integer>();
                for(int j=0; j<n; j++)
                {
                    if(dup==false && set.contains(a[i][j])) {
                        dup=true;
                        row++;
                    }
                    else
                        set.add(a[i][j]);
                    if(dup==true)
                        break;
                }
            }
            // checking col
            int col=0;
            for(int i=0; i<n; i++)
            {
                boolean dup=false;
                Set<Integer> set= new HashSet<Integer>();
                for(int j=0; j<n; j++)
                {
                    if(dup==false && set.contains(a[j][i])) {
                        dup=true;
                        col++;
                    }
                    else
                        set.add(a[j][i]);
                    if(dup==true)
                        break;
                }
            }
            System.out.println("Case #"+itr+": "+trace+" "+row+" "+col);
            itr++;
        }
    }
}
