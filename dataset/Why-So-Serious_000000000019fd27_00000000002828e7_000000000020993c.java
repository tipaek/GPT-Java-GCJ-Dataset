import java.util.HashSet;
import java.util.Scanner;


public class Solution 
{
    static StringBuilder sb  = new StringBuilder();
    
    public static void main(String[] args) throws Exception
    {
        int i,j;
        
        Scanner sc = new Scanner(System.in);
        //test cases
        int t = sc.nextInt();
        int count  = 1;
        for(count = 1;count <= t; count++)
        {
            //input n
            int n = sc.nextInt();
            
            //input array
            int a[][] = new int[n][n];
            for(i = 0; i < n; i++ )
            {
                for(j = 0; j < n; j++)
                {
                    a[i][j] = sc.nextInt();
                }
            }
            sb.append("Case #" + count +": ");
            calc(a, n);
            sb.append("\n");
        
        } //while for test cases ends
        sc.close();
        System.out.print(sb);
        
    }// main ends

    private static void calc(int[][] a, int n) {
        int i, j , rc = 0, cc = 0 , sd = 0;
        HashSet<Integer> hs = new HashSet<>();
        
        // sum of diagonals
        for(i = 0; i < n; i++)
            sd += a[i][i];
        
        //row major
        for(i = 0; i < n; i++ )
        {
            hs.clear();
            for(j = 0; j < n; j++)
            {
                if(hs.contains(a[i][j]))
                {
                    rc++;
                    break;
                }
                else
                    hs.add(a[i][j]);
            }
        }
        
        hs.clear();
        //column wise
        for(i = 0; i < n; i++ )
        {
            hs.clear();
            for(j = 0; j < n; j++)
            {
                
                if(hs.contains(a[j][i]))
                {
                    cc++;
                    break;
                }
                else
                    hs.add(a[j][i]);
            }
        }
       
        sb.append(sd+" "+rc+ " "+cc);
        return ;
    }
    
}
