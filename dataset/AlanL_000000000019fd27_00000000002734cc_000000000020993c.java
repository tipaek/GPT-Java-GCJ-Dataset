import java.util.*;
import java.io.*;
/**
 *
 * @author alanl
 */
public class CodeJam2020 {

    /**
     * @param args the command line arguments
     */
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
        int t = readInt();
        for(int z = 1; z<=t; z++){
            int n = readInt(), trace = 0, r = 0, c = 0, arr[][] = new int[n][n];
            for(int i = 0; i<n; i++){
                Set<Integer>s = new HashSet<>();
                for(int j = 0; j<n; j++){
                    arr[i][j] = readInt();
                    if(i==j)trace+=arr[i][j];
                    s.add(arr[i][j]);
                }
                if(s.size()!=n)r++;
            }
            for(int i = 0; i<n; i++){
                Set<Integer>s = new HashSet<>();
                for(int j = 0; j<n; j++){
                    s.add(arr[j][i]);
                }
                if(s.size()!=n)c++;
            }
            System.out.println("Case #"+z+": "+trace+" "+r+" "+c);
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