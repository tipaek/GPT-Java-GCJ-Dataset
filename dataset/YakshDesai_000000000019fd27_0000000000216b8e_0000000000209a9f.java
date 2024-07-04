import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{


    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    static int gcd(int a, int b) {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
    }

    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        int t = r.nextInt();
        int flag = 0;
        while (t-- > 0) {
            flag++;
            String str = r.readLine();
            StringBuffer ans = new StringBuffer();
            int active = Integer.parseInt(String.valueOf(str.charAt(0)));
            for(int i=0;i<active;i++) ans.append('(');
            ans.append(str.charAt(0));
            for(int i = 1; i < str.length(); i++){
                if(str.charAt(i)==str.charAt(i-1)) ans.append(str.charAt(i));
                else if(str.charAt(i)<str.charAt(i-1)){
                    int diff = Integer.parseInt(String.valueOf(str.charAt(i-1))) - Integer.parseInt(String.valueOf(str.charAt(i)));
                    active-=diff;
                    while(diff-->0){
                        ans.append(')');
                    }ans.append(str.charAt(i));
                }else{
                    int diff = Integer.parseInt(String.valueOf(str.charAt(i))) - Integer.parseInt(String.valueOf(str.charAt(i-1)));

                    active+=diff;
                    while(diff-->0) {
                        ans.append('(');
                    }
                    ans.append(str.charAt(i));
                }
            }
            while(active-->0) ans.append(')');
            System.out.println("Case #"+flag+": " + ans);
        }
    }
}


