import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String[] args)throws IOException
    {
        Reader in = new Reader();
        int t = in.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int testCase = 1;testCase <= t;testCase++)
        {
            stringBuilder.append("Case #").append(testCase).append(": ");
            int n = in.nextInt();
            long[][] A = new long[n][n];
            for (int i=0;i<n;i++)   for (int j=0;j<n;j++)   A[i][j] = in.nextLong();
            long trace = 0L;
            for (int i=0;i<n;i++)   trace += A[i][i];
            int c1 = 0;
            int c2 = 0;
            for (int i=0;i<n;i++)
            {
                HashSet<Long> h = new HashSet<>();
                for (int j=0;j<n;j++)
                {
                    if (h.contains(A[i][j]))
                    {
                        c1++;
                        break;
                    }
                    else
                        h.add(A[i][j]);
                }
            }
            for (int i=0;i<n;i++)
            {
                HashSet<Long> h = new HashSet<>();
                for (int j=0;j<n;j++)
                {
                    if (h.contains(A[j][i]))
                    {
                        c2++;
                        break;
                    }
                    else
                        h.add(A[j][i]);
                }
            }
            stringBuilder.append(trace).append(" ").append(c1).append(" ").append(c2).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
class Reader
{
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

    public String readLine() throws IOException
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
        }  while ((c = read()) >= '0' && c <= '9');

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
}