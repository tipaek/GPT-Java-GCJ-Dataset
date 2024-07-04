import java.util.*;
import java.io.*;

public class Solution {
    public static int gCount = 0;
    public static int b, Diff, Same, Count;
    public static PrintWriter out;
    public static FS sc;
    public static int[] known, type;

    public static void reset() {
        Diff = -1;
        Same = -1;
        Count = 0;
        Arrays.fill(known, -1);
    }

    public static int get2(int ind) {
        int ind2 = ds.find(ind);
        return known[ind2] ^ g[ind][ind2];
    }

    public static int get(int ind) 
        throws Exception
    {
        if (Count == 10)
            reset();
        Count++;
        ind = ds.find(ind);
        out.println(ind + 1);
        out.flush();
        gCount++;
//      System.err.println(gCount + " : " +  (ind + 1));
  //    System.err.flush();
        String s = sc.next();
        if (s.equals("N"))
            throw new Exception("BAD CASE");
        known[ind] = Integer.parseInt(s);
        if (type[ind] != -1)
            update(ind);
        return known[ind];
    }

    public static void update(int ind) {
        if (type[ind] == 0){
            if (Same == -1)
                Same = ind;
            else {
                ds.union(Same, ind);
                g[ind][Same] = g[Same][ind] = known[Same] ^ known[ind];
            }
        } else {
            if (Diff == -1) 
                Diff = ind;
            else {
                ds.union(Diff, ind);
                g[ind][Diff] = g[Diff][ind] = known[Diff] ^ known[ind];
            }
        }
    }

    public static boolean isKnown(int ind) {
        ind = ds.find(ind);
        return (known[ind] != -1);
    }

    public static int[][] g;
    public static DS ds;

    public static void main(String[] Args) 
        throws Exception
    {
//        System.err.println("Starting...");
  //      System.err.flush();
        sc = new FS(System.in);
        int t = sc.nextInt(), cc = 0;
        b = sc.nextInt();
        known = new int[b];
        type = new int[b];
        g = new int[b][b];
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while (t-->0) {
//            System.err.println("New Case");
            gCount = 0;
//            System.err.flush();
            reset();
            Arrays.fill(type, -1);
            ds = new DS(b);
            int total = 0;
            for (int i = 0; i < b; i++)
                for (int j = 0; j < b; j++)
                    g[i][j] = -1;

            int[] comp = new int[b];
            
            for (int i = 0; i < b; i++) {
                int j = b - i - 1;
                if (j < i)
                    break;
                comp[i] = j;
                comp[j] = i;
                try {
                    get(i);
                    get(j);
                } catch(Exception e) {
                    out.close();
                    return;
                }
                g[i][j] = g[j][i] = type[i] = type[j] = (known[i] ^ known[j]);
                ds.union(i, j);
                update(i);
            }
            boolean good = false;
            while (!good) {
                good = true;
                for (int i = 0; i < b; i++) {
                    if (!isKnown(i)){
                        good = false;
                        get(i);
                    }
                }
            }
            for (int i = 0; i < b; i++)
                for (int j = 0; j < b; j++)
                    for (int k = 0; k < b; k++)
                        if (g[j][i] != -1 && g[i][k] != -1)
                            g[j][k] = g[j][i] ^ g[i][k];
//            System.err.println("Answering!\n");
  //          System.err.flush();
            String s = "";
            for (int i = 0; i < b; i++) {
                int res = get2(i);
                s = s + res;
                out.print(res);
            }
//            System.err.println(s);
  //          System.err.flush();
            out.println();
            out.flush();
            s = sc.next();
            if (s.equals("N")) return;
        }

        out.close();
    }


    public static class DS {
        int[] p, r;
        DS(int x) {
            p = new int[x];
            r = new int[x];
            for(int i = 0; i < x; i++)
                p[i] = i;
        }
        int find (int x) {
            return (x == p[x]) ? x : (p[x] = find(p[x]));
        }
        void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;
            if (r[a] == r[b]) {
                r[a]++;
                p[b] = a;
            } else if (r[a] < r[b]){
                p[a] = b;
            } else {
                p[b] = a;
            }
        }
    }

    public static class FS 
    {
        BufferedReader br;
        StringTokenizer st;
        FS(InputStream in)
            throws Exception
        {
            br = new BufferedReader(new InputStreamReader(in));
            st = new StringTokenizer(br.readLine());
        }
    
        String next()
            throws Exception
        {
            if (st.hasMoreTokens())
                return st.nextToken();
            st = new StringTokenizer(br.readLine());
            return next();
        }   

        int nextInt()
            throws Exception
        {
            return Integer.parseInt(next());
        }
    }
}