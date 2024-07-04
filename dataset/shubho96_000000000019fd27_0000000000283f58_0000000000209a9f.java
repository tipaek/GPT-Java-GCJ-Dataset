
import java.io.*;
import java.util.*;


public class Solution{
    public static void main(String[] args) {
        FastReader in  = new FastReader();

        int t = in.nextInt();  
        
        int tt = 0;
        while(++tt <= t){
            String str = in.next();
            StringBuffer sb = new StringBuffer(str);

            int ff = Integer.parseInt("" + sb.charAt(0));
            add(sb, 0, ff, "(");

            for(int i = ff; i < sb.length() - 1;){
                int a = Integer.parseInt("" +sb.charAt(i));
                int b = Integer.parseInt("" +sb.charAt(i + 1));

                if(a > b){
                    int diff = a - b;
                    add(sb, i + 1, diff, ")");
                    i += (diff + 1);
                }
                else if(b > a){
                    int diff = b - a;
                    add(sb, i + 1, diff, "(");
                    i += (diff + 1);
                }
                else
                    ++i;

            }
            int lastNum = Integer.parseInt("" + sb.charAt(sb.length() - 1));
            if(lastNum > 0){
                sb.append(")");
                add(sb, sb.length() - 1, lastNum - 1, ")");
            }
            
            System.out.println("Case #" +tt +": "+ sb.toString());
        }
    }

    public static void add(StringBuffer sb, int idx, int times, String brace){
        int d = 1;
        while(d <= times){
            sb.insert(idx, brace);
            ++d;
        }
    }

}


class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                String s = br.readLine();
                if (s == null || s.length() == 0)
                    return null;
                st = new StringTokenizer(s);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        // return Integer.parseInt(next());
        String s = next();
        // System.out.println("inputed s ::" + s);
        if (s == null)
            return -1;
        else
            return Integer.parseInt(s);

    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
            if (str == null || str.length() == 0)
                return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}