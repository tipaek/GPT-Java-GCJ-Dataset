import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	int k=0;
	int r=0;
	int c=0;
	
	public Solution(Scanner in) {
		strMethod(in);
	}
	void strMethod(Scanner in) {
        int N = in.nextInt();
        in.nextLine();
        //ArrayList<String> rows = new ArrayList<String>();
        ArrayList<StringBuilder> cols = new ArrayList<StringBuilder>();
        for (int i = 0; i < N; i++) {
        	cols.add(new StringBuilder(""));
        }
        for (int i = 0; i < N; i++) {
        	StringBuilder row = new StringBuilder(in.nextLine().trim() + " "); 
        	//rows.add(row);
        	for(int n=1; n<=N; n++) {
        		if(row.indexOf(Integer.toString(n)+" ")<0) {
        			r++;
        			break;
        		}
        	}
        	//String[] numbers = row.split(" ");
	        for(int j=0; j<N; j++) {
	        	int pos = row.indexOf(" ");
	        	String str = row.substring(0, pos+1);
	        	//System.out.println(i+","+j+"="+str);
	        	cols.get(j).append(str);
	        	if (i==j) {
	        		k += Integer.parseInt(str.trim());
	        	}    	
	        	row.delete(0, pos+1);
	        }       	
        }

        for(int j=0; j<N; j++) {
        	for(int n=1; n<=N; n++) {
        		if(cols.get(j).indexOf(Integer.toString(n)+" ")<0) {
        			c++;
        			break;
        		}
        	}
        }
 
	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        int TS = in.nextInt();
        ArrayList<Solution> solution = new ArrayList<Solution>();
        for (int ts = 0; ts < TS; ts++ ) {
        	solution.add(new Solution(in));
        }
        in.close();
        for (int ts = 0; ts < TS; ts++ ) {
        	Solution s = solution.get(ts);
        	System.out.println("Case #" + (ts+1) + ": " + s.k + " "+  s.r + " " + s.c);
        }
	}
}
