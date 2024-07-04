//package competitive;
import java.util.*;
import java.io.*;
//" only if the class is public. */
 class Solution
{
	
	
	public static void main (String[] args) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter out = new PrintWriter(System.out);
	    
		   
		String test =(br.readLine());
		    
		if(test!=null) {
			int t = Integer.parseInt(test);
			for(int k=0; k<t; k++) {
				String[] line = br.readLine().split(" ");
				int x = Integer.parseInt(line[0]);
				int y =Integer.parseInt(line[1]);
				String m = line[2];
				int flag=0;
				for(int i=0; i<m.length(); i++) {
					if(m.charAt(i)=='N') {
						y+=1;
					}
					else if(m.charAt(i)=='S') {
						y-=1;
					}
					else if(m.charAt(i)=='E') {
						x+=1;
					}
					else if(m.charAt(i)=='W') {
						x-=1;
					}
					if(Math.abs(x)+Math.abs(y)<=(i+1)) {
						out.println("Case #"+(k+1)+": "+(i+1));
						flag=1;
						break;
					}
				}
				if(flag==0) {
					out.println("Case #"+(k+1)+": IMPOSSIBLE");
				}
				
			}
		}
		out.flush();
	}
		   
	
}
