import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] stp) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int t=scan.nextInt(),i;
        int ncase=1;
        while(t-- > 0)
        {
            int n=scan.nextInt();
            Pair pair[]=new Pair[n];
            for(i=0;i<n;i++)
            {
                pair[i]=new Pair(scan.nextInt(),scan.nextInt(),i,69);
            }
            Arrays.sort(pair,new Pair.BasedOnFirstElement().thenComparing(new Pair.BasedOnLastElement()));
            String ans="";
            int c=0,j=0;
            boolean flag=true;
            for(i=0;i<n;i++)
            {
                if(c <= pair[i].begin)
                {
                    c=pair[i].finish;
                    pair[i].c=1;   //c
                }
                else if(j <= pair[i].begin)
                {
                    j=pair[i].finish;
                    pair[i].c=0;   //j
                }
                else { flag=false; break;}
            }
            if(flag==true)
            {
                Arrays.sort(pair,new Pair.BasedOnThirdElement());
                for(i=0;i<n;i++)
                {
                    if(pair[i].c == 0) ans+="J";
                    else ans+="C";
                }
            }
            else ans+="IMPOSSIBLE";

            System.out.println("Case #"+ncase+": "+ans);
            ncase++;
        }
    }


    static class Pair implements Comparable<Pair>
    {
        int begin,finish, index;
        int c;

        public Pair(int d, int g, int i,int c)
        {
            this.begin = d;
            this.finish = g;
            this.index = i;
            this.c = c;
        }

        @Override
        public int compareTo(Pair p) {
            return 1;
        }

        static class BasedOnFirstElement implements Comparator<Pair>
        {
            public int compare(Pair q, Pair s)
            {
                return -Integer.compare(s.begin, q.begin);
            }
        }

        static class BasedOnThirdElement implements Comparator<Pair>
        {
            public int compare(Pair q, Pair s)
            {
                return -Integer.compare(s.index, q.index);
            }
        }


        static class BasedOnLastElement implements Comparator<Pair>
        {
            public int compare(Pair q, Pair s)
            {
                return -Integer.compare(s.c, q.c);
            }
        }
    }


}