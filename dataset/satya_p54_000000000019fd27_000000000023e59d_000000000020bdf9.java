				
import java.util.*;import java.io.*;import java.math.*;

public class Solution
{
	static class Node{
		int str,end;
		public Node(int str,int end){
			this.str=str;
			this.end=end;
		}
	}

	static class sort_by_start implements Comparator<Node>{
		public int compare(Node A,Node B){
			return A.str-B.str;
		}
	}

	static int count_taken(boolean taken[],int n){
		int cnt=0;
		for(boolean i : taken)
			if(!i)
				cnt++;

		return cnt;
	} 
    public static void process(int tc)throws IOException
    {
    	int n=ni();
    	ArrayList<Node> li = new ArrayList<>();
    	boolean taken[]=new boolean[n];
    	Arrays.fill(taken,false);

    	for(int i=1;i<=n;i++) li.add(new Node(ni(),ni()));

    	Collections.sort(li,new sort_by_start());

    	char res[]=new char[n+1];
    	char curr='J';

    	for(int i=0;i<n;i++){

    		if(taken[i])
    			continue;

    		if(count_taken(taken,n)==1){
    			res[i]=curr;
    			break;
    		}

    		int end=li.get(i).end;
    		taken[i]=true;
    		res[i]=curr;

    		int take=-1;
    		for(int j=0;j<n;j++){
    			if(taken[j] || li.get(j).str<end)
    				continue;
    			taken[j]=true;
    			//res[j]=curr;
    			take=j;
    			break;
    		}

    		if(take==-1){
    			pn("Case #"+tc+": "+"IMPOSSIBLE");
    			//pn(i+" "+take);
    			return;
    		}

    		res[take]=curr;
    		curr=(curr=='J')?'C':'J';
    	}
    	p("Case #"+tc+": ");
    	for(int i=0;i<n;i++) p(res[i]);
    	pn("");
    }


   	static AnotherReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        out = new PrintWriter(System.out);
        sc=new AnotherReader();
        boolean oj = true;

    	//oj = System.getProperty("ONLINE_JUDGE") != null;
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
	
	
	