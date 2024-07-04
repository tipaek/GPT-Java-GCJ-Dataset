import java.math.*;
import java.io.*;
import java.util.*;
import java.awt.*;
public class Solution {
    static Helper hp;
    final static int MAXN = 1000_006;
    final static long MOD = (long) 1e9 + 7;
    public static void main(String []args)throws Exception
    {
        hp=new Helper(MOD,MAXN);
        //hp.initIO("input.txt","output.txt");
        hp.initIO(System.in,System.out);
        solve();
    }
    static void solve()throws Exception{
        boolean testCases = true;
   	    int tc = testCases ? hp.nextInt() : 1,n=hp.nextInt();
        for (int tce = 1; tce <= tc; tce++) {
        	int ques=0;
        	int diffx=0,diffy=0,samex=0,samey=0,flag1=0,flag2=0;
        	int b[]=new int[n+1];
     		for(int i=1;i<=n/2;i+=5)
     		{
     			for(int j=i;j<i+5;j++)
     			{
     				ques+=2;
     				hp.println(j);
     				hp.flush();
     				b[j]=hp.nextInt();
     				hp.println(n-j+1);
     				hp.flush();
     				b[n-j+1]=hp.nextInt();
     				if(b[j]==b[n-j+1])
     				{
     					samex=j;
     					samey=n-j+1;
     					flag1=1;
     				}
     				if(b[j]!=b[n-j+1])
     				{
     					diffx=j;
     					diffy=n-j+1;
     					flag2=1;
     				}
     			}
     			{
     				int x1=0,x2=0;
     				if(samex!=0)
     				{
     					ques++;
     					hp.println(samex);
     					hp.flush();
     					x1=hp.nextInt();
     				}
     				if(diffx!=0)
     				{
     					ques++;
     					hp.println(diffx);
     					hp.flush();
     					x2=hp.nextInt();
     				}
     				if(x1!=b[samex] && x2!=b[diffx])
     				{
     					for(int j=1;j<i+5;j++)
     					{
     						b[j]=Math.abs(1-b[j]);
     						b[n-j+1]=Math.abs(1-b[n-j+1]);
     					}
     				}
     				else if(x1!=b[samex] && x2==b[diffx])
     				{
     					for(int j=1;j<i+5;j++)
     					{
     						int temp=b[j];
     						b[j]=Math.abs(1-b[n-j+1]);
     						b[n-j+1]=Math.abs(1-temp);
     					}
     				}
     				else if(x1==b[samex] && x2!=b[diffx])
     				{
     					for(int j=1;j<i+5;j++)
     					{
     						int temp=b[j];
     						b[j]=b[n-j+1];
     						b[n-j+1]=temp;
     					}
     				}
     			}
     		}
     		StringBuilder sb=new StringBuilder();
     		for(int i=1;i<=n;i++)
     		{
     			sb.append(b[i]+" ");
     		}
     		hp.println(sb);
     		hp.flush();
        }
        hp.flush();
    }

}
class Point implements Comparable<Point>
{
	int x,y,index;
	Point(int xx,int yy,int index)
	{
		x=xx;
		y=yy;
		this.index=index;
	}
	public int compareTo(Point p)
	{
		if(x-p.x!=0)
			return x-p.x;
		else
			return y-p.y;
	}
	public String toString()
	{
		return x+" "+y;
	} 
}
class Helper {
    final long MOD;
    final int MAXN;
    final Random rnd;

    public Helper(long mod, int maxn) {
        MOD = mod;
        MAXN = maxn;
        rnd = new Random();
    }


    public static int[] sieve;
    public static ArrayList<Integer> primes;

    public void setSieve() {
        primes = new ArrayList<>();
        sieve = new int[MAXN];
        int i, j;
        for (i = 2; i < MAXN; ++i)
            if (sieve[i] == 0) {
                primes.add(i);
                for (j = i; j < MAXN; j += i) {
                    sieve[j] = i;
                }
            }
    }


    public static long[] factorial;

    public void setFactorial() {
        factorial = new long[MAXN];
        factorial[0] = 1;
        for (int i = 1; i < MAXN; ++i) factorial[i] = factorial[i - 1] * i % MOD;
    }

    public long getFactorial(int n) {
        if (factorial == null) setFactorial();
        return factorial[n];
    }

