import java.util.*;
class Solution
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        StringBuilder sb =new StringBuilder("");
	        for(int i=0;i<t;i++)
	        {
	            int x = sc.nextInt();
	            int y =sc.nextInt();
	            String p = sc.next();
	            int w=0;
	       
	            int ti =0;
	           for(int j=0; j<p.length();j++)
	           {
	               ti++ ;
	              if(p.charAt(j)=='N')
	               y++;
	               else if(p.charAt(j)=='S') 
	               y-- ;
	               else if(p.charAt(j)=='E')
	            	  x++ ;
	               else
	            	   x-- ;
	               
	               if( ti>=(Math.abs(x)+Math.abs(y)) )
	               {
	                   w=1;
	                  break ; 
	               }
	           }
	           
	            if(w==0)
	            sb.append("Case #"+(i+1)+": IMPOSSIBLE\n");
	            else
	            sb.append("Case #"+(i+1)+": "+ti+"\n");
	        }
	        sb.setLength(sb.length()-1);
	        System.out.print(sb);

    }
}