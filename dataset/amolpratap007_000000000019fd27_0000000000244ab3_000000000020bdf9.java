import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.util.*;
import java.lang.*;
import java.util.HashMap;
import java.util.PriorityQueue;
public class Solution implements Runnable
{
    static class pair implements Comparable
    {
        int f;
        int s;
        pair(int fi, int se)
        {
            f=fi;
            s=se;
        }
        public int compareTo(Object o)//desc order
        {
            pair pr=(pair)o;
            if(s>pr.s)
                return -1;
            if(s==pr.s)
            {
                if(f>pr.f)
                    return 1;
                else
                    return -1;
            }
            else
                return 1;
        }
        public boolean equals(Object o)
        {
            pair ob=(pair)o;
            if(o!=null)
            {
                if((ob.f==this.f)&&(ob.s==this.s))
                    return true;
            }
            return false;
        }
        public int hashCode()
        {
            return (this.f+" "+this.s).hashCode();
        }
    }
    public class triplet implements Comparable
    {
        int f;
        int s;
        int t;
        triplet(int f,int s,int t)
        {
            this.f=f;
            this.s=s;
            this.t=t;
        }
        public boolean equals(Object o)
        {
            triplet ob=(triplet)o;
            if(o!=null)
            {
                if((ob.f==this.f)&&(ob.s==this.s)&&(ob.t==this.t))
                    return true;
            }
            return false;
        }
        public int hashCode()
        {
            return (this.f+" "+this.s+" "+this.t).hashCode();
        }
        public int compareTo(Object o)//asc order
        {
            triplet tr=(triplet)o;
            if(s>tr.s)
                return 1;
            else
                return -1;
        }
    }
    void merge1(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int [n1];
        int R[] = new int [n2];
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i]<=R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    void sort1(int arr[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
            sort1(arr, l, m);
            sort1(arr , m+1, r);
            merge1(arr, l, m, r);
        }
    }
    public static void main(String args[])throws Exception
    {
        new Thread(null,new Solution(),"Solution",1<<27).start();
    }
    public void run()
    {
        try
        {
            InputReader in = new InputReader(System.in);
            PrintWriter out = new PrintWriter(System.out);
            int t=in.ni();
            for(int q=1;q<=t;q++)
            {
                out.print("Case #"+q+": ");
                int n=in.ni();
                int start[]=new int[n+1];
                int end[]=new int[n+1];
                int a[]=new int[1500];
                for(int i=1;i<=n;i++)
                {
                    start[i]=in.ni();
                    end[i]=in.ni();
                    a[start[i]]++;
                    a[end[i]]--;
                }
                int ans[]=new int[n+1];
                int k=0;
                for(int i=0;i<1500;i++)
                {
                    k+=a[i];
                    if(k>2)
                        break;
                }
                if(k>2)
                    out.println("IMPOSSIBLE");
                else
                {
                    PriorityQueue<triplet>pq=new PriorityQueue<>();
                    for(int i=1;i<=n;i++)
                        pq.add(new triplet(i,start[i],end[i]));
                    int y=0;
                    for(int i=1;i<=n;i++)
                    {
                        triplet tt=pq.remove();
                        if(tt.s>=y)
                        {
                            ans[tt.f]=1;
                            y=tt.t;
                        }
                        else
                            ans[tt.f]=0;
                    }
                    for(int i=1;i<=n;i++)
                    {
                        if(ans[i]==0)
                            out.print("C");
                        else
                            out.print("J");
                    }
                    out.println();
                }
            }
            out.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int ni() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nl() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ni();
            }
            return a;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

    }
}