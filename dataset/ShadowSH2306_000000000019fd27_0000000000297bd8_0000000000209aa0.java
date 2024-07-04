import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


import java.io.*;

public class Solution {
	
	static int[][] finalList;
	static int[] availableNumList;
	
	
	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = in.nextInt();
		int count=1;
		int max_p=0;
		boolean checkImm=false;
		
		while(count<=t) {
			
			checkImm=false;
			
			int n = Integer.parseInt(in.next());
			finalList = new int[n][n];
			int k = Integer.parseInt(in.next());
			//System.out.println(n);
			//System.out.println(k);
			
			 availableNumList = new int[n];
			for (int i = 0; i < availableNumList.length; i++) {
				availableNumList[i]=(i+1);
			}
			
			List<List<Integer>> combinationList = availableCombinations(availableNumList, k);
			
			List<List<Integer>> combinationListTempList = new ArrayList<List<Integer>>();
			
			for (int i = 0; i < combinationList.size(); i++) {
				
				int index = i;
				List<Integer> tempList = combinationList.get(i);
				
				if (tempList.size()==n ) {
					if (Collections.frequency(tempList, tempList.get(0)) == tempList.size() && checkImm==false) {
						
						
						for (int m = 0; m < combinationList.get(i).size(); m++) {
							
							finalList[m][m] = combinationList.get(i).get(m);
							
						}
						
						finalList = createSquare(n);
						displaySquare();
						System.out.println();
						
						boolean checkLatin = checkLatinSquare();
						
						//System.out.println("Check: "+checkLatin);
						
						if (checkLatin) {
							System.out.println("Case #"+count+": POSSIBLE");
							displaySquare();
							checkImm=true;
							break;
						}
						
						
					}
					Collections.shuffle(tempList);
					combinationListTempList.add(tempList);
					
					
					
					
					
					/*for (int temp : tempList) {
						int occurrences = Collections.frequency(tempList, temp);
						 if (occurrences > max_p) {
							max_p = occurrences;
							max_ind=i;
							System.out.println("Max: "+max_ind);
						}
					}*/
					
				}
			}
			
			if (checkImm) {
				count+=1;
				continue;
			}
			
			System.out.println("Max: "+max_p);
			
			
			
			combinationList.clear();
			combinationList.addAll(combinationListTempList);
			
			System.out.println(combinationList.toString());
			
			
			
			if (combinationList.size()==0) {
				
				System.out.println("Case #"+count+": IMPOSSIBLE");
				count+=1;
				continue;
			}
			
			else {
				int cnt=0;
				boolean checkLatin=false;
				
				
				
				
				while(cnt<combinationList.size())
				{
					
					
					
				
					
				
				for (int i = 0; i < combinationList.get(cnt).size(); i++) {
					
					finalList[i][i] = combinationList.get(cnt).get(i);
					
				}
				
				finalList = createSquare(n);
				displaySquare();
				System.out.println();
				
				checkLatin = checkLatinSquare();
				
				//System.out.println("Check: "+checkLatin);
				
				if (checkLatin) {
					System.out.println("Case #"+count+": POSSIBLE");
					displaySquare();
					break;
				}
				
				
				cnt+=1;
				
			}
				
				if (!checkLatin) {
					System.out.println("Case #"+count+": IMPOSSIBLE");
				}
			}
			finalList=null;
			availableNumList=null;
			combinationList.clear();
			combinationListTempList.clear();
			count+=1;
			
		}
		
		
		
		
	}
	
	public static void displaySquare() {
		
		for (int i = 0; i < finalList.length; i++) {
			for (int j = 0; j <  finalList.length; j++) {
				
				System.out.print(finalList[i][j]+" ");
				
			}
			
			System.out.println();
		}
		
		
	}
	
	
	public static int[][] createSquare(int n ) {
		int cnt=0;
		
		int turns=0;
		
		
		
		
		for (int i = 0; i < n; i++) {
			
			turns=0;
			
			int tempItem = finalList[i][i];
			
			
			if (tempItem==n) {
				cnt=0;
			}
			
			
			else {
				cnt = availableNumList[tempItem];
			}
			
			
			
			
			int j=i+1;

			while(turns<n)
			{
				
				if (j>=n) {
					j=0;
				}
				
				if (i!=j) {
					
					
					
					
					if (cnt>=n) {
						cnt = 0;
					}
					
					if (availableNumList[cnt]==tempItem) {
						cnt+=1;
						if (cnt>=n) {
							cnt = 0;
						}
					}
					
					finalList[i][j] = availableNumList[cnt];
					cnt+=1;
					turns+=1;
					//System.out.println("Cnt: "+cnt);
					
				}
			j++;
				
			}
			
			
			
			
			tempItem=0;
			cnt=0;
		}
		
		return finalList;
	}
	
	public static boolean checkLatinSquare() 
    {
        for (int i = 0; i<finalList.length ;i++) 
        {
            if(checkCopies(finalList[i]))
            {
                return false;
            }

            int[] column = new int[finalList[i].length]; 
            for(int j = 0; j<finalList.length; j++)
            {
                column[j] = finalList[j][i]; 
            }

            if(checkCopies(column))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean checkCopies(int[] tempArray)
    {
        for (int i = 0; i<tempArray.length; i++) 
        {
            for(int j = 0; j<tempArray.length; j++)
            {
                if (i != j && (tempArray[i] == tempArray[j]))
                {
                	tempArray=null;
                    return true;
                }
            }    
        }
        tempArray=null;
        return false;
    }
	
	
	public static List<List<Integer>> availableCombinations(int[] availableNums, int targetNum) {
	    List<List<Integer>> ansList = new ArrayList<>();
	    List<Integer> tempList = new ArrayList<>();
	    availableCombinations2(availableNums, 0, targetNum, 0, tempList, ansList);
	    tempList.clear();
	    return ansList;
	}
	 
	public static void availableCombinations2(int[] availableNums, int start, int targetNum, int sum,
	                    List<Integer> list, List<List<Integer>> resultList2){
	    if(sum>targetNum){
	    	
	        return;
	    }
	 
	    if(sum==targetNum){
	        resultList2.add(new ArrayList<>(list));
	        
	        return;
	    }
	 
	    for(int i=0; i<availableNums.length; i++){
	        list.add(availableNums[i]);
	        availableCombinations2(availableNums, i, targetNum, sum+availableNums[i], list, resultList2);
	        list.remove(list.size()-1);
	    }
	}
	
	
	
	
	


}
