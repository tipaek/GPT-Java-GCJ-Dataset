import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) throws FileNotFoundException {
        //Scanner in = new Scanner(new File("testcase.txt"));
    	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(in.nextLine());
        for(int i=0; i<T; i++) {
        	String[] RC = in.nextLine().split(" ");
        	int R = Integer.valueOf(RC[0]);
        	int C = Integer.valueOf(RC[1]);
        	//System.out.println("R: "+R+"  C: "+C);
        	String[][] dancers = new String[R][C];
        	for(int j=0; j<R; j++) {
        		String s = in.nextLine();
        		dancers[j] = s.split(" ");
        	}
        	
        	//String[][] test = {{"3","1","2"}};
        	//System.out.println(continueOn(test));
        	//System.out.println(calculateNeighborsAvg(0,2,test));
        	
        	int answer = solve(R, C, dancers);
        	
        	System.out.println("Case #"+(i+1)+": "+answer);
        }
    }
    public static int solve(int R, int C, String[][] dancers) {
    	int answer = 0;
    	for(int i=0; i<R; i++) {
    		for(int j=0; j<C; j++) {
    			answer += Integer.valueOf(dancers[i][j]);
    		}
    	}
    	boolean continueComp = continueOn(dancers);
    	ArrayList<Integer> remove = new ArrayList<>();
    	while(continueComp == true) {
    		for(int i=0; i<R; i++) {
    			for(int j=0; j<C; j++) {
    				if(calculateNeighborsAvg(i,j,dancers) > Integer.valueOf(dancers[i][j])) {
    					remove.add(i);
    					remove.add(j);
        				//dancers[i][j] = "0";
        			}
    				else {
    					answer += Integer.valueOf(dancers[i][j]);
    				}
    			}
    		}
    		for(int i = 0; i<remove.size(); i+=2) {
    			int x = remove.get(i);
    			int y = remove.get(i+1);
    			dancers[x][y] = "0";
    		}
    		continueComp = continueOn(dancers);
    	}
    	
    	return answer;
    }
    public static boolean continueOn(String[][] dancers) {
    	boolean continueOn = false;
    	for(int i=0; i<dancers.length; i++) {
    		for(int j = 0; j<dancers[0].length; j++) {
    			if(!dancers[i][j].equals("0") && calculateNeighborsAvg(i,j,dancers) > Integer.valueOf(dancers[i][j])) {
    				continueOn = true;
    				break;
    			}
    		}
    	}
    	return continueOn;
    }
    public static double calculateNeighborsAvg(int i, int j, String[][] dancers) {
    	double avg = 0;
    	int count = 0;
    	int sum = 0;
    	for(int col = j+1; col < dancers[0].length; col++) {
    		if(!dancers[i][col].equals("0")) {
    			sum += Integer.valueOf(dancers[i][col]);
    			count++;
    			
    			break;
    		}
    	}
    	for(int col = j-1; col >=0; col--) {
    		if(!dancers[i][col].equals("0")) {
    			sum += Integer.valueOf(dancers[i][col]);
    			count++;
    			break;
    		}
    	}
    	for(int row = i+1; row < dancers.length; row++) {
    		if(!dancers[row][j].equals("0")) {
    			sum += Integer.valueOf(dancers[row][j]);
    			count++;
    			
    			break;
    		}
    	}
    	for(int row = i-1; row >= 0; row--) {
    		if(!dancers[row][j].equals("0")) {
    			sum += Integer.valueOf(dancers[row][j]);
    			count++;
    			break;
    		}
    	}
    	avg = ((double) sum / count);
    	return avg;
    }
}