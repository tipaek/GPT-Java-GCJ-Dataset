import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
 {
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int test = Integer.parseInt(br.readLine()); 
  
	    for(int idx = 1; idx <= test; idx++) {
	        int n = Integer.parseInt(br.readLine());
	        int[][] time = new int[n][3];
	        int posC = -1;
	        int posJ = -1;
	        char[] chars = new char[n];
	        String[] firstVals = br.readLine().trim().split(" ");
	        time[0][0] = Integer.parseInt(firstVals[0]);
	        time[0][1] = Integer.parseInt(firstVals[1]);
	        time[0][2] = 0;
	        
	        for(int i = 1; i < n; i++) {
	            String[] vals = br.readLine().trim().split(" ");
	            time[i][0] = Integer.parseInt(vals[0]);
	            time[i][1] = Integer.parseInt(vals[1]);
	            time[i][2] = i;
	            int keyStart = time[i][0];
	            int keyEnd = time[i][1];
	            int keyPos = time[i][2];
                int j = i - 1; 
      
                while (j >= 0 && time[j][0] > keyStart) { 
                    time[j + 1][0] = time[j][0]; 
                    time[j + 1][1] = time[j][1]; 
                    time[j+1][2] = time[j][2];
                    j = j - 1; 
                } 
                time[j+1][0] = keyStart;
                time[j+1][1] = keyEnd;
                time[j+1][2] = keyPos;
	        }

	        posC = 0;
	        chars[time[0][2]] = 'C';
	        int flag = 0;
	        for(int i = 1; i < n; i++) {
	            if((time[i][0] - time[posC][1]) >= 0) {
	                chars[time[i][2]] = 'C';
	                //res.replace(time[i][2], time[i][2]+1, 'C');
	                posC = i;
	            }
	            else if(posJ == -1) {
	                chars[time[i][2]] = 'J';
	                //res.replace(time[i][2], time[i][2]+1, 'J');
	                posJ = i;
	            }
	            else if((time[i][0] - time[posJ][1]) >= 0) {
	                chars[time[i][2]] = 'J';
	                //res.replace(time[i][2], time[i][2] +1, 'J');
	                posJ = i;
	            }
	            else {
	                flag = -1;
	                break;
	            }
	            
	        }
	        System.out.print("Case #" + idx + ": ");
	        if(flag == -1) {
	            System.out.println("IMPOSSIBLE");
	        }
	        else {
	            for(int  i = 0 ; i< n; i++) {
	                
	                System.out.print(chars[i]);
	            }
	            System.out.println();
	            /*for(int i = 0; i < n; i++) {
	                System.out.println(time[i][0]);
	                System.out.println("pos : " + time[i][2]);
	            }*/
	        }
	        
	        
	    }
    }
}