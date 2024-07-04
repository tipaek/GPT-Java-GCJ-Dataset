import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.StringTokenizer;


public class Solution
{
    public static void main(String[] stp) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t=Integer.parseInt(st.nextToken()),i;
        int ncase=1;
        while(t-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            Pair pair[]=new Pair[n];
            for(i=0;i<n;i++)
            {
                st=new StringTokenizer(br.readLine());
                pair[i]=new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),i);
            }
            Arrays.sort(pair,new Pair.BasedOnFirstElement());
            StringBuilder sb=new StringBuilder();
            int c=0,j=0;
            boolean flag=true;
            for(i=0;i<n;i++)
            {
                if(c <= pair[i].start)
                {
                    c=pair[i].end;
                    pair[i].c='C';
                }
                else if(j <= pair[i].start)
                {
                    j=pair[i].end;
                    pair[i].c='J';
                }
                else { flag=false; break;}
            }
            if(flag==true)
            {
                Arrays.sort(pair,new Pair.BasedOnThirdElement());
                for(i=0;i<n;i++) sb.append(pair[i].c);
            }
            else sb.append("IMPOSSIBLE");

            pw.println("Case #"+ncase+": "+sb.toString());
            ncase++;
        }
        pw.flush();
    }


    static class Pair implements Comparable<Pair>
    {
        int start, end, index;
        char c;

        public Pair(int d, int g, int i)
        {
            this.start = d;
            this.end = g;
            this.index = i;
        }

        @Override
        public int compareTo(Pair p) {
            return 1;
        }

        static class BasedOnFirstElement implements Comparator<Pair>
        {
            public int compare(Pair q, Pair s)
            {
                return -Integer.compare(s.start, q.start);
            }
        }

        static class BasedOnSecondElement implements Comparator<Pair>
        {
            public int compare(Pair q, Pair s)
            {
                return -Integer.compare(s.end, q.end);
            }
        }

        static class BasedOnThirdElement implements Comparator<Pair>
        {
            public int compare(Pair q, Pair s)
            {
                return -Integer.compare(s.index, q.index);
            }
        }
    }


}