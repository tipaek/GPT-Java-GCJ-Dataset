import java.util.*;
import java.io.*;
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
        for(int z = 1; z<=t; z++){
            int n = readInt();
            Integer[][]arr = new Integer[n][2];
            for(int i = 0; i<n; i++){
                arr[i][0] = readInt(); arr[i][1] = readInt();
            }
            System.out.print("Case #"+z+": ");
            boolean first = true, second = true, flag = true;
            String cur = "je", ans = "";
            int ce = -1, cs = Integer.MAX_VALUE, je = -1, js = Integer.MAX_VALUE;
            for(int i = 0; i<n; i++){
                if(cur.equals("je")){
                    if(je<=arr[i][0]){
                        first = true;
                        second = true;
                        je = arr[i][1];
                        if(js==Integer.MAX_VALUE)js = arr[i][0];
                        ans+="J";
                    }
                    else if(js>=arr[i][1]){
                        first = true;
                        second = true;
                        js = arr[i][0];
                        ans+="J";
                        if(je==-1)je = arr[i][1];
                    }
                    else{
                        first = false;
                        if(second){
                            cur = "ce";
                            i--;
                            continue;
                        }
                        else{
                            flag = false;
                            break;
                        }
                    }
                }
                else{
                    if(ce<=arr[i][0]){
                        first = true;
                        second = true;
                        ce = arr[i][1];
                        if(cs==Integer.MAX_VALUE)cs = arr[i][0];
                        ans+="C";
                    }
                    else if(cs>=arr[i][1]){
                        first = true;
                        second = true;
                        cs = arr[i][0];
                        if(ce==-1)ce = arr[i][1];
                        ans+="C";
                    }
                    else{
                        second = false;
                        if(first){
                            cur = "je";
                            i--;
                            continue;
                        }
                        else{
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if(!flag)System.out.println("IMPOSSIBLE");
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