import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);	
		int T;
		T=sc.nextInt();
		sc.nextLine();
		int K=T;
		while(T-- >0)
		{
			
			String s = sc.nextLine();
			
			s= s +"0";

			char carr [] = s.toCharArray();
			StringBuilder sb = new StringBuilder();
			
			int curr_depth =0;
			
			for(int i=0;i<carr.length;i++)
			{
				int v = carr[i]-'0';
			 	
				while(curr_depth<v)
				{
					sb.append('(');
					curr_depth++;
				}
			
				
				while(curr_depth>v)
				{
					sb.append(')');
					curr_depth--;
				}
				if(i!=carr.length-1)
					sb.append(v);
				
			}
			int re= K-T;
			System.out.println("Case #"+re+": "+sb.toString());
		}

	}

}
