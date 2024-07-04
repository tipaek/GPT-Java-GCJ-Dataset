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

    static int[] toIntArray() throws Exception
    {
        String[] sp = split();
        int n = sp.length;
        int[] ary = new int[n];
        for(int i = 0; i < n; i++) ary[i] = Integer.valueOf(sp[i]);
        return ary;
    }

    static long[] toLongArray() throws Exception
    {
        String[] sp = split();
        int n = sp.length;
        long[] ary = new long[n];
        for(int i = 0; i < n; i++) ary[i] = Long.valueOf(sp[i]);
        return ary;
    }    

    public static void main(String[] args) throws Exception
    {
        int _k = Integer.valueOf("1");
        if(test > 0) in = new BufferedReader(new InputStreamReader(System.in));
        else in = new BufferedReader(new FileReader(file));
        if(test < 0) {String[] str = in.readLine().split(" ");}

        
        
        /****************************************************/  
        /****************************************************/
        /****************************************************/
        /****************************************************/

        int t = readInt();
        
        for(int tt = 1; tt <= t; tt++)
        {
            int n = readInt();
            int c = 0, j = 0;
            int[][] schedule = new int[n][];
            for(int i = 0; i < n; i++)
            {
                int[] ary = toIntArray();
                schedule[i] = new int[]{ary[0], ary[1], i};
            }
            Arrays.sort(schedule, (a, b)->(a[0] - b[0]));

            char[] tasks = new char[n];
            boolean found = true;
            
            String str = "";
            
            for(int[] sch : schedule)
            {
                int from = sch[0], to = sch[1], idx = sch[2];
                if(c <= from)
                {
                    c = to;
                    tasks[idx] = 'C';
                }
                else if(j <= from)
                {
                    j = to;
                    tasks[idx] = 'J';
                }
                else
                {
                    // cannot achieve
                    found = false;
                }
            }

            if(!found) str = "IMPOSSIBLE";
            else str = String.valueOf(tasks);
                        
            out.printf("Case #%d: %s\n", tt, str);
        }


        /****************************************************/
        /****************************************************/
        /****************************************************/
        /****************************************************/

        out.flush();
    }

    static int dfs(Trie root, int len, int k)
    {
        
        if(root == null) return 0;
        int count = root.strCount;
        int re = 0;

        for(int i = 0; i < 26; i++)
        {
            int ans = dfs(root.child[i], len + 1, k);
            if(ans > 0)
            {
                count -= (root.child[i].strCount / k) * k;
                re += ans;
            }
        }
        
        re += len * (count / k);
        return re;
    }

    static class Trie
    {
        Trie[] child = new Trie[26];
        int strCount = 0;

        void insert(String str)
        {
            Trie root = this;
            for(char c : str.toCharArray())
            {
                if(root.child[c - 'A'] == null) root.child[c - 'A'] = new Trie();
                root = root.child[c - 'A'];
                root.strCount++;
            }
        }
    }


}