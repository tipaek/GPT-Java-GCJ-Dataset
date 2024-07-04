

import java.util.*;

public class Solution{

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nr = scanner.nextInt();
		String str[]=new String[100];
		for( int i=0;i<nr;i++) {
			str[i]= scanner.next();
		}
		scanner.close();
		
		
		for( int i=0;i<nr;i++) {
			int i1=i+1;
			System.out.print("Case #"+i1+": ");
			int pre=0;
			int last=0;
			for (int j=0;j<str[i].length();j++) {
				char c=str[i].charAt(j);
				int a=Integer.parseInt(String.valueOf(c));
				
				int diff=a-pre;
				
				if (diff==0)System.out.print(a);
				else if(diff<0) {
					int diff1=0-diff;
					for(int k=0;k<diff1;k++)System.out.print(")");
					System.out.print(a);
				}
				else if(diff>0) {
					for(int k=0;k<diff;k++)System.out.print("(");
					System.out.print(a);
				}
				
				pre=a;
				if(j==str[i].length()-1)last=a;
			}
			if (last!=0) {
				for(int k=0;k<last;k++)System.out.print(")");
				System.out.println("");
			}
			else System.out.println("");
			
			
			
		}
		
		
		
	}

}
