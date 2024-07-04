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
        	String[][] og = new String[N][2];
        	for(int j=0; j<N; j++) {
        		String[] temp = in.nextLine().split(" ");
        		activities[j] = temp;
        		og[j] = temp;
        	}
        	Arrays.sort(activities, (a, b) -> Integer.valueOf(a[0]) - Integer.valueOf(b[0]));
        	String ans = solve(activities, og);
        	System.out.println("Case #"+(i+1)+": "+ans);
        }
        
     }
    public static String solve(String[][] matrix, String[][] og) {
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
    			Jindex = i+1;
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
    			begC = Integer.valueOf(matrix[Cindex][0]);
    			endC = Integer.valueOf(matrix[Cindex][1]);
    			ans += "C";
    			i+=1;
    		}
    	}
    	char[] output = new char[N];
    	ArrayList<String> ogArray = new ArrayList<String>();
    	for(String[] s : og) {
    		ogArray.add(s[0]);
    	}
    	for(int k=0; k<N; k++) {
    		String key = (matrix[k][0]);
    		int index = ogArray.indexOf(key);
    		ogArray.set(index, String.valueOf(Integer.MAX_VALUE));
    		output[index] = ans.charAt(k);
    	}
    	System.out.println(ans);
    	System.out.println(ogArray);
    	return String.valueOf(output);
    }
}