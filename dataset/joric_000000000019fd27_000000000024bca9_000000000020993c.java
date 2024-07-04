import java.util.ArrayList;
import java.util.Scanner;

public class Vestigium {
	public static void main(String[] args) {
		Vestigium vestigium = new Vestigium();
		vestigium.inputString();
		
//		int[][] arr1 = {{1, 2, 3, 4}, {2, 1, 4, 3}, {3, 4, 1, 2}, {4, 3, 2, 1}};
//		int[][] arr2 = {{2, 2, 2, 2}, {2, 3, 2, 3}, {2, 2, 2, 3}, {2, 2, 2, 2}};
//		int[][] arr3 = {{2, 1, 3}, {1, 3, 2}, {1, 2, 3}};
//
//		vestigium.checkLatinSquare(1, arr1);
//		vestigium.checkLatinSquare(2, arr2);
//		vestigium.checkLatinSquare(3, arr3);
	}
	
	public void inputString() {
		Scanner sc = new Scanner(System.in);
		int caseNum = Integer.parseInt(sc.nextLine());
		
		ArrayList<int[][]> list = new ArrayList<int[][]>();
		
		String intString;
		String[] numString;
		int[] nums;
		
		for(int i = 0; i < caseNum; i ++) {
			int squareSize = Integer.parseInt(sc.nextLine());
			
			int[][] square = new int[squareSize][];
			
			for(int j = 0; j < squareSize; j ++) {
				intString = sc.nextLine();
				
				numString = intString.split(" ");
				nums = new int[numString.length];
				
				for(int k = 0; k < numString.length; k ++) {
					nums[k] = Integer.parseInt(numString[k]);
				}
				
				square[j] = nums;
			}
			
			list.add(square);
		}
		  
		sc.close();
		
		for(int i = 0; i < list.size(); i ++) {
			this.checkLatinSquare(i+1, list.get(i));
		}
    }
	
	public void checkLatinSquare(int caseNum, int[][] square) {
		int trace=0, errRows=0, errCols=0;
		int squareSize = square.length;
		
		int[] checkArray = new int[squareSize]; 
		
		
		for(int i=0; i<squareSize; i++) {
			trace += square[i][i];
		}
		
		for(int i=0; i<squareSize; i++) {
			checkArray = this.initArray(checkArray);
			
			for(int j=0; j<squareSize; j++) {
				if(checkArray[square[i][j]-1]==0) {
					checkArray[square[i][j]-1] = 1;
				}else {
					errRows++;
					break;
				}
			}
		}
		
		for(int j=0; j<squareSize; j++) {
			checkArray = this.initArray(checkArray);
			
			for(int i=0; i<squareSize; i++) {
				if(checkArray[square[i][j]-1]==0) {
					checkArray[square[i][j]-1] = 1;
				}else {
					errCols++;
					break;
				}
			}
		}
		
		
		
		System.out.println("Case #"+caseNum+": "+trace+" "+errRows+" "+errCols);
	}
	
	public int[] initArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			array[i] = 0;
		}
		
		return array;
	}
}