    public long ncr(int n, int r) {
        if (r > n) return 0;
        if (factorial == null) setFactorial();
        long numerator = factorial[n];
        long denominator = factorial[r] * factorial[n - r] % MOD;
        return numerator * pow(denominator, MOD - 2, MOD) % MOD;
    }


    public long[] getLongArray(int size) throws Exception {
        long[] ar = new long[size];
        for (int i = 0; i < size; ++i) ar[i] = nextLong();
        return ar;
    }

    public int[] getIntArray(int size) throws Exception {
        int[] ar = new int[size];
        for (int i = 0; i < size; ++i) ar[i] = nextInt();
        return ar;
    }

    public String[] getStringArray(int size) throws Exception {
        String[] ar = new String[size];
        for (int i = 0; i < size; ++i) ar[i] = next();
        return ar;
    }

    public String joinElements(long... ar) {
        StringBuilder sb = new StringBuilder();
        for (long itr : ar) sb.append(itr).append(" ");
        return sb.toString().trim();
    }


    public String joinElements(int... ar) {
        StringBuilder sb = new StringBuilder();
        for (int itr : ar) sb.append(itr).append(" ");
        return sb.toString().trim();
    }

    public String joinElements(String... ar) {
        StringBuilder sb = new StringBuilder();
        for (String itr : ar) sb.append(itr).append(" ");
        return sb.toString().trim();
    }

    public String joinElements(Object... ar) {
        StringBuilder sb = new StringBuilder();
        for (Object itr : ar) sb.append(itr).append(" ");
        return sb.toString().trim();
    }


    public long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


    public long max(long... ar) {
        long ret = ar[0];
        for (long itr : ar) ret = Math.max(ret, itr);
        return ret;
    }

    public int max(int... ar) {
        int ret = ar[0];
        for (int itr : ar) ret = Math.max(ret, itr);
        return ret;
    }

    public long min(long... ar) {
        long ret = ar[0];
        for (long itr : ar) ret = Math.min(ret, itr);
        return ret;
    }

    public int min(int... ar) {
        int ret = ar[0];
        for (int itr : ar) ret = Math.min(ret, itr);
        return ret;
    }


    public long sum(long... ar) {
        long sum = 0;
        for (long itr : ar) sum += itr;
        return sum;
    }

    public long sum(int... ar) {
        long sum = 0;
        for (int itr : ar) sum += itr;
        return sum;
    }

    public long pow(long base, long exp, long MOD) {
        base %= MOD;
        long ret = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) ret = ret * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return ret;
    }


    static final int BUFSIZE = 1 << 20;
    static byte[] buf;
    static int index, total;
    static InputStream in;
    static BufferedWriter bw;


    public void initIO(InputStream is, OutputStream os) {
        try {
            in = is;
            bw = new BufferedWriter(new OutputStreamWriter(os));
            buf = new byte[BUFSIZE];
        } catch (Exception e) {
        }
    }

    public void initIO(String inputFile, String outputFile) {
        try {
            in = new FileInputStream(inputFile);
            bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(outputFile)));
            buf = new byte[BUFSIZE];
        } catch (Exception e) {
        }
    }

    private int scan() throws Exception {
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0)
                return -1;
        }
        return buf[index++];
    }

    public String next() throws Exception {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c > 32; c = scan())
            sb.append((char) c);
        return sb.toString();
    }

    public int nextInt() throws Exception {
        int c, val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+')
            c = scan();
        for (; c >= '0' && c <= '9'; c = scan())
            val = (val << 3) + (val << 1) + (c & 15);
        return neg ? -val : val;
    }

    public long nextLong() throws Exception {
        int c;
        long val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+')
            c = scan();
        for (; c >= '0' && c <= '9'; c = scan())
            val = (val << 3) + (val << 1) + (c & 15);
        return neg ? -val : val;
    }

    public void print(Object a) throws Exception {
        bw.write(a.toString());
    }

    public void printsp(Object a) throws Exception {
        print(a);
        print(" ");
    }

    public void println() throws Exception {
        bw.write("\n");
    }

    public void println(Object a) throws Exception {
        print(a);
        println();
    }

    public void flush() throws Exception {
        bw.flush();
    }
}
