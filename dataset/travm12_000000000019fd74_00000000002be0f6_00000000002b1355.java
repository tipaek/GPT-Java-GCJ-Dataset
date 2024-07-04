
import java.util.*;
import java.io.*;

public class Solution {
    public static PrintWriter out;
    public static long left;
    public static TreeSet<Integer>[] rs, cs;
    public static int[][] grid;
    public static void main(String[] args) throws Exception{
        FS sc = new FS(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt(), cc = 0;
        int[] q2 = new int[1000000];
        while (t-->0) {
            out.printf("Case #%d: ", ++cc);
            int r = sc.nextInt();
            int c = sc.nextInt();
            rs = new TreeSet[r];
            cs = new TreeSet[c];
            grid = new int[r][c];
            int[][] round = new int[r][c];
            for (int i = 0; i < r; i++)
                rs[i] = new TreeSet<Integer>();
            for (int i = 0; i < c; i++)
                cs[i] = new TreeSet<Integer>();
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++) {
                    grid[i][j] = sc.nextInt();
                    rs[i].add(j);
                    cs[j].add(i);
                }
            int fptr = 0;
            int bptr = 0;
            int[] q = new int[r * c * 2];
            int rounds = 1;
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++) {
                    int[] res = getAvg(i,j);
                    if (res[1] * grid[i][j] < res[0]){
                        q[bptr++] = i;
                        q[bptr++] = j;
                        round[i][j] = rounds;
                    }
                }
            while (fptr != bptr) {
                int f2 = 0;
                int b2 = 0;
                rounds++;
                while (fptr != bptr) {
                    int ii = q[fptr++];
                    int jj = q[fptr++];
                    rs[ii].remove(jj);
                    cs[jj].remove(ii);
                    if (rs[ii].higher(jj) != null) {
                        q2[b2++] = ii;
                        q2[b2++] = rs[ii].higher(jj);
                    }
                    if (rs[ii].lower(jj) != null) {
                        q2[b2++] = ii;
                        q2[b2++] = rs[ii].lower(jj);
                    }
                    if (cs[jj].higher(ii) != null) {
                        q2[b2++] = cs[jj].higher(ii);
                        q2[b2++] = jj;
                    }
                    if (cs[jj].lower(ii) != null) {
                        q2[b2++] = cs[jj].lower(ii);
                        q2[b2++] = jj;
                    }
                }
                while (f2 != b2) {
                    int i = q2[f2++];
                    int j = q2[f2++];
                    int[] res = getAvg(i,j);
                    if (round[i][j] == 0 && res[1] * grid[i][j] < res[0]){
                        q[bptr++] = i;
                        q[bptr++] = j;
                        round[i][j] = rounds;
                    }
                }
            }
            long ans = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    long tmp = round[i][j];
                    if (tmp == 0)
                        tmp = rounds;
                    ans += tmp * grid[i][j];
                }
            }
            out.println(ans);
        }
        out.close();
    }
    public static int[] getAvg(int i, int j) {
        int[] ret = new int[2];
        
        if (rs[i].higher(j) != null) {
            ret[1]++;
            ret[0] += grid[i][rs[i].higher(j)];
        }
        if (rs[i].lower(j) != null) {
            ret[1]++;
            ret[0] += grid[i][rs[i].lower(j)];
        }
        if (cs[j].higher(i) != null) {
            ret[1]++;
            ret[0] += grid[cs[j].higher(i)][j];
        }
        if (cs[j].lower(i) != null) {
            ret[1]++;
            ret[0] += grid[cs[j].lower(i)][j];
        }
        return ret;
    }
    public static class FS {
        BufferedReader br;
        StringTokenizer st;
        FS(InputStream in) throws Exception{
            br = new BufferedReader(new InputStreamReader(in));
            st = new StringTokenizer(br.readLine());
        }
        String next() throws Exception {
            if (st.hasMoreTokens())
                return st.nextToken();
            st = new StringTokenizer(br.readLine());
            return next();
        }
        int nextInt() throws Exception {
            return Integer.parseInt(next());
        }
    }
}