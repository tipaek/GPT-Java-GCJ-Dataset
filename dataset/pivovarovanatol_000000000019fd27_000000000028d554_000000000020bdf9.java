
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
 
public class Solution {
    public static void solve(Scanner input, int caseNum, int[][] nums, int n) {
    	int trace = 0;
    	boolean cam = false;
    	boolean jam = false;
    	int[] curJam = {Integer.MIN_VALUE,Integer.MIN_VALUE};
    	int[] curCam = {Integer.MIN_VALUE,Integer.MIN_VALUE};
    	String sched = "";
    	String assignedTo = "";
    	HashMap<String, String> tasksMap = new HashMap<>();
    	
    	TreeMap<Integer, int[]> map = new TreeMap<>();
    	
    	for (int i=0;i<n;i++) {
    		map.put(nums[i][0], nums[i]);
    	}
    	
    	for(Map.Entry<Integer,int[]> entry : map.entrySet()) {
    		  // int key = entry.getKey();
    		  int[] value = entry.getValue();
    		  
    		  // if jamie is not busy - assign task
    		  if (curJam[1] <= value[0]) {
    			  assignedTo = "C";
    			  //sched += "C";
    			  tasksMap.put(value[0] + "|" + value[1], assignedTo);
    			  curJam = value;
    		  } else if (curCam[1]<=value[0]) {
    			  assignedTo = "J";
    			  //sched += "J";
    			  tasksMap.put(value[0] + "|" + value[1], assignedTo);
    			  curCam = value;
    		  } else {
    			  sched = "IMPOSSIBLE";
    			  System.out.println("Case #" + caseNum + ": " + sched);
    			  return;
    		  }
    		  //System.out.println("Time is from:" + value[0] + " to " + value[1] + " assigned to " +assignedTo);
    		}
    	
    	for (int i=0;i<n;i++) {
    		sched += tasksMap.get(nums[i][0] + "|" + nums[i][1]);
    	}
    	
        System.out.println("Case #" + caseNum + ": " + sched);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
         try {
 			input = new Scanner(new FileInputStream(new File("C:\\Users\\i855719\\git\\kickstart\\KickStart\\CodeJam2020\\qalificationRound\\PArentingPartneringReturns\\input.txt")));
 		} catch (FileNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        // number of cases
        int T = input.nextInt();
        
        // for every case - execute the solution
        for (int ks = 1; ks <= T; ks++) {
        	int N = input.nextInt();
            int[][] nums = new int[N][2];
        	
            for (int i=0;i<N;i++) {
                nums[i][0] = input.nextInt();
                nums[i][1] = input.nextInt();
            }
            solve(input, ks, nums, N);
        }
        
        input.close();
        
    }
}
