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
            System.out.print("Case #"+t+": ");
            int x = readInt(), y = readInt(), myx = 0, myy = 0, ans = -1;
            String s = next();
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i)=='N')y++;
                else if(s.charAt(i)=='S')y--;
                if(myx==x&&myy==y){
                    ans = i+1;
                    break;
                }
                if(myx<x)myx++;
                else if(y>0)myy++;
                else myy--;
            }
            if(ans==-1&&myx==x&&myy==y)System.out.println(s.length());
            else if(ans==-1)System.out.println("IMPOSSIBLE");
            else System.out.println(ans);
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
