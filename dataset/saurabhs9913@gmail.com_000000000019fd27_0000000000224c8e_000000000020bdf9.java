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
            Game[] A = new Game[n];
            for (int i=0;i<n;i++)   A[i] = new Game(in.nextInt(), in.nextInt(), i);
            Arrays.sort(A);
            boolean flag = true;
            int assign = 0;
            int[] ans = new int[n];
            for (int i=0;i<n;i++)
            {
                ans[A[i].index] = assign;
                if (i < n - 1 && A[i + 1].s < A[i].e) assign = (assign + 1) % 2;
            }
            outer: for (int i=0;i<n;i++)
            {
                for (int j=0;j<n;j++)
                {
                    if (i != j && ans[A[i].index] == ans[A[j].index] && checkIntersection(A[i].s, A[i].e, A[j].s, A[j].e))
                    {
                        flag = false;
                        break outer;
                    }
                }
            }
            if (flag)
            {
                for (int i=0;i<n;i++)
                {
                    if (ans[i] == 0)
                        stringBuilder.append("C");
                    else
                        stringBuilder.append("J");
                }
                stringBuilder.append("\n");
            }
            else
                stringBuilder.append("IMPOSSIBLE\n");
        }
        System.out.println(stringBuilder);
    }
    public static boolean checkIntersection(int l1, int r1, int l2, int r2)
    {
        if (r1 <= l2 || r2 <= l1)   return false;
        return true;
    }
}
class Game implements Comparable<Game>
{
    int s;
    int e;
    int index;

    public Game(int s, int e, int index)
    {
        this.s = s;
        this.e = e;
        this.index = index;
    }

    @Override
    public int compareTo(Game ob)
    {
        return this.s - ob.s;
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