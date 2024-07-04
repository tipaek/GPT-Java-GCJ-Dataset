import java.util.*;
import java.io.*;

public class Solution 
{
    public static class Letter implements Comparable<Letter>
    {
        char c;
        int f;
        public Letter(char c, int f)
        {
            this.c = c;
            this.f = f;
        }
        public int compareTo(Letter l)
        {
            return Integer.compare(l.f,f);
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
            int[] freq = new int[26];
            for(int i = 0; i < 10000; i++)
            {
                StringTokenizer st = new StringTokenizer(input.readLine());
                int Q = Integer.parseInt(st.nextToken());
                String R = st.nextToken();
                for(int c = 0; c < R.length(); c++) freq[R.charAt(c)-'A']++;
            }
            //System.out.println(Arrays.toString(freq));
            PriorityQueue<Letter> pq = new PriorityQueue<Letter>();
            for(int i = 0; i < 26; i++) if(freq[i]!=0) pq.add(new Letter((char)('A'+i),freq[i]));
            String ans = "";
            for(int i = 0; i < 9; i++) ans += pq.poll().c;
            ans = pq.poll().c+ans;
            out.println(ans);
        }
        out.flush();
        out.close();
    }
}