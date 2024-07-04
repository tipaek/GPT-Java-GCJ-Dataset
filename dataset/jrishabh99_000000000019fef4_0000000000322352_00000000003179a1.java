import java.math.*;
import java.io.*;
import java.awt.*;
import java.util.*;
public class Solution {
    static Helper hp;
    final static int MAXN = 1000_006;
    final static long MOD = (long) 1000000007;
    final static long MOD1 = (long) 998244353;
	public static void debug(Object s)throws Exception{
		if(hp.debugger)System.out.println(s.toString());
	}
	public static void debug(Object a[])throws Exception{
		if(hp.debugger)System.out.println(Arrays.toString(a));
	}
    public static void main(String []args)throws Exception
   	{
        hp=new Helper(MOD,MAXN);
        //hp.initIO("sample.in.txt","output.txt");
        hp.initIO(System.in,System.out);
        solve();
    }
    static void solve()throws Exception{
        boolean testCases = true;
   	    int tc = testCases ? hp.nextInt() : 1;
        for (int tce = 1; tce <= tc; tce++) {
        	hp.print("Case #"+tce+": ");
        	int u=hp.nextInt();
        	if(u!=2)continue;
        	HashSet<String> p[]=new HashSet[101];
        	for(int i=0;i<101;i++)p[i]=new HashSet<>();
        	String charSet="";
        	HashSet<Character> set=new HashSet<>();
        	String ans[]=new String[10];
        	for(int i=0;i<10000;i++)
        	{
        		int q=hp.nextInt();
        		String s=hp.next();
        		if(q<=10)
        		{
        			p[q].add(s);
        		}
        		for(int j=0;j<s.length();j++)
        		{
        			if(set.contains(s.charAt(j)))continue;
        			set.add(s.charAt(j));
        			charSet+=s.charAt(j);
        		}
        	}
        	StringBuilder sb=new StringBuilder();
        	for(int i=1;i<=9;i++)
        	{
        		for(String s:p[i])
        		{
        			if(set.contains(s.charAt(0)))
        			{
        				set.remove(s.charAt(0));
        				sb.append(s);
        				break;
        			}
        		}
        	}
        	for(int i=0;i<10;i++)
        	{
        		if(set.contains(charSet.charAt(i)))
        		{
        			hp.print(charSet.charAt(i));
        			break;
        		}
        	}
        	hp.println(sb);
      	}
        hp.flush();
    }
    
}
class Myclass
{
	int index,count,length;
	Myclass()
	{
		index=0;
	}
	Myclass(int index,int count,int length)
	{
		this.index=index;this.count=count;
		this.length=length;
	}
	public String toString()
	{
		return "("+index +","+count+","+length+")";
	}
	public int hashCode()
	{
		return index*3+count*7;
	}
	public boolean equals(Object o)
	{
		if(o==this)return true;
		if(!(o instanceof Myclass))return false;
		Myclass p=(Myclass)o;
		if(p.index==index&& p.count==count)return true;
		return false;
	}
}
class Helper {
    final long MOD;
    final int MAXN;
    final Random rnd;
    boolean debugger;
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
        for(i=0;i<MAXN;i++) sieve[i]=i;
        for (i = 2; i*i< MAXN; ++i)
        {
            if (sieve[i] == i) {
                for (j = i*i;j < MAXN; j += i) {
                	if(sieve[j]==j)
                    sieve[j] = i;
                }
            }
        }
        for(i=2;i<MAXN;i++)if(sieve[i]==i)primes.add(i);
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


    public Long[] getLongArray(int size) throws Exception {
        Long[] ar = new Long[size];
        for (int i = 0; i < size; ++i) ar[i] = new Long(nextLong());
        return ar;
    }

    public Integer[] getIntArray(int size) throws Exception {
        Integer[] ar = new Integer[size];
        for (int i = 0; i < size; ++i) ar[i] = new Integer(nextInt());
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
    public int max(int ... ar)
    {
    	int max=ar[0];
    	for(int itr:ar)
    		max=Math.max(max,itr);
    	return max;
    }
    public long max(long ... ar){
    	long max=ar[0];
    	for(long itr:ar)max=Math.max(max,itr);
    	return max;
    }
    public <T extends Comparable<T>> T max(T ... ar)
    {
    	T max=ar[0];
    	for(T itr:ar) max=itr.compareTo(max)>0?itr:max;
    	return max;
    }
    public <T extends Comparable<T>> T min(T ... ar)
    {
    	T min=ar[0];
    	for(T itr:ar) min=itr.compareTo(min)<0?itr:min;
    	return min;	
    }
    public Long sum(Long... arr)
    {
    	Long sum=new Long(0);
    	for(Long itr:arr)sum+=itr;
    	return sum;
    }
    public Long sum(Integer ... arr)
    {
    	Long sum=new Long(0);
    	for(Integer itr:arr)sum+=itr;
    	return sum;
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
        	debugger=false;
            in = is;
            bw = new BufferedWriter(new OutputStreamWriter(os));
            buf = new byte[BUFSIZE];
        } catch (Exception e) {
        }
    }

    public void initIO(String inputFile, String outputFile) {
        try {
        	debugger=true;
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