import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String[] args)throws IOException
    {
        Reader in = new Reader();
        int t = in.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int tt= 1;tt<=t;tt++)
        {
            long x = in.nextLong();
            long y = in.nextLong();
            long dx = Math.abs(x);
            long dy = Math.abs(y);
            long[] A = new long[100];
            long[] B = new long[100];
            long maxForX = 0L;
            int id = 0;
            while (dx != 0)
            {
                A[id] = dx % 2;
                dx /= 2;
                id++;
            }
            maxForX = Math.max(maxForX, id);
            id = 0;
            while (dy != 0)
            {
                B[id] = dy % 2;
                dy /= 2;
                id++;
            }
            maxForX = Math.max(maxForX, id);
            boolean pos = true;
            for (int i=0;i<maxForX;i++)
            {
                if (A[i] == 1 && B[i] == 1)
                {
                    boolean haha = false;
                    if(i - 1 >=0 && A[i-1]==1)
                    {
                        A[i-1] = -1;
                        int j = i;
                        while(A[j] == 1)
                        {
                            A[j]=0;
                            j++;
                        }
                        A[j] = 1L;
                        maxForX = Math.max(maxForX,j);
                        haha = true;
                    }
                    else if(i-1 >= 0 && B[i-1] == 1)
                    {
                        B[i-1] = -1;
                        int j = i;
                        while(B[j] == 1)
                        {
                            B[j] = 0;
                            j++;
                        }
                        maxForX = Math.max(maxForX,j);
                        B[j] = 1;
                        haha=true;
                    }
                    if (!haha)
                    {
                        pos = false;
                        break;
                    }
                }
                else if (A[i] == 0 && B[i] == 0)
                {
                    boolean haha = false;
                    if(i-1>=0 && A[i-1]==1)
                    {
                        A[i-1] = -1;
                        int j = i;
                        while(A[j]==1)
                        {
                            A[j]=0;
                            j++;
                        }
                        A[j]=1;
                        maxForX = Math.max(maxForX, j);
                        haha = true;
                    }
                    else if(i-1 >= 0 && B[i-1] == 1)
                    {
                        B[i-1] = -1;
                        int j = i;
                        while(B[j] == 1)
                        {
                            B[j] = 0;
                            j++;
                        }
                        maxForX = Math.max(maxForX,j);
                        B[j] = 1;
                        haha = true;
                    }

                    if(!haha)
                    {
                        pos=false;
                        break;
                    }
                }
            }
            stringBuilder.append("Case #").append(tt).append(": ");
            if (!pos)
            {
                stringBuilder.append("IMPOSSIBLE");
            }
            else
            {
                StringBuilder stringBuilder1 = new StringBuilder();
                for (int i=0;i<100;i++)
                {
                    if (A[i] == 0 && B[i] == 0)
                        break;
                    else if (A[i] == 1 && B[i] == 0)
                    {
                        if (x >= 0)
                            stringBuilder1.append("E");
                        else
                            stringBuilder1.append("W");
                    }
                    else if (A[i] == -1 && B[i] == 0)
                    {
                        if (x >= 0)
                            stringBuilder1.append("W");
                        else
                            stringBuilder1.append("E");
                    }
                    else if (B[i] == 1 && A[i] == 0)
                    {
                        if (y >= 0)
                            stringBuilder1.append("N");
                        else
                            stringBuilder1.append("S");
                    }
                    else if (B[i] == -1 && A[i] == 0)
                    {
                        if (y >= 0)
                            stringBuilder1.append("S");
                        else
                            stringBuilder1.append("N");
                    }
                }
                stringBuilder.append(stringBuilder1);
            }
            if (tt < t)
                stringBuilder.append("\n");
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