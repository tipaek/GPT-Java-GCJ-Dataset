import java.util.*;

public class Solution {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[][] answer = new int[T][3];
        for(int i=0;i<T;i++)
        {
            int N = scanner.nextInt();
            ArrayList<Integer> rows = new ArrayList<>();
            ArrayList<Integer> cols = new ArrayList<>();
            int[] matrix = new int[N*N];
            int trace = 0;
            for(int j=0;j<N*N;j++) {
                matrix[j] = scanner.nextInt();
                if (j%(N+1) == 0)
                    trace+=matrix[j];
            }
            answer[i][0] = trace;
            int r = 0;
            for(int j=0;j<N*N;j+=N)
            {
                rows.clear();
                for(int k=j;k<j+N;k++)
                {
                    if(rows.contains(matrix[k]))
                    {
                        r++;
                        break;
                    }
                    else
                        rows.add(matrix[k]);
                }
            }
            answer[i][1] = r;
            int c = 0;
            for(int j=0;j<N;j++)
            {
                cols.clear();
                for(int k=j;k<N*N;k+=N)
                {
                    if(cols.contains(matrix[k]))
                    {
                        c++;
                        break;
                    }
                    else
                        cols.add(matrix[k]);
                }
            }
            answer[i][2] = c;
        }
        for(int i=0;i<T;i++)
            System.out.println("Case #" + (i+1) + ": " + answer[i][0] + " " + answer[i][1] + " " + answer[i][2]);
    }
}
