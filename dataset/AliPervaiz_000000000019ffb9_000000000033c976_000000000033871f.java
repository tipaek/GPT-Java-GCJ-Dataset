import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int tc = 1; tc <= T; tc++)
        {
            out.print("Case #"+tc+":");
            StringTokenizer st = new StringTokenizer(input.readLine());
            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int[] a = new int[C];
            st = new StringTokenizer(input.readLine());
            for(int i = 1; i < a.length; i++) a[i] = Integer.parseInt(st.nextToken());
            for(int i = 0; i < D; i++)
            {
                st = new StringTokenizer(input.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                out.print(" " + Math.max(1,Math.abs(a[x]-a[y])));
            }
            out.println();
        }
        out.close();
    }
}