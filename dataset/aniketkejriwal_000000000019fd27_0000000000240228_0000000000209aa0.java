import java.util.*;

class Solution
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int T= in.nextInt();
        int i=0;
        while(i<T)
        {
            i++;
            int N=in.nextInt();
            int K=in.nextInt();
            if(K%N!=0)
                System.out.println("Case #"+i+": "+"IMPOSSIBLE");
            else
            {
                System.out.println("Case #"+i+": "+"POSSIBLE");
                int j=K/N;
                List<Integer> L=new ArrayList<Integer>();
                for(int k=1;k<=N;k++)
                {
                    if(k==j)
                        continue;
                    L.add(k);
                }
                for(int k=0;k<N;k++)
                {
                    int m=0;
                    for(int l=0;l<N;l++)
                    {
                        if(k==l)
                        {
                            System.out.print(j+" ");
                            continue;
                        }
                        System.out.print(L.get(m)+" ");
                        m++;
                    }
                    L.add(0,L.get(N-2));
                    L.remove(N-1);
                    System.out.println("");
                }
            }
        }
    }
}
        
            