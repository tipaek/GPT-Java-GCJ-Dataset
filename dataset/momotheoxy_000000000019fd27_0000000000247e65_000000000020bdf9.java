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

            String out = "";

            int start[] = new int[N];
            int end[] = new int[N];
            int index[] = new int[N];
            char answer[] = new char[N];

            //receive all data
            for (int act = 0; act < N; act++)
            {
                start[act] = in.nextInt();
                end[act] = in.nextInt();
                index[act] = act;
            }

            //sort
            for (int i = 0; i < start.length; i++) 
            {
                int minS = start[i];
                int minE = end[i];
                int minI = index[i];
                int minId = i;
                for (int j = i+1; j < start.length; j++) {
                    if (start[j] < minS) {
                        minS = start[j];
                        minE = end[j];
                        minI = index[j];
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
                
                temp = index[i];
                index[i] = minI;
                index[minId] = temp;
            }

            int C = 0;
            int J = -1;
            answer[index[0]] = 'C';

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
                    answer[index[act]] = 'C';
                }
                else if (J == -1)   
                {
                    J = act;
                    answer[index[act]] = 'J';
                }
                else    
                { 
                    out = "IMPOSSIBLE";
                    break;
                }

            }

            if (!out.equals("IMPOSSIBLE"))
            {
                out = new String(answer);
            }

            //print output
            System.out.print("Case #" + testCase + ": ");
            System.out.print(out);
            System.out.println();
        }
    }
}