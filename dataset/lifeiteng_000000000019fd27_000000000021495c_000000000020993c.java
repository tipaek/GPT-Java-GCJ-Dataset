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
        int[] ary = {0};
        for(int tt = 1; tt <= t; tt++)
        {
            
            int n = readInt();
            int[][] g = new int[n][n];
            int k = 0, r = 0, c = 0;

            for(int i = 0; i < n; i++)
            {
                g[i] = toIntArray();
                Set<Integer> rset = new HashSet<>();
                boolean row = false;
                for(int val : g[i])
                {
                    if(rset.contains(val)) row = true;
                    rset.add(val);
                }

                k += g[i][i];
                if(row) r++;
            }

            for(int j = 0; j < n; j++)
            {
                boolean col = false;
                Set<Integer> cset = new HashSet<>();
                for(int i = 0; i < n; i++)
                {
                    if(cset.contains(g[i][j])) col = true;
                    cset.add(g[i][j]);
                }
                if(col) c++;
            }

            out.printf("Case #%d: %d %d %d\n", tt, k, r, c);
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