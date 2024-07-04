import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int z=0;z<t;z++)
        {
            int n = Integer.parseInt(in.readLine());
            String[] A = new String[n];
            for (int i=0;i<n;i++)   A[i] = in.readLine();
            int maxx = 0;
            int maxi = -1;
            StringBuilder res = new StringBuilder();
            for (int i=0;i<10000;i++)
                res.append("#");
            int maxLen = 10000;
            boolean flag = true;
            for (int i=0;i<n;i++)
            {
                for (int j=0;j<A[i].length();j++)
                {
                    if (A[i].charAt(j) == '*')
                        break;
                    else
                    {
                        if (res.charAt(j) == '#')
                            res.setCharAt(j, A[i].charAt(j));
                        else
                        {
                            if (res.charAt(j) != A[i].charAt(j))
                            {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                for (int j=A[i].length() - 1;j>=0;j--)
                {
                    if (A[i].charAt(j) == '*')
                        break;
                    else
                    {
                        if (res.charAt(maxLen - A[i].length() + j) == '#')
                            res.setCharAt(maxLen - A[i].length() + j, A[i].charAt(j));
                        else
                        {
                            if (res.charAt(maxLen - A[i].length() + j) != A[i].charAt(j))
                            {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
            }
            if (!flag)
                stringBuilder.append("Case #").append(z + 1).append(": ").append("*");
            else
            {
                StringBuilder pref = new StringBuilder();
                StringBuilder suff = new StringBuilder();
                for (int i=0;i<maxLen;i++)
                {
                    if (res.charAt(i) != '#')
                        pref.append(res.charAt(i));
                    else
                        break;
                }
                for (int i=maxLen - 1;i>=0;i--)
                {
                    if (res.charAt(i) != '#')
                        suff.append(res.charAt(i));
                    else
                        break;
                }
                suff.reverse();
                for (int i=0;i<n;i++)
                {
                    int c = 0;
                    int idx = 0;
                    for (int j=0;j<A[i].length();j++)
                    {
                        if (A[i].charAt(j) == '*')
                        {
                            c++;
                            idx = j;
                        }
                    }
                    if (c > 1)
                    {
                        StringBuilder temp = new StringBuilder();
                        boolean ff = true;
                        for (int j=0;j<idx;j++)
                        {
                            if (A[i].charAt(j) == '*')
                            {
                                if (ff)
                                    ff = false;
                                else
                                {
                                    if (!ff)
                                        temp.append(A[i].charAt(j));
                                }
                            }
                        }
                        pref.append(temp);
                    }
                }
                pref.append(suff);
                stringBuilder.append("Case #").append(z + 1).append(": ").append(pref);
            }
            if (z < t - 1)
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