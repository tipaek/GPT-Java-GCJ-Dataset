import java.util.*;

public class Solution {
  public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
    String[] input = in.nextLine().split(" ");
    int t = Integer.valueOf(input[0]);
    int bits = Integer.valueOf(input[1]);
    
    for (int i = 1; i <= t; i++) {
    	//start of test case
    	ArrayList<Integer> data = new ArrayList<Integer>();
    	for(int j=0; j < 10; j++) {
    		System.out.println(j+1);
    		int nbit = Integer.valueOf(in.nextLine());
    		data.add(nbit);
    	}
    	String output = "";
    	for(Integer a : data) {
    		output = output + a;
    	}
    	System.out.println(output);
    	
    	String response = in.nextLine();
    	if(response.equals("N")) System.exit(0);
    }
  }
    
}
  
 
