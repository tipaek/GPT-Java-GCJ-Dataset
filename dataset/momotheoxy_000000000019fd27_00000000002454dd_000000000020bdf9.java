import java.util.*;

class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();
        
        for (int testCase = 1; testCase <= T; testCase++)
        {
            int N = in.nextInt();

            StringBuilder out = new StringBuilder();

            int start[] = new int[N];
            int end[] = new int[N];

            //receive all data
            for (int act = 0; act < N; act++)
            {
                start[act] = in.nextInt();
                end[act] = in.nextInt();
            }

            //sort
            for (int i = 0; i < start.length; i++) 
            {
                int minS = start[i];
                int minE = end[i];
                int minId = i;
                for (int j = i+1; j < start.length; j++) {
                    if (start[j] < minS) {
                        minS = start[j];
                        minE = end[j];
                        minId = j;
                    }
                }
                // swapping
                int temp = start[i];
                start[i] = minS;
                start[minId] = temp;
                
                temp = end[i];
                end[i] = minE;
                end[minId] = temp;
            }

            int C = 0;
            int J = -1;
            out.append('C');

            for (int act = 1; act < N; act++)
            {
                //release worker from past job
                for (int back = act - 1; back >= 0 && back >= act - 3; back--)
                {
                    if (start[act] >= end[back])
                    {
                        if (C == back)  C = -1;
                        else if (J == back) J = -1;
                    }
                }

                if (C == -1)    
                {
                    C = act;
                    out.append('C');
                }
                else if (J == -1)   
                {
                    J = act;
                    out.append('J');
                }
                else    out = new StringBuilder("IMPOSSIBLE");
            }

            //print output
            System.out.print("Case #" + testCase + ": ");
            System.out.print(out.toString());
            System.out.println();
        }
    }
}