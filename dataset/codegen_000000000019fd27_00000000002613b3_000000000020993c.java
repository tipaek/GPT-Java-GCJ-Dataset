import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		
		for(int t=1; t<=T; t++){
			int k = 0;
			int r = 0;
			int c = 0;
			HashMap<Integer, ArrayList<Integer>> columns = new HashMap<Integer, ArrayList<Integer>>();
			
			int N = in.nextInt();
			for(int i=0; i<N; i++){
				ArrayList<Integer> rowList = new ArrayList<Integer>();
				for(int j=0; j<N; j++){
					int val = in.nextInt();
					rowList.add(val);
					
					if(!columns.containsKey(j)){
						columns.put(j, new ArrayList<Integer>());
					}
					ArrayList<Integer> column = columns.get(j);
					column.add(val);
					
					if(i == j){
						k += val;
					}
				}
				if(checkDuplicate(rowList)){
					r++;
				}
			}
			for(int i=0; i<N; i++){
				ArrayList<Integer> column = columns.get(i);
				if(checkDuplicate(column)){
					c++;
				}
			}
			
			System.out.println("Case #" + t +": " + k + " " + r + " " + c);
		}
	}
	
	public static boolean checkDuplicate(ArrayList<Integer> inputList){
		HashMap<Integer, Object> resultMap = new HashMap<Integer, Object>();
	    for (Integer element : inputList) {
	        if (resultMap.containsKey(element)) {
	            return true;
	        }
	        else {
	            resultMap.put(element, null);
	        }
	    }
	    return false;
	}

}
