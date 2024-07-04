import java.util.*;
import java.io.*;
/**
 *
 * @author alanl
 */
public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
        int t = readInt(), a = readInt(), b = readInt();
        for(int z = 1; z<=t; z++){
            int curx = -1000000000+a, cury = -1000000000+b, curx1 = 1000000000-a, cury1 = 1000000000-b;
            for(int i = curx; i<=curx1; i++){
                for(int j = cury; j<=cury1; j++){
                    System.out.println(i+" "+j);
                    String cur = readLine();
                    if(cur.equals("CENTER"))break;
                }
            }
        }
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(input.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readChar () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return input.readLine().trim();
    }
    //System.out.println(Arrays.toString(e.getStackTrace()));
}