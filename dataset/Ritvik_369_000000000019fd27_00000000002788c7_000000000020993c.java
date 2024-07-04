import java.io.*;
import java.util.*;
class LMAT
{
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
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
        public String nextString() throws IOException
        {
            String str00 = scan.next();
            return str00;
        }
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64];
            int cnt = 0, c;
            while ((c = read()) != -1)  
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
        String next() throws IOException 
        {
            int c;
            for (c = read(); c <= 32; c = read());
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = read())
            {
                sb.append((char) c);
            }
            return sb.toString();
        }
        public int nextInt() throws IOException 
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
        public long nextLong() throws IOException 
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
        public double nextDouble() throws IOException
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
        public int[] nextArray(int n) throws IOException 
        {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = nextInt();
            }
            return a;
        }
    }
    public static void main(String args[])throws IOException
    {
        Reader r=new Reader();
        int t=r.nextInt();
        for(int z=1;z<=t;z++)
        {
            int n=r.nextInt();
            int a[][]=new int[n][n];
            int c[]=new int[n];
            int tr=0,sumr=0,sumc=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=r.nextInt();
                }
            }
            for(int i=0;i<n;i++)
            {
                tr+=a[i][i];
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    c[j]=0;
                }
                for(int j=0;j<n;j++)
                {
                    if(c[a[i][j]-1]==1)
                    {
                        sumr++;
                        break;
                    }
                    else
                    {
                        c[a[i][j]-1]++;
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    c[j]=0;
                }
                for(int j=0;j<n;j++)
                {
                    if(c[a[j][i]-1]==1)
                    {
                        sumc++;
                        break;
                    }
                    else
                    {
                        c[a[j][i]-1]++;
                    }
                }
            }
            System.out.println("Case #"+z+":"+" "+tr+" "+sumr+" "+sumc);
        }
    }
}