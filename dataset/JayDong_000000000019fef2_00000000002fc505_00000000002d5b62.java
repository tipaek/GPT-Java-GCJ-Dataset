import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) throws FileNotFoundException {
        //Scanner in = new Scanner(new File("testcase.txt"));
    	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(in.nextLine());
        for(int i=0; i<T; i++) {
        	String[] parameters = in.nextLine().split(" ");
        	String answer = solve(Integer.valueOf(parameters[0]), Integer.valueOf(parameters[1]));
        	System.out.println("Case #" + (i+1) + ": "+answer);
        }
        
    }
    public static String solve(int x, int y) {
    	
    	String ans = "";
    	if(Math.abs(x)%2 == 0 && Math.abs(y) % 2 == 0) {
    		ans = "IMPOSSIBLE";
    	}
    	else if(Math.abs(x)%2 == 1 && Math.abs(y) %2 == 1) {
    		ans = "IMPOSSIBLE";
    	}
    	else {
    		int sum = Math.abs(x + y);
        	int minMoves = 0;
        	for(int i = 0; i<32; i++) {
        		if(Math.pow(2, i) <= sum) {
        			minMoves = i+1;
        		}
        		else {
        			break;
        		}
        	}
        	//NNNN NNNE 
        	List<String> combos = generatePermutations("NESW", minMoves);
        	boolean found = false;
        	for(int i = 0; i<combos.size(); i++) {
        		String combo = combos.get(i);
        		if(endPoint(combo)[0] == x && endPoint(combo)[1] == y) {
        			ans = combo;
        			found = true;
        			break;
        		}
        	}
        	if(found == false) {
        		ans = "IMPOSSIBLE";
        	}
    	}
    	
    	return ans;
    }
    public static int[] endPoint(String s) {
    	int[] ans = new int[2];
    	int x = 0; int y = 0;
    	for(int i=0; i<s.length(); i++) {
    		if(s.substring(i, i+1).equals("N")) {
    			y += Math.pow(2, i);
    		}
    		else if(s.substring(i, i+1).equals("E")) {
    			x += Math.pow(2, i);
    		}
    		else if(s.substring(i, i+1).equals("S")) {
    			y -= Math.pow(2, i);
    		}
    		else {
    			x -= Math.pow(2, i);
    		}
    	}
    	ans[0] = x;
    	ans[1] = y;
    	return ans;
    }
    public static List<String> generatePermutations(String str,int k){
		
		List permList = new LinkedList<String>();
		for(int j = 0; j < str.length(); j++){
			permList.add(str.charAt(j));
		}
	
		do{
			
			for(int x = 0; x < str.length(); x++){
				String newElement = permList.get(0).toString() + str.charAt(x);
				permList.add(newElement.toString());
			}
			permList.remove(0);
			
		}while(permList.get(0).toString().length() != k);
		
		return(permList);
		
		
	}
}