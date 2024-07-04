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
		
		while(count<=t) {
			
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
				
				
				List<Integer> tempList = combinationList.get(i);
				if (tempList.size()==n) {
					combinationListTempList.add(tempList);
					
				}
			}
			
			combinationList.clear();
			combinationList.addAll(combinationListTempList);
			
			//System.out.println(combinationList.toString());
			
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
					
					
				int[][] checkList = new int[n][n];
					
				
				List<Integer> tempDiagonalList = new ArrayList<Integer>();
				tempDiagonalList= combinationList.get(cnt);
				for (int i = 0; i < n; i++) {
					
					checkList[i][i] = tempDiagonalList.get(i);
					
				}
				
				checkList = createSquare(n, checkList);
				//displaySquare(checkList);
				
				checkLatin = checkLatinSquare(checkList);
				//System.out.println("Check: "+checkLatin);
				
				if (checkLatin) {
					finalList = checkList;
					System.out.println("Case #"+count+": POSSIBLE");
					displaySquare(finalList);
					break;
				}
				
				
				cnt+=1;
				
			}
				
				if (!checkLatin) {
					System.out.println("Case #"+count+": IMPOSSIBLE");
				}
			}
			
			
			count+=1;
			
		}
		
		
		
		
	}
	
	public static void displaySquare(int[][] tempMat) {
		
		for (int i = 0; i < tempMat.length; i++) {
			for (int j = 0; j < tempMat.length; j++) {
				
				System.out.print(tempMat[i][j]+" ");
				
			}
			
			System.out.println();
		}
		
	}
	
	
	public static int[][] createSquare(int n, int[][] sampleList) {
		int cnt=0;
		
		int turns=0;
		
		int[][] finalTempList = sampleList;
		
		
		for (int i = 0; i < n; i++) {
			
			turns=0;
			
			int tempItem = finalTempList[i][i];
			List<Integer> availableTempList = IntStream.of(availableNumList)
		              .boxed().collect(Collectors.toCollection(ArrayList::new));
			//System.out.println("Available items: "+availableTempList.toString());
			availableTempList.remove(availableTempList.indexOf(tempItem));
			if (tempItem==n) {
				cnt=0;
			}
			
			
			else {
				cnt = availableTempList.indexOf(tempItem+1);
			}
			
			
			
			
			int j=i+1;

			while(turns<(n-1))
			{
				
				if (j>=n) {
					j=0;
				}
				
				if (i!=j) {
					
					
					//System.out.println("Cnt: "+cnt);
					if (cnt>=(n-1)) {
						cnt = 0;
					}
					
					finalTempList[i][j] = availableTempList.get(cnt);
					cnt+=1;
					turns+=1;
					//System.out.println("Cnt: "+cnt);
					
				}
			j++;
				
			}
			
			
			/*if (turns<n) {
				for (int j = 0; turns <n; j++) {
					if (i!=j) {
						
						
						System.out.println("Cnt: "+cnt);
						if (cnt>=(n-1)) {
							cnt = 0;
						}
						
						finalTempList[i][j] = availableTempList.get(cnt);
						cnt+=1;
						turns+=1;
						//System.out.println("Cnt: "+cnt);
						
					}
				}
			}*/
			
			availableTempList.clear();
			tempItem=0;
			cnt=0;
		}
		
		return finalTempList;
	}
	
	public static boolean checkLatinSquare(int[][] tempArray) 
    {
        for (int i = 0; i<tempArray.length ;i++) 
        {
            if(checkCopies(tempArray[i])==true)
            {
                return false;
            }

            int[] column = new int[tempArray[i].length]; 
            for(int j = 0; j<tempArray.length; j++)
            {
                column[j] = tempArray[j][i]; 
            }

            if(checkCopies(column)==true)
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
                    return true;
                }
            }    
        }
        return false;
    }
	
	
	public static List<List<Integer>> availableCombinations(int[] availableNums, int targetNum) {
	    List<List<Integer>> ansList = new ArrayList<>();
	    List<Integer> tempList = new ArrayList<>();
	    availableCombinations2(availableNums, 0, targetNum, 0, tempList, ansList);
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
