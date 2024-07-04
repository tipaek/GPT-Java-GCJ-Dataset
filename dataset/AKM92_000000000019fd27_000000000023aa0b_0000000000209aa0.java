import java.util.*;

public class Solution {
    
    public static int sum(int N)
    {
        if(N == 1)
            return 1;
        return N + sum(N-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++)
        {
            int N = sc.nextInt();
            int K = sc.nextInt();
            boolean poss = true;
            if(K >= N)
            {
                /*if(K == sum(N) && K>2)
                {
                    System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                    for(int j = 0; j < N; j++)
                    {
                        StringBuilder sb = new StringBuilder();
                        for(int k = 0; k < N; k++)
                        {
                            int g = (j+k)%(N);
                            sb.append(Integer.toString(g+1));
                            sb.append(" ");
                        }
                        System.out.println(sb.toString().trim());
                    }
                }
                else*/ if(K % N == 0)
                {
                    int n = K/N;
                    System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                    for(int j = 0; j < N; j++)
                    {
                        StringBuilder sb = new StringBuilder();
                        for(int k = 0; k < N; k++)
                        {
                            int g = (n-j+k-1)%(N);
                            sb.append(Integer.toString(g+1));
                            sb.append(" ");
                        }
                        System.out.println(sb.toString().trim());
                    }
                }
                else
                    poss = false;
            }
            else
                poss = false;
            if(!poss)
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
        }
        
    }
    
}
