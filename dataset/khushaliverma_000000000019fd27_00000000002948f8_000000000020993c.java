import java.util.*;

class Solution
{
    static Scanner var = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        int T = var.nextInt();
        for(int t=0; t<T; t++)
        {
            int N = var.nextInt();
            int arr[][] = new int[N][N];
            int trace = 0;
            int r = 0, c = 0;
            int totr = 0, totc = 0;
            HashMap<Integer, Integer> row = new HashMap<Integer, Integer>();
            HashMap<Integer, Integer> col = new HashMap<Integer, Integer>();
            for(int i=0; i<N; i++)
            {
                row.clear(); r=0;
                for(int j=0; j<N; j++)
                {
                    arr[i][j] = var.nextInt();
                    if(i==j)
                    {
                        trace+=arr[i][j];
                    }
                    
                    if(row.containsKey(arr[i][j]))
                        r++;
                    else
                        row.put(arr[i][j], i);
                }
                if(r>0)
                    totr++;
            }
            
            for(int j=0; j<N; j++)
            {
                col.clear(); c=0;
                for(int i=0; i<N; i++)
                {
                    if(col.containsKey(arr[i][j]))
                        c++;
                    else
                        col.put(arr[i][j], j);
                }
                if (c>0)
                    totc++;
            }
            int w = t+1;
            System.out.print("Case #" + w + ": ");
            System.out.println(trace + " " + totr + " " + totc);
        }
    }
}