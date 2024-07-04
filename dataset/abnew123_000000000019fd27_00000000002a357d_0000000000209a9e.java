import java.util.Scanner;

public class Solution {
  public static void solve(Scanner input, int b) {
    boolean[] data = new boolean[b];
    if(b == 10) {
    		for(int i = 1; i <= 10; i ++) {
    			System.out.println(i);
    			String s = input.next();
    			data[i-1] = Integer.parseInt(s) == 1;
    		}
    		String answer = "";
    		for(int i = 0; i < 10; i++) {
    			answer += data[i]?1:0;
    		}
    		System.out.println(answer);
    		if(input.next().equals("Y")) {
    			return;
    		}
    		else {
    			return;
    		}
    }
    else {
    		int counter = 0;
    		int[] checkers = new int[4];
    		int type = -1;
    		int switchCase = 0;
    		while(counter < (b/2)) {
    			if(type == -1) {
    				System.out.println(1);
    				String tmp = input.next();
    				System.out.println(1);
    				tmp = input.next();
    			}
    			if(type == 0) {
    				//base type
    				//comp checkers
    				System.out.println(checkers[0] + 1);
    				boolean tmp = Integer.parseInt(input.next()) == 1;
    				System.out.println(checkers[1] + 1);
    				boolean tmp2 = Integer.parseInt(input.next()) == 1;
    				if(tmp == data[checkers[0]] && tmp2 == data[checkers[1]]) {
    					switchCase = 0;
    				}
    				if(tmp == data[checkers[0]] && tmp2 != data[checkers[1]]) {
    					switchCase = 3;
    				}
    				if(tmp != data[checkers[0]] && tmp2 != data[checkers[1]]) {
    					switchCase = 2;
    				}
    				if(tmp != data[checkers[0]] && tmp2 == data[checkers[1]]) {
    					switchCase = 1;
    				}
    			}
    			if(type == 1) {
    				//same case
    				//comp only 1 check, waste a move
    				System.out.println(checkers[0]+1);
    				String tmp = input.next();
    				if(data[checkers[0]] == (Integer.parseInt(tmp) == 1)) {
    					switchCase = 0;
    				}
    				else {
    					switchCase = 2;
    				}
    				System.out.println(1);
    				tmp = input.next();
    			}
    			if(type == 2) {
    				//diff case
    				//comp 1 check, waste a move
    				System.out.println(checkers[0] + 1);
    				String tmp = input.next();
    				if(data[checkers[0]] == (Integer.parseInt(tmp) == 1)) {
    					switchCase = 2;
    				}
    				else {
    					switchCase = 0;
    				}
    				System.out.println(1);
    				tmp = input.next();
    			}
    			fixData(switchCase, data);
    			if((b/2) - counter > 4) {
    				int[] arr = run_iteration(input, data, switchCase, counter);
    				type = arr[4];
    				for(int k = 0; k < 4; k++) {
    					checkers[k] = arr[k];
    				}
    			}
    			else {
    				for(int i = 0; i < (b/2) - counter; i++) {
    					System.out.println(data.length - i - counter);
    					String s = input.next();
    					data[data.length - i - counter - 1] = Integer.parseInt(s) == 1;
    					System.out.println(i+1 + counter);
    					s = input.next();
    					data[i + counter] = Integer.parseInt(s) == 1;
    				}
    				String answer = "";
	    	    		for(int i = 0; i < data.length; i++) {
	    	    			answer += data[i]?1:0;
	    	    		}
	    	    		System.out.println(answer);
	    	    		if(input.next().equals("Y")) {
	    	    			return;
	    	    		}
	    	    		else {
	    	    			return;
	    	    		}
    			}
    			counter+=4;
    		}
    		
    		
    }
  }
  private static void fixData(int switchCase, boolean[] data) {
	  if(switchCase == 0) {
		  //do nothing
	  }
	  if(switchCase == 1 || switchCase == 3) {
		  boolean[] data2 = new boolean[data.length];
		  for(int i = 0; i < data.length; i++) {
			  data2[i] = data[data.length - i - 1];
		  }
		  for(int i = 0; i < data.length; i++) {
			  data[i] = data2[i];
		  }
	  }
	  if(switchCase == 2 || switchCase == 3) {
		  for(int i = 0; i < data.length; i++) {
			  data[i] = !data[i];
		  }
	  }
  }
  //returns new type
  private static int[] run_iteration(Scanner input, boolean[] data, int switchCase, int counter) {
	//find checkers
	String s = "";
	int type = 0;
	boolean[] set1 = new boolean[4];
	boolean[] set2 = new boolean[4];
	for(int i = 0; i < 4; i++) {
		System.out.println(data.length - i - counter);
		s = input.next();
		data[data.length - i - counter - 1] = Integer.parseInt(s) == 1;
		set2[i] = Integer.parseInt(s) == 1;
		System.out.println(i+1 + counter);
		s = input.next();
		data[i + counter] = Integer.parseInt(s) == 1;
		set1[i] = Integer.parseInt(s) == 1;
	}
	boolean allSame = true;
	boolean allDiff = true; 
	for(int i = 0; i < 4; i++) {
		if(set1[i] == set2[i]) {
			allDiff = false;
		}
		else {
			allSame = false;
		}
	}
	int[] answer = new int[5];
	if(!allSame && !allDiff) {
		type = 0;
		for(int i = 0; i < 4; i++) {
			if(set1[i] != set2[i]) {
				answer[0] = counter+i;
				answer[2] = data.length - counter - 1 - i;
			}
		}
		for(int i = 0; i < 4; i++) {
			if(set1[i] == set2[i]) {
				answer[1] = counter+i;
				answer[3] = data.length - counter - 1 - i;
			}
		}
		
	}
	if(allSame) {
		type = 1;
		answer[0] = counter;
		answer[1] = 0; //throwaway
		answer[2] = data.length - counter - 1;
		answer[3] = 0; //throwaway
	}
	if(allDiff) {
		type = 2;
		answer[0] = counter;
		answer[1] = 0; //throwaway
		answer[2] = data.length - counter - 1;
		answer[3] = 0; //throwaway
	}
	
	answer[4] = type;
	return answer;
  }
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = Integer.parseInt(input.next());
    int B = Integer.parseInt(input.next());
    for (int ks = 1; ks <= T; ks++) {
    		solve(input, B);
    }
  }
}
