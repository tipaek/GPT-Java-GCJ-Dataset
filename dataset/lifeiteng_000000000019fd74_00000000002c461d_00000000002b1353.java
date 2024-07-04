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

        new Solution().pascal();
        out.flush();
    }

    void pascal() throws Exception
    {
        int t = readInt();
        long[][] rows = new long[40][40];
        rows[0][0] = 1;
        rows[1][0] = rows[1][1] = 1;
        for(int i = 2; i <= 35; i++)
        {
            rows[i][0] = 1;
            for(int j = 1; j <= i; j++)
            {
                rows[i][j] = rows[i - 1][j - 1] + rows[i - 1][j];
            }
            // System.out.println(Arrays.toString(rows[i]));
        }

        for(int tt = 1; tt <= t; tt++)
        {
            int n = readInt();
            long sum = (long) n;
            int x = 0, y = 0;
            long run = 0, summ = 0;
            out.printf("Case #%d:\n", tt);
            while(true)
            {
                summ = run + (1 << x) / 2;
                if(summ <= sum && summ + 400 >= sum)
                {
                    // sum -= summ;
                    summ = run;
                    break;
                }
                run += rows[x][y];

                // out.printf("..%d %d sum = %d\n", x + 1, y + 1, run);
                out.printf("%d %d\n", x + 1, y + 1);
                if(x % 2 == 0) y++;
                x++;
            }
            while(y > 0)
            {
                summ += rows[x][y];
                // out.printf("%d %d %d sum = %d\n", x + 1, y + 1, rows[x][y], summ);
                out.printf("%d %d\n", x + 1, y + 1);
                y--;
            }
            while(sum > summ)
            {
                summ ++;
                out.printf("%d %d\n", x + 1, y + 1);
                x++;
                // sum--;
            }

            

        }
    }

    void patternMatching() throws Exception
    {
        int t = readInt();
        
        for(int tt = 1; tt <= t; tt++)
        {
            int n = readInt();
            String starts = null, ends = null;
            boolean flag = true;
            List<String> middles = new ArrayList<>();

            for(int i = 0; i < n; i++)
            {
                String p = in.readLine();
                int p1 = p.indexOf("*"),
                    p2 = p.lastIndexOf("*");

                String starting = p.substring(0, p1);
                String ending = p.substring(p2 + 1);
                String middle = p.substring(p1, p2);

                if(starts == null) starts = starting;
                if(ends == null) ends = ending;
                if(!match0(starts, starting)) flag = false;
                if(!match1(ends, ending)) flag = false;
                
                if(flag && starts.length() < starting.length()) starts = starting;
                if(flag && ends.length() < ending.length()) ends = ending;
                if(middle.length() > 0) middles.add(middle);    
            }
            
            String str = "*";

            if(flag) str = starts + merge(middles) + ends;
            
            out.printf("Case #%d: %s\n", tt, str);
        }
            
        out.flush();
    }

    String merge(List<String> list)
    {
        StringBuilder sb = new StringBuilder();
        for(String str : list)
        {
            sb.append(str);
        }
        String ans = sb.toString();
        // System.out.println(ans);
        ans = ans.replaceAll("\\*", "");
        return ans;
    }

    boolean match0(String s1, String s2)
    {
        if(s1.length() < s2.length()) return match0(s2, s1);
        return s1.indexOf(s2) == 0;
    }

    boolean match1(String s1, String s2)
    {
        if(s1.length() < s2.length()) return match1(s2, s1);
        String r1 = reverse(s1), r2 = reverse(s2);
        return r1.indexOf(r2) == 0;
    }

    String reverse(String str)
    {
        return new StringBuilder(str).reverse().toString();
    }
}