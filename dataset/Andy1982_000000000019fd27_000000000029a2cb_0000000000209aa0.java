import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	static List<Set<Integer>> listOfComb = new ArrayList<>();
	static boolean foundSolution=false;
	static Set<String> solution=new LinkedHashSet<>();
	
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int noOfTestCases = input.nextInt();
		List<String> list = new ArrayList<>();

		input.nextLine();
		for(int i=0;i<noOfTestCases;i++) {
				String str = input.nextLine();
				list.add(str);
		}
		
		int counter=1;
		for(String str:list) {
			
			System.out.flush();
			String result=checkSolution(str);
			if(result.equals("IMPOSSIBLE")) {
			System.out.println("Case #"+counter+": "+result);
			} else {
				System.out.println("Case #"+counter+": "+result);
				solution.stream().forEach(v->System.out.println(v));
			}
			System.out.flush();
			counter++;
			foundSolution=false;
			listOfComb=new ArrayList<>();
			solution= new LinkedHashSet<>();
		}
	}
	
	
	
	public static String checkSolution(String input) {
		
		String[] inputArr=input.split(" ");
		int dimension =Integer.valueOf(inputArr[0]);
		int k=Integer.valueOf(inputArr[1]);
		
		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
		findCombination(dimension,linkedHashSet);
	  // System.out.println(listOfComb);
	 
	   List<Set<Integer>> colList = new ArrayList<>();
	   
	   buildArrayAndCheckTrace(listOfComb,colList,dimension,k);
	   
	   return foundSolution ==true?"POSSIBLE":"IMPOSSIBLE";
	   
	}

	private static void buildArrayAndCheckTrace(List<Set<Integer>> combinations, List<Set<Integer>> colList,int n,int k) {
		
		if(colList.size()==n) {
		
			if(checkForTrace(colList,k)) {
				foundSolution=true;
				StringBuilder sb = new StringBuilder();
				for(Set<Integer> set:colList) {
					set.stream().forEach(v->sb.append(v+" "));
					solution.add(sb.toString().trim());
					sb.setLength(0);
				}
				return;
			}
		return;
		}
		
		for(Set<Integer> set:combinations) {
		 boolean isPresent=false;
		for(Set<Integer> set1:colList) {
			  if(compareHashSet(set1,set)) {
				  continue;
			  }
			  isPresent=true;
			  break;
		}
		if(isPresent) continue;
		colList.add(set);
		buildArrayAndCheckTrace(combinations, colList, n, k);
		if(foundSolution) return;
		colList.remove(set);
	}
	}
	private static boolean checkForTrace(List<Set<Integer>> colList,int k) {
		
		int trace=0;
		int counter =0;
		for(Set<Integer> set:colList) {
			int j=0;
		 for(Integer val:set) {
			 if(counter==j) {
				 trace+=val;
			 }
			 j++;
		 }
		 counter++;
		}
		
		return  trace-k==0;
	}
	public static boolean compareHashSet(Set<Integer> set1,Set<Integer> set2) {
		
		 Iterator<Integer> iter1=set1.iterator();
		 Iterator<Integer> iter2 = set2.iterator();
		 
		 while(iter1.hasNext() && iter2.hasNext()) {
			 if(iter1.next()==iter2.next()) return false;
		 }
		return true;
	}
	

	private static void findCombination(int n,LinkedHashSet<Integer> list) {
		
		if(list.size()==n) {
		Set<Integer> set= new LinkedHashSet<>();
		list.stream().forEach(v->set.add(v));
			listOfComb.add(set);
		}
		
		for(int i=1;i<=n;i++ ) {
			if(list.contains(i)) continue;
			list.add(i);
			findCombination(n,list);
			list.remove(i);
			
		}
		
		
	}
	
	
}
