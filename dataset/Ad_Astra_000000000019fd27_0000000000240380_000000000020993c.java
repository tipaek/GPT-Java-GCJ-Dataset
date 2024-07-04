import java.util.*;
public class Solution {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i =1;
        while((i-1)!=t)
        {
            
            int n = sc.nextInt();
            int arr[][] = new int[n][n];
            int sum =0;
            
            for(int k=0;k<n;k++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[k][j]= sc.nextInt();
                    if(k==j)
                    {
                        sum = sum+arr[k][j];
                    }
                }
            }
            
            int n_sum = (n*(n+1))/2;
            int n_mul = 1;
            
            for(int j=2;j<=n;j++)
            {
                n_mul*= j;
            }

            int x=0,y=0, track=0;
            
            while(track!=n)
            {
                int row_col_sum =0;
                int row_col_mul =1;
                
                for(int j=0;j<n;j++)
                {
                    row_col_mul *= arr[track][j];
                    row_col_sum += arr[track][j];
                    // System.out.println("row "+row_col_sum+" "+track);
                }
                if(row_col_sum!=n_sum || row_col_mul!=n_mul)
                {
                    x++;
                }
                
                row_col_sum= 0;
                row_col_mul =1;
                
                for(int j=0;j<n;j++)
                {
                    row_col_mul *= arr[track][j];
                    row_col_sum += arr[j][track];
                    // System.out.println("COLUMN "+row_col_sum+" "+track);
                }
                if(row_col_sum!=n_sum || row_col_mul!=n_mul)
                {
                    y++;
                }
                track++;
            }
            
            
            System.out.println("Case #"+i+": "+sum+" "+x+" "+y);
            // System.out.println();
            i++;
        }
    }
}