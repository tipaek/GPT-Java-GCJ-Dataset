import java.util.*;
import java.io.*;

public class Solution
{
    public static class Letter implements Comparable<Letter>
    {
        char c;
        long f;
        public Letter(char c, long f)
        {
            this.c = c;
            this.f = f;
        }
        public int compareTo(Letter l)
        {
            return Long.compare(l.f,f);
        }
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int TC = Integer.parseInt(input.readLine());
        for(int t = 1; t <= TC; t++)
        {
            out.print("Case #" + t + ": ");
            int U = Integer.parseInt(input.readLine());
            long[] freq = new long[26];
            boolean[] first = new boolean[26];
            for(int i = 0; i < 10000; i++)
            {
                StringTokenizer st = new StringTokenizer(input.readLine());
                long Q = Long.parseLong(st.nextToken());
                String R = st.nextToken();
                first[R.charAt(0)-'A'] = true;
                for(int c = 0; c < R.length(); c++) freq[R.charAt(c)-'A'] += 1*Math.pow(10,R.length()-c-1);
            }
            PriorityQueue<Letter> pq = new PriorityQueue<Letter>();
            String ans = "";
            for(int i = 0; i < 26; i++)
            {
                if(freq[i]!=0)
                {
                    if(!first[i]) ans += (char)('A'+i);
                    else pq.add(new Letter((char)('A'+i),freq[i]));
                }
            }
            for(int i = 0; i < 9; i++) ans += pq.poll().c;
            out.println(ans);
        }
        out.flush();
        out.close();
    }
}
