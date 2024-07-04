
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int ca = 1;
		while(cases>0)
		{
			TreeMap<Integer,Integer> C = new TreeMap<>();
			TreeMap<Integer,Integer> J = new TreeMap<>();
			StringBuilder sb = new StringBuilder();
			int line = sc.nextInt();
			boolean impossible = false;
			for(int i =0;i<line;i++)
			{
				int start = sc.nextInt();
				int end = sc.nextInt();
				
				if(C.isEmpty())
				{
					C.put(start, end);
					sb.append("C");
					continue;
				}
				if(J.isEmpty())
				{
					J.put(start,end);
					sb.append("J");
					continue;
				}

				boolean addC=true,addJ=true;
				
				for(int x:C.keySet())
				{
					
					if(x<=start&&start<C.get(x)) {addC=false;break;}
					if(x<end&&end<=C.get(x)) {addC=false;break;}
					
				}
				if(addC) {C.put(start,end); sb.append("C");continue;}
				for(int x:J.keySet())
				{
					
					if(x<=start&&start<J.get(x)) {addJ=false; break;}
					if(x<end&&end<=J.get(x)) {addJ=false;break;}				
				}
				if(addJ) {J.put(start,end); sb.append("J");continue;}
				
				//special case if it doesn't put
				if(!addJ&!addC) {impossible = true;break;}
				
			}
			System.out.print("Case #" + ca+": ");
			if(impossible)
				System.out.print("IMPOSSIBLE");
			else
				System.out.print(sb.toString());
			System.out.println();
			ca++;
			cases--;
		}
		
	}
	
}
