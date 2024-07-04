import java.io.*;
import java.util.*;
import java.math.*;
public class Solution {
    private static String solve() throws Exception{
		//Solve the problem
		int x = nin();
		int y = nin();
		String s = nl();
		
		for (int min=0; min < s.length(); min++)
		{
		    switch(s.charAt(min))
		    {
		        case 'S': y--;break;
		        case 'N': y++;break;
		        case 'E': x++;break;
		        case 'W': x--;break;
		    }
		    
		    int mov_needed = Math.abs(x) + Math.abs(y);
		    if( min+1 >= mov_needed) { return Integer.toString(min+1); }
		}
		return "IMPOSSIBLE";
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