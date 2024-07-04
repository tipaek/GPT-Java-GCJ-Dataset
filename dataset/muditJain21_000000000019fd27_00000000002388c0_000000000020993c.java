import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jain
 */
public class Solution {
    
    public static void main(String[] args) throws IOException {
        
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    int test = 1;
	    while(test <= t) {
	        int n = Integer.parseInt(br.readLine());
	        int arr[][] = new int[n][n];
	        int temp[][] = new int[n][n];
	        for(int i = 0; i < n; i++) {
	            String line = br.readLine();
	            String strs[] = line.trim().split("\\s+");
	            for(int j = 0; j < n; j++) {
	                arr[i][j] = Integer.parseInt(strs[j]);
	                temp[i][j] = Integer.parseInt(strs[j]);
	            }
	        }
	        
	        int trace = 0;
	        for(int i = 0; i< n; i++) {
	            trace += arr[i][i];
	        }
	        
	        int rows = 0; int cols = 0;
	        
	        for(int i = 0; i < n; i++) {
	            for(int j = 0; j < n; j++) {
	                if(temp[i][(int)Math.abs(temp[i][j])-1] > 0) {
	                    temp[i][(int)Math.abs(temp[i][j])-1] = -temp[i][(int)Math.abs(temp[i][j])-1];
	                }
	                else {
	                    rows++;
	                    break;
	                }
	            }
	        }
	        
	        for(int i = 0; i < n; i++) {
	            for(int j = 0; j < n; j++) {
	                if(arr[(int)Math.abs(arr[j][i])-1][i] > 0) {
	                    arr[(int)Math.abs(arr[j][i])-1][i] = -arr[(int)Math.abs(arr[j][i])-1][i];
	                }
	                else {
	                    cols++;
	                    break;
	                }
	            }
	        }
	        
	        System.out.println("Case #"+test+": "+trace+" "+rows+" "+cols);
	        
                test++;
	    }
	 }
}