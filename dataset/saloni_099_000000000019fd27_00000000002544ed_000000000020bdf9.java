
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
			
			int[][] array=new int[n][3];
			
			
			for(int j=0;j<n;j++) {
				int start=in.nextInt();
				int end=in.nextInt();
				array[j][0]=start;
				array[j][1]=end;
				array[j][2]=j;
				
			}
			
			Arrays.sort(array, new Comparator<int[]>() { 
	            
		          @Override              
		          // Compare values according to columns 
		          public int compare(final int[] entry1,  
		                             final int[] entry2) { 
		  
		            // To sort in descending order revert  
		            // the '>' Operator 
		            if (entry1[1] < entry2[1]) 
		                return 1; 
		            else
		                return -1; 
		          } 
		        });
			
			
			
			ArrayList<Integer> j_start=new ArrayList<Integer>();
			ArrayList<Integer> j_end=new ArrayList<Integer>();
			ArrayList<Integer> j_index=new ArrayList<Integer>();
			
			ArrayList<Integer> c_start=new ArrayList<Integer>();
			ArrayList<Integer> c_end=new ArrayList<Integer>();
			ArrayList<Integer> c_index=new ArrayList<Integer>();
			
			j_index.add(array[0][2]);
			j_start.add(array[0][0]);
			j_end.add(array[0][1]);
			
			
			c_start.add(array[1][0]);
			c_end.add(array[1][1]);
			c_index.add(array[1][2]);
			
			
			
			
			
			
			if(n>2) {
				
				for(int h=2;h<n;h++) {
					//System.out.println(j_start.get(j_end.size()-1));
					
					
					
					if(j_start.get(j_start.size()-1)>=array[h][1]) {
						j_index.add(array[h][2]);
						j_start.add(array[h][0]);
						j_end.add(array[h][1]);
						
						
					}
					else if(c_start.get(c_start.size()-1)>=array[h][1]) {
						
						c_start.add(array[h][0]);
						c_end.add(array[h][1]);
						c_index.add(array[h][2]);
					}
					else {
						ans="IMPOSSIBLE";
					}
				}
				
				
				
				
				
				
			}
			
//		System.out.println("index of j");
//		for(int k=0;k<j_index.size();k++) {
//			
//			System.out.println(j_index.get(k));
//		}
//		System.out.println("index of c");
//		for(int t=0;t<c_index.size();t++) {
//			
//			System.out.println(c_index.get(t));
//		}
//			
		String[] answer=new String[n];
		if(ans.equals("IMPOSSIBLE")) {
			
		System.out.println("Case #" + (i+1) + ": " + (ans));
		}
		else {
			for(int k=0;k<j_index.size();k++) {
				answer[j_index.get(k)]="J";
				
			}
			for(int k=0;k<c_index.size();k++) {
				answer[c_index.get(k)]="C";
				
			}
			
			ans="";
			for(int k=0;k<n;k++) {
				ans=ans+answer[k];
				
			}
			System.out.println("Case #" + (i+1) + ": " + (ans));
		}
		    
		}    
		
	}
}
