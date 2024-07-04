// 
import java.math.*;
import java.util.*;
import java.io.*;
  
public class Solution { 
  
    static int test = 10; // 0 for local testing, 1 for std input

    static BufferedReader in;
    static PrintWriter out = new PrintWriter(System.out);
    static PrintWriter logg;
    static String file = "../in";
    static int inf = 1_000_000;

    void swap(boolean[]ary, int i, int j)
    {
        boolean t = ary[i];
        ary[i] = ary[j];
        ary[j] = t;
    }

    void swap(int[]ary, int i, int j)
    {
        int t = ary[i];
        ary[i] = ary[j];
        ary[j] = t;
    }
    
    String[] split() throws Exception
    {
        return in.readLine().split(" ");
    }

    int readInt() throws Exception
    {
        return Integer.valueOf(in.readLine());
    }

    int[] toIntArray() throws Exception
    {
        String[] sp = split();
        int n = sp.length;
        int[] ary = new int[n];
        for(int i = 0; i < n; i++) ary[i] = Integer.valueOf(sp[i]);
        return ary;
    }

    long[] toLongArray() throws Exception
    {
        String[] sp = split();
        int n = sp.length;
        long[] ary = new long[n];
        for(int i = 0; i < n; i++) ary[i] = Long.valueOf(sp[i]);
        return ary;
    }    


    boolean distinct(int[] bits, int[] p)
    {
        int p1 = p[0], p2 = p[1], p3 = p[2], p4 = p[3];

        if(bits[p1] == bits[p2] && bits[p3] != bits[p4]) return true;
        if(bits[p1] != bits[p2] && bits[p3] == bits[p4]) return true;
        
        return false;
    }

    int read(int pos) throws Exception
    {
        out.println(pos + 1);
        out.flush();
        return Integer.valueOf(in.readLine());
    }

    public static void main(String[] args) throws Exception
    {
        int _k = Integer.valueOf("1");
        // logg = new PrintWriter("log");
        if(test > 0) in = new BufferedReader(new InputStreamReader(System.in));
        else in = new BufferedReader(new FileReader(file));
        if(test < 0) {String[] str = in.readLine().split(" ");}

        
        
        /****************************************************/  
        /****************************************************/
        /****************************************************/
        /****************************************************/

        new Solution().patternMatching();
    }

    void pascal() throws Exception
    {

    }

    void patternMatching() throws Exception
    {
        int t = readInt();
        
        for(int tt = 1; tt <= t; tt++)
        {
            int n = readInt();
            String starts = null, ends = null;
            boolean flag = true;
            for(int i = 0; i < n; i++)
            {
                String p = in.readLine();
                int pos = p.indexOf("*");
                String starting = p.substring(0, pos);
                String ending = p.substring(pos + 1);
                if(starts == null) starts = starting;
                if(ends == null) ends = ending;
                if(!match(starts, starting)) flag = false;
                if(!match(ends, ending)) flag = false;
                if(!flag) break;
                if(flag && starts.length() < starts.length()) starts = starting;
                if(flag && ends.length() < ending.length()) ends = ending;
                
            }
            String str = "*";
            if(flag) str = starts + ends;
            
            out.printf("Case #%d: %s\n", tt, str);
        }
            
        out.flush();
    }

    boolean match(String s1, String s2)
    {
        if(s1.length() < s2.length()) return match(s2, s1);
        String r1 = reverse(s1), r2 = reverse(s2);
        return r1.indexOf(r2) == 0;
    }

    String reverse(String str)
    {
        return new StringBuilder(str).reverse().toString();
    }
}