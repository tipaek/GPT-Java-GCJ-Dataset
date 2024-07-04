
import java.util.*;

import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution   
{
	
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in=new Scanner(System.in);
		
		int T=in.nextInt();
		for(int i=0;i<T;i++){
		    
			int n=in.nextInt();
			
			String ans=""; 
			
			int[][] array=new int[n][2];
			
			
			for(int j=0;j<n;j++) {
				int start=in.nextInt();
				int end=in.nextInt();
				array[j][0]=start;
				array[j][1]=end;
			}
			
			
			ArrayList<Integer> j_start=new ArrayList<Integer>();
			ArrayList<Integer> j_end=new ArrayList<Integer>();
			
			ArrayList<Integer> c_start=new ArrayList<Integer>();
			ArrayList<Integer> c_end=new ArrayList<Integer>();
			
			j_start.add(array[0][0]);
			j_end.add(array[0][1]);
			
			ans=ans+"J";
			
			c_start.add(array[1][0]);
			c_end.add(array[1][1]);
			
			ans=ans+"C";
			
			if(array.length>2) {
				
				for(int k=2;k<n;k++) {
					int min=array[k][0];
					int max=array[k][1];
					
					
					int temp=0;
					int check=0;
					for(int h=0;h<j_start.size();h++) {
						if(min>j_start.get(h) && min<j_end.get(h) || (max<j_end.get(h) && max>j_start.get(h)) || (j_start.get(h)>min && j_start.get(h)<max)) {
							check=1;
							
							break;
						}
						
					}
					if(check==0) {
						temp=1;
						ans=ans+"J";
						j_start.add(min);
						j_end.add(max);
					}
					
					check=0;
						for(int h=0;h<c_start.size();h++) {
							if(((min>c_start.get(h) && min<c_end.get(h)) || (max<c_end.get(h) && max>c_start.get(h))) && temp==0) {
								check=1;
								ans="IMPOSSIBLE";
								break;
							}
							
							
						}
					
						if(check==0 && temp==0) {
							temp=1;
							ans=ans+"C";
							c_start.add(min);
							c_end.add(max);
						}
					
					
				}
				
				
			}
		
		String im="I";
		for(int k=0;k<ans.length();k++) {
			if(ans.charAt(k)==im.charAt(0)) {
				ans="IMPOSSIBLE";
				break;
			}
		}
			
		System.out.println("Case #" + (i+1) + ": " + (ans));
		 
		    
		}    
		
	}
}
