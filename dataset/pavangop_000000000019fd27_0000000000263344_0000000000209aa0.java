import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	private static boolean resFound = false;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		
		for (int i=0;i<cases;i++){
			resFound=false;
			int size = scanner.nextInt();
			int K = scanner.nextInt();
			ArrayList<Integer> ans = new ArrayList<>();
			ArrayList<Character> fullSet = new ArrayList<>();
			String min="",max="";
			for(int k=1;k<=size;k++){
				fullSet.add((char)(k+'0'));
				min+=k;
				max+=(size-k+1);
			}
			int minI = Integer.parseInt(min);
			int maxI = Integer.parseInt(max);
//			System.out.println(fullSet+min+max);
			for (int k=minI;k<=maxI;k++) {
				String s = k+"";
				Set<Character> set = new HashSet<>();
				for(Character c:s.toCharArray()){
					if(fullSet.contains(c))
						set.add(c);
				}
				if(set.size()==size){
					ans.add(k);
				}
				
			}
//			System.out.println(ans.size()+" "+ans);
			
			int r = size; 
			int n = ans.size(); 
			printCombination(ans, n, r, K,i);
			if(!resFound){
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
			}
			
		}
		scanner.close();
		
		
	}
		/* arr[] ---> Input Array 
		data[] ---> Temporary array to store current combination 
		start & end ---> Staring and Ending indexes in arr[] 
		index ---> Current index in data[] 
		r ---> Size of a combination to be printed */
		static void combinationUtil(ArrayList<Integer> ans, int data[], int start, 
									int end, int index, int r, int K, int case_num) 
		{ 
			// Current combination is ready to be printed, print it 
			if(resFound){
				return;
			}
			if (index == r) 
			{ 
				if(sumDiag(data)==K){
					System.out.println("Case #"+(case_num+1)+": POSSIBLE");
					for (int j=0; j<r; j++){
						String temp = data[j]+"";
						temp = temp.replaceAll(".", "$0 ");
						System.out.println(temp.trim());
					}
						
					resFound=true;
				}
				return; 
			} 

			// replace index with all possible elements. The condition 
			// "end-i+1 >= r-index" makes sure that including one element 
			// at index will make a combination with remaining elements 
			// at remaining positions 
			for (int i=start; i<=end && end-i+1 >= r-index; i++) 
			{ 
				data[index] = ans.get(i);
				if(!resFound){
					combinationUtil(ans, data, i+1, end, index+1, r,K,case_num);
				} else {
					break;
				}
			} 
		} 

		private static int sumDiag(int[] data) {
			int size = data.length;
			ArrayList<HashSet<Character>> cols = new ArrayList<HashSet<Character>>();
			boolean isValid = true;
			int diagSum=0;
			for(int i=0;i<size;i++){
				String sTT = data[i]+"";
				diagSum = diagSum + Character.getNumericValue(sTT.charAt(i));
				cols.add(new HashSet<Character>());
				for(int j=0;j<size;j++){
					String s = data[j]+"";
					cols.get(i).add(s.charAt(i));
				}
			}
			for(HashSet<Character> sT:cols){
				if(sT.size()<size)
					isValid = false;
			}
			if(isValid){
				return diagSum;
			} else {
				return -1;
			}
			
		}
		
		// The main function that prints all combinations of size r 
		// in arr[] of size n. This function mainly uses combinationUtil() 
		static void printCombination(ArrayList<Integer> ans, int n, int r, int K, int case_num) 
		{ 
			// A temporary array to store all combination one by one 
			int data[]=new int[r]; 

			// Print all combination using temprary array 'data[]' 
			combinationUtil(ans, data, 0, n-1, 0, r, K,case_num);
		} 

}
