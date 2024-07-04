

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

 class Solution {

	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int noOfTestCases = input.nextInt();
		List<List<String>> listOfInput  = new ArrayList<>();
		for(int i=0;i<noOfTestCases;i++) {
			int dimesion = input.nextInt();
			 input.nextLine();
			List<String> list = new ArrayList<>();
			for(int j=0;j<dimesion;j++) {
				String str = input.nextLine();
				list.add(str);
			}
			listOfInput.add(list);
		}
		
		int counter=1;
		for(List<String> list:listOfInput) {
			
			System.out.println("Case #"+counter+": "+calculateOutput(list));
			counter++;
		}
		
		
	}

	private static String calculateOutput(List<String> list) {
		
		List<Set<String>> rowList = new ArrayList<>(list.size());
		List<Set<String>> colList = new ArrayList<>(list.size());
		
		
		 int counter =0;
		int traceSum=0;
		int rowDup=0;
		int colDup=0;
		Map<String,Boolean> map = new HashMap<>();
		for(String str :list) {
			rowList=new ArrayList<>(list.size());
			
			String[] arr=str.split(" ");
			for(int i=0;i<arr.length;i++) {
				String minString=arr[i];
				if(i==counter) {
					traceSum+=Integer.valueOf(minString);
					
				}
				if(rowList.size()==0) {
				 rowList.add(0,new HashSet<String>());
				}
				  if(!(rowList.get(0).add(minString))) {
					  if(!(map.containsKey("row_"+counter) )) {
						  rowDup++;
						  map.put("row_"+counter, true);
						  }
					 	  }
				  if(i>=colList.size()) {
					 colList.add(i,new HashSet<String>());
				  }
				  if(!(colList.get(i).add(minString))) {
					  if(!(map.containsKey("col_"+i) )) {
						  colDup++;
						  map.put("col_"+i, true);
						  }
				  }
			}
			counter++;
		}
		
		StringBuilder sb = new StringBuilder();
		 sb.append(traceSum+" "+rowDup+" "+colDup);
		
		return sb.toString();
	}
	
	
}
