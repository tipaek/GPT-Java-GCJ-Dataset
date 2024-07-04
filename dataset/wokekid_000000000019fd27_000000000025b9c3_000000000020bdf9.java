import java.util.*;
import java.io.*;
//import java.lang.*;
    public class CJ_NestingDepth {
    	
        public static void startsort(int arr[][]){ 
            Arrays.sort(arr, new Comparator<int[]>() { 
              public int compare(final int[] entry1,  
                                 final int[] entry2) { 
                if (entry1[0] > entry2[0]) 
                    return 1; 
                else
                    return -1; 
              } 
            });  
        } 
        
        public static String tasks(int[][] jobs, ArrayList<Integer> req) {
        	ArrayList<Integer> start = new ArrayList<Integer>(jobs.length);
            for(int j = 0; j <jobs.length; j++){
//                start[j] = jobs[j][0];
            	start.add(jobs[j][0]);
            }
        	String[] ans = new String[jobs.length];
        	String[] fin = new String[jobs.length];
        	ans[0] = "J";
        	int prev = 0; 
        	int curr = 1;
        	int p = 0;
        	int c =0;
        	int[] rem = new int[jobs.length];
//        	Assign 1st task to J and assign as many tasks to J as possible.
        	for(; curr < jobs.length; curr++) {
        		if(jobs[prev][1] <= jobs[curr][0]) {
        			ans[curr] = "J";
        			prev = curr;
        		}
//        		storing tasks to be done by C
        	else {
        			rem[curr] = curr;	
        		}
        	}
        	
//        	Check if its valid for C to do remaining tasks
        	for(int i = 0; i < rem.length; i++) {
        		if(rem[i] != 0 & p == 0) {
        			p = i; ans[p] = "C"; rem[p] = 0;
        		}
        		if(rem[i] != 0 & c == 0) {
        			c = i;
        			break;
                 }
        	}
        	
        	for(; c < jobs.length; c++) {
        		if(rem[c] != 0) {
        			if(jobs[p][1] <= jobs[c][0]) {
            			ans[c] = "C";
            			p = c;
            			rem[c] = 0;
        			}else {
//        				fin = "IMPOSSIBLE";
        				return "IMPOSSIBLE";
        			}
        		}	
        	}
        	
        	for(int i = 0; i < jobs.length; i++) {
                int x = req.indexOf(start.get(i));
        		fin[x] = ans[i];
        	}
        	StringBuffer sb = new StringBuffer();
            for(int i = 0; i < fin.length; i++) {
               sb.append(fin[i]);
            }
            String str = sb.toString();
//            System.out.println(str);	
            return str;
        }
        
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int[][] jobs = new int[n][2];
          ArrayList<Integer> start_req = new ArrayList<Integer>(n);
          for(int j = 0; j <n; j++){
              jobs[j][0] = in.nextInt();
              jobs[j][1] = in.nextInt();
              start_req.add(jobs[j][0]);
          }
          
          startsort(jobs);
//          Copying sorted array.
          int[][] jb = new int[n][2];
          for(int h = 0; h <n; h++) {
        	  for(int k = 0; k <2; k++) {
        		 jb[h][k] = jobs[h][k]; 
        	  }
          }
//          System.out.println(tasks(jb, start_req));
          System.out.println("Case #" + i + ": " + tasks(jb, start_req));
        }
      }
    }