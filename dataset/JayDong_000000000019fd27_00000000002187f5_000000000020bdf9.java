import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) throws FileNotFoundException {
        //Scanner in = new Scanner(new File("testcase.txt"));
    	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(in.nextLine());
        for(int i=0; i<T; i++) {
        	int N = Integer.valueOf(in.nextLine());
        	String[][] activities = new String[N][2];
        	for(int j=0; j<N; j++) {
        		activities[j] = in.nextLine().split(" ");
        	}
        	Arrays.sort(activities, (a, b) -> Integer.valueOf(a[0]) - Integer.valueOf(b[0]));
        	String ans = solve(activities);
        	System.out.println("Case #"+(i+1)+": "+ans);
        }
        
     }
    public static String solve(String[][] matrix) {
    	String ans = "C";
    	int N = matrix.length;
    	int Cindex = 0;
    	int Jindex = 0;
    	String[] Ctask = matrix[Cindex];
    	int begC = Integer.valueOf(Ctask[0]);
    	int endC = Integer.valueOf(Ctask[1]);
    	int begJ = 0;
    	int endJ = 0;
    	int i = 0;
    	while(i<N-1) {
    		if(endC > Integer.valueOf(matrix[i+1][0]) && endJ <= Integer.valueOf(matrix[i+1][0])) {
    			Jindex = Cindex+1;
    			begJ = Integer.valueOf(matrix[Jindex][0]);
    			endJ = Integer.valueOf(matrix[Jindex][1]);
    			ans += "J";
    			i+=1;
    		}
    		else if(endC > Integer.valueOf(matrix[i+1][0]) && endJ > Integer.valueOf(matrix[i+1][0])) {
    			return "Impossible";
    		}
    		else if(endC <= Integer.valueOf(matrix[i+1][0])) {
    			Cindex = i+1;
    			begJ = Integer.valueOf(matrix[Cindex][0]);
    			endJ = Integer.valueOf(matrix[Cindex][1]);
    			ans += "C";
    			i+=1;
    		}
    	}
    	return ans;
    }
}