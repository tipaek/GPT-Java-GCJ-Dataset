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
            List<ArrayList<Integer>> A=new ArrayList<ArrayList<Integer>>();
            for(int k=0;k<N;k++)
            {
                A.add(new ArrayList<Integer>());
                for(int l=0;l<N;l++)
                {
                    A.get(k).add(l,in.nextInt());
                }
            }
            int s=0,r=0,c=0;
            HashSet<Integer> H=new HashSet<Integer>();
            HashSet<Integer> H1=new HashSet<Integer>();
            for(int k=0;k<N;k++)
            {
                H.clear();
                H1.clear();
                int f=0,g=0;
                for(int l=0;l<N;l++)
                {
                    if(!H.add(A.get(k).get(l)) && f==0)
                    {
                        r++;
                        f=1;
                    }
                    if(!H1.add(A.get(l).get(k)) && g==0)
                    {
                        c++;
                        g=1;
                    }
                    if(k==l)
                        s=s+A.get(k).get(l);
                }
            }
            System.out.println("Case #"+i+": "+s+" "+r+" "+c);
        }
    }
}
        
            