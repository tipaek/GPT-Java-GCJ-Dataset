import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args){
		try(Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))){
			int t = Integer.parseInt(in.nextLine());
			
		    for (int i = 1; i <= t; ++i) {
		    	String[] line = in.nextLine().split(" ");
		    	int squareHeight = Integer.parseInt(line[0]);
		    	
		    	int[][] square = new int[squareHeight][squareHeight];
		    	Set<Integer> rowsWithDuplicates = new HashSet<>();
		    	Set<Integer> colsWithDuplicates = new HashSet<>();
		    	
		    	Map<Integer, Set<Integer>> colsIntMap = new HashMap<>();

		    	int latinSquare = 0;
				int latinSquareIndex = 0;
		    	
		    	for(int row = 0; row < squareHeight; row++){
		    		square[row] = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		    		
		    		Set<Integer> intsForRow = new HashSet<>();
		    		for(int col = 0; col < square[row].length; col++){
		    			int thisInt = square[row][col];
		    			
		    			if(latinSquareIndex == col){
		    				latinSquare += thisInt;
		    			}
		    			Set<Integer> intsForCol = colsIntMap.computeIfAbsent(col, c -> new HashSet<>());
		    			
		    			
		    			if(intsForRow.contains(thisInt)){
		    				rowsWithDuplicates.add(row);
		    			}
		    			if(intsForCol.contains(thisInt)){
		    				colsWithDuplicates.add(col);
		    			}
		    			
		    			intsForRow.add(thisInt);
		    			intsForCol.add(thisInt);
		    		}
    				latinSquareIndex++;
		    	}
		    	
				System.out.println("Case #" + i + ": " + latinSquare + " " + rowsWithDuplicates.size() + " " + colsWithDuplicates.size()) ;
		    }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
