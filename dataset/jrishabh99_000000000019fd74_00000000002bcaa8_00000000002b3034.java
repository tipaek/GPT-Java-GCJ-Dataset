import java.math.*;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
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
   	    int tc = testCases ? hp.nextInt() : 1;
   	    
        for (int tce = 1; tce <= tc; tce++) {
        	int n=hp.nextInt(),flag=0;
        	String s[]=new String[n];
        	for(int i=0;i<n;i++)
        		s[i]=hp.next();
        	String prefix="",suffix="",ans="";
        	for(int i=0;i<n;i++)
        	{
        		//hp.println(s[i]);
        		int l=s[i].length();
				String z[]=s[i].split("\\*");
				int l1=z.length,last=s[i].lastIndexOf("*");
				boolean check=false;
				for(int j=0;j<last;j++)
				{
					if(check && s[i].charAt(j)!='*')
						ans+=s[i].charAt(j);
					if(s[i].charAt(j)=='*')check=true;
				}
        		if(s[i].charAt(l-1)!='*')
        		{
        			if(suffix.equals(""))
        			{
        				suffix=z[l1-1];
        			}
        			else if(z[l1-1].endsWith(suffix))
        			{
        				suffix=z[l1-1];
        			}
        			else if(suffix.endsWith(z[l1-1]))
        			{

        			}
        			else
        			{
        				flag=1;break;
        			}
        		}
        		if(s[i].charAt(0)!='*')
        		{
        			if(prefix.equals(""))
        			{
        				prefix=z[0];
        			}
        			else if(z[0].startsWith(prefix))
        				prefix=z[0];
        			else if(prefix.startsWith(z[0]))
        			{

        			}
        			else
        			{
        				flag=1;
        				break;
        			}
        		}
        		//hp.println(suffix+" "+prefix);
        	}
        	if(flag==1)
        	{
        		hp.println("Case #"+tce+": *");
        	}
        	else
        		hp.println("Case #"+tce+": "+prefix+ans+suffix);
        }
        hp.flush();
    }
}
class Myclass
{
	int x,y;
	Myclass(int xx,int yy)
	{
		x=xx;
		y=yy;
	}
	public int compareTo(Myclass p)
	{
		return 0;
	}
	public int hashCode()
	{
		return x*31+y*67;
	}
	public boolean equals(Object o)
	{
		if(o==this)return true;
		if(!(o instanceof Myclass))return false;
		Myclass p=(Myclass)o;
		if(p.x==x && p.y==y)return true;
		return false;
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