import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String result = helper(x,y,"");
			sb.append("Case #"+(t+1)+": "+result+"\n");
		}
		System.out.print(sb.toString());
		
	}

	public static String helper(int x, int y,String prev) {
		//System.out.println("begin "+x+" "+y+" "+prev);
		if (x==0 && y==0) 
			return "";
		else if (x==0 && y==-1)  {
			//System.out.println(x+" "+y+" return N");
			return prev+"S";
		}
		else if (x==0 && y==1)  {
			//System.out.println(x+" "+y+" return S");
			return prev+"N";
		}
		else if (x==-1 && y==0)  {
			//System.out.println(x+" "+y+" return E");
			return prev+"W";
		}
		else if (x==1 && y==0) {
			//System.out.println(x+" "+y+" return W");
			return prev+"E";
		}
		else if (x%2==0 && y%2==0 || Math.abs(x%2) ==1 &&  Math.abs(y%2)==1) { 
			//System.out.println("starting "+ x+" "+y+" but Impossible");
			return "IMPOSSIBLE";
		}
		
		String result = prev;
		boolean found = false;
		
		//case 2 when x is odd -> go S
		if (Math.abs(x%2) == 1) {
			int x2 = x-1;
			int y2 = y;
			String temp = helper(x2/2,y2/2,prev+'E');

			if ( !temp.equals("IMPOSSIBLE") && !found) {
				result = temp;
				found = true;
			}
			else if (!temp.equals("IMPOSSIBLE") && found && prev.length()+1 >= temp.length()) {
				result = temp;
			}
			//System.out.println("HERE IS "+result +" after " +x+" "+y+ " go W"  );
		}
		
				
		//case 1 when x is odd -> go N
		if (Math.abs(x%2) == 1) {
			int x1 = x+1;
			int y1 = y;
			String temp = helper(x1/2,y1/2,prev+'W');
			if ( !temp.equals("IMPOSSIBLE") && !found) {
				result = temp;
				found = true;
			}
			else if (!temp.equals("IMPOSSIBLE") && found && prev.length()+1 >= temp.length()) {
				result = temp;
			}
		}
		
		
		
		//case 3 when y is odd -> go E
		if (Math.abs(y%2) == 1) {
			int x3 = x;
			int y3 = y+1;
			String temp = helper(x3/2,y3/2,prev+'S');
			if ( !temp.equals("IMPOSSIBLE") && !found) {
				result = temp;
				found = true;
			}
			else if (!temp.equals("IMPOSSIBLE") && found && prev.length()+1 >= temp.length()) {
				result = temp;
			}
		}
		
		//case 4 when y is odd -> go W
		if (Math.abs(y%2) == 1) {
			int x4 = x;
			int y4 = y-1;
			String temp = helper(x4/2,y4/2,prev+'N');
			if ( !temp.equals("IMPOSSIBLE") && !found) {
				result = temp;
				found = true;
			}
			else if (!temp.equals("IMPOSSIBLE") && found && prev.length()+1 >= temp.length()) {
				result = temp;
			}
		}
		
		//System.out.println(x+" "+y+" "+prev + " "+found+" "+ (found ? result : "IMPOSSIBLE"));
		return found ? result : "IMPOSSIBLE";
	}

}
