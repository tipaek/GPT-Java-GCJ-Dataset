import java.util.*;
import java.io.*;

public class Main {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static String next () throws IOException { while (st == null || !st.hasMoreTokens())
	    st = new StringTokenizer(br.readLine().trim());return st.nextToken(); }
    static long rlong () throws IOException { return Long.parseLong(next());}
    static int rint () throws IOException { return Integer.parseInt(next());}
    static double rdouble () throws IOException { return Double.parseDouble(next());}
    static String rline () throws IOException { return br.readLine().trim(); }
    static long gcd(long m, long n){ if(n == 0) return m; return gcd(n, m % n); }
    static void out(String a){ pr.print(a); }
    static void out(long a){ pr.print(a); }
    static void outln(String a){ pr.println(a); }
    static void outln(long a){ pr.println(a); }
    static void outln(double a){ pr.println(a); }
    static void outln(long a, long b){ pr.println(a + "  " + b); }

    // public static ArrayList<String> arr;
    // public static boolean poss;

    public static void main(String [] args) throws IOException{
        int t = rint();
        for(int z = 1; z <= t; z++){ //Round
            int n = rint();
            String [] arr = new String [n+2]; String str = "", end = ""; 
            int [] flip = new int [n+2];
            boolean poss = true;

            for(int j = 0; j < n; j++) arr[j] = rline();

            for(int i = 0; i < n; i++){
                // System.out.println(arr[i]);
                for(int j = 0; j < arr[i].length(); j++){
                    if(arr[i].charAt(j) == '*' && flip[i] == 0){
                        // System.out.println(j + " thing");
                        flip[i] = j+1;
                        if(str.startsWith(arr[i].substring(0, j))) continue;
                        else if(arr[i].substring(0, j).startsWith(str)) str = arr[i].substring(0, j);
                        else{ poss = false; System.out.println(i + " " + j); }
                    }
                    else if(flip[i] != 0 && j == arr[i].length()-1){

                        // System.out.println(str + " " + arr[i].substring(0, j) + " " + str.endsWith(arr[i].substring(flip[i], j+1)) + " " + arr[i].substring(flip[i], j+1).endsWith(str));
                        if(end.endsWith(arr[i].substring(flip[i], j+1))) continue;
                        else if(arr[i].substring(flip[i], j+1).endsWith(end)) end = arr[i].substring(flip[i], j+1);
                        else{ poss = false; System.out.println(i + " " + j); }
                    }
                }
            }

            // while(done != n && poss){
            //     for(int i = 0; i < n; i++){
            //         if(arr[i].charAt(pt[i]))
            //     }
            // }

            // for(int i = 0; i < n; i++){
            //     if(arr[i].charAt(pt[i]) != '*'){ str = arr[i].substring(0, arr[i].indexOf('*')+1); break; }
            // }

            // while(done != n && poss){
            //     for(int i = 0; i < n; i++){
            //         if(arr[i].charAt(pt[i]))
            //     }
            // // }
            // int i = 0, j = str.length()-1;
            // while(i < end.length() && j >= 0){
            //     if(str.charAt(j) == end.charAt(i)){ i++; j--; }
            //     else break;
            // }
            // str = str.substring(0, j+1) + end;
            if(poss)System.out.println("Case #" + z + ": " + str + end);
            else System.out.println("Case #" + z + ": *");
        }
        pr.close();
    }
}