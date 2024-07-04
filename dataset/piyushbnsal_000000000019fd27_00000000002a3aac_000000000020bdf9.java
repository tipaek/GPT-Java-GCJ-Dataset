import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int t=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<t;i++)
		{
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int[] start=new int[n];
			int[] end=new int[n];
			
			ArrayList<Integer> j_start=new ArrayList<>();
			ArrayList<Integer> j_end=new ArrayList<>();
			ArrayList<Integer> c_start=new ArrayList<>();
			ArrayList<Integer> c_end=new ArrayList<>();
			ArrayList<Integer> temp_start=new ArrayList<>();
			ArrayList<Integer> temp_end=new ArrayList<>();
			
			StringBuilder ans=new StringBuilder();
			
			boolean answer=true;
			
			for(int j=0;j<n;j++)
			{
				st=new StringTokenizer(br.readLine());
				start[j]=Integer.parseInt(st.nextToken());
				end[j]=Integer.parseInt(st.nextToken());
				
				
				temp_start=new ArrayList<>();
				temp_end=new ArrayList<>();
				
				temp_start=new ArrayList<>(j_start);
				temp_end=new ArrayList<>(j_end);
				temp_start.add(start[j]);
				temp_end.add(end[j]);
				
				if((findPlatform(temp_start,temp_end))==1)
				{
					j_start.add(start[j]);
					j_end.add(end[j]);
					ans.append("C");
				}
				
				else
				{
					temp_start=new ArrayList<>(c_start);
					temp_end=new ArrayList<>(c_end);
					temp_start.add(start[j]);
					temp_end.add(end[j]);
					
					if((findPlatform(temp_start,temp_end))==1)
					{
						c_start.add(start[j]);
						c_end.add(end[j]);
						ans.append("J");
					}
					
					else
						answer=false;
				}
			}
			
			if(answer)
			System.out.println("Case #"+(int)(i+1)+": "+ans);
			else
			System.out.println("Case #"+(int)(i+1)+": IMPOSSIBLE");
			
		}

	}
	
	public static int findPlatform(ArrayList<Integer> arr, ArrayList<Integer> dep) 
	{ 
	   // Sort arrival and departure arrays 
		int n=arr.size();
	   Collections.sort(arr); 
	   Collections.sort(dep); 
	   
	   // plat_needed indicates number of platforms 
	   // needed at a time 
	   int plat_needed = 1, result = 1; 
	   int i = 1, j = 0; 
	   
	   // Similar to merge in merge sort to process  
	   // all events in sorted order 
	   while (i < n && j < n) 
	   { 
	      // If next event in sorted order is arrival,  
	      // increment count of platforms needed 
	      if (arr.get(i) < dep.get(j)) 
	      { 
	          plat_needed++; 
	          i++; 
	   
	          // Update result if needed  
	          if (plat_needed > result)  
	              result = plat_needed; 
	      } 
	   
	      // Else decrement count of platforms needed 
	      else
	      { 
	          plat_needed--; 
	          j++; 
	      } 
	   } 
	   
	   return result; 
	} 
	
}
