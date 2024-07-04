import java.util.*;
import java.io.*;
import java.text.*;
/**
 *
 * @author alanl
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
        int t = readInt();
        for(int tests = 1; tests<=t; tests++){
            System.out.print("Case #"+tests+": ");
            int x = readInt(), y = readInt();
            String s = next();
            boolean flag = false;
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i)=='N')y++;
                else if(s.charAt(i)=='S')y--;
                else if(s.charAt(i)=='E')x++;
                else x--;
                int dis = Math.abs(x)+Math.abs(y-0);
                if(i+1>=dis){
                    System.out.println(i+1);
                    flag = true;
                    break;
                }
            }
            if(!flag)System.out.println("IMPOSSIBLE");
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
}
