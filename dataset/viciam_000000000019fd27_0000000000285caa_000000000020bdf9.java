import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	int cases [][][];
	
	public Solution(){
		
	}
		
	public String solvePuzzle(int nr, int [][] input){
		int cT =0;
		int jT =0;
		String[] result = new String[input.length];
		Arrays.sort(input, (x,y) -> (x[0] < y[0] ? -1: 1));
		
		for (int i=0; i<input.length; i++){
			if (input[i][0] >= cT){
				cT = input[i][1];
				result[ input[i][2]] = "C";
			}else if (input[i][0] >= jT){
				jT = input[i][1];
				result[ input[i][2]] = "J";
			} else {
				return "Case #"+nr+": IMPOSSIBLE";
			}
		}
		String finalResult = "";
		for(String s : result){
			finalResult =finalResult+s;
		}
				
		
		return "Case #"+nr+": "+finalResult;
	}
	public void run(){
		parseInput();
		
		for (int i=0; i< cases.length; i++){
			System.out.println(solvePuzzle(i+1, cases[i]));
		}
	}
	public void parseInput(){		
		Scanner s= new Scanner(System.in);
		int nrCases = Integer.parseInt(s.nextLine());
		cases = new int[nrCases][][];
		
		for (int i=0; i<nrCases; i++){
			int size = Integer.parseInt(s.nextLine());
			cases[i] = new int[size][3];
			for (int j=0; j< size; j++){
				String[] nrs = s.nextLine().split(" ");
				cases[i][j][2] = j;
				for (int k=0; k< 2; k++){
					cases[i][j][k] =  Integer.parseInt(nrs[k]);
				}
			}
		}
		s.close();
	}
	public static void main(String[] args) {
		(new Solution()).run();
	}

}
