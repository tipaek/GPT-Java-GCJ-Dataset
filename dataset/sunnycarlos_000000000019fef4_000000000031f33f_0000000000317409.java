import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int t = sc.nextInt();
        for (int test = 1; test <= t; test++) {
            sb.append("Case #"+test+": ");
            int y=sc.nextInt(),x=sc.nextInt();
            String str = sc.next();
            int a = 0, b = 0;
            int min=Integer.MAX_VALUE;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'S') {
                    a++;
                    if (i+1>= foo(a,b,x,y)){
                        min=i+1;
                        break;
                    }
                } else if (str.charAt(i) == 'E') {
                    b--;
                    if (i+1>= foo(a,b,x,y)){
                        min=i+1;
                        break;
                    }
                } else if (str.charAt(i) == 'N') {
                    a--;
                    if (i+1>= foo(a,b,x,y)){
                        min=i+1;
                        break;
                    }
                } else {
                    b++;
                    if (i+1>= foo(a,b,x,y)){
                        min=i+1;
                        break;
                    }
                }
            }
            if(min==Integer.MAX_VALUE)sb.append("IMPOSSIBLE");
            else sb.append(min);
            if (test!=t)sb.append("\n");
        }
        System.out.print(sb);
    }
    static int foo(int a, int b, int x, int y){
        return Math.abs(a-x)+Math.abs(b-y);
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}