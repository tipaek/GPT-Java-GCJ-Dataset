import java.util.*;
import java.io.*;
public class Solution


{
	static Hashtable<String ,Pair>hash=new Hashtable<>();
	static HashSet<String>set=new HashSet<>();
	public static void main(String[] args) throws java.lang.Exception {
	
	BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
    int t= Integer.parseInt(inp.readLine());
    for(int i=0;i<t;i++){	

    String h[]=inp.readLine().split(" ");
   	
       long x=Long.parseLong(h[0]);
    long y=Long.parseLong(h[1]);
   	long sum=Math.abs(x)+Math.abs(y);
   	hash=new Hashtable<>();
   	set=new HashSet<>();
   	
   		long largest=(int)Math.pow(2,Math.log(sum)/Math.log(2)+1);
   		Pair p=get(0, 0,Math.abs(x),Math.abs(y), 1, largest,x,y);
   		if(!p.a){System.out.println("Case #"+(i+1)+": IMPOSSIBLE");}
   		else{System.out.println("Case #"+(i+1)+": "+p.b);}
   	

		
}
	}
	static Pair get(long a,long b,long xx,long yy,long k, long largest, long aa, long bb)
	{	
		ArrayList<Integer>arr=new ArrayList<>();
		if(xx==a && yy==b){return new Pair(true, "");}
		if(hash.containsKey(a+" "+b+" "+k)){return hash.get(a+" "+b+" "+k);}
		if(k>largest || set.contains(a+" "+b)){return new Pair(false,"");}
		
		
		set.add(a+" "+b);
		// if(visited[j]){return get(a,xx,k*2,largest,);}
		// Pair t=get(a,k*2,largest);
		Pair y=get(a+k,b,xx,yy,k*2,largest,aa,bb);
		Pair z=get(a-k,b,xx,yy,k*2,largest,aa,bb);
		Pair l=get(a,b+k,xx,yy,k*2,largest,aa,bb);
		Pair m=get(a,b-k,xx,yy,k*2,largest,aa,bb);
		Pair pp=new Pair(false,"");
		if(y.a){pp=new Pair(true,(aa>=0?"E":"W")+y.b);}
		else if(z.a){pp= new Pair(true,(aa>=0?"W":"E")+z.b);}
		else if(l.a){pp =new Pair(true,(bb>=0?"N":"S")+l.b);}
		else if(m.a){pp= new Pair(true, (bb>=0?"S":"N")+m.b);}
		hash.put(a+" "+b+" "+k,pp);
		set.remove(a+" "+b);
		return pp;
	}

}
class Pair
{
	boolean a;

	String b;
	Pair(boolean c,String d)
	{
		a=c;
		b=d;

	}
}