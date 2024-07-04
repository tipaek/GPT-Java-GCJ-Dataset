import java.util.*;
import java.io.*;


public class Solution
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(f.readLine());
        for (int j=1; j<=t; j++)
        {
            int n = Integer.parseInt(f.readLine());
            int[][] se = new int[2*n][3];
            for (int i=0; i<n; i++)
            {
                StringTokenizer st = new StringTokenizer(f.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                se[2*i][0] = s;
                se[2*i][1] = 0;
                se[2*i][2] = i;
                se[2*i+1][0] = e;
                se[2*i+1][1] = 1;
                se[2*i+1][2] = i;
            }

            Arrays.sort(se, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0]==o2[0])
                    {
                        return o2[1]-o1[1];
                    }
                    else
                    {
                        return o1[0]-o2[0];
                    }
                }
            });

            boolean p = true;
            int[] ans = new int[n];
            int a = -1;
            int b = -1;
            for (int i=0; i<2*n; i++)
            {
                if (se[i][1]==0)
                {
                    if (a ==-1)
                    {
                        a = se[i][2];
                        ans[se[i][2]] = 0;
                    }
                    else if (b==-1)
                    {
                        b = se[i][2];
                        ans[se[i][2]] = 1;
                    }
                    else
                    {
                        p = false;
                    }
                }
                else
                {
                    if (a==se[i][2])
                    {
                        a = -1;
                    }
                    else if (b==se[i][2])
                    {
                        b = -1;
                    }
                }
            }

            System.out.print("Case #" + j + ": ");
            if (p)
            {
                for(int i=0; i<n; i++)
                {
                    if (ans[i]==0) System.out.print("C");
                    else System.out.print("J");
                }
                System.out.println();
            }
            else
            {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}