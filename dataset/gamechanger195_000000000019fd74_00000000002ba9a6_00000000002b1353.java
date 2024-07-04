import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class Solution {
    public static void main(String args[]) throws IOException {
        FastReader in = new FastReader(System.in);
        StringBuilder sb = new StringBuilder();
        int i, j;
        int t0 = 0;
        int t = in.nextInt();
        while (t0++ < t) {
            int n = in.nextInt();
            sb.append("Case #" + t0 + ": ").append("\n");
            StringBuilder sb1 = new StringBuilder();
            if (n <= 500) {
                for (i = 1; i <= n; i++)
                    sb1.append(i).append(" 1\n");
                sb.append(sb1);
                continue;
            }
            else{
                sb1.append("1 1\n2 2\n3 3\n4 4\n4 3\n4 2\n4 1\n");
                int sum=11;
                for(i=5;i<=500;i++){
                    if(n-(sum+1)==(i-1)){
                        sb1.append(i).append(" 1\n").append(i+" 2\n");
                        break;
                    }
                    sb1.append(i+" 1\n");
                }
                sb.append(sb1);
            }


        }
        System.out.print(sb);


    }
}

class FastReader {

    byte[] buf = new byte[2048];
    int index, total;
    InputStream in;

    FastReader(InputStream is) {
        in = is;
    }

    int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0) {
                return -1;
            }
        }
        return buf[index++];
    }

    String next() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c > 32; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }

    int nextInt() throws IOException {
        int c, val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }

    long nextLong() throws IOException {
        int c;
        long val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }
}
