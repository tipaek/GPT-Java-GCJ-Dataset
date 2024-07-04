import java.io.*;
import java.util.*;

public class Solution {
public static String process(ArrayList<int[]> cont) {
		
		String r = "", _J = "J", _C="C";
		ArrayList<int[]> J = new ArrayList<int[]>();
		ArrayList<int[]> C = new ArrayList<int[]>();
		
		J.add( cont.get(0) );
		r += _J;
		
		for(int i=1;i<cont.size(); i++) {
			int []p = cont.get(i);
			
			if(ver(J,p)) {
				J.add(p);
				r += _J;
			}
			else if(ver(C,p)) {
				C.add(p);
				r += _C;
			}
			else {
				return "";
			}
		}
		
		return r;
	}
	
	/**
	 * True no overlap
	 * False overlap
	 * @param c
	 * @param p1
	 * @return
	 */
	public static boolean ver(ArrayList<int[]> c, int[]p1){
		
		if(c.size() == 0) {return true;}
		
		for(int i=0;i<c.size();i++) {
			int []p2 = c.get(i);
			
			if(p1[1] <= p2[0] || p2[1] <= p1[0])
			{
			}else {
				return false;
			}
			
		}
		return true;
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		String text = in.next();
		int N = Integer.parseInt(text);

		for (int i = 0; i < N; i++) {

			text = in.next();
			long num = Long.parseLong(text);
			
			ArrayList<int[]> cont = new ArrayList<int[]>();
			
			for(int j=0; j<num; j++) {
				text = in.next();
				int a = Integer.parseInt(text);
				
				text = in.next();
				int b = Integer.parseInt(text);
				int[] p = {a,b};
				cont.add(p);
			}
			
			Collections.reverse(cont);
			String outRes = process(cont);
			outRes = new StringBuilder(outRes).reverse().toString();
			
			if(outRes.compareTo("") != 0) { 
				System.out.println("Case #"+(i+1)+": " + outRes);
			}else{
			 	System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
			}
		}
		in.close();
	}
}
