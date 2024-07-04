import java.util.*;
import java.io.*;
import static java.lang.Math.*;
public class Solution {
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String nextLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int ni() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nl() throws IOException
        {
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

        public double nd() throws IOException
        {
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

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
    public static void main(String[] args) throws IOException {
        new Thread(null,null,"BaZ",1<<25)
        {
            public void run()
            {
                try
                {
                    Freak();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }
    static long modPow(long x,long p,long m) {
        if(p==0)
            return 1;
        if(p%2==0)
            return modPow((x*x)%m,p>>1,m)%m;
        return x*(modPow(x,p-1,m)%m)%m;
    }
    static long mul(long a,long b,long m) {
        a%=m;
        b%=m;
        return (a*b)%m;
    }
    //global variable
//    static Reader sc = new Reader();
    static StringBuilder sb = new StringBuilder();
    static PrintWriter pw = new PrintWriter(System.out,true);
    static final int MAX = 300000;
    static long BIT[] = new long[MAX+1];
    static int x=0,y=0;
    static int posi=0,negi=0,posj=0,negj=0;
    static boolean bool = false;
    static Scanner sc = new Scanner(System.in);
    static void Freak() throws IOException {
        int test = sc.nextInt();
        for(int t=1;t<=test;t++) {
            sb.append("Case #" + t + ": ");

            //code here
            int x= sc.nextInt(), y = sc.nextInt();
            char arr[]= sc.next().toCharArray();
            int n = arr.length;
            for(int i =0;i<n;i++) {
                if(arr[i]=='N')
                    y++;
                else if(arr[i]=='S')
                    y--;
                else if(arr[i]=='E')
                    x++;
                else
                    x--;
                if(abs(x)+abs(y)<=i+1) {
                    n=0;
                    sb.append(i+1 +"\n");
                    break;
                }
            }
            if(n>0)
                sb.append("IMPOSSIBLE\n");
        }
        pw.print(sb);
        pw.flush();
        pw.close();
    }
    static class Pair implements Comparable<Pair> {
        long x,y;
        int idx;
        char ch;
        Pair(long x, long y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
        public int compareTo(Pair other) {
            if(this.x>other.x) {
                return 1;
            }
            else if(this.x<other.x) {
                return -1;
            }
            else if(this.y>other.y) {
                return 1;
            }
            else if(this.y<other.y) {
                return -1;
            }
            return 0;
        }
        public String toString() {
            return "{" + x+ ", " + y +"}";
        }
    }
}
/*
2
2 3
1 2
3 3
2 5
2 2
10 30
 */
