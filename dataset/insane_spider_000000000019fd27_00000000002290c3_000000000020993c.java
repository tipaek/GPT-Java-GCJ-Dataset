import java.util.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int cas=1;
        while(t!=0)
        {
            int n = s.nextInt();
            int matrix[][]=new int[n][n];
            int trace=0;
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)        //trace
                {
                    matrix[i][j] = s.nextInt();
                    if(i==j)
                        trace=trace+matrix[i][j];
                }
            int rows=0;
            for(int i=0;i<n;i++)    //rows
            {
                int narr[]= new int[n];
                for(int j=0;j<n;j++)
                {
                    narr[matrix[i][j]-1]=narr[matrix[i][j]-1]+1;
                    if(narr[matrix[i][j]-1]>1)
                    {
                        rows++;
                        break;
                    }
                }
            }
            int col=0;
            for(int i=0;i<n;i++)    //columns
            {
                int narr[]= new int[n];
                for(int j=0;j<n;j++)
                {
                    narr[matrix[j][i]-1]=narr[matrix[j][i]-1]+1;
                    if(narr[matrix[j][i]-1]>1)
                    {
                        col++;
                        break;
                    }
                }
            }
        System.out.println("Case #"+cas+": "+trace+" "+rows+" "+col);
        t--;  
        cas ++;
        }
        
    }
}