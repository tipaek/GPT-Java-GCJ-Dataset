				
import java.util.*;import java.io.*;import java.math.*;

public class Solution
{
	static class Node{
		int str,end,idx;
		public Node(int str,int end,int idx){
			this.str=str;
			this.end=end;
			this.idx=idx;
		}
	}

	static boolean they_touch(int a,int b,int c,int d){//Do they inersect
		if(c>=b)
			return false;
		if(d<=a)
			return false;
		return true;
	}

	static boolean intersect(ArrayList<Node> l,Node n){
		
		if(l.size()==0)
			return false;

		for(Node i : l){
			if(they_touch(i.str,i.end,n.str,n.end))
				return true;
		}

		return false;
	}

    public static void process(int tc)throws IOException
    {
    	int n=ni();
    	Node arr[]=new Node[n+1];
    	for(int i=1;i<=n;i++) arr[i]=new Node(ni(),ni(),i);

    	ArrayList<Node> l1 = new ArrayList<>();
    	ArrayList<Node> l2 = new ArrayList<>();

    	for(int i=1;i<=n;i++){
    		if(!intersect(l1,arr[i]))
    			l1.add(arr[i]);
    		else if(!intersect(l2,arr[i]))
    			l2.add(arr[i]);
    	}


    	if(l1.size()+l2.size()!=n){
    		pn("Case #"+tc+": "+"IMPOSSIBLE");
    		return;
    	}

    	char res[]=new char[n+1];

    	for(Node x : l1)
    		res[x.idx]='J';

    	for(Node x : l2)
    		res[x.idx]='C';
    	p("Case #"+tc+": ");
    	for(int i=1;i<=n;i++) p(res[i]);
    	pn("");
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
        int t=ni(),cnt=0;
        while(t-->0)
            process(++cnt);
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
	
	
	