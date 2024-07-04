import java.util.*;
import java.io.*;
public class Solution {
    public static void solve(int t) throws IOException{
        String S = next();
        char[] ar = S.toCharArray();
        int cnt = 0;
        System.out.print("Case #" + t + ": ");
        for (int i = 0; i<ar.length; i++){
            int val = ar[i]-'0';
            while (cnt>val){
                System.out.print(')');
                cnt--;
            } 
            while (cnt<val){
                System.out.print('(');
                cnt++;
            }
            System.out.print(val);
        }
        while (cnt>0){
            System.out.print(')');
            cnt--;
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException{
        int T = readInt();
        for (int t = 1; t<=T; t++){
            solve(t);
        }
        
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine().trim());
            return st.nextToken();
    }
    static long readLong() throws IOException {
            return Long.parseLong(next());
    }

    static float readFloat() throws IOException {
            return Float.parseFloat(next());
    }

    static boolean readBool() throws IOException {
            return Boolean.parseBoolean(next());
    }

    static short readShort() throws IOException {
            return Short.parseShort(next());
    }

    static byte readByte() throws IOException {
            return Byte.parseByte(next());
    }

    static int readInt() throws IOException {
            return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
            return Double.parseDouble(next());
    }

    static char readChar() throws IOException {
            return next().charAt(0);
    }

    static String readLine() throws IOException {
            return br.readLine().trim();
    }

    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static void print(Object o) {
            pr.print(o);
    }
}