// 
import java.math.*;
import java.util.*;
import java.io.*;
  
public class Solution { 
  
    static int test = 10; // 0 for local testing, 1 for std input

    static BufferedReader in;
    static PrintWriter out = new PrintWriter(System.out);
    static String file = "../in";
    static int inf = 1_000_000;

    static void swap(int[]ary, int i, int j)
    {
        int t = ary[i];
        ary[i] = ary[j];
        ary[j] = t;
    }
    
    static String[] split() throws Exception
    {
        return in.readLine().split(" ");
    }

    static int readInt() throws Exception
    {
        return Integer.valueOf(in.readLine());
    }
    public static void main(String[] args) throws Exception
    {
        int _k = Integer.valueOf("1");
        if(test > 0) in = new BufferedReader(new InputStreamReader(System.in));
        else in = new BufferedReader(new FileReader(file));
        if(test < 0) {String[] str = in.readLine().split(" ");}

        int t = readInt();
        
        for(int tt = 1; tt <= t; tt++)
        {
            
            String str = in.readLine();
            int n = str.length();
            Deque<Integer> q1 = new ArrayDeque<>(), q3 =  new ArrayDeque<>();
            Deque<String> q2 = new ArrayDeque<>(), q4 = new ArrayDeque<>();
            for(char c : str.toCharArray())
            {
                int val = c - '0';
                q1.offerLast(val);
                q2.offerLast("" + c);
            }

            for(int i = 9; i >= 1; i--)
            {

                q3 = new ArrayDeque<>();
                q4 = new ArrayDeque<>();
                
                while(!q1.isEmpty())
                {
                    if(q1.peekFirst() < i) 
                    {
                        q3.offerLast(q1.pollFirst());
                        q4.offerLast(q2.pollFirst());
                    }
                    else
                    {
                        String ss = "";
                        while(!q1.isEmpty() && q1.peekFirst() == i)
                        {
                            q1.pollLast();
                            ss += q2.pollFirst();
                        }
                        q3.offerLast(i - 1);
                        q4.offerLast("(" + ss + ")");
                    }
                }
                q1 = q3;
                q2 = q4;
                
            }
            String ss = "";
            while(!q2.isEmpty()) ss += q2.pollFirst();
            out.printf("Case #%d: %s\n", tt, ss);
        }
        out.flush();
    }
}