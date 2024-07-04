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
            if(t>tr.t)
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
    String inttobin(long x)
    {
        String s="";
        while(x!=0)
        {
            long k=x%2;
            if(k==1)
                s="1"+s;
            else
                s="0"+s;
            x=x/2;
        }
        return s;
    }
    String twoscomp(String s)
    {
        int n=s.length();
        String onec="",twoc="";
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='0')
                onec+="1";
            else
                onec+="0";
        }
        int i;
        twoc=onec;
        for (i = n - 1; i >= 0; i--)
        {
            if (onec.charAt(i) == '1')
            {
                twoc = twoc.substring(0, i) + '0' + twoc.substring(i + 1);
            }
            else
            {
                twoc = twoc.substring(0, i) + '1' + twoc.substring(i + 1);
                break;
            }
        }
        if (i == -1)
            twoc = '1' + twoc;
        return twoc;
    }
    public static void main(String args[])throws Exception
    {
        new Thread(null,new Solution(),"Solution",1<<27).start();
    }
    String equ(String s,int max)
    {
        int l=s.length();
        while(l<max)
        {
            s=s+"0";
            l++;
        }
        return s;
    }
    String find(String s1,int k1,String s2,int k2)
    {
        int l1=s1.length();
        int l2=s2.length();
        int max=Math.max(l1,l2);
        s1=equ(s1,max);
        s2=equ(s2,max);
        String ans="";
        int k=0;
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)==s2.charAt(i))
            {
                k=1;
                break;
            }
            if(s1.charAt(i)=='1')
            {
                if(k1==-1)
                    ans+='E';
                else
                {
                    if(i==k1)
                        ans+='E';
                    else
                        ans += 'W';
                }
            }
            if(s2.charAt(i)=='1')
            {
                if(k2==-1)
                    ans+='N';
                else
                {
                    if(i==k2)
                        ans+='N';
                    else
                        ans += 'S';
                }
            }
        }
        if(k==1)
            return "";
        else
            return ans;
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
                long xx=in.nl();
                long yy=in.nl();
                long x=Math.abs(xx);
                long y=Math.abs(yy);
                String s11=inttobin(x);
                String s21=inttobin(y);
                String s12=twoscomp(s11);
                String s22=twoscomp(s21);
                s12="1"+s12;
                int k1=s12.length()-1;
                s22="1"+s22;
                int k2=s22.length()-1;
                StringBuilder sb=new StringBuilder(s11);
                s11=sb.reverse().toString();
                sb=new StringBuilder(s12);
                s12=sb.reverse().toString();
                sb=new StringBuilder(s21);
                s21=sb.reverse().toString();
                sb=new StringBuilder(s22);
                s22=sb.reverse().toString();
                String ans="";
                String s=find(s11,-1,s21,-1);
                //out.println(s);
                if(s.length()!=0)
                {
                    if(ans.equals(""))
                        ans=s;
                    else
                    {
                        if(s.length()<ans.length())
                            ans=s;
                    }
                }
                s=find(s11,-1,s22,k2);
                //out.println(s);
                if(s.length()!=0)
                {
                    if(ans.equals(""))
                        ans=s;
                    else
                    {
                        if(s.length()<ans.length())
                            ans=s;
                    }
                }
                s=find(s12,k1,s21,-1);
                //out.println(s);
                if(s.length()!=0)
                {
                    if(ans.equals(""))
                        ans=s;
                    else
                    {
                        if(s.length()<ans.length())
                            ans=s;
                    }
                }
                s=find(s12,k1,s22,k2);
                //out.println(s);
                if(s.length()!=0)
                {
                    if(ans.equals(""))
                        ans=s;
                    else
                    {
                        if(s.length()<ans.length())
                            ans=s;
                    }
                }
                if(ans.length()==0)
                    out.println("IMPOSSIBLE");
                else
                {
                    char c[]=ans.toCharArray();
                    int ll=ans.length();
                    if(xx<0)
                    {
                        for(int i=0;i<ll;i++)
                        {
                            if(c[i]=='E')
                                c[i]='W';
                            else if(c[i]=='W')
                                c[i]='E';
                        }
                    }
                    if(yy<0)
                    {
                        for(int i=0;i<ll;i++)
                        {
                            if(c[i]=='N')
                                c[i]='S';
                            else if(c[i]=='S')
                                c[i]='N';
                        }
                    }
                    ans="";
                    for(int i=0;i<ll;i++)
                        ans+=c[i];
                    out.println(ans);
                }
            }
            out.close();
        }
        catch(Exception e){
            System.out.println(e);
            //throw new RuntimeException();
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