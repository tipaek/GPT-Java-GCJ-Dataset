import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner();
        PrintWriter out = new PrintWriter(System.out) ;
        int TC = sc.nextInt() ;
        for(int c = 1 ; c <= TC ; c++)
        {
            boolean [] isTaken = new boolean[2] ;
            char [] output = {'C' , 'J'} ;
            int N = sc.nextInt() ;
            char [] sb = new char [N] ;
            Event [] events = new Event[N << 1] ;
            for(int i = 0 ; i < N ;i ++)
            {
                int start = sc.nextInt() , end = sc.nextInt();
                events[i << 1] = new Event(start , i , 1) ;
                events[i << 1 | 1] = new Event(end  , i , -1) ;
            }
            Arrays.sort(events);
            boolean isPossible = true ;
            for(int i = 0 ; i < N << 1 && isPossible; i ++)
            {
                int idx = events[i].idx ;
                if(events[i].isEnd == -1)
                {
                    if(sb[idx] == 'J')
                        isTaken[1] = false ;
                    else
                        isTaken[0] = false ;
                }
                else
                {
                    if(!isTaken[0])
                    {
                        isTaken[0] = true ;
                        sb[idx] = output[0] ;
                    }
                    else if (!isTaken[1])
                    {
                        isTaken[1] = true ;
                        sb[idx] = output[1]  ;
                    }
                    else
                        isPossible = false ;

                }

            }
            if(isPossible)
                out.printf("Case #%d: %s\n" , c ,new String(sb));
            else
                out.printf("Case #%d: IMPOSSIBLE\n" , c );
        }
        out.flush();
        out.close();
    }
    static class Event implements Comparable<Event>
    {
        int time ;
        int isEnd ;
        int idx ;

        Event(int a , int b , int c)
        {
            time = a ;
            idx = b ;
            isEnd = c ;
        }

        @Override
        public int compareTo(Event o)
        {
            if(time != o.time)
                return time - o.time ;

            return isEnd - o.isEnd;
        }
    }
    static class Scanner
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        StringTokenizer st ;

        String next() throws Exception
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine()) ;
            return st.nextToken() ;
        }
        int nextInt() throws Exception
        {
            return Integer.parseInt(next()) ;
        }
        long nextLong() throws Exception
        {
            return Long.parseLong(next()) ;
        }
        double nextDouble() throws Exception
        {
            return Double.parseDouble(next()) ;
        }
    }
}
