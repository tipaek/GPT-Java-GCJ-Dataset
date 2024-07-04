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
   	
       int x=Integer.parseInt(h[0]);
    int y=Integer.parseInt(h[1]);
   	int sum=Math.abs(x)+Math.abs(y);
   	
   	
   		int largest=(int)Math.pow(2,Math.log(sum)/Math.log(2)+1);
   		Pair p=get(0, 0,Math.abs(x),Math.abs(y), 1, largest,x,y);
   		if(!p.a){System.out.println("Case #"+(i+1)+": IMPOSSIBLE");}
   		else{System.out.println("Case #"+(i+1)+": "+p.b);}
   	

		
}
	}
	static Pair get(int a,int b,int xx,int yy, int k, int largest, int aa, int bb)
	{	
		ArrayList<Integer>arr=new ArrayList<>();
		if(xx==a && yy==b){return new Pair(true, "");}
		
		if(k>largest){return new Pair(false,"");}
		// if(visited[j]){return get(a,xx,k*2,largest,);}
		// Pair t=get(a,k*2,largest);
		Pair y=get(a+k,b,xx,yy,k*2,largest,aa,bb);
		Pair z=get(a-k,b,xx,yy,k*2,largest,aa,bb);
		Pair l=get(a,b+k,xx,yy,k*2,largest,aa,bb);
		Pair m=get(a,b-k,xx,yy,k*2,largest,aa,bb);
		if(y.a){return new Pair(true,(aa>=0?"E":"W")+y.b);}
		if(z.a){return new Pair(true,(aa>=0?"W":"E")+z.b);}
		if(l.a){return new Pair(true,(bb>=0?"N":"S")+l.b);}
		if(m.a){return new Pair(true, (bb>=0?"S":"N")+m.b);}
		return new Pair(false,"");
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