				
import java.util.*;import java.io.*;import java.math.*;

public class Solution
{

    public static void process(int tc)throws IOException
    {
    	int n=ni(),arr[][]=new int[n+1][n+1];
    	HashSet<Integer> set = new HashSet<Integer>();

    	long k=0l,r=0l,c=0l;
    	for(int i=1;i<=n;i++){
    		for(int j=1;j<=n;j++){
    			set.add(arr[i][j]=ni());
    			if(i==j)
    				k+=(arr[i][j])*1l;
    		}
    		if(set.size()!=n)
    			r++;
    		set.clear();
    	}

    	for(int i=1;i<=n;i++){
    		for(int j=1;j<=n;j++){
    			set.add(arr[j][i]);
    		}
    		if(set.size()!=n)
    			c++;
    		set.clear();
    	}

    	pn("Case #"+tc+": "+k+" "+r+" "+c);
    }


   	static AnotherReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        out = new PrintWriter(System.out);
        sc=new AnotherReader();
        boolean oj = true;

    //	oj = System.getProperty("ONLINE_JUDGE") != null;
    	if(!oj) sc=new AnotherReader(100);

        long s = System.currentTimeMillis();
        int t=ni(),cnt=1;
        while(t-->0)
            process(cnt++);
        out.flush();
        if(!oj)
            System.out.println(System.currentTimeMillis()-s+"ms");
        System.out.close();  
    }

    static void pn(Object o){out.println(o);}
    static void p(Object o){out.print(o);}
    static void pni(Object o){out.println(o);System.out.flush();}
    static int ni()throws IOException{return sc.nextInt();}
    static long nl()throws IOException{return sc.nextLong();}
    static double nd()throws IOException{return sc.nextDouble();}
    static String nln()throws IOException{return sc.nextLine();}
    static long gcd(long a, long b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int bit(long n)throws IOException{return (n==0)?0:(1+bit(n&(n-1)));}
    static boolean multipleTC=false;



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
	
	
	