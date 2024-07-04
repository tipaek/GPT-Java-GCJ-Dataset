	import java.util.*;
	import java.io.*;
	import java.util.regex.*;
	import java.lang.Math;
	public class Solution {
	    public static void main(String[] args) {
	        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	        int t = in .nextInt();
	        for (int i = 1; i <= t; i++) {
	            int N=in .nextInt();
	            int S=in .nextInt();
	            String D=in .next();
int h=0;
for(int j=0;j<D.length();j++)
{
    if(D.charAt(j)=='N')
    {
        S=Verticfun(S,"N");
    }
    
    
    else if(D.charAt(j)=='S')
    {
        S=Verticfun(S,"S");
    }
    
    else if(D.charAt(j)=='E')
    {
        N=Verticfun(N,"E");
    }
    
    else if(D.charAt(j)=='W')
    {
        N=Verticfun(N,"W");
    }
    
    int res=Math.abs(N)+Math.abs(S);
    
    if(j>=res-1)
    {j++;
        System.out.println("Case #"+i+": "+j);
    h=1;
        break;
    }
    
    
}
if(h==0){
  System.out.println("Case #"+i+": IMPOSSIBLE");  
}
	            }} 
	    public static int Horizfun(int x,String s)
	    {
	        if(s=="E")
	        return x+1;
	        else
	        return x-1;
	    }
	    
	    public static int Verticfun(int y,String s)
	    {
	                if(s=="N")
	        return y+1;
	        else
	        return y-1;
	    }
	    
	    
	    
	}