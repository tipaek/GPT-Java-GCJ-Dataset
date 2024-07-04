
import java.util.*;


import java.io.*;

public class Solution {
	
	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	

	public static void main(String[] args) {
		
		
		int t = in.nextInt();
		int count=1;
		
		while(count<=t)
		{
			String elem = "";
			int arr[][];
			int rep_rows=0;
			int rep_col=0;
			int trace=0;
			int size = in.nextInt();
			arr  = new int[size][size];
			
			String tempString;
			int cnt =1;
			
			while(cnt<=size)
			{
				int l = elem.length();
				
				elem+=readInput();
				if (elem.length()>l) {
					cnt+=1;
					
				}
				
			}
			
			
			
			
			
			int ind=0;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					arr[i][j] = Character.getNumericValue(elem.charAt(ind));
					ind+=1;
				}
			}
			ArrayList<Integer> rows=new ArrayList<Integer>();
			ArrayList<Integer> cols=new ArrayList<Integer>();
			//loop through rows
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (rows.contains(arr[i][j])) {
						rep_rows+=1;
						break;
					}
					
					rows.add(arr[i][j]);
				}
				rows.clear();
			}
			
			rows.clear();
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (cols.contains(arr[j][i])) {
						rep_col+=1;
						break;
					}
					cols.add(arr[j][i]);
				}
				cols.clear();
			}
			
			cols.clear();
			
			//trace
			for(int i=0;i<size;i++)
			{
				trace+=arr[i][i];
			}
			
			if (count==t) {
				System.out.print("Case #"+count+": "+trace+" "+rep_rows+" "+rep_col);

			}
			else {
				System.out.println("Case #"+count+": "+trace+" "+rep_rows+" "+rep_col);

			}
			
			count+=1;
		
		}
		
		 
		
		

	}
	
	public static String readInput() {
		 
		 	String tempString;
		
		 	tempString = in.nextLine();
			tempString.trim();
			tempString = tempString.replaceAll("\\s+","");
			return tempString;
		 
	}

}
