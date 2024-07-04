import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    private static String solve() throws Exception{
		//Solve the problem
		BigInteger u = new BigInteger("10").pow(nin()).subtract(new BigInteger("1"));
		
		Hashtable<String, List> traductor = new Hashtable<String, List>();
		Hashtable<Long, String> res = new Hashtable<Long, String>();
		
		for (int i=0; i < 10000; i++)
		{
		    long q = nlo();
		    String r = nl();
	        String key = Long.toString(q);
	        
	        if(key.length() == r.length())
	        {
	            List a = traductor.get(key);
		        if (a==null) { a =new ArrayList<String>();}
		        if ( ! a.contains(r)  ) { a.add(r);}
		        traductor.put(key, a); 
	        }
		}
		//printtraductor
	/*	for( int x = 0; x <=25 ; x++)
	    {
	        System.out.println ( x + ": " + traductor.get(String.valueOf(x)) );
	    }*/
	    
		//YA TENEMOS LOS DATOS, resolver
		    String primero = "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
		long i = 0;
		long hasta = Long.parseLong(String.valueOf(u));
		while (i < hasta)
		{
		    String key = String.valueOf(i);
		    if(traductor.get(key) != null && traductor.get(key).size()==1)
		    {
		        String m = String.valueOf(traductor.get(key).get(0));
		        res.put(i, m);
		        for (int c=0;c<m.length();c++)
		        {
		            res.put(Long.parseLong(key.substring(c,c+1)), m.substring(c,c+1));
		            
		            List a =new ArrayList<String>(); a.add(m.substring(c,c+1));
		            traductor.put(key.substring(c,c+1), a);
		           // System.out.println("El " + key.substring(c,c+1) + " es " +m.substring(c,c+1));
		        }
		    }
		    String siguiente = primero.substring(0,key.length()+1);
		    i= Long.parseLong(siguiente);
		}
		   
		for( int x = 0; x <= 10 ; x++)
	    {
	        String stringX = String.valueOf(x);
	        Long longx = Long.parseLong(stringX);
	        List a = traductor.get(stringX);
		    if (a==null) { a =new ArrayList<String>();}
		    if(a.size()>1)
		    {
    		    for (int y = x-1; y >=0; y--)
    		    {
    		        
	        String stringy = String.valueOf(y);
	        Long longy = Long.parseLong(stringy);
	        
		    // System.out.println ( "get res" + stringy +":"+res.get(longy));
	        
    		        if(a.contains(res.get(longy)))
    		        {
    		            a.remove(res.get(longy));
    		        }
    		    }
    		    traductor.put(stringX,a);
    		    if( a.size()==1) 
    		    {
    		         res.put(longx, String.valueOf(a.get(0)));
		            
    		    }
		    }
	    } /*
		//printtraductor
		for( int x = 0; x <=25 ; x++)
	    {
	        System.out.println ( x + ": " + traductor.get(String.valueOf(x)) );
	    }*/
		    /*RES
		    for( int x = 0; x <=25 ; x++)
		    {
		        String xValue = String.valueOf( res.get( Long.parseLong(String.valueOf( x)) ) );
		        System.out.println ( x + ": " + xValue );
		    }*/
		    
		    String devolver = "";
		     for( int x = 0; x <=9 ; x++)
		    {
		        devolver = devolver + String.valueOf( res.get( Long.parseLong(String.valueOf( x)) ) );
		    }
		   return devolver;
	}
	
    static Scanner in;
    static BufferedWriter out;
	
	public static void main(String[] args) throws Exception{
		in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		int cases = in.nextInt();
		for(int t=1;t<=cases;t++){
			out.write(String.format("Case #%d: %s\n",t,solve()));
		}
		out.flush();
    }
	
	
    static String nl(){
		return in.nextLine().trim();
    }
    
    static long nlo(){
		return in.nextLong();
    }
    static int nin(){
		return in.nextInt();
    }	
    static double ndo(){
		return in.nextDouble();
    }
	static char nch()
	{
		return in.next().charAt(0);
	}
}