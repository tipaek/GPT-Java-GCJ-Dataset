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

        new Solution().isad();
    }

    void isad() throws Exception
    {
        int[] ary = toIntArray();
        int t = ary[0], B = ary[1];

        
        for(int tt = 1; tt <= t; tt++)
        {
            // logg.printf("\n[Test case ... %d]\n", tt);
            int[] bits = new int[B];
            for(int i = 0; i < 10; i++) bits[i] = read(i);
            
            // Arrays.fill(bits, -1);

            // int[] p = {0, 1, B - 2, B - 1};
            // bits[0] = read(0);
            // bits[B - 1] = read(B - 1);

            

            // // find the next two pairs 
            // int q = 3;
            // boolean found = false;
            // boolean[] vis = new boolean[B];

            // while(!found && p[1] < p[2])
            // {
            //     bits[p[1]] = read(p[1]);
            //     vis[p[1]] = true;
            //     bits[p[2]] = read(p[2]);
            //     vis[p[2]] = true;
            //     q += 2;
            //     found = distinct(bits, p);
            //     if(found) break;
            //     p[1]++;
            //     p[2]--;
            // }

            // // logg.println(Arrays.toString(p));
            // // logg.println(Arrays.toString(bits));
            // // logg.println("at run.. " + q);

            // // if(p[1] < p[2])
            // {
            //     String status = "" + bits[p[0]] + bits[p[1]] + bits[p[2]] + bits[p[3]];
                
                
            //     for(int k = 0; k < 4; k++)
            //     {
            //         vis[p[k]] = true;
            //     }

            //     while(q < 150)
            //     {
            //         // now we have 4 bits to know the current status, and next status
            //         // logg.println("queries..." + q);
            //         if(q % 10 == 1)
            //         {
            //             // get the next 4 status, and update the bits accordingly
            //             String nextStatus = "";
            //             for(int k = 0; k < 4; k++)
            //             {
            //                 nextStatus += ""+ read(p[k]);
            //             }

            //             int op = comp(status, nextStatus);
            //             // logg.printf("%d .. status = .. %s %s %d\n", q, status, nextStatus, op);

            //             bits = update(bits, op);
            //             vis = updatevis(vis, op);
            //             q += 4;
            //             status = nextStatus;
            //         }
            //         else
            //         {
            //             boolean readDig = false;
            //             for(int i = 0; i < B; i++)
            //             {
            //                 if(vis[i]) continue;
            //                 bits[i] = read(i);
            //                 vis[i] = true;
            //                 readDig = true;
            //                 break;
            //             }
            //             if(!readDig)
            //             {
            //                 // logg.printf("finished all digits.. q = %d\n", q);
            //                 break;
            //             }
            //             q++;
            //         }
            //     }

            //     // logg.println(Arrays.toString(vis));
            // }

            String str = "";
            for(int k : bits) str += k;
            // logg.println(str);
                        
            out.printf("%s\n", str);
            out.flush();

            String ans = in.readLine();
            if(ans.equals("N")) break;
        }
    }

    // int[][] ans;

    // void indicium() throws Exception
    // {
    //     int t = readInt();

    //     for(int tt = 1; tt <= t; tt++)
    //     {
    //         int[] ary = toIntArray();
    //         int n = ary[0], k = ary[1];
    //         ans = null;
    //         int diag = k / n;
    //         dfs(n, 0, k, new int[n][n]);
    //         if(ans != null)
    //         {
    //             out.printf("Case #%d: POSSIBLE\n", tt);
    //             for(int [] aa : ans)
    //             {
    //                 for(int k : aa) out.printf("%d ", k);
    //                 out.printf("\n");
    //             }
    //         }
    //         else out.printf("Case #%d: IMPOSSIBLE\n", tt);
    //     }
    // }

    // boolean dfs(int n, int row, int k, int[][] ary, Set<Integer>[] cols)
    // {
    //     if(row == n - 1)
    //     {
            
            
    //         ary[row][row] = k - sum;
            


    //         for(int i = 0; i < n; i++)
    //         {
    //             // ary[row][]    
    //         }

    //         int sum = 0;
    //         for(int i = 0; i < n; i++) sum += ary[i][i];
    //         if(sum == k)
    //         {
    //             ans = ary;
    //             return true;
    //         }
    //         return fale;
    //     }
    //     for(int i = 0; i < n; i++)
    //     {
    //         for(int val = 1; val <= n; val++)
    //         {
    //             if(cols[i].contains(val)) continue;
    //             cols[i].add(val);
    //             ary[row][i] = val;
    //         }
    //     }
    // }

}