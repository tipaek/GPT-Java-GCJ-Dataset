import java.util.*;import java.io.*;import java.math.*;
public class Solution
{
    public static void process(int Ccase)throws IOException
    {
       	long x=nl();
       	long y=nl();
      	StringBuffer ans = new StringBuffer();
      	char n='N';
      	char s='S';
      	char w='W';
      	char e='E';
      	if(x<0)
      	{
      		x=Math.abs(x);
      		e='W';
      		w='E';
      	}
      	if(y<0)
      	{
      		y=Math.abs(y);
      		n='S';
      		s='N';
      	}
      	if(x+y==1)
      	{
      		if(x==1)
      			ans.append(e);
      		else
      			ans.append(n);
      	}
      	else if(pow(x+y)>0 || x+y%2==0)
      		ans.append("IMPOSSIBLE");
      	else
      	{
      		if(x==0)
      		{
      			int temp=pow(y+1);
      			for(int i=0;i<temp;i++)
      				ans.append(n);
      			if(temp>-1)
      			{
      				pn("Case #"+Ccase+": "+ans.toString());
      				return;
      			}
      		}
      		if(y==0)
      		{
      			int temp=pow(x+1);
      			for(int i=0;i<temp;i++)
      				ans.append(e);
      			if(temp>-1)
      			{
      				pn("Case #"+Ccase+": "+ans.toString());
      				return;
      			}
      		}
      		long total=(long)Math.pow(2,high(x+y))-1;
      		TreeSet<Integer> negtotal=util((total-(x+y))/2);
      		TreeSet<Integer>negx=util((long)Math.pow(2,high(x))-x);
      		TreeSet<Integer>negy=util((long)Math.pow(2,high(y))-y);
      		// TreeSet<Integer>tempp=new TreeSet<Integer>(negx);
      		// tempp.addAll(negy);
      		char[]dir=new char[pow(total+1)];
      		Arrays.fill(dir,'#');
      		dir[high(x)]=e;
      		dir[high(y)]=n;
      		for(Integer zz:negx)
      			dir[zz]=w;
      		for(Integer zz:negy)
      			dir[zz]=s;
      		for(int i=0;i<dir.length;i++)
      		{
      			if(dir[i]=='#')
      			{
      				ans=new StringBuffer();
      				ans.append("IMPOSSIBLE");
      				break;
      			}
      			ans.append(dir[i]);
      		}
      	}
		pn("Case #"+Ccase+": "+ans.toString()); 
    }
    static int high(long n)
    {
    	double ans=Math.ceil(Math.log(n)/Math.log(2));
    	return (int)ans;
    }
    static int pow(long n)
    {
    	double ans=Math.log(n)/Math.log(2);
    	if(ans==Math.floor(ans))
    		return (int)ans;
    	else return -1;
    }
    static TreeSet<Integer> util(long n)
    {
    	TreeSet<Integer> set = new TreeSet<Integer>();
    	int i=0;
    	while(n>0)
    	{
    		if(n%2==1)
    			set.add(i);
    		i++;
    		n/=2;
    	}
    	return set;
    }
    static AnotherReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        boolean oj = true;
        if(oj){sc=new AnotherReader();out=new PrintWriter(System.out);}
        else{sc=new AnotherReader(100);out=new PrintWriter("output.txt");}
        int t=1;
        t=ni();
        for(int i=1;i<=t;i++) {process(i);}
        out.flush();out.close();  
    }

    static void pn(Object o){out.println(o);}
    static void p(Object o){out.print(o);}
    static void pni(Object o){out.println(o);out.flush();}
    static int ni()throws IOException{return sc.nextInt();}
    static long nl()throws IOException{return sc.nextLong();}
    static double nd()throws IOException{return sc.nextDouble();}
    static String nln()throws IOException{return sc.nextLine();}
    static int[] nai(int N)throws IOException{int[]A=new int[N];for(int i=0;i!=N;i++){A[i]=ni();}return A;}
    static long[] nal(int N)throws IOException{long[]A=new long[N];for(int i=0;i!=N;i++){A[i]=nl();}return A;}
    static long gcd(long a, long b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int bit(long n)throws IOException{return (n==0)?0:(1+bit(n&(n-1)));}

/////////////////////////////////////////////////////////////////////////////////////////////////////////

    static class AnotherReader{BufferedReader br; StringTokenizer st;
    AnotherReader()throws FileNotFoundException{
    br=new BufferedReader(new InputStreamReader(System.in));}
    AnotherReader(int a)throws FileNotFoundException{
    br = new BufferedReader(new FileReader("input.txt"));}
    String next()throws IOException{
    while (st == null || !st.hasMoreElements()) {try{
    st = new StringTokenizer(br.readLine());}
    catch (IOException  e){ e.printStackTrace(); }}
    return st.nextToken(); } int nextInt() throws IOException{
    return Integer.parseInt(next());}
    long nextLong() throws IOException
    {return Long.parseLong(next());}
    double nextDouble()throws IOException { return Double.parseDouble(next()); }
    String nextLine() throws IOException{ String str = ""; try{
    str = br.readLine();} catch (IOException e){
    e.printStackTrace();} return str;}}
   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
}