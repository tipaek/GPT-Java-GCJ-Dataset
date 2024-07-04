import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int len=Integer.parseInt(sc.nextLine());
        for(int i=0;i<len;i++){
            int currInput=Integer.parseInt(sc.nextLine());
            int inputArr[][] =new int [currInput][currInput];
            for(int j=0;j<currInput;j++) {
            	String[] currRow=sc.nextLine().split(" ");
            	for(int k=0;k<currInput;k++) {
            		inputArr[j][k]=Integer.parseInt(currRow[k]);
            	}
            }
            performCalcuation(inputArr,currInput,i);
            
        }
    }

	private static void performCalcuation(int[][] inputArr, int length,int testcase) {
		int diagSum = 0,duplicateRow=1,duplicateCol=1;
		Map<Integer,Integer> rowMap=new HashMap<Integer,Integer>();
		Map<Integer,Integer> colMap=new HashMap<Integer,Integer>();
		for(int i=0;i<length;i++) {
			diagSum+=inputArr[i][i];
			rowMap.clear();
			colMap.clear();
			for(int j=0;j<length;j++) {
				int tempRowVal=inputArr[i][j];
				if(rowMap.containsKey(tempRowVal)) {
					int temp=rowMap.get(tempRowVal)+1;
					rowMap.put(tempRowVal, temp);
					if(temp>duplicateRow)
						duplicateRow=temp;
				}else {
					rowMap.put(tempRowVal, 1);
				}
			}
			for(int j=0;j<length;j++) {
				int tempColVal=inputArr[j][i];
				if(colMap.containsKey(tempColVal)) {
					int temp=colMap.get(tempColVal)+1;
					colMap.put(tempColVal, temp);
					if(temp>duplicateCol)
						duplicateCol=temp;
				}else {
					colMap.put(tempColVal, 1);
				}
			}
			
		}
		if(duplicateCol==1)
			duplicateCol=0;
		if(duplicateRow==1)
			duplicateRow=0;
		System.out.println("Case #"+(testcase+1)+": "+diagSum+" "+duplicateRow+" "+duplicateCol+" ");
        System.out.flush();
	}    
    
    
}