import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		try(Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))){
			int t = Integer.parseInt(in.nextLine());
			
		    for (int i = 1; i <= t; ++i) {
		    	int target = Integer.parseInt(in.nextLine());

				System.out.println("Case #" + i + ":");
				for(String step: findAnswer(target)){
					System.out.println(step);
				}
		    }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static List<String> findAnswer(int target){
		List<String> steps = new ArrayList<>();
		
		//let's only concern ourselves with col 1 and 2 just to keep this problem simple
		int sum = 1;
		int currentRow = 1;
		int currentCol = 1;
		steps.add(currentRow + " " + currentCol);
		
		if(target > 1){
			currentRow++;
			sum += 1;
			steps.add(currentRow + " " + currentCol);
		}
		
		//currentRow will both serve as the counter for the row, and for the value in column 2 for that row..
		while(sum != target){
			boolean lateralMove = false;
			if( (sum + currentRow) > target ){
				if(currentCol == 2){
					lateralMove = true;
				}
				currentCol = 1;
				sum += 1;
			}
			else{
				currentCol = 2;
				sum += currentRow;
			}
			
			if(!lateralMove){
				currentRow++;
			}
			
			steps.add(currentRow + " " + currentCol);
		}
		
		return steps;
	}
	
}
