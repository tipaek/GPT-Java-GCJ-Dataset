import java.io.*;
import java.util.*;

/**
 *
 * @author User
 */
public class Solution
{

    public static String solve(Scanner in)
    {
        String answer ="";
        int N = in.nextInt();
        int arr[][] = new int[N][N];
        int trace=0;
        int row=0;
        int col=0;
        for (int i = 0; i < N; i++)
        {
            int arr2[]=new int[N];
            boolean rowDone=true;
            for (int j = 0; j < N; j++)
            {
                arr[i][j]= in.nextInt();
                if (++arr2[arr[i][j]-1]>1 &&rowDone)
                {
                    rowDone=false;
                    row++;
                }
                
                if (i==j)
                {
                   trace+=arr[i][j];
                }
            }
        }
        for (int i = 0; i < N; i++)
        {
            int arr2[]=new int[N];
            boolean rowDone=true;
            for (int j = 0; j < N; j++)
            {
                if (++arr2[arr[j][i]-1]>1 &&rowDone)
                {
                    rowDone=false;
                    col++;
                }
            }
        }
        

        
        answer+=trace+" "+row+" "+col;
        //stop writing from here
        return answer;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int rep = 0; rep < T; rep++)
        {
            String answer = solve(in);
            System.out.println("Case #" + (rep + 1) + ": " + answer);

        }
    }
}